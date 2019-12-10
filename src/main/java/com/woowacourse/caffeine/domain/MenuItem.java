package com.woowacourse.caffeine.domain;

import com.woowacourse.caffeine.application.dto.MenuItemUpdateRequest;
import com.woowacourse.caffeine.domain.exception.InvalidMenuItemNameException;
import com.woowacourse.caffeine.domain.exception.InvalidMenuItemPriceException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class MenuItem {

    public static final int PRICE_MIN_INCLUSIVE = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nameInEnglish;
    private String description;
    private int price;
    private String img;
    private String category;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop vendor;

    protected MenuItem() {
    }

    @Builder
    public MenuItem(final String name, final String nameInEnglish, final String description, final int price, final String img, final String category, final Shop vendor) {
        this.name = name;
        this.nameInEnglish = nameInEnglish;
        this.description = description;
        this.price = price;
        this.img = img;
        this.category = category;
        this.vendor = vendor;

        if (name.isEmpty()) {
            throw new InvalidMenuItemNameException(name);
        }

        if (price < PRICE_MIN_INCLUSIVE) {
            throw new InvalidMenuItemPriceException(price);
        }
    }

    public void update(final MenuItemUpdateRequest menuItemUpdateRequest) {
        this.name = menuItemUpdateRequest.getName();
        this.description = menuItemUpdateRequest.getDescription();
        this.price = menuItemUpdateRequest.getPrice();
    }
}
