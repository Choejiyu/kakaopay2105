package com.example.kakaopay2105.web.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 요청 응답 메시지
 */
@Getter
@AllArgsConstructor //생성자를 자동 생성해주는
public enum ResCode {
    E001("처리 가능한 csv파일이 아닙니다."),

    E999("내부 오류"),

    S000("정상처리되었습니다.");

    private final String message;
}
