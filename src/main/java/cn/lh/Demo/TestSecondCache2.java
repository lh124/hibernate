package cn.lh.Demo;

import org.hibernate.Session;

import cn.lh.hibernate.pojo.Member;
import cn.lh.util.HibernateSessionFactory;


public class TestSecondCache2 {
	public static void main(String[] args) throws Exception {
		Session sessionA = HibernateSessionFactory.getSessionFactory().openSession() ;
		System.out.println("************ 第一次查询Member对象 ************");
		Member memA = sessionA.get(Member.class, 93L) ;
		memA.setName("哈哈");
		System.out.println(memA);
		Session sessionB = HibernateSessionFactory.getSessionFactory().openSession() ;
		System.out.println("************ 第一次查询Member对象 ************");
		Member memB = sessionB.get(Member.class, 93L) ; // 查询同样的内容
		System.out.println(memB);
		sessionA.close();
		sessionB.close();
	}
}
