package com.spirit.cloud.seata.order.feign;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户相关接口
 * 
 * @author User
 *
 */
@FeignClient(name = "account-service", url = "127.0.0.1:8083")
public interface UserFeignClient {

	/**
	 * 
	 * @param userId
	 * @param money
	 * @return
	 */
	@GetMapping("/debit")
	Boolean debit(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);
}
