package com.newlecture.web.academy.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Embeddable
public class MainMenuId implements Serializable {
	
	private int academyId;
	public MainMenuId() {
		
	}
	
	
}
