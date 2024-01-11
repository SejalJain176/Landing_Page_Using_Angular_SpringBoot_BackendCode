package com.example.demo.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Courses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	public Long id;
	
	@Column(name = "course_Name")
	public String course_Name;
	
	@Column(name = "course_Duration")
	public String course_Duration;
	
	@Column(name = "course_Teacher")
	public String course_Teacher;
	
	@Column(name = "course_Description")
	public String course_Description;
	
	@Column(name = "image_Url")
	public String image_url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourse_Name() {
		return course_Name;
	}

	public void setCourse_Name(String course_Name) {
		this.course_Name = course_Name;
	}

	public String getCourse_Duration() {
		return course_Duration;
	}

	public void setCourse_Duration(String course_Duration) {
		this.course_Duration = course_Duration;
	}

	public String getCourse_Teacher() {
		return course_Teacher;
	}

	public void setCourse_Teacher(String course_Teacher) {
		this.course_Teacher = course_Teacher;
	}

	public String getCourse_Description() {
		return course_Description;
	}

	public void setCourse_Description(String course_Description) {
		this.course_Description = course_Description;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
	
	
	

}
