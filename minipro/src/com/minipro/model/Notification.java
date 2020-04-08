package com.minipro.model;

public class Notification 
{
	int id;
	int pid;
	String note;
	String n_date;
	public Notification()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getN_date() {
		return n_date;
	}
	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	
	public Notification(int id, int pid, String note, String n_date)
	{
		super();
		this.id = id;
		this.pid = pid;
		this.note = note;
		this.n_date = n_date;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", pid=" + pid + ", note=" + note + ", n_date=" + n_date + "]";
	}
	
}
