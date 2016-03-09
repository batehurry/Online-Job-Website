package com.qzw.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itiddler.web.GetRequest;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.filters </p>
 * <p> 类名称：EncodingFilter.java  </p>
 * <p> 类描述：编码过滤器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月8日  下午10:33:14
 * @version 1.0
 */
public class EncodingFilter implements Filter {
	
	private String charset = "UTF-8";

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) response;
		if (req.getMethod().equalsIgnoreCase("GET")) {
			if (!(req instanceof GetRequest)) {
				req = new GetRequest(req, charset);
			}
		} else {
			req.setCharacterEncoding(charset);
		}
		rsp.setCharacterEncoding(charset);
		chain.doFilter(req, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		String charset = fConfig.getInitParameter("charset");
		if (charset != null && !charset.isEmpty()) {
			this.charset = charset;
		}
	}
	
}