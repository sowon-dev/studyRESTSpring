package com.itwillbs.domain;

public class SampleVO {
	private Integer num;
	private String name;
	private String tel;
	
	public SampleVO() {};
	public SampleVO(Integer num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "SampleVO [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
}
