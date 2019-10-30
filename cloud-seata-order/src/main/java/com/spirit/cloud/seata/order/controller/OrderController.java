package com.spirit.cloud.seata.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirit.cloud.seata.order.service.OrderService;

import lombok.AllArgsConstructor;

/**
 * 
 * @author User
 *
 */
@RestController
@AllArgsConstructor
public class OrderController {

	/**
	 * 
	 */
	private OrderService orderService;

	/**
	 * 创建订单
	 * 
	 * @param userId
	 * @param commodityCode
	 * @param count
	 * @return
	 */
	@GetMapping("/create")
	public Boolean create(String userId, String commodityCode, Integer count) {
		orderService.create(userId, commodityCode, count);
		return true;
	}

}
