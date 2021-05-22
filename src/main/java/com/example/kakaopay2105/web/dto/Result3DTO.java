package com.example.kakaopay2105.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Result3DTO {
    private String year;
    private List<ResultDTO> dataList;

}
