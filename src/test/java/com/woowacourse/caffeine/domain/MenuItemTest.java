package com.woowacourse.caffeine.domain;

import com.woowacourse.caffeine.domain.exception.InvalidMenuItemNameException;
import com.woowacourse.caffeine.domain.exception.InvalidMenuItemPriceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuItemTest {

    @Test
    void create() {
        // given
        String name = "아메리카노";
        String nameInEnglish = "Americano";
        String description = "아메리카노 좋아~ 좋아~ 좋아~";
        int price = 2500;
        String img = "abc";
        String category = "coffee";
        Shop shop = new Shop("어디야 커피");

        // when & then
        assertDoesNotThrow(() -> new MenuItem(name, nameInEnglish, description, price, img, category, shop));
    }

    @Test
    void name_empty() {
        // given
        String name = "";
        String nameInEnglish = "Americano";
        String description = "아메리카노 좋아~ 좋아~ 좋아~";
        int price = 2500;
        String img = "abc";
        String category = "coffee";
        Shop shop = new Shop("어디야 커피");

        // when & then
        assertThrows(InvalidMenuItemNameException.class, () -> new MenuItem(name, nameInEnglish, description, price, img, category, shop));
    }

    @Test
    void price_minus() {
        // given
        String name = "아메리카노";
        String nameInEnglish = "Americano";
        String description = "아메리카노 좋아~ 좋아~ 좋아~";
        int price = -2500;
        String img = "abc";
        String category = "coffee";
        Shop shop = new Shop("어디야 커피");

        // when & then
        assertThrows(InvalidMenuItemPriceException.class, () -> new MenuItem(name, nameInEnglish, description, price, img, category, shop));
    }
}
