/**
 * 
 */
package com.mad.recruit.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * <p>
 * Post processes a failed login attempt. The target page to be shown is
 * determined using the 'loginFailureURL' set in the security.xml configuration
 * file.
 * </p>
 * 
 *
 */
public class AuthenticationFailureHandler extends
		SimpleUrlAuthenticationFailureHandler {

	private String loginFailureURL;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		getRedirectStrategy().sendRedirect(request, response,
				getLoginFailureURL());
	}

	/**
	 * @return the loginFailureURL
	 */
	private String getLoginFailureURL() {
		return loginFailureURL;
	}

	/**
	 * @param loginFailureURL
	 *            the loginFailureURL to set
	 */
	public void setLoginFailureURL(String loginFailureURL) {
		this.loginFailureURL = loginFailureURL;
	}
}
