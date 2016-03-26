/**
 * 
 */
package com.mad.recruit;

import org.apache.commons.lang3.CharEncoding;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HSN7KOR
 *
 */

@Controller
@RequestMapping("/login")
public class LoginController
{

	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage()
	{
		return "login";
	}

	@RequestMapping(value = "/isLoggedIn", produces = MediaType.APPLICATION_JSON_VALUE + ";charset="
			+ CharEncoding.UTF_8, method = RequestMethod.GET)
	public @ResponseBody String isLoggedIn()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && !(auth instanceof AnonymousAuthenticationToken))
		{
			if (auth.isAuthenticated())
			{
				return "{\"loggedin\":\"true\"}";
			}
		}
		return "{\"loggedin\":\"false\"}";
	}

	@RequestMapping(value = "/loggedInUser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody String isLoggedInUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return name;
	}

	@RequestMapping(value = "/success", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody String loginSuccess()
	{
		return "{\"login\":\"success\"}";
	}

	@RequestMapping(value = "/failure", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody String loginFailure()
	{
		return "{\"login\":\"failure\"}";
	}

	@RequestMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody String logout()
	{
		return "{\"logout\":\"success\"}";
	}
}
