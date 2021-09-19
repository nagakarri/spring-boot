package com.nkarri.waracle.cakemanager.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nkarri.waracle.cakemanager.models.Cake;
import com.nkarri.waracle.cakemanager.service.CakeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CakeController.class)
public class CakeControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CakeService mockCakeService;

    @Test
    public void getAllCakes() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .get("/")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

    }

    @Test
    public void givenValidCake_WhenPostInvoked_ShouldReturn200() throws Exception {
        Cake cake = new Cake(12,"12", "Chocolate mud cake", "We think we’ve found the ultimate mud cake – it’s rich, dense and oh so chocolatey");

        // Execute the POST request
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/")
                        .content(asJsonString(cake))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().is3xxRedirection());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
