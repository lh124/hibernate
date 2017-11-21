package cn.lh.Demo;

import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.lh.hibernate.pojo.Member;
import cn.lh.util.HibernateSessionFactory;

public class TestHibernateDemo {
	@Test
	public void testQueryUpdate() {
		String hql = "UPDATE Member SET name=:pname,age=:page WHERE mid=:pmid" ;
		Query query = HibernateSessionFactory.getSession().createQuery(hql) ;
		query.setParameter("pname", "周鼻洞") ;
		query.setParameter("page", 56) ;
		query.setParameter("pmid", 1L) ; 
		Transaction transaction = HibernateSessionFactory.getSession().beginTransaction() ;
		transaction.begin(); 
		int len = query.executeUpdate() ; // 更新
		System.out.println("*** 更新行数：" + len);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
	
	@Test
	public void testQueryList() { // 查询要编写HQL代码
		int currentPage = 1 ; 
		int lineSize = 5 ; 
		String hql = "FROM Member AS m" ; // Member描述的是POJO类
		Query<Member> query = HibernateSessionFactory.getSession().createQuery(hql) ;
		query.setFirstResult((currentPage - 1) * lineSize) ;
		query.setMaxResults(lineSize) ;
		List<Member> allMembers = query.list() ;
		for (Member mem : allMembers) {
			System.out.println(mem);
		}
		HibernateSessionFactory.closeSession(); 
	} 
	
	@Test
	public void testDelete() {
		HibernateSessionFactory.getSession().getTransaction().begin();
		Member mem = HibernateSessionFactory.getSession().get(Member.class, 9L) ;	// 查询
		HibernateSessionFactory.getSession().delete(mem);
		HibernateSessionFactory.getSession().getTransaction().commit();
	}
	
	@Test
	public void testUpdate() {
		Member vo = new Member();
		vo.setMid(8L);
		vo.setName("周不动");
		vo.setAge(13);
		vo.setNote("望草屎。。。");
		vo.setSalary(1.1); 
		HibernateSessionFactory.getSession().getTransaction().begin();
		HibernateSessionFactory.getSession().update(vo);  
		HibernateSessionFactory.getSession().getTransaction().commit();
		HibernateSessionFactory.closeSession(); 
	}
	
	@Test
	public void testLoad() { 
		Member mem = HibernateSessionFactory.getSession().load(Member.class, 79L) ;
		System.out.println(mem);
		HibernateSessionFactory.closeSession(); 
		System.out.println("***********************");
	}
	@Test
	public void testGet() {
		Member mem = HibernateSessionFactory.getSession().get(Member.class, 78L) ;
		System.out.println(mem);
		HibernateSessionFactory.closeSession(); 
	}
	@Test
	public void testCreate() {
		Member vo = new Member();
		vo.setName("周啊动");
		vo.setAge(18);
		vo.setBirthday(new Date());
		vo.setNote("老不要脸的");
		vo.setSalary(9999.99);
		HibernateSessionFactory.getSession().getTransaction().begin();
		System.out.println(HibernateSessionFactory.getSession().save(vo)); 
		HibernateSessionFactory.getSession().getTransaction().commit();
		HibernateSessionFactory.closeSession(); 
	}
}
