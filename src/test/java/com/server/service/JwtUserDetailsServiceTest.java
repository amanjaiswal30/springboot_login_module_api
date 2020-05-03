package com.server.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.server.dao.UserDao;
import com.server.model.UserDataAccessObject;
import com.server.model.UserDataStoringObject;
import com.server.service.JwtUserDetailsService;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class JwtUserDetailsServiceTest {
	JwtUserDetailsService jwtuds=mock(JwtUserDetailsService.class);
	@MockBean
	UserDao userdao;
	@Test
	public void testloadbyValidUsername()
	{
		UserDataStoringObject user=new UserDataStoringObject();
		UserDataAccessObject value=new UserDataAccessObject();
		value.setUsername("aman@gmail.com");
		value.setPassword("#Bfmvaj03");
		user.setUsername(value.getUsername());
		user.setPassword(value.getPassword());
		when(userdao.save(value)).thenReturn(value);
		when(userdao.findByUsername("aman@gmail.com")).thenReturn(value);
		assertThat(userdao.findByUsername(value.getUsername())).isEqualTo(value);
	}
	@Test
	public void testloadbyNullUsername()
	{
		UserDataAccessObject value=new UserDataAccessObject();
		when(userdao.findByUsername(null)).thenThrow(new UsernameNotFoundException("User not found with username"));
		try {
			userdao.findByUsername(null);
		
		}
		catch(UsernameNotFoundException e)
		{
			assertEquals("User not found with username",e.getMessage());
		}
	}
	@Test
	public void testSave()
	{
		UserDataStoringObject user=new UserDataStoringObject();
		UserDataAccessObject value=new UserDataAccessObject();
		user.setPassword("#Bfmvaj03");
		user.setUsername("aman@gmail.com");
		value.setUsername(user.getUsername());
		value.setPassword(user.getPassword());
		when(userdao.save(value)).thenReturn(value);
		assertThat(userdao.save(value)).isEqualTo(value);
	}
}
