package com.microservice.rickmaster;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.microservice.rickmaster.controller.CoffeeController;
import com.microservice.rickmaster.model.Coffee;
import com.microservice.rickmaster.service.CoffeeService;
import org.jose4j.json.JsonUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@WebMvcTest(value = CoffeeController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class RickMasterApplicationTests {
    @MockBean
    private CoffeeService coffeeService;


    @Autowired
    private MockMvc mockMvc;



    @Test
    public void PostCreateCoffee() throws Exception {
        Coffee coffee= new Coffee();
        coffee.setWeight(60F);
        coffee.setArabica(30);
        coffee.setRobust(70);
        coffee.setCountry("aaaa");
        coffee.setSort("great");
        given(coffeeService.create(Mockito.any())).willReturn(coffee);
        ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json= ow.writeValueAsString(coffee);
        mockMvc.perform(post("/api/coffee").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(json)))
                .andExpect(jsonPath("$.sort",is("great")))
                .andExpect(jsonPath("$.country",is("aaaa")))
                .andExpect(jsonPath("$.robust",is("70")))
                .andExpect(jsonPath("$.arabica",is("30")));
        verify(coffeeService,VerificationModeFactory.times(1)).create(Mockito.any());
        reset(coffeeService);
    }

}
