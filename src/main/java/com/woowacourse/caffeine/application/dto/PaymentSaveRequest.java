package com.woowacourse.caffeine.application.dto;

public class PaymentSaveRequest {

    private int amount;
    private String customerId;
    private Long orderId;

    public PaymentSaveRequest(){
    }

    public PaymentSaveRequest(final int amount, final String customerId, final Long orderId) {
        this.amount = amount;
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }
}
