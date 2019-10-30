package com.spirit.cloud.seata.storage.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spirit.cloud.seata.storage.entity.StorageTbl;
import com.spirit.cloud.seata.storage.mapper.StorageMapper;

import lombok.AllArgsConstructor;
/**
 * 库存
 * @author User
 *
 */
@Service
@AllArgsConstructor
public class StorageService {

	private StorageMapper storageDAO;

	/**
	 * 
	 * @param commodityCode
	 * @param count
	 */
	@Transactional
	public void deduct(String commodityCode, int count) {
		StorageTbl storageTbl = StorageTbl.builder().commodityCode(commodityCode).build();
		//
		StorageTbl storage = storageDAO.selectOne(new QueryWrapper<>(storageTbl));
		storage.setCount(storage.getCount() - count);
		//修改库存
		storageDAO.updateById(storage);
	}
}
