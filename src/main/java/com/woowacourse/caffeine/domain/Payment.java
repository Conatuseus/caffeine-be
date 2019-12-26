package com.woowacourse.caffeine.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private String customerId;

    @OneToOne
    private Order order;

    public Payment(final int amount, final String customerId, final Order order) {
        this.amount = amount;
        this.customerId = customerId;
        this.order = order;
    }

    public Long getId() {
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
