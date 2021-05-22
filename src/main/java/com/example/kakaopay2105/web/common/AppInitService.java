package com.example.kakaopay2105.web.common;

import com.example.kakaopay2105.web.dto.BankEntity;
import com.example.kakaopay2105.web.dto.BranchEntity;
import com.example.kakaopay2105.web.dto.TradeEntity;
import com.example.kakaopay2105.web.mapper.ComMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor

public class AppInitService implements ApplicationRunner {
    private final ComMapper comMapper;


    @Override
    public void run(ApplicationArguments args) throws Exception {

                final String branchCsvPath = "data_branch.csv";
                final String storeCsvPath = "data_bank.csv";
                final String tradeCsvPath = "data_trade.csv";
                log.info("APP 초기화, {}, {}, {} 파일 DB에 저장", branchCsvPath, storeCsvPath, tradeCsvPath);

                //CSV 파일 읽기
                final List<BankEntity> bankEntitys = ComUtils.csvFileToDTO(new InputStreamReader(new ClassPathResource(storeCsvPath).getInputStream()), BankEntity.class);
                final List<BranchEntity> branchEntities = ComUtils.csvFileToDTO(new InputStreamReader(new ClassPathResource(branchCsvPath).getInputStream()), BranchEntity.class);
                final List<TradeEntity> tradeEntities = ComUtils.csvFileToDTO(new InputStreamReader(new ClassPathResource(tradeCsvPath).getInputStream()), TradeEntity.class);

                //DB 저장

               for(BankEntity bankEntity : bankEntitys) {
                  comMapper.insertBank(bankEntity);
                }

                for(BranchEntity branchEntity : branchEntities) {
                   comMapper.insertBranch(branchEntity);
                }

                for(TradeEntity tradeEntity : tradeEntities) {
                   comMapper.insertTrade(tradeEntity);
                }
            }
}


