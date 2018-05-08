package com.troy.test.data.model;

public class MyModel {
	private String name;
	private Long id;

	public MyModel(String name, Long id) {
		this.name = name;
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
