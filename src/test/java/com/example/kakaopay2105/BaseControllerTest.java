package com.example.kakaopay2105;

import com.example.kakaopay2105.web.controller.BaseController;
import com.example.kakaopay2105.web.controller.MainController;
import com.example.kakaopay2105.web.service.KakaoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BaseControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    BaseController controller;
    @Mock
    KakaoService mockKakaoService;

    // == 단독모드 ==
    @Before
    public void setUpMockMvc() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk());
    }
}
