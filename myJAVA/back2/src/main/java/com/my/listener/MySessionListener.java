package com.my.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionListener implements HttpSessionAttributeListener {

private int loginedCnt;

	public MySessionListener() {
		System.out.println("MySessionListener객체 생성됨");
	}


	public void attributeAdded(HttpSessionBindingEvent se)  { 
		System.out.println("MySessionListener.attributeAdded()메서드 호출됨");
		if(se.getName().equals("loginedId")) {
			loginedCnt++;
			System.out.println("로그인되었습니다: 로그인된 총사용자수 :" + loginedCnt);
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent se)  { 
		System.out.println("MySessionListener.attributeRemoved()메서드 호출됨");
		if(se.getName().equals("loginedId")) {
			loginedCnt--;
			System.out.println("로그아웃되었습니다: 로그인된 총사용자수 :" + loginedCnt);
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent se)  { 
		// TODO Auto-generated method stub
	}

}
