package com.example.kakaopay2105.web.controller;

import com.example.kakaopay2105.web.service.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequiredArgsConstructor
public class BaseController {
    private final KakaoService kakaoService;

    @RequestMapping(value = "/home", method =  RequestMethod.GET)

    public String home() {

        return "index.html";
    }


}


