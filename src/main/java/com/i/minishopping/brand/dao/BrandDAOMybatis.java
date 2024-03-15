package com.i.minishopping.brand.dao;

import com.i.minishopping.brand.bean.BrandDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BrandDAOMybatis implements BrandDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public BrandDTO checkBrandId(Long brandId) {
        return null;
    }
}
