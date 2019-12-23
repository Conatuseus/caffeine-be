package com.woowacourse.caffeine.application.dto;

import com.woowacourse.caffeine.domain.Order;

public class PaymentResponse {

    private long id;
    private int amount;
    private String customerId;
    private Order order;

    public PaymentResponse(final long id, final int amount, final String customerId, final Order order) {
        this.id = id;
        this.amount = amount;
        this.customerId = customerId;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Order getOrder() {
        return order;
    }
}
