package com.nkarri.waracle.cakemanager.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nkarri.waracle.cakemanager.models.Cake;
import com.nkarri.waracle.cakemanager.service.CakeService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CakeRestControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CakeService mockCakeService;


    @Test
    public void givenValidCake_WhenPostInvoked_ShouldReturn200() throws JSONException {

        String cakeJson = "{\"number\": \"12\", \"name\":\"Chocolate mud cake\", \"info\": \"We think we’ve found the ultimate mud cake – it’s rich, dense and oh so chocolatey.\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(cakeJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("/cakes", entity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(mockCakeService, times(1)).newCake(any(Cake.class));
    }

    /*
        {
            "status":400,
            "errors":["Please provide a Cake Number"]
        }
     */
    @Test
    public void givenEmptyNumber_WhenPostInvoked_ShouldReturn400() throws JSONException {

        String cakeJson = "{\"name\": \"Fruit Cake\",  \"info\": \"Mixed fruits cake with great taste\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(cakeJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("/cakes", entity, String.class);

        String expectedJson = "{\"status\":400,\"errors\":[\"Please provide a Cake Number\"]}";
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        JSONAssert.assertEquals(expectedJson, response.getBody(), false);

        verify(mockCakeService, times(0)).newCake(any(Cake.class));

    }

    /*
        {
            "status":400,
            "errors":["Please provide a Cake Name"]
        }
     */
    @Test
    public void givenEmptyName_WhenPostInvoked_ShouldReturn400() throws JSONException {

        String cakeJson = "{\"number\": \"13\",  \"info\": \"Mixed fruits cake with great taste\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(cakeJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("/cakes", entity, String.class);

        String expectedJson = "{\"status\":400,\"errors\":[\"Please provide a Cake Name\"]}";
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        JSONAssert.assertEquals(expectedJson, response.getBody(), false);

        verify(mockCakeService, times(0)).newCake(any(Cake.class));

    }

    /*
        {
            "status":400,
            "errors":["Please provide Cake Info"]
        }
     */
    @Test
    public void givenEmptyInfo_WhenPostInvoked_ShouldReturn400() throws JSONException {

        String cakeJson = "{\"number\": \"13\",  \"name\": \"Fruit Cake\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(cakeJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("/cakes", entity, String.class);

        String expectedJson = "{\"status\":400,\"errors\":[\"Please provide Cake Info\"]}";
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        JSONAssert.assertEquals(expectedJson, response.getBody(), false);

        verify(mockCakeService, times(0)).newCake(any(Cake.class));

    }
}
