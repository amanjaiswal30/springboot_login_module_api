package com.server.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.server.model.UserDataAccessObject;
import com.server.model.UserDataStoringObject;
import com.server.service.JwtUserDetailsService;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class JwtAuthenticationControllerTest {
	JwtUserDetailsService uds=mock(JwtUserDetailsService.class);
	 @Autowired
	 private MockMvc mvc;
	 @Autowired
	 WebApplicationContext context;
	 @Test
	    public void shouldNotAllowAccessToUnAuthenticatedUsers() throws Exception {
	        ResultMatcher isUnauthorized = status().isUnauthorized();
	        String body = "{\"username\":\"" + "sahiljsr11@gmail.com" + "\",\"password\":\"" + "#Bfmvaj03" + "\"}";
	        mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(isUnauthorized);
	    }
	 @Test
	 public void shouldGenerateAuthToken() throws Exception {
	        String body = "{\"username\":\"" + "amanjazz@gmail.com" + "\",\"password\":\"" + "#Bfmvaj03" + "\"}";
	        mvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(body)).andReturn().getResponse().getContentAsString().contains("bearer");
	    }
	 @Test
	 public void testRegistration() throws Exception
	 {
		 String body = "{\"username\":\"" + "sahil1js1r11@gmail.com" + "\",\"password\":\"" + "#Bfmvaj03" + "\"}";
		 mvc.perform(MockMvcRequestBuilders.post("/register").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isOk()).andReturn();
	 }
}