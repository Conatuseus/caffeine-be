package com.woowacourse.caffeine.presentation.controller;

import com.woowacourse.caffeine.application.dto.PaymentResponse;
import com.woowacourse.caffeine.application.dto.kakaopay.KakaoPayReadyRequest;
import com.woowacourse.caffeine.application.service.KakaoPayService;
import com.woowacourse.caffeine.application.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.woowacourse.caffeine.presentation.controller.PaymentController.V1_PAYMENT;

@RestController
@RequestMapping(V1_PAYMENT)
public class PaymentController {

    public static final String V1_PAYMENT = "/v1/payment";
    private final KakaoPayService kakaoPayService;
    private final PaymentService paymentService;

    public PaymentController(final KakaoPayService kakaoPayService, final PaymentService paymentService) {
        this.kakaoPayService = kakaoPayService;
        this.paymentService = paymentService;
    }

    @PostMapping("/kakaopay")
    public ResponseEntity kakaoPayStart(@RequestBody final KakaoPayReadyRequest request) {
        return new ResponseEntity<>(kakaoPayService.ready(request), HttpStatus.FOUND);
    }

    @GetMapping("/{orderId}/kakaopay/success")
    public ResponseEntity kakaoPaySuccess(@PathVariable final Long orderId, @RequestParam("pg_token") final String pgToken) {
        PaymentResponse paymentResponse = paymentService.save(kakaoPayService.success(orderId, pgToken));
        return ResponseEntity.ok(paymentResponse);
    }
}
