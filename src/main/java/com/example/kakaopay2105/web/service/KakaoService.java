package com.example.kakaopay2105.web.service;

import com.example.kakaopay2105.web.dto.BranchEntity;
import com.example.kakaopay2105.web.dto.Result3DTO;
import com.example.kakaopay2105.web.dto.ResultDTO;
import com.example.kakaopay2105.web.dto.TradeEntity;
import com.example.kakaopay2105.web.mapper.ComMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class KakaoService {

    private final ComMapper comMapper;

    public KakaoService(ComMapper comMapper) {
        this.comMapper = comMapper;
    }


    public List<TradeEntity> getAllTradeList() throws Exception {
        return comMapper.selectAllTrade();
    }
    public List<BranchEntity>getAllBranchList() {
        return comMapper.selectAllBranch();
    }
    /**
     * 1. 2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발.
     * (단, 취소여부가 ‘Y’ 거래는 취소된 거래임, 합계 금액은 거래금액에서 수수료를 차감한 금액임)
     * @return 결과
     */
    public List<ResultDTO> result01(){
        return comMapper.result01();
    }

    /**
     * 2.2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발.
     * (취소여부가 ‘Y’ 거래는 취소된 거래임.
     * @return 결과
     */
    public List<ResultDTO> result02(){

        return comMapper.result02();
    }
    /**
     * 3.	연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.
     * ( 취소여부가 ‘Y’ 거래는 취소된 거래임)
     *  @return 결과
     */
    public List<Result3DTO> result03(){
        List<Result3DTO> resultlist = new ArrayList<Result3DTO>();
        String[] yearList = {"2018","2019"};
        for (String year :yearList){
            Result3DTO result3DTO = new Result3DTO();
            result3DTO.setYear(year);
            result3DTO.setDataList(comMapper.result03(year));
            resultlist.add(result3DTO);
        }
        return resultlist;
    }

    /**
    * 4.	분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다.
    * 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발( 취소여부가 ‘Y’ 거래는 취소된 거래임,)
    * @retun 결과 404 -> 에러메세지 변경
     */
    public List<ResultDTO> result04(String branchCd){
        return comMapper.result04(branchCd);

    }
}