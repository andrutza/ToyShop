package toyshop.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		String url = "";
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String role = authorities.iterator().next().getAuthority();
		if (isAdmin(role)) {
			url = "/admin";
		} else if (isSeller(role)) {
			url = "/seller";
		} else {
			url = "/accessDenied";
		}
		return url;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	private boolean isSeller(String role) {
		if (role.equals("ROLE_SELLER")) {
			return true;
		}
		return false;
	}

	private boolean isAdmin(String role) {
		if (role.equals("ROLE_ADMINISTRATOR")) {
			return true;
		}
		return false;
	}

}
