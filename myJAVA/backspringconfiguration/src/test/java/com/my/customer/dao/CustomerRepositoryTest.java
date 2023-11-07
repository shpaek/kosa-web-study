package com.my.customer.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.my.customer.dto.Customer;
import com.my.exception.FindException;

@ExtendWith(SpringExtension.class) //스프링용 단위테스트
//ApplicationContext생성 = 스프링컨테이너 = 스프링엔진 생성
@ContextConfiguration(classes = {config.MyApplicationContext.class})
class CustomerRepositoryTest {
	@Autowired
	CustomerRepository repository;
	@Test
	void test() {
		int i = 10;	//실제 처리결과 데이터
		int expectedI = 10;	//성공될 예상 데이터
		assertTrue(i==expectedI);
		
		String msg = "hello";	//실제 처리결과 데이터
		String expectedMsg = "Hi";	//성공될 예상 데이터
		assertEquals(expectedMsg, msg);
	}
	
	@Test
	void testInsert() {
	}

	@Test
	@DisplayName("아이디로 고객검색테스트")
	void testSelectById() throws FindException {
		String id = "010";
		Customer c = repository.selectById(id);
		String expectedPwd = "1";
		String expectedName = "1";
		assertEquals(expectedPwd, c.getPwd());
		assertEquals(expectedName, c.getName());
	}
}
