package com.spirit.cloud.seata.business.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirit.cloud.seata.business.service.BusinessService;

import lombok.AllArgsConstructor;

/**
 * 
 * @author User
 *
 */
@RestController
@AllArgsConstructor
public class BusinessController {

	private BusinessService businessService;
	/**
	 * 购买下单，模拟全局事务提交
	 */
	@RequestMapping("/purchase/commit")
	public Boolean purchaseCommit() {
		businessService.purchase("1001", "2001", 1);
		return true;
	}
	/**
	 * 购买下单，模拟全局事务回滚
	 */
	@RequestMapping("/purchase/rollback")
	public Boolean purchaseRollback() {
		try {
			businessService.purchase("1002", "2001", 1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
