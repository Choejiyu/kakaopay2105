package com.example.kakaopay2105.web.dto;

import com.example.kakaopay2105.web.common.ComException;
import com.example.kakaopay2105.web.common.ResCode;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;
@Alias("bank")
@Data
public class BankEntity implements CsvEntity {
    private String acctNo;
    private String acctNm;
    private String branchCd;

    @Override
    public void rowToDto(List<String> row) throws ComException {
        if(row.size() != 3) throw new ComException(ResCode.E001);
        this.acctNo = row.get(0);
        this.acctNm = row.get(1);
        this.branchCd = row.get(2);
    }
}
