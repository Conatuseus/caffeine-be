package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.dto.PaymentSaveRequest;
import com.woowacourse.caffeine.domain.Order;
import com.woowacourse.caffeine.domain.Payment;
import com.woowacourse.caffeine.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PaymentInternalService {

    private final PaymentRepository paymentRepository;
    private final OrderInternalService orderInternalService;

    public PaymentInternalService(final PaymentRepository paymentRepository, final OrderInternalService orderInternalService) {
        this.paymentRepository = paymentRepository;
        this.orderInternalService = orderInternalService;
    }

    public Payment save(final PaymentSaveRequest paymentSaveRequest) {
        final Order order = orderInternalService.findById(paymentSaveRequest.getOrderId());
        return paymentRepository.save(
            new Payment(paymentSaveRequest.getAmount(), paymentSaveRequest.getCustomerId(), order));
    }
}
