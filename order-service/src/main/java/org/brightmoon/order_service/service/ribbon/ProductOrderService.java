package org.brightmoon.order_service.service.ribbon;

import org.brightmoon.order_service.model.ProductOrder;

public interface ProductOrderService {

	/**
	 * 下单接口(ribbon调用)
	 */
	ProductOrder save(Integer userId, Integer productId);
}