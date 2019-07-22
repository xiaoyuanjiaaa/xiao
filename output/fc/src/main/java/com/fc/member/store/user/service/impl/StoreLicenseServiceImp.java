package com.fc.member.store.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fc.common.plugin.mybatis.IMapper;
import com.fc.common.service.impl.ServiceImpl;

import com.fc.member.store.user.dao.IStoreLicenseDao;
import com.fc.member.store.user.service.IStoreLicenseService;
import com.fc.member.store.user.entity.StoreLicense;
/**
 * <p>Title: StoreLicense</p>
 * <p>Description: 服务模板表 Service 层</p>
 * @author xiaoyj
 * @date 2019-06-28 11:15:43
 */
@Service("storeLicenseService")
public class StoreLicenseServiceImp extends ServiceImpl<StoreLicense> implements IStoreLicenseService{

	@Autowired
	private IStoreLicenseDao storeLicenseDao;
	
	@Override
	protected IMapper<StoreLicense> getDao() {
		return storeLicenseDao;
	}
	/**
	 * 插入数据
	 * @return
	 */
	@Override
	public int insertSelective(StoreLicense obj) {
		return storeLicenseDao.insertSelective(obj);
	}
}
