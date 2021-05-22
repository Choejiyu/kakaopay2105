package com.example.kakaopay2105;

import static org.hamcrest.CoreMatchers.is;
//import org.junit.Test;
import com.example.kakaopay2105.web.dto.BankEntity;
import com.example.kakaopay2105.web.dto.BranchEntity;
import com.example.kakaopay2105.web.dto.TradeEntity;
import com.example.kakaopay2105.web.mapper.ComMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class MapperTests {

    @Autowired
    private ComMapper comMapper;

    @Test
    public void firstBankInsert() throws Exception{
        BankEntity params = new BankEntity();

        //given
        params.setAcctNm("계좌이름테스트");
        params.setBranchCd("은행이름테스트");
        params.setAcctNo("12345678");

        //when
        int result = comMapper.insertBank(params);
        System.out.println("BANK table INSERT 결과 :"+ result +" 건 입니다.");

        //then
        assertThat(params.getAcctNm().equals("계좌이름테스트"));
        assertThat(params.getBranchCd().equals("은행이름테스트"));
        assertThat(params.getAcctNo().equals(12345678));


    }
    @Test
    public void firstBranchInsert(){
        //given
        BranchEntity params = new BranchEntity();
        params.setBranchCd("Test");
        params.setBranchNm("테스트점");

        //when
        int result = comMapper.insertBranch(params);
        System.out.println("BRANCH table INSERT 결과 :"+ result +" 건 입니다.");

        //then
        assertThat(params.getBranchCd().equals("Test"));
        assertThat(params.getBranchNm().equals("테스트점"));
    }

    @Test
    public void firstTradeInsert(){

        //given
        TradeEntity params = new TradeEntity();
        params.setTrdDt("20200000");
        params.setAcctNo("12345678");
        params.setTrdNo("거래번호");
        params.setAmt(100);
        params.setFees(10);

        //when
        int result = comMapper.insertTrade(params);
        System.out.println("TRADE table INSERT 결과 :"+ result +" 건 입니다.");

        //then
        assertThat(params.getTrdDt().equals("20200000"));
        assertThat(params.getAcctNo().equals("12345678"));
        assertThat(params.getTrdNo().equals("거래번호"));

    }




}
