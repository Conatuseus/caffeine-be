package com.woowacourse.caffeine.application.dto.kakaopay;

public class KakaoPayReadyRequest {

    private long orderId;

    public KakaoPayReadyRequest() {
    }

    public KakaoPayReadyRequest(final long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(final long orderId) {
        this.orderId = orderId;
    }
}
