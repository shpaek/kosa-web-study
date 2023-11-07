package com.my.customer.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.customer.dto.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository(value = "customerDAO")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class CustomerOracleMybatisRepository implements CustomerRepository {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public Customer selectById(String id) throws FindException {
//		String resource = "com/my/sql/mybatis-config.xml";
//		InputStream inputStream;
		SqlSession session = null;
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory =
//					new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			Customer c = (Customer)session.selectOne("com.my.customer.CustomerMapper.selectById", id);
			if(c != null) {
				return c;
			}else {
				throw new FindException("고객이 없습니다");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}		

	}
	@Override
	public void insert(Customer c) throws AddException {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			session.insert("com.my.customer.CustomerMapper.insert", c);
			session.commit();
		} catch(Exception e){
			session.rollback();
			throw new AddException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	
}