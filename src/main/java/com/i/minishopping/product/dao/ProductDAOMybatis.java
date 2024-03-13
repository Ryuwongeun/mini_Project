package com.i.minishopping.product.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.i.minishopping.product.bean.ProductDTO;

import java.util.List;

@Transactional
@Repository
public class ProductDAOMybatis implements ProductDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void write(ProductDTO productDTO) {
        sqlSession.insert("productSQL.write", productDTO);
    }

    @Override
    public List<ProductDTO> getProductList() {
        return sqlSession.selectList("productSQL.getProductList");
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        sqlSession.update("productSQL.updateProduct", productDTO);
    }

    @Override
    public void deleteProduct(ProductDTO productDTO) {
        sqlSession.delete("productSQL.deleteProduct", productDTO);
    }
}
