package com.woowacourse.caffeine.domain.exception;

public class InvalidKakaoPayException extends RuntimeException {

    private static final String INVALID_KAKAO_PAY_REQUEST_MESSAGE = "잘못된 결제 요청입니다.";

    public InvalidKakaoPayException() {
        super(INVALID_KAKAO_PAY_REQUEST_MESSAGE);
    }
}
