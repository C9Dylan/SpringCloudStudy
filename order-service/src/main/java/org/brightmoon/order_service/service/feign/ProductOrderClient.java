package org.brightmoon.order_service.service.feign;

import org.brightmoon.order_service.model.Product;
import org.brightmoon.order_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 生成一个代理类,代理内部使用的依旧是http请求来访问其他服务
 */
@FeignClient(name = "product-service", fallback = ProductOrderFallback.class)
public interface ProductOrderClient {
	/**
	 * 下单接口(feign调用)
	 */
	@GetMapping("/api/v1/product/{id}")
	Product queryProductById(@PathVariable(value = "id") Integer pid);

	@GetMapping("/api/v1/product/feginTimeOutTest")
	Response<Object> feginTimeOutTest();
}