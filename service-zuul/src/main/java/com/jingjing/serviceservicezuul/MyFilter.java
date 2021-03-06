package com.jingjing.serviceservicezuul;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(MyFilter.class);

	//这里可以写逻辑  是否要过滤 
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	//过滤器的具体逻辑，可以很复杂 包括差sql nosql 去判断该请求到底有没有权限
	@Override
	public Object run()  {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken =request.getParameter("token");
		if (accessToken==null) {
			log.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		log.info("ok");
		return null;
	}

	//过滤器的类型 
		//四种生命周期
			// pre 路由之前，routing 路由之时，post 路由之后，error 发送错误调用
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	//过滤的顺序
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
