package com.spirit.cloud.seata.user.service;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spirit.cloud.seata.user.entity.AccountTbl;
import com.spirit.cloud.seata.user.mapper.AccountMapper;

import lombok.AllArgsConstructor;

/**
 * 
 * @author User
 *
 */
@Service
@AllArgsConstructor
public class AccountService {

	
  /**
   * 
   */
  private static final String ERROR_USER_ID = "1002";

  /**
   * 
   */
  private AccountMapper accountDAO;

  /**
   * 
   * @param userId
   * @param num
   */
  @Transactional(rollbackFor = Exception.class)
  public void debit(String userId, BigDecimal num) {
	//查询账户
    AccountTbl account = accountDAO.selectById(userId);
    account.setMoney(account.getMoney().subtract(num));
    //修改账户余额
    accountDAO.updateById(account);
    //
    if (ERROR_USER_ID.equals(userId)) {
      throw new RuntimeException("account branch exception");
    }
  }
}
