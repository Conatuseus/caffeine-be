package com.woowacourse.caffeine.application.converter;

import com.woowacourse.caffeine.application.dto.PaymentResponse;
import com.woowacourse.caffeine.domain.Payment;

public class PaymentConverter {

    public static PaymentResponse convertToDto(final Payment payment) {
        return new PaymentResponse(
            payment.getId(),
            payment.getAmount(),
            payment.getCustomerId(),
            payment.getOrder()
        );
    }
}
