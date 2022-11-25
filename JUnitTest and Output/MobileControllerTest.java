package com.example.mobile.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.example.mobile.entity.Mobile;
import com.example.mobile.service.MobileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MobileController.class})
@ExtendWith(SpringExtension.class)
class MobileControllerTest {
    @Autowired
    private MobileController mobileController;

    @MockBean
    private MobileService mobileService;

  
    @Test
    void testAddMobile() throws Exception {
        Mobile mobile = new Mobile();
        mobile.setId(1);
        mobile.setName("Name");
        mobile.setPrice(1);
        mobile.setStatus("Status");
        String content = (new ObjectMapper()).writeValueAsString(mobile);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mobile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(mobileController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

   
  
    @Test
    void testGetMobile() throws Exception {
        Mobile mobile = new Mobile();
        mobile.setId(1);
        mobile.setName("Name");
        mobile.setPrice(1);
        mobile.setStatus("Status");
        when(mobileService.getMobile(anyInt())).thenReturn(mobile);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mobile/{id}", 1);
        MockMvcBuilders.standaloneSetup(mobileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\",\"price\":1,\"status\":\"Status\"}"));
    }
}

