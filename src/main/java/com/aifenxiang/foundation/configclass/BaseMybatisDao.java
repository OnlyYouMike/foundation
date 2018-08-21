package com.aifenxiang.foundation.configclass;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author: zj
 * @create: 2018-08-21 21:50
 **/
public class BaseMybatisDao extends SqlSessionTemplate {

    public BaseMybatisDao(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }
}
