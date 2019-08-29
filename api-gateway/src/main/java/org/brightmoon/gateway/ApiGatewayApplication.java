package org.brightmoon.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Kim QQ.Cong on 2019-08-08 / 14:22:28
 *
 * @author: CongQingquan
 * @Description: 网关服务启动类
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}