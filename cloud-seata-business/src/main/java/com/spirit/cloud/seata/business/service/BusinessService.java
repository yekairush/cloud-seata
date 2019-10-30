package com.spirit.cloud.seata.business.service;

import org.springframework.stereotype.Service;
import com.spirit.cloud.seata.business.feign.OrderFeignClient;
import com.spirit.cloud.seata.business.feign.StorageFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;

/**
 * 
 * @author User
 *
 */
@Service
@AllArgsConstructor
public class BusinessService {
	private StorageFeignClient storageFeignClient;
	private OrderFeignClient orderFeignClient;
	/**
	 * 减库存，下订单
	 */
	@GlobalTransactional
	public void purchase(String userId, String commodityCode, int orderCount) {
		// 减库存
		storageFeignClient.deduct(commodityCode, orderCount);
		// 下订单
		orderFeignClient.create(userId, commodityCode, orderCount);
	}
}
