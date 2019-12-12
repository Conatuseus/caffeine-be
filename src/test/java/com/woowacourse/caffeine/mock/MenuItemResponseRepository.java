package com.woowacourse.caffeine.mock;

import com.woowacourse.caffeine.application.dto.MenuItemResponse;

public class MenuItemResponseRepository {

    public static final MenuItemResponse menuItemResponse =
        new MenuItemResponse(1L, "아이스 아메리카노", "Ice Americano", "시원한 아이스 아메리카노", 3000,
            "https://github.com/eunsukko/TIL/blob/master/201912/caffeine/pictures/starbucks_%EC%84%9D%EC%B4%8C%ED%98%B8%EC%88%98.jpg?raw=true", "coffee", ShopResponseRepository.shopResponse1);

    public static final MenuItemResponse updatedMenuItemResponse =
        new MenuItemResponse(2L, "updatedName","updatedNameInEnglish", "updatedDescription",
            123456789, "updatedImage", "updatedCategory", ShopResponseRepository.shopResponse1);
}
