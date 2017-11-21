package cn.lh.Demo;

import org.hibernate.Transaction;

import cn.lh.hibernate.pojo.Member;
import cn.lh.util.HibernateSessionFactory;


public class TestMemberStatus {
	public static void main(String[] args) throws Exception {
		// 在关闭之前mem对象属于持久态，可以直接修改数据
		Member mem = HibernateSessionFactory.getSession().get(Member.class, 2L) ;
		Transaction transaction = HibernateSessionFactory.getSession().beginTransaction() ;
		mem.setName("周不是东西。");	// 更新持久态中的属性内容
		mem.setNote("没有好鸟。");
		transaction.commit();
		HibernateSessionFactory.closeSession(); 
	}
}
