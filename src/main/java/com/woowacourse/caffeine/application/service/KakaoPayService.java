package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.dto.PaymentSaveRequest;
import com.woowacourse.caffeine.application.dto.kakaopay.KakaoPayApprovalVO;
import com.woowacourse.caffeine.application.dto.kakaopay.KakaoPayReadyRequest;
import com.woowacourse.caffeine.application.dto.kakaopay.KakaoPayReadyVO;
import com.woowacourse.caffeine.domain.Order;
import com.woowacourse.caffeine.domain.OrderItem;
import com.woowacourse.caffeine.domain.exception.InvalidKakaoPayException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class KakaoPayService {

    private static final String HOST = "https://kapi.kakao.com";
    private static final String PAYMENT_BASE_URL = "http://localhost:8080/v1/payment/";
    private final OrderInternalService orderInternalService;
    private final OrderItemInternalService orderItemInternalService;
    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    private Order order;
    private List<OrderItem> orderItems;
    private int totalAmount;

    public KakaoPayService(final OrderInternalService orderInternalService, final OrderItemInternalService orderItemInternalService) {
        this.orderInternalService = orderInternalService;
        this.orderItemInternalService = orderItemInternalService;
    }

    public String ready(final KakaoPayReadyRequest request) {
        final long orderId = request.getOrderId();
        this.order = orderInternalService.findById(orderId);
        this.orderItems = orderItemInternalService.findAllByOrder(order);
        this.totalAmount = orderItems.stream().mapToInt(OrderItem::getPrice)
            .sum();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = getKakaoPayRequestHeaders();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", String.valueOf(orderId));
        params.add("partner_user_id", String.valueOf(order.getCustomerId()));
        params.add("item_name", "커피");
        params.add("quantity", String.valueOf(orderItems.size()));
        params.add("total_amount", String.valueOf(totalAmount));
        params.add("tax_free_amount", "0");
        params.add("approval_url", PAYMENT_BASE_URL + orderId + "/kakaopay/success");
        params.add("cancel_url", PAYMENT_BASE_URL);
        params.add("fail_url", PAYMENT_BASE_URL);


        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(params, headers);
        try {
            kakaoPayReadyVO = restTemplate.postForObject(URI.create(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);

            return Objects.requireNonNull(kakaoPayReadyVO).getNext_redirect_pc_url();
        } catch (RestClientException e) {
            throw new InvalidKakaoPayException();
        }
    }

    public PaymentSaveRequest success(final Long orderId, final String pgToken) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = getKakaoPayRequestHeaders();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", String.valueOf(orderId));
        params.add("partner_user_id", order.getCustomerId());
        params.add("pg_token", pgToken);
        params.add("total_amount", String.valueOf(totalAmount));

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(params, headers);

        try {
            kakaoPayApprovalVO = restTemplate.postForObject(URI.create(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            return Objects.requireNonNull(kakaoPayApprovalVO).convertToPaymentSaveRequestDto();
        } catch (RestClientException e) {
            throw new InvalidKakaoPayException();
        }
    }

    private HttpHeaders getKakaoPayRequestHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "admin Key");
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        return headers;
    }
}
