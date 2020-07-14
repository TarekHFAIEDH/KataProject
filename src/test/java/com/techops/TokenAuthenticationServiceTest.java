package com.techops;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import  com.techops.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenAuthenticationServiceTest {

    @Autowired
    private MockMvc mvc;



    @Test
    public void registerUserTest() throws Exception {
        String uri = "/register";
        User user = new User();
        user.setUsername("Tarik");
        user.setPassword("123");
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(user);
        System.out.println(jsonString);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonString)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is created successfully");
    }



    @Test
    public void getOperationsTest() throws Exception {
        String token = TokenAuthenticationService.createToken("tarik");
      //  String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0YXJlayIsImV4cCI6MTU5NDY1MjQ5NiwiaWF0IjoxNTk0NjM0NDk2fQ.0EafNfYb0xpZbAg3PmALLlGzkiud0LQS2hjkpETj5mZG8JB2WNx2kyyrwJkb41ugUpMoSi_1I0CMHqYDmn5hvw";
        mvc.perform(MockMvcRequestBuilders.get("/KataServices/operations").header("Authorization", "Bearer "+token)).andExpect(status().isOk());

    }
  @Test
  public void depositOperationTest() throws Exception {
    String token = TokenAuthenticationService.createToken("tarik");
    String body = "{\"amount\":\"10000\"}";
    mvc.perform(MockMvcRequestBuilders.put("/KataServices/deposit")
            .content(body)
            .header("Authorization", "Bearer "+token))
            .andExpect(status().isForbidden()).andReturn();
}
    @Test
    public void withDrawalOperationTest() throws Exception {
        String token = TokenAuthenticationService.createToken("tarik");
        String body = "{\"amount\":\"10000\"}";
        mvc.perform(MockMvcRequestBuilders.put("/KataServices/withdrawal")
                .content(body)
                .header("Authorization", "Bearer "+token))
                .andExpect(status().isForbidden()).andReturn();
    }
}