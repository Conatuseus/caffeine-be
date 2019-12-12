package com.woowacourse.caffeine.mock;

import com.woowacourse.caffeine.application.dto.MenuItemCreateRequest;

public class MenuItemCreateRequestRepository {

    public static final MenuItemCreateRequest menuItemCreateRequest =
        new MenuItemCreateRequest("아이스 아메리카노", "Ice Americano", "시원한 아이스 아메리카노", 3000,
            "https://github.com/eunsukko/TIL/blob/master/201912/caffeine/pictures/starbucks_%EC%84%9D%EC%B4%8C%ED%98%B8%EC%88%98.jpg?raw=true", "coffee", 1L);
}
