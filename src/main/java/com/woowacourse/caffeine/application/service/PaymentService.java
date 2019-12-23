package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.converter.PaymentConverter;
import com.woowacourse.caffeine.application.dto.PaymentResponse;
import com.woowacourse.caffeine.application.dto.PaymentSaveRequest;
import com.woowacourse.caffeine.domain.Payment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PaymentService {

    private final PaymentInternalService paymentInternalService;

    public PaymentService(final PaymentInternalService paymentInternalService) {
        this.paymentInternalService = paymentInternalService;
    }

    public PaymentResponse save(final PaymentSaveRequest paymentSaveRequest) {
        Payment payment = paymentInternalService.save(paymentSaveRequest);
        return PaymentConverter.convertToDto(payment);
    }
}
