package org.brightmoon.order_service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {

	@Bean
	@LoadBalanced// 构建并注入ribbon包裹的Rest请求模版(支持负载均衡,也是注解的名字.会去eureka中寻找注册的商品生产者的请求URL)
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
