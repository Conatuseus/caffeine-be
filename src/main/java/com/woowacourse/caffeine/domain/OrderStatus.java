package com.woowacourse.caffeine.domain;

enum OrderStatus {
    CANCEL("주문 취소"),
    SUCCESS("주문 성공"),
    FAIL("주문 실패"),
    IN_PROGRESS("준비 중"),
    READY("준비 완료"),
    FINISH("수령 완료");

    private String status;

    OrderStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
