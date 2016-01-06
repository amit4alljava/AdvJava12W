package com.dao;

public class CommonDTO {
	private String category;
	private String values;
	private String desc;
	private String status;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CommonDTO [category=" + category + ", values=" + values
				+ ", desc=" + desc + ", status=" + status + "]";
	}
	

}
