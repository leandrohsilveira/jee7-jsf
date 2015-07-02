package br.com.lhs.jee7.jsf.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class WebRootFilter
 */
@WebFilter("/*")
public class WebRootFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// HttpServletRequest req = (HttpServletRequest) request;
		// if (StringUtils.isNotBlank(req.getRequestURI()) &&
		// !req.getRequestURI().startsWith("/jee7-jsf/javax.faces.resource") &&
		// !req.getRequestURI().startsWith("/jee7-jsf/resources")) {
		// req.getRequestDispatcher("/").forward(request, response);
		// return;
		// }
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
