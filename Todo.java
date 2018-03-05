package com.demo.demorest;

public class Todo {
	
	private int id;
	private String tname;
	private String isDone;
	private String createdat;
	private String doneat;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public String getIsDone() {
		return isDone;
	}
	public void setIsDone(String isDone) {
		this.isDone = isDone;
	}
	
	public String getCreatedat() {
		return createdat;
	}
	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}
	
	public String getDoneat() {
		return doneat;
	}
	public void setDoneat(String doneat) {
		this.doneat = doneat;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", tname=" + tname + ", isDone=" + isDone + ", createdat=" + createdat + ", doneat="
				+ doneat + "]";
	}
	
}

