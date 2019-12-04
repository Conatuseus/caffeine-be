package com.woowacourse.caffeine.domain;

enum PaymentStatus {
    SUCCESS("결제 완료"),
    FAIL("결제 실패"),
    CANCEL("결제 취소");

    private final String message;

    PaymentStatus(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
