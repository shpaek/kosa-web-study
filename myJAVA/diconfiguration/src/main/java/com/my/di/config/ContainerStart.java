package com.my.di.config;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.customer.dao.CustomerRepository;
import com.my.customer.service.CustomerService;
import com.my.di.dto.A;
import com.my.di.dto.B;
import com.my.exception.FindException;
import com.my.order.dao.OrderRepository;
import com.my.order.dto.OrderInfo;
import com.my.order.service.OrderService;
import com.my.product.dao.ProductRepository;
import com.my.product.service.ProductService;

public class ContainerStart {

	public static void main(String[] args) {
		//스프링엔진 = 스프링 컨테이너 = 스프링 어플리케이션컨텍스트

		//스프링엔진 시작한다, 스프링 컨테이너가 구동된다, 스프링 어플리케이션컨텍스트 생성됐다
		ApplicationContext ctx;
//		ctx = new ClassPathXmlApplicationContext(configFileName);
		ctx = new AnnotationConfigApplicationContext(MyApplicationContext.class);

		//스프링컨테이너에 있는 스프링객체를 찾는다
		A a1 = ctx.getBean("a", com.my.di.dto.A.class);
		System.out.println(a1);
		
		//스프링컨테이너에 있는 스프링객체를 찾는다
		A a2 = ctx.getBean("a", com.my.di.dto.A.class);
		System.out.println(a2);

		System.out.println("싱글톤여부:" + (a1 == a2)); //true
		System.out.println("msg:" + a1.getMsg());
		
		B b1 = ctx.getBean("b", com.my.di.dto.B.class);
		System.out.println("no:" + b1.getNo());
		
		ProductRepository r1 = ctx.getBean("productDAO", com.my.product.dao.ProductRepository.class);
		System.out.println(r1);
		
		ProductService s1 = ctx.getBean("productService", com.my.product.service.ProductService.class);
		try {
			System.out.println(s1.findAll(1));
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//테스트 코드1
//		CustomerRepository r2 = ctx.getBean("customerDAO", com.my.customer.dao.CustomerRepository.class);
//		System.out.println(r1);
//		
//		CustomerService s2 = ctx.getBean("customerService", com.my.customer.service.CustomerService.class);
//		try {
//			s2.idDupChk("010");
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		OrderRepository r3 = ctx.getBean("orderDAO", com.my.order.dao.OrderRepository.class);
//		System.out.println(r1);
//		
//		OrderService s3 = ctx.getBean("orderService", com.my.order.service.OrderService.class);
//		try {
//			System.out.println(s3.findById("010"));
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//테스트 코드2
		CustomerRepository r2 = ctx.getBean("customerDAO", com.my.customer.dao.CustomerRepository.class);
		System.out.println(r2);
		
		CustomerService s2 = ctx.getBean("customerService", com.my.customer.service.CustomerService.class);
		try {
			s2.login("010", "1");
		} catch (FindException e) {
			e.printStackTrace();
		}
	
		OrderRepository r3 = ctx.getBean("orderDAO", com.my.order.dao.OrderRepository.class);
		System.out.println(r3);
		
		OrderService s3 = ctx.getBean("orderService", com.my.order.service.OrderService.class);
		try {
			List<OrderInfo> list = s3.findById("010");
			System.out.println("총주문수량 : " + list.size());
		} catch (FindException e) {
			e.printStackTrace();
		}
		
	}
}
