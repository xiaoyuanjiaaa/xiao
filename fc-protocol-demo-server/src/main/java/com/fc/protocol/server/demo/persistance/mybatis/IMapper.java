package com.fc.protocol.server.demo.persistance.mybatis;

import java.util.List;

/**
 * <p>Title: IMapper</p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author wanghw
 * @date 2016年3月21日
 */
public interface IMapper<T> {
	/**
	 * 根据主键查询记录
	 * @param key 主键的集合
	 * @return 实体对象
	 */
	public T getByPK(Object key);

	/**
	 * 根据实体对象查询记录
	 * @param t 实体对象
	 * @return 实体对象列表
	 */
	public List<T> getRows(T t);

	/**
	 * 根据查询条件查询记录
	 * @param PageQuery pageQuery 封装的查询条件对象
	 * @return 实体对象列表
	 */
	public List<T> getRowsPage(PageQuery pageQuery);

	/**
	 * 创建对象
	 * @param t 实体对象
	 */
	public void create(T t) throws Exception;

	/**
	 * 更新对象
	 * @param t 实体对象
	 */
	public void update(T t) throws Exception;

	/**
	 * 根据主键删除对象
	 * @param key 主键的集合
	 */
	public void deleteByPK(Object key) throws Exception;
}
