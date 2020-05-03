package com.server.config;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;

import com.server.config.JwtAuthenticationEntryPoint;

import org.junit.runner.RunWith;
@RunWith(MockitoJUnitRunner.class)
@EnableWebSecurity
class JwtAuthenticationEntryPointTest {
	JwtAuthenticationEntryPoint auth=new JwtAuthenticationEntryPoint();
	@Test
	public void commence() throws IOException,ServletException{
		MockHttpServletRequest request=new MockHttpServletRequest();
		MockHttpServletResponse response=new MockHttpServletResponse();
		AuthenticationException ex=new AuthenticationCredentialsNotFoundException("");
		auth.commence(request, response,ex );
		assertEquals(HttpServletResponse.SC_UNAUTHORIZED,response.getStatus());
	}
}