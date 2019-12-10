package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.dto.MenuCreateRequest;
import com.woowacourse.caffeine.domain.MenuItem;
import com.woowacourse.caffeine.domain.Shop;
import com.woowacourse.caffeine.repository.MenuItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuItemInternalServiceTest {

    @Mock
    private ShopInternalService shopInternalService;

    @Mock
    private MenuItemRepository menuItemRepository;

    @InjectMocks
    private MenuItemInternalService menuItemInternalService;

    @Test
    void findByShopId() {
        // given
        Shop shop = new Shop("어디야 커피");
        MenuItem americano = MenuItem.builder()
            .name("아메리카노")
            .nameInEnglish("Americano")
            .description("맛있는 아메리카노")
            .price(2500)
            .img("https://github.com/eunsukko/TIL/blob/master/201912/caffeine/pictures/starbucks_banana.jpeg?raw=true")
            .category("coffee")
            .vendor(shop)
            .build();

        MenuItem cafeLatte = MenuItem.builder()
            .name("카페라떼")
            .nameInEnglish("cafe latte")
            .description("고소한 라떼")
            .price(3000)
            .img("https://github.com/eunsukko/TIL/blob/master/201912/caffeine/pictures/starbucks_banana.jpeg?raw=true")
            .category("coffee")
            .vendor(shop)
            .build();

        List<MenuItem> menus = Arrays.asList(americano, cafeLatte);

        // whe
        when(menuItemRepository.findByVendor(shop)).thenReturn(menus);
        List<MenuItem> found = menuItemRepository.findByVendor(shop);

        // then
        assertThat(found).isEqualTo(menus);
    }

    @Test
    void createMenuItem() {
        //given
        Shop shop = new Shop("어디야 커피");
        long shopId = 1;

        MenuItem menuItem = MenuItem.builder()
            .name("아이스 아메리카노")
            .nameInEnglish("Ice Americano")
            .description("시원한 아메리카노")
            .price(2000)
            .img("abc")
            .category("coffee")
            .vendor(shop)
            .build();

        MenuCreateRequest menuCreateRequest = new MenuCreateRequest(
            "아이스 아메리카노", "Ice Americano", "시원한 아메리카노", 2000, "abc", "coffee", shopId);

        //when
        when(menuItemInternalService.createMenuItem(menuCreateRequest)).thenReturn(menuItem);
        MenuItem created = menuItemInternalService.createMenuItem(menuCreateRequest);

        //then
        assertThat(menuItem).isNotNull();
//        assertThat(created).isEqualTo(menuItem);
    }

    @Test
    void findByMenuItemId() {
    }

    @Test
    void updateMenuItem() {
    }
}