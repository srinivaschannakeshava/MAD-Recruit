package com.mad.recruit.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mad.recruit.bean.AdminBean;
import com.mad.recruit.service.HttpServices;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		try {
			String name = authentication.getName();
			String password = authentication.getCredentials().toString();
			// AdminBean admin=new AdminBean(name,password);
			HttpServices httpPut = new HttpServices();
			String admin = httpPut.sendPut("mgetlogin",
					"{\"username\":\"" + name + "\",\"password\":\"" + password + "\"}");

			if (admin != null) {
				ObjectMapper mapper = new ObjectMapper();

				AdminBean user = mapper.readValue(admin, AdminBean.class);

				List<GrantedAuthority> grantedAuths = new ArrayList<>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
				Authentication auth = new UsernamePasswordAuthenticationToken(user, password, grantedAuths);
				return auth;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(UsernamePasswordAuthenticationToken.class);
	}

}
