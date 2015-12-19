package com.vi.test;

import org.hibernate.Session;

import com.vi.util.HibernateUtil;
import com.vi.util.MyTools;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Session session=HibernateUtil.openSession();
		//123456密码加到md5变成？
		System.out.println(MyTools.MD5("123456"));
		
	}

}
