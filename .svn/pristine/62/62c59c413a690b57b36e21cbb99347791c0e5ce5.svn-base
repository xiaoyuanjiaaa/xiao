package com.fc.protocol.server.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.fc.protocol.server.demo.entity.Test;
import com.fc.protocol.server.demo.entity.WechatRecharge;
import com.fc.protocol.server.demo.persistance.mybatis.IMapper;
import com.fc.protocol.server.demo.persistance.mybatis.PageQuery;
 
/**
 * Created by jack on 2017/7/20.
 * 接口，对Test表进行操作
 */
@Mapper
public interface TestMapper extends IMapper<Test> {
    Test findTestById(int id);
 
    int add(Test test);
 
    int deleteById(int id);
 
    int updateByID(Test test);
 
    List<Test> findByName(String name);
    
    public List<Map<String, Object>> getTestListPage(PageQuery pageQuery);
    
}