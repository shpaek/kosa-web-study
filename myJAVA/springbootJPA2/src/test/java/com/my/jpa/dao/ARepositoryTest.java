package com.my.jpa.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.my.jpa.dto.ADTO;
import com.my.jpa.entity.A;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class ARepositoryTest {

	@Autowired
	ARepository r;
	
	@Test
	void test() {
		log.error(r.getClass().getName()); 
	}

	@Test
	@Transactional
	@Commit
	void test1Save() {
		A a = new A();
		a.setA_1("one");
		a.setA_2(new BigDecimal(1.0));
		a.setA4("a4");
		r.save(a);
		
		A a1 = new A();
		a1.setA_1("one");
		a1.setA_2(new BigDecimal(2.0));
		r.save(a1);
		//r.save(a1);
		
		//r.save(a2);
	
	}
	
	@Test
	void test2FindById() {
		String a_1 = "one";
		Optional<A> optA = r.findById(a_1);
		Assertions.assertTrue(optA.isPresent());
		A a= optA.get();
		log.error("a_1{}, a_2{}", a.getA_1(), a.getA_2());
	}
	
	@DisplayName("UPDATE용도의 save()테스트")
	@Test
	void test3Save() {
		String a_1 = "one";
		Optional<A> optA = r.findById(a_1);
		Assertions.assertTrue(optA.isPresent());
		A a= optA.get();
		a.setA_2(new BigDecimal(3.0));
		r.save(a);
	}
	
	@Test
	@Transactional
	@Commit
	void test4DeleteById() {
		String a_1 = "one";
		r.deleteById(a_1); //silently ignore -> rollback예외발생
		
	}
	
	@Test
	@Transactional
	@Commit
	void test4Delete() {
		String a_1 = "one";
//		A a = new A();
//		a.setA_1(a_1);
//		r.delete(a); // -> entity가 없으면 rollback예외발생 안 함
		
		Optional<A> aOpt = r.findById(a_1);
		aOpt.ifPresent(a-> r.delete(a));
		
	}
	
	@Test
	void test5QueryMethod() {
		List<A> list = r.findByA4("a4one");
		log.error("r.findByA4(a4one)결과 : {}", list);
		
	}

	@Test
	void test6FindByA4Like() {
		String word = "%4f%";
		List<A> list = r.findByA4Like(word);
		log.error("r.findByA4Like(4f)결과 : {}", list);
		
	}
	
	@Test
	void test7FindByA4LikeOrderByA4() {
		String word = "%4f%";
		List<A> list = r.findByA4LikeOrderByA4(word);
		log.error("r.findByA4LikeOrderByA4(4f)결과 : {}", list);
		
	}
	
	@Test
	void test8FindByA4LikeJpql() {
		String word = "%4f%";
		List<A> list = r.findByA4LikeJpql(word);
		log.error("r.findByA4LikeJpql(4f)결과 : {}", list);
		
	}
	
	@Test
	void test9FindByA4LikeJpqlA1A4() {
		String word = "%4f%";
		List<Object[]> list = r.findByA4LikeJpqlA1A4(word);
		for(Object[] arr: list) {
			log.error("r.findByA4LikeJpqlA1A4(4f)결과 : {}, {}", arr[0], arr[1]);
		}
		
	}
	
	@Test
	@Transactional
	@Commit
	void test10Modify() {
		String a_1 = "one";
		BigDecimal a_2 = new BigDecimal(888);
		int rowcnt = r.modify(a_1, a_2);
		log.error("수정된 행 수:{}", rowcnt);
	}
	
	@Test
	@Transactional
	@Commit
	void test11QdslSearch() {
		List<A> list = r.search1();
		log.error("search1()={}", list );
	}
	
	@Test
	@Transactional
	@Commit
	void test12QdslSearch2() {
		List<A> list = r.search2(3);
		log.error("search2()={}", list );
	}
	
	@Test
	@Transactional
	@Commit
	void test13QdslSearch3() {
		List<A> list = r.search3("4f");
		log.error("search3()={}", list );
	}
	
	@Test
	@Transactional
	@Commit
	void test14QdslSearch4() {
		List<A> list = r.search4(new String[]{"a_1", "a4"},"t");
		log.error("search4()={}", list );
	}
	
	@Test
	@Transactional
	@Commit
	void test15QdslSearch5() {
		List<A> list = r.search5(3, "4f");
		log.error("search5()={}", list );
	}
	
	@Test
	@Transactional
	@Commit
	void test16Add() {
		ADTO dto = new ADTO();
		dto.setA1("six");
		dto.setA2(6);
		dto.setA4("a46");
		r.add(dto);
	}
	
	@DisplayName("Page처리용 findAll메서드")
	@Test
	void testPageable() {
		int currentPage = 2;//현재페이지
		int pageIndex = currentPage-1;//zero-based page index.
		int size = 4;//the size of the page to be returned.
		Sort sort = Sort.by("a4").ascending();//must not be null, use Sort.unsorted() instead. 
		Pageable pageable = PageRequest.of(pageIndex,  size, sort);
		
		Page<A> page = r.findAll(pageable);
		
		log.error("페이지별 보여줄 목록수 : page.getSize()={}",page.getSize());
		log.error("총페이지수 : page.getTotalPages()={}",page.getTotalPages());
		log.error("목록수 : page.getContent().size()={}", page.getContent().size());
		log.error("목록 : page.getContent()={}", page.getContent());
	}
}
