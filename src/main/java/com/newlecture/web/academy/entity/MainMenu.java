package com.newlecture.web.academy.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@IdClass(Member.class)
public class MainMenu {
	@Id
	//@GeneratedValue //디폴트값을 자동으로 해줌!! [mysql]
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
	private String title;
	private String url;
	@Column(updatable=false, insertable=false)
	private String academyId;
	@Column(updatable=false)
	private Integer parentId; //Integer null이 가능한 정수형을 써주자!! to value null 
	@Column(insertable=false, name="[order]")
	private int order;
	
	@ManyToOne
	@JoinColumn(name="academyId")
	private Academy academy;
	
	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	
	public MainMenu() {
		
	}
	
	public MainMenu(int id, String title, String url) {
		this.id = id;
		this.title = title;
		this.url = url;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAcademyId() {
		return academy.getId();
	}
	public void setAcademyId(String academyId) {
		this.academy.setId(academyId);
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	//트랜잭션의 4요소
	@Override
	@Transactional // 아이솔레이션 찾아볼
	public String toString() {
		return "MainMenu [id=" + id + ", title=" + title + ", url=" + url + ", academyId=" + academyId + ", parentId="
				+ parentId + ", order=" + order + "]";
	}
	
}
