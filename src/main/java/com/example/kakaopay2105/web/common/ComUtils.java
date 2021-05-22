package com.example.kakaopay2105.web.common;

import com.example.kakaopay2105.web.dto.CsvEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ComUtils {


    /**
     * csv 파일 처리
     * 한 행의 문자열 ',' 구분자로 분리 후 문자열 리스트로 반환
     * @param row 행
     * @return 구분된 문자열 리스트
     */
    public static List<String> parsingCsvRow(final String row) {
        List<String> parsRow = new ArrayList<>();

        if(StringUtils.isEmpty(row)) return parsRow;

        String[] strings = row.split(",");

        boolean dobuleQ = false;

        StringBuffer sb = null;


        for(String e : strings) {
            if(e.startsWith("\"")) {
                dobuleQ = true;
                sb = new StringBuffer();
                sb.append(e,1,e.length());
                sb.append(",");
                continue;
            }

            if(dobuleQ) {
                if(e.endsWith("\"")) {
                    sb.append(e,0,e.length()-1);
                    parsRow.add(sb.toString());
                    dobuleQ = false;

                } else {
                    sb.append(e);
                }
            } else {
                parsRow.add(e);
            }
        }
        return parsRow;
    }

    /**
     * csv 파일을 읽어서 CsvDTO 리스트 변환
     * @param reader Csv 파일
     * @return CsvDTO List
     * @throws ComException ComException
     */
    public static <T extends CsvEntity> List<T> csvFileToDTO(final Reader reader, Class<T> dtoClass) throws ComException {
        String line;
        List<T> rowList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(reader)){
            br.readLine();//첫줄 넘기기
            while ((line = br.readLine()) != null) {
                T t = dtoClass.newInstance();

                t.rowToDto(parsingCsvRow(line));
                rowList.add(t);
            }
        } catch (Exception e) {
            log.error("readCsvFile ERR",e);
            throw new ComException(ResCode.E999);
        }

        return rowList;
    }

}
