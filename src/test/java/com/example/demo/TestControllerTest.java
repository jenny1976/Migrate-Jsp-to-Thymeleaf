/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class TestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void showHomeJspResolver() throws Exception {
        ResultActions result = mockMvc.perform(get("/jsp"));

        result
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("items"));
    }

    @Test
    public void showHomeThymeleafResolver() throws Exception {
        ResultActions result = mockMvc.perform(get("/thymeleaf"));

        result
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("items"));
    }

    private void assertView(ResultActions result, String viewResolver) throws Exception {
        result
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("name", "Spring Squad"))
                .andExpect(view().name(viewResolver + "/home"));
    }
}
