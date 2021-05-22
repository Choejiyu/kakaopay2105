package com.example.kakaopay2105.web.mapper;

import com.example.kakaopay2105.web.dto.BankEntity;
import com.example.kakaopay2105.web.dto.BranchEntity;
import com.example.kakaopay2105.web.dto.ResultDTO;
import com.example.kakaopay2105.web.dto.TradeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ComMapper {
        //거래 정보 입력
        int insertTrade(TradeEntity dto);

        //상점 정보 입력
        int insertBranch(BranchEntity dto);

        //계좌 정보 입력
        int insertBank(BankEntity dto);

        @Select("SELECT * FROM TRADE")
        List<TradeEntity> selectAllTrade();

        @Select("SELECT * FROM BRANCH")
        List<BranchEntity> selectAllBranch();

        List<ResultDTO> result01();

        List<ResultDTO> result02();

        List<ResultDTO> result03(String year);

        List<ResultDTO> result04(String branchCd);

}
