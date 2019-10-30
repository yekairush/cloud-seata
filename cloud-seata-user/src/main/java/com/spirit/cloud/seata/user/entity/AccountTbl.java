package com.spirit.cloud.seata.user.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountTbl {

  @TableId(value = "user_id")
  private Long id;
  private String userId;
  private BigDecimal money;
}
