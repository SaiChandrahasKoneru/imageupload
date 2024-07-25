package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Doc {
	@Id
	private int id;
	private String name;
	private String extension;
	@Lob
	@Column(columnDefinition="BLOB")
	private String picture;
	public Doc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doc(String name, String extension, String picture) {
		super();
		this.name = name;
		this.extension = extension;
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
