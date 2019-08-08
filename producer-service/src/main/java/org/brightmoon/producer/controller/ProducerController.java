package org.brightmoon.producer.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.brightmoon.producer.model.Product;
import org.brightmoon.producer.service.impl.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProducerController {

	@Value("${server.port}")
	private String port;

	@Autowired
	private ProducerService producerService;

	@GetMapping("/list")
	public List<Product> queryAllProduct(HttpServletRequest request) {
		return producerService.queryAllProduct();
	}

	@GetMapping("/{id}")
	public Product queryAllProduct(@PathVariable(value = "id", required = false) String id) {

		Product product = producerService.queryProductById(Integer.valueOf(id));

		product.setName(product.getName() + " -> server.port = " + port);

		return product;
	}

	@GetMapping("/feginTimeOutTest")
	public void feginTimeOutTest() {
		System.out.println("API -> feginTimeOutTest : Begin");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("API -> feginTimeOutTest : Over");
	}
}