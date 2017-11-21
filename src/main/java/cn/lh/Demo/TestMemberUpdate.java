package cn.lh.Demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.lh.util.HibernateSessionFactory;


public class TestMemberUpdate {
	public static void main(String[] args) throws Exception {
		String hql = "UPDATE Member SET name=:pname,age=:page WHERE mid=:pmid" ;
		Session session = HibernateSessionFactory.getSession() ; // 打开一个新的Session对象
		Query query = session.createQuery(hql) ;
		query.setParameter("pname", "周鼻洞") ;
		query.setParameter("page", 56) ; 
		query.setParameter("pmid", 1L) ; 
		Transaction transaction = session.beginTransaction() ;
		int len = query.executeUpdate() ; // 更新
		System.out.println("*** 更新行数：" + len);
		transaction.commit();
		session.close();
	}
}
