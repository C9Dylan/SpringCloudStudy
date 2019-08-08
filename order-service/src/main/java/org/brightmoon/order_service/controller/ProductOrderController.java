package org.brightmoon.order_service.controller;

import org.brightmoon.order_service.model.ProductOrder;
import org.brightmoon.order_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api/v1/order")
@SuppressWarnings("all")
public class ProductOrderController {

	@Autowired
	@Qualifier("ribbonService")
	private org.brightmoon.order_service.service.ribbon.ProductOrderService ribbonProductOrderService;

	@Autowired
	@Qualifier("feignService")
	private org.brightmoon.order_service.service.feign.ProductOrderService feignProductOrderService;

	@GetMapping("/ribbon{uid}/{pid}")
	public ProductOrder saveOrderAndGet(@PathVariable("uid") String uid, @PathVariable("pid") String pid) {
		return ribbonProductOrderService.save(Integer.valueOf(uid), Integer.valueOf(pid));
	}

	@GetMapping("/feign/{uid}/{pid}")
	@HystrixCommand(fallbackMethod = "productOrderFallBack") // 调用下游服务异常时,会执行fallback处理函数
	public ProductOrder feignSava(@PathVariable("uid") String uid, @PathVariable("pid") String pid) {
		return feignProductOrderService.feignSava(Integer.valueOf(uid), Integer.valueOf(pid));
	}

	@GetMapping("/feginTimeOutTest")
	@HystrixCommand(fallbackMethod = "feignTimeoutTestFallBack") // 调用下游服务异常时,会执行fallback处理函数
	public Response<Object> feignTimeOutTest() {
		return feignProductOrderService.feignTimeoutTest();
	}

	/**
	 * 回退处理函数
	 */
	private ProductOrder productOrderFallBack(String uid, String pid) {
		System.out.println("productOrderFallBack method");
		return null;
	}
	
	private Response<Object> feignTimeoutTestFallBack() {
		System.out.println("feignTimeoutTestFallBack method");
		return null;
	}
}
