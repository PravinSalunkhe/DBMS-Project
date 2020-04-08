package com.minipro.model;

public class Sport 
{
	
	private int host_id;
	private String event_name;
	private String sport_name;
	private String sport_date;
	private String reg_date;
	private int fees;
	private int total_participation;
	private int max_participation;
	private String city;
	
	public Sport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sport(int host_id, String event_name, String sport_name, String sport_date, int fees,int max_participation, int total_participation
			) {
		super();
		this.host_id = host_id;
		this.event_name = event_name;
		this.sport_name = sport_name;
		this.sport_date = sport_date;
		this.fees = fees;
		this.total_participation = total_participation;
		this.max_participation = max_participation;
	}

	public int getHost_id() {
		return host_id;
	}

	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getSport_name() {
		return sport_name;
	}

	public void setSport_name(String sport_name) {
		this.sport_name = sport_name;
	}

	public String getSport_date() {
		return sport_date;
	}

	public void setSport_date(String sport_date) {
		this.sport_date = sport_date;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int gettotal_participation() {
		return total_participation;
	}

	public void settotal_participation(int total_participation) {
		this.total_participation = total_participation;
	}

	public int getmax_participation() {
		return max_participation;
	}

	public void setmax_participation(int max_participation) {
		this.max_participation = max_participation;
	}

	public int getTotal_participation() {
		return total_participation;
	}

	public void setTotal_participation(int total_participation) {
		this.total_participation = total_participation;
	}

	public int getMax_participation() {
		return max_participation;
	}

	public void setMax_participation(int max_participation) {
		this.max_participation = max_participation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "Sport [host_id=" + host_id + ", event_name=" + event_name + ", sport_name=" + sport_name
				+ ", sport_date=" + sport_date + ", reg_date=" + reg_date + ", fees=" + fees + ", total_participation="
				+ total_participation + ", max_participation=" + max_participation + ", city=" + city + "]";
	}

	
	

}
