package com.woowacourse.caffeine.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woowacourse.caffeine.application.dto.MenuItemCreateRequest;
import com.woowacourse.caffeine.application.dto.MenuItemResponse;
import com.woowacourse.caffeine.application.dto.MenuItemUpdateRequest;
import com.woowacourse.caffeine.application.service.MenuItemService;
import com.woowacourse.caffeine.mock.MenuItemCreateRequestRepository;
import com.woowacourse.caffeine.mock.MenuItemResponseRepository;
import com.woowacourse.caffeine.mock.MenuItemUpdateRequestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.woowacourse.caffeine.controller.MenuController.V1_MENU;
import static com.woowacourse.caffeine.utils.ApiDocumentUtils.getDocumentRequest;
import static com.woowacourse.caffeine.utils.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MenuController.class)
@AutoConfigureRestDocs
public class MenuDocumentationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenuItemService menuItemService;

    @Test
    @DisplayName("메뉴 아이템 생성 문서")
    void create_menuItem() throws Exception {
        // given
        MenuItemCreateRequest menuItemCreateRequest = MenuItemCreateRequestRepository.menuItemCreateRequest;
        MenuItemResponse menuItemCreateResponse = MenuItemResponseRepository.menuItemResponse;
        given(menuItemService.createMenuItem(any())).willReturn(menuItemCreateResponse);

        // when
        ResultActions result = mockMvc.perform(
            RestDocumentationRequestBuilders.post(String.format("%s", V1_MENU))
                .content(new ObjectMapper().writeValueAsString(menuItemCreateRequest))
                .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        result.andExpect(status().isCreated())
            .andDo(print())
            .andDo(document("menuItem-create",
                getDocumentRequest(),
                getDocumentResponse()));
    }

    @Test
    @DisplayName("메뉴 아이템 조회 문서")
    void retrieve_menuItem() throws Exception {
        // given
        long menuItemId = 1L;
        MenuItemResponse menuItemResponse = MenuItemResponseRepository.menuItemResponse;
        given(menuItemService.findByMenuItemId(menuItemId)).willReturn(menuItemResponse);

        // when
        ResultActions result = mockMvc.perform(
            RestDocumentationRequestBuilders.get(String.format("%s/{menuItemId}", V1_MENU), menuItemId)
        );

        // then
        result.andExpect(status().isOk())
            .andDo(print())
            .andDo(document("menuItem-retrieve",
                getDocumentRequest(),
                getDocumentResponse(),
                pathParameters(
                    parameterWithName("menuItemId").description("메뉴 id")
                ),
                responseFields(
                    fieldWithPath("id").description("메뉴 id"),
                    fieldWithPath("name").description("메뉴 이름"),
                    fieldWithPath("nameInEnglish").description("메뉴 이름(영어)"),
                    fieldWithPath("description").description("메뉴 소개"),
                    fieldWithPath("price").description("메뉴 가격"),
                    fieldWithPath("imgUrl").description("메뉴 이미지 URL"),
                    fieldWithPath("category").description("메뉴 카테고리"),
                    fieldWithPath("vendor").description("상점"),
                    fieldWithPath("vendor.id").description("상점 id"),
                    fieldWithPath("vendor.name").description("상점 이름"),
                    fieldWithPath("vendor.image").description("상점 이미지"),
                    fieldWithPath("vendor.address").description("상점 주소"),
                    fieldWithPath("vendor.phoneNumber").description("상점 전화번호")
                )));
    }

    @Test
    @DisplayName("메뉴 정보 수정")
    void update_menuItem() throws Exception {
        // given
        long menuItemId = 2L;
        MenuItemUpdateRequest menuItemUpdateRequest = MenuItemUpdateRequestRepository.menuItemUpdateRequest;
        MenuItemResponse updatedMenuItemResponse = MenuItemResponseRepository.updatedMenuItemResponse;
        given(menuItemService.updateMenuItem(menuItemId, menuItemUpdateRequest)).willReturn(updatedMenuItemResponse);

        // when
        ResultActions result = mockMvc.perform(
            RestDocumentationRequestBuilders.put(String.format("%s/{menuItemId}", V1_MENU), menuItemId)
                .content(new ObjectMapper().writeValueAsString(menuItemUpdateRequest))
                .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        result.andExpect(status().isOk())
            .andDo(print())
            .andDo(document("menuItem-update",
                getDocumentRequest(),
                getDocumentResponse(),
                pathParameters(
                    parameterWithName("menuItemId").description("메뉴 id")
                ),
                responseFields(
                    fieldWithPath("id").description("메뉴 id"),
                    fieldWithPath("name").description("메뉴 이름"),
                    fieldWithPath("nameInEnglish").description("메뉴 이름(영어)"),
                    fieldWithPath("description").description("메뉴 소개"),
                    fieldWithPath("price").description("메뉴 가격"),
                    fieldWithPath("imgUrl").description("메뉴 이미지 URL"),
                    fieldWithPath("category").description("메뉴 카테고리"),
                    fieldWithPath("vendor").description("상점"),
                    fieldWithPath("vendor.id").description("상점 id"),
                    fieldWithPath("vendor.name").description("상점 이름"),
                    fieldWithPath("vendor.image").description("상점 이미지"),
                    fieldWithPath("vendor.address").description("상점 주소"),
                    fieldWithPath("vendor.phoneNumber").description("상점 전화번호")
                )));
    }

    @Test
    @DisplayName("메뉴 삭제")
    void delete_menuItem() throws Exception {
        // given
        long menuItemId = 2L;

        // when
        ResultActions result = mockMvc.perform(
            RestDocumentationRequestBuilders.delete(String.format("%s/{menuItemId}", V1_MENU), menuItemId)
        );

        // then
        result.andExpect(status().isNoContent())
            .andDo(print())
            .andDo(document("menuItem-delete",
                getDocumentRequest(),
                getDocumentResponse()));
    }
}
