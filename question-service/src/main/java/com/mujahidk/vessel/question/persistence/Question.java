package com.mujahidk.vessel.question.persistence;

public class Question extends BaseEntity {

	private String id;
	private String title;

	public Question(String id, String title) {
		this.id = id;
		this.title = title;
	}

	@Override
	String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
