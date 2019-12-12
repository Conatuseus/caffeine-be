package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.converter.ShopConverter;
import com.woowacourse.caffeine.application.dto.MenuItemCreateRequest;
import com.woowacourse.caffeine.application.dto.MenuItemResponse;
import com.woowacourse.caffeine.application.dto.MenuItemUpdateRequest;
import com.woowacourse.caffeine.application.dto.ShopResponse;
import com.woowacourse.caffeine.domain.MenuItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuItemService {

    private final MenuItemInternalService menuItemInternalService;
    private final ShopConverter shopConverter;

    public MenuItemService(final MenuItemInternalService menuItemInternalService, final ShopConverter shopConverter) {
        this.menuItemInternalService = menuItemInternalService;
        this.shopConverter = shopConverter;
    }

    @Transactional(readOnly = true)
    public List<MenuItemResponse> findByShopId(final long shopId) {
        return menuItemInternalService.findByShopId(shopId)
            .stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }

    public MenuItemResponse createMenuItem(final MenuItemCreateRequest menuItemCreateRequest) {
        MenuItem menuItem = menuItemInternalService.createMenuItem(menuItemCreateRequest);
        return convertToResponse(menuItem);
    }

    @Transactional(readOnly = true)
    public MenuItemResponse findByMenuItemId(final long menuItemId) {
        MenuItem menuItem = menuItemInternalService.findById(menuItemId);
        return convertToResponse(menuItem);
    }

    public MenuItemResponse updateMenuItem(final long menuItemId, final MenuItemUpdateRequest menuItemUpdateRequest) {
        MenuItem updatedMenuItem = menuItemInternalService.updateMenuItem(menuItemId, menuItemUpdateRequest);
        return convertToResponse(updatedMenuItem);
    }

    public void deleteMenuItem(final long menuItemId) {
        menuItemInternalService.deleteMenuItem(menuItemId);
    }

    private MenuItemResponse convertToResponse(final MenuItem menuItem) {
        return new MenuItemResponse(
            menuItem.getId(),
            menuItem.getName(),
            menuItem.getNameInEnglish(),
            menuItem.getDescription(),
            menuItem.getPrice(),
            menuItem.getImgUrl(),
            menuItem.getCategory(),
            shopConverter.convertToDto(menuItem.getVendor(), ShopResponse.class)
        );
    }
}
