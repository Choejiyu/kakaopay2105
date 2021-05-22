package com.example.kakaopay2105.web.dto;

import com.example.kakaopay2105.web.common.ComException;
import com.example.kakaopay2105.web.common.ResCode;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;
@Alias("trade")
@Data
public class TradeEntity implements CsvEntity {

    private String trdDt; //거래일자
    private String acctNo; //계좌번호
    private String trdNo; //거래번호
    private long amt; //금액
    private long fees; //수수료
    private boolean cancel; //취소여부

    @Override
    public void rowToDto(List<String> row) throws ComException {
        if(row.size() != 6) throw new ComException(ResCode.E001);
        this.trdDt = row.get(0);
        this.acctNo = row.get(1);
        this.trdNo = row.get(2);
        this.amt = Long.parseLong(row.get(3));
        this.fees = Long.parseLong(row.get(4));
        this.cancel = row.get(5).equals("Y");

    }
}
