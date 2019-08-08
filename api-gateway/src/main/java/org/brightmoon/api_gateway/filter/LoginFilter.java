package org.brightmoon.api_gateway.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * Created by 明月   on 2018-11-20 / 00:52
 *
 * @Description: 登录的zuul过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {

		// 拦截需要校验的接口
		// 是否进行拦截true - false

		return true;
	}

	@Override
	public Object run() throws ZuulException {

		// 拦截后执行的函数
		
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 4;
	}
}
