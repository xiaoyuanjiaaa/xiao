package com.fc.member.store.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.fc.common.plugin.mybatis.IMapper;

import com.fc.member.store.user.entity.StoreLicense;
/**
 * <p>Title: StoreLicense</p>
 * <p>Description: 服务模板表 DAO层</p>
 * @author xiaoyj
 * @date 2019-06-28 11:15:43
 */
@Mapper
public interface IStoreLicenseDao extends IMapper<StoreLicense>{
	/**插入数据*/
	int insertSelective(StoreLicense obj);
}