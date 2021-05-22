package com.example.kakaopay2105.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResultDTO {

    private String year;
    private String name;
    private String acct;
    private int sumAmt;

    private List<ResultDTO> dataList;
    private String brName;
    private String brCode;



    }
