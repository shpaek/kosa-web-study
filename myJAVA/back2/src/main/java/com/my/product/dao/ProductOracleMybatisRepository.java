package com.my.product.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.my.exception.FindException;
import com.my.product.dto.Product;
import com.my.sql.MyConnection;

public class ProductOracleMybatisRepository implements ProductRepository {
	private SqlSessionFactory sqlSessionFactory;

	public ProductOracleMybatisRepository() {
		String resource = "com/my/sql/mybatis-config.xml";
		InputStream inputStream;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> selectAll(int startRow, int endRow) throws FindException {
		
		SqlSession session = null;
		List<Product> list = new ArrayList<>();	
		try {
			session = sqlSessionFactory.openSession();
			//session.selectOne();
			Map<String, Integer> map = new HashMap<>();
			map.put("start", startRow);
			map.put("end", endRow);
			list = session.selectList("com.my.product.ProductMapper.selectAll", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	public int selectCount() throws FindException{
		
		SqlSession session = null;

		try {
			session = sqlSessionFactory.openSession(); //Connection
			int count = session.selectOne("com.my.product.ProductMapper.selectCount");
			return count;
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}		
	}




	@Override
	public Product selectByProdNo(String prodNo) throws FindException {
		SqlSession session = null;

		try {
			session = sqlSessionFactory.openSession(); //Connection
			Product p = session.selectOne("com.my.product.ProductMapper.selectByProdNo", prodNo);
			if(p != null) {
				return p;
			}else {
				throw new FindException("상품이 없습니다");
			}
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}		
	}


}
