package com.woowacourse.caffeine.mock;

import com.woowacourse.caffeine.application.dto.MenuItemUpdateRequest;

public class MenuItemUpdateRequestRepository {

    public static final MenuItemUpdateRequest menuItemUpdateRequest =
        new MenuItemUpdateRequest("updatedName", "updatedNameInEnglish", "updatedDescription",
            123456789, "updatedImage", "updatedCategory");
}
