package cn.lh.hibernate.pojo;
// Generated 2017-11-21 18:56:48 by Hibernate Tools 5.2.1.Final

import java.util.Date;

/**
 * Member generated by hbm2java
 */
public class Member implements java.io.Serializable {

	private Long mid;
	private String name;
	private Integer age;
	private Double salary;
	private Date birthday;
	private String note;

	public Member() {
	}

	public Member(String name, Integer age, Double salary, Date birthday, String note) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.birthday = birthday;
		this.note = note;
	}

	public Long getMid() {
		return this.mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
