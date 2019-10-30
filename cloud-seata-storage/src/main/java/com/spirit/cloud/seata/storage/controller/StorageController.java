package com.spirit.cloud.seata.storage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirit.cloud.seata.storage.service.StorageService;

import lombok.AllArgsConstructor;

/**
 * 
 * @author User
 *
 */
@RestController
@AllArgsConstructor
public class StorageController {

	private StorageService storageService;
	/**
	 * 减库存
	 * @param commodityCode
	 * @param count
	 * @return
	 */
	@GetMapping(path = "/deduct")
	public Boolean deduct(String commodityCode, Integer count) {
		storageService.deduct(commodityCode, count);
		return true;
	}
}
