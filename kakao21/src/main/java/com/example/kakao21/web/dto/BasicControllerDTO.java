package com.example.kakao21.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public class BasicControllerDTO {
    private final String name;
    private final int amount;
}