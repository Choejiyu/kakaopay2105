package com.example.kakaopay2105;

import org.junit.Test;
import org.json.JSONObject;
import com.example.kakaopay2105.web.controller.MainController;
import com.example.kakaopay2105.web.dto.ResultDTO;
import com.example.kakaopay2105.web.service.KakaoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MainControllerTest {

    private MockMvc mockMvc;

   @Autowired
   private KakaoService kakaoService;

    @InjectMocks
    MainController maincontroller;

    @Mock
    KakaoService mockKakaoService;

    // == 단독모드 ==
    @Before
    public void setUpMockMvc() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(maincontroller).build();
    }

    @Test
    public void result01Test() throws Exception{

        final ResultDTO resultDTO = new ResultDTO();
        resultDTO.setYear("2018");
        resultDTO.setName("계좌명");
        resultDTO.setAcct("계좌번호");
        resultDTO.setSumAmt(10000);
        mockMvc.perform(get("/getResult01"))
                .andExpect(status().isOk());
               /* .andExpect(content().json(  //json array
                        "[" +
                                " {'year':'2018',\n" +
                                "   'name':'계좌명',\n" +
                                "   'acctNo':'계좌번호',\n" +
                                "   'sumAmt':10000}\n" +
                                "]"
                ));*/

    }
    @Test
    public void result02Test() throws Exception{

        final ResultDTO resultDTO = new ResultDTO();
        resultDTO.setYear("2018");
        resultDTO.setName("계좌명");
        resultDTO.setAcct("계좌번호");
        System.out.println(resultDTO);
        mockMvc.perform(get("/getResult02"))
                .andExpect(status().isOk());
                /*.andExpect(content().json(  //json array
                        "[" +
                                " {'year':'2018',\n" +
                                "   'name':'계좌명',\n" +
                                "   'acctNo':'계좌번호'}\n" +
                                "]"
                ));*/

    }
    @Test
    public void result03Test() throws Exception{
        JSONObject jsonObject = new JSONObject();
        final ResultDTO resultDTO = new ResultDTO();
        resultDTO.setYear("2018");
        resultDTO.setName("계좌명");
        resultDTO.setAcct("계좌번호");
        System.out.println(resultDTO);
        mockMvc.perform(get("/getResult03"))
                .andExpect(status().isOk());
                /*.andExpect(content().json(  //json array
                        "[" +
                                " {'year':'2018',\n" +
                                "   'name':'계좌명',\n" +
                                "   'acctNo':'계좌번호'}\n" +
                                "]"
                ));*/

    }
    @Test
    public void result04Test() throws Exception{
        final ResultDTO resultDTO = new ResultDTO();
        resultDTO.setYear("2018");
        resultDTO.setName("계좌명");
        resultDTO.setAcct("계좌번호");
        System.out.println(resultDTO);
        mockMvc.perform(get("/getResult04"));
               // .andExpect(status().isOk());
                /*.andExpect(content().json(  //json array
                        "[" +
                                " {'year':'2018',\n" +
                                "   'name':'계좌명',\n" +
                                "   'acctNo':'계좌번호'}\n" +
                                "]"
                ));*/

    }

}
