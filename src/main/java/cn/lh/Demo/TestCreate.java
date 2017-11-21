package cn.lh.Demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.lh.hibernate.pojo.Member;

public class TestCreate {
	 public static void main(String[] args) {
		// 当读取了hibernate.cfg.xml文件之后可以知道数据库的操作地址，以及所有对应的*.hbm.xml文件路径
			Configuration config = new Configuration().configure() ; // 读取配置hibernate.cfg.xml文件
			SessionFactory factory = config.buildSessionFactory() ; // 创建SessionFactory
			Session session = factory.openSession() ; // 打开一个新的Session对象
			Member vo = new Member() ;
			vo.setName("廖欢");
			vo.setAge(77);
			vo.setBirthday(new Date());
			vo.setNote("哈哈哈");
			vo.setSalary(-9999.99);
			//session.getTransaction().begin();  // 开启事务，后面的臭毛病
			System.err.println(session.save(vo));// 保存
			System.err.println("mid = " + vo.getMid());
			//session.getTransaction().commit();  // 提交事务
			session.close();
			factory.close(); 
	}
}
