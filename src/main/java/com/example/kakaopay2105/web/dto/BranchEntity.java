package com.example.kakaopay2105.web.dto;

import com.example.kakaopay2105.web.common.ComException;
import com.example.kakaopay2105.web.common.ResCode;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;
@Alias("branch")
@Data
public class BranchEntity implements CsvEntity {
    private String branchCd;
    private String branchNm;
    @Override
    public void rowToDto(List<String> row) throws ComException {
        if(row.size() != 2) throw new ComException(ResCode.E001);

        this.branchCd = row.get(0);
        this.branchNm = row.get(1);
    }
}
