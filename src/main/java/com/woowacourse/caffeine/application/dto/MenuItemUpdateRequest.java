package com.woowacourse.caffeine.application.dto;

public class MenuItemUpdateRequest {

    private String name;
    private String description;
    private int price;

    public MenuItemUpdateRequest() {
    }

    public MenuItemUpdateRequest(final String name, final String description, final int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }
}
