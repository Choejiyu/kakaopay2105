package com.example.kakaopay2105.web.dto;

import com.example.kakaopay2105.web.common.ComException;

import java.util.List;

public interface CsvEntity {

    void rowToDto(List<String> row) throws ComException;
}
