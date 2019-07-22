package com.fc.member.store.user.service;

import com.fc.common.service.IService;
import com.fc.member.store.user.entity.StoreLicense;
/**
 * <p>Title: StoreLicense</p>
 * <p>Description: 服务模板表 Service 接口</p>
 * @author xiaoyj
 * @date 2019-06-28 11:15:43
 */
public interface IStoreLicenseService extends IService<StoreLicense>{
	
	/**插入数据*/
	int insertSelective(StoreLicense obj);
}
