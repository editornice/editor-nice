package com.editornice.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum ErrorCode {

    /**
     * TODO : 예외 코드와 메세지에 대한 규칙 정해야 됨
     */
    NOT_FOUND_MEMBER_ID(4001, "해당 멤버는 존재하지 않습니다."),
    NOT_FOUND_EMPLOYER_ID(4002, "해당 구인자는 존재하지 않습니다.");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
