package com.hexa.CareerPortal.security;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
 
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	private JwtTokenProvider jwtTokenProvider;
	private UserDetailsService customUserDetails;
	public static String CURRENT_USER = "";
	public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UserDetailsService customUserDetails) {
		this.jwtTokenProvider = jwtTokenProvider;
		this.customUserDetails = customUserDetails;
	}
 
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// get jwt token from http request
		String token = getTokenFromRequest(request);
		// validate token
		if(StringUtils.hasText(token) && jwtTokenProvider.validateToken(token))
		{
			// get username from token
			String username = jwtTokenProvider.getUsername(token);
			CURRENT_USER  = username;
			// load user name
			UserDetails  userDetails = customUserDetails.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		filterChain.doFilter(request, response);
	}
	private String getTokenFromRequest(HttpServletRequest request)
	{
		String bearerToken = request.getHeader("Authorization");
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
		{
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
}