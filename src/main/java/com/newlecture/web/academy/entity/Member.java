package com.newlecture.web.academy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@Table(name=user)
public class Member {
	@Id
	private String id;
	private String name;
	private String email;
	private String pwd;
	@Column(insertable=false) //insert 할 때 뺴기 할 수 없다 
	private Date regDate;
	//@Column(name="FOTO")
	private String photo;
	
	/*
	 * 만약 id가 자동 증가인 경우 아래처럼 
	 * 	@Id
		@GeneratedValue //디폴트값을 자동으로 해줌!! [mysql]
		@GeneratedValue(
			//mssql
			strategy=GenerationType.AUTO,
			generator="native"
		)
		@GenericGenerator(
			name="native",
			strategy="native"
		)
		private int id; 
	 * 
	 */
	
	
	public Member() {
		
	}
	
	public Member(String id, String name, String email, String pwd, Date regDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.regDate = regDate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", regDate=" + regDate
				+ "]";
	}
	
	
	
}
