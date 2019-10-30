package com.spirit.cloud.seata.order.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spirit.cloud.seata.order.entity.OrderTbl;
import com.spirit.cloud.seata.order.feign.UserFeignClient;
import com.spirit.cloud.seata.order.mapper.OrderTblMapper;

import lombok.AllArgsConstructor;

/**
 * 
 * @author User
 *
 */
@Service
@AllArgsConstructor
public class OrderService {

	private UserFeignClient userFeignClient;
	private OrderTblMapper orderDAO;

	@Transactional
	public void create(String userId, String commodityCode, Integer count) {

		BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
		OrderTbl order = new OrderTbl();
		order.setUserId(userId);
		order.setCommodityCode(commodityCode);
		order.setCount(count);
		order.setMoney(orderMoney);
		// 订单创建
		orderDAO.insert(order);
		// 用户账务处理
		userFeignClient.debit(userId, orderMoney);
	}

}
