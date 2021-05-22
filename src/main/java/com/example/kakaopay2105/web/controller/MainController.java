package com.example.kakaopay2105.web.controller;


import com.example.kakaopay2105.web.dto.Result3DTO;
import com.example.kakaopay2105.web.dto.ResultDTO;
import com.example.kakaopay2105.web.service.KakaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
public class MainController {
    private final KakaoService kakaoService;

    public MainController(KakaoService kakaoService) {
        this.kakaoService = kakaoService;
    }

    // @ResponseBody  // 자바 객체를 http요청의 body 내용으로 매핑하는 역할
    @GetMapping("/getResult01")
    public List<ResultDTO> result01(){
        return kakaoService.result01();
    }

    @GetMapping("/getResult02")
    public List<ResultDTO> result02(){
        //System.out.println(comService.result01());
        return kakaoService.result02();
    }
    @GetMapping("/getResult03")
    public List<Result3DTO> result03(){
        return (List<Result3DTO>) kakaoService.result03();

    }

    @GetMapping("/getResult04")
     public List<ResultDTO> result04(HttpServletResponse httpServletResponse, @RequestParam String branchCd, @RequestParam String branchNm){
        String message = "";
        if ("B".equals(branchCd)){
            throw new BranchCdisB(message);
        }
        return kakaoService.result04(branchCd);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "br code not found error")
    public static class BranchCdisB extends RuntimeException {

        public BranchCdisB(String message) {

            super(message);
        }

    }

}
