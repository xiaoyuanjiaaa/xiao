package com.fc.information.finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fc.common.plugin.mybatis.IMapper;
import com.fc.common.service.impl.ServiceImpl;

import com.fc.information.finance.dao.IStoreFinanceDao;
import com.fc.information.finance.service.IStoreFinanceService;
import com.fc.information.finance.entity.StoreFinance;
/**
 * <p>Title: StoreFinance</p>
 * <p>Description: 店铺财务明细表 Service 层</p>
 * @author xiaoyj
 * @date 2019-06-27 15:36:33
 */
@Service("storeFinanceService")
public class StoreFinanceServiceImp extends ServiceImpl<StoreFinance> implements IStoreFinanceService{

	@Autowired
	private IStoreFinanceDao storeFinanceDao;
	
	@Override
	protected IMapper<StoreFinance> getDao() {
		return storeFinanceDao;
	}
	/**
	 * 插入数据
	 * @return
	 */
	@Override
	public int insertSelective(StoreFinance obj) {
		return storeFinanceDao.insertSelective(obj);
	}
}
