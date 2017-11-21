package cn.lh.Demo;

import org.hibernate.Transaction;

import cn.lh.hibernate.pojo.Member;
import cn.lh.util.HibernateSessionFactory;


public class TestMemberStatus3 { 
	public static void main(String[] args) throws Exception {
		Transaction transaction = HibernateSessionFactory.getSession().beginTransaction() ;
		for (int x = 0; x < 100; x++) {
			Member mem = new Member(); // 在关闭之前mem对象属于持久态，可以直接修改数据
			mem.setName("周鼻孔 - " + x);
			mem.setNote("大如豆 - " + x);
			HibernateSessionFactory.getSession().save(mem); // 瞬时态变为持久态
			if (x % 10 == 0) {
				HibernateSessionFactory.getSession().flush();
				HibernateSessionFactory.getSession().clear();;
			}
		}
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
}
