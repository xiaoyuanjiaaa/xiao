package com.fc.information.finance.service;

import com.fc.common.service.IService;
import com.fc.information.finance.entity.StoreFinance;
/**
 * <p>Title: StoreFinance</p>
 * <p>Description: 店铺财务明细表 Service 接口</p>
 * @author xiaoyj
 * @date 2019-06-27 15:36:33
 */
public interface IStoreFinanceService extends IService<StoreFinance>{
	
	/**插入数据*/
	int insertSelective(StoreFinance obj);
}
