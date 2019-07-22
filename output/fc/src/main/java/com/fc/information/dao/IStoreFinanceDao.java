package com.fc.information.dao;

import org.apache.ibatis.annotations.Mapper;

import com.fc.common.plugin.mybatis.IMapper;

import com.fc.information.entity.StoreFinance;
/**
 * <p>Title: StoreFinance</p>
 * <p>Description: 店铺财务明细表 DAO层</p>
 * @author xiaoyj
 * @date 2019-06-27 15:29:56
 */
@Mapper
public interface IStoreFinanceDao extends IMapper<StoreFinance>{
	/**插入数据*/
	int insertSelective(StoreFinance obj);
}