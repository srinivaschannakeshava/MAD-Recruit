package com.mad.recruit.auth;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * <p>
 * A post-processor for successful authentication. The target page to be shown
 * is determined using the 'loginSuccessURL' set in the security.xml
 * configuration file.
 * </p>
 * 
 * 
 */
public class AuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {

	private String loginSuccessURL;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		getRedirectStrategy().sendRedirect(request, response, getLoginSuccessURL());
	}

	/**
	 * @return the loginSuccessURL
	 */
	private String getLoginSuccessURL() {
		return loginSuccessURL;
	}

	/**
	 * @param loginSuccessURL
	 *            the loginSuccessURL to set
	 */
	public void setLoginSuccessURL(String loginSuccessURL) {
		this.loginSuccessURL = loginSuccessURL;
	}

}
