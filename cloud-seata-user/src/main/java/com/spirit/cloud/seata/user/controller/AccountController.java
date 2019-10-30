package com.spirit.cloud.seata.user.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirit.cloud.seata.user.service.AccountService;

import lombok.AllArgsConstructor;

/**
 * 
 * @author User
 *
 */
@RestController
@AllArgsConstructor
public class AccountController {

	private AccountService accountService;
	//账户计算
	@RequestMapping("/debit")
	public Boolean debit(String userId, BigDecimal money) {
		accountService.debit(userId, money);
		return true;
	}
}
