package com.minipro.model;

public class Event {
	
	private int host_id;
	private String event_name;
	private String city;
	private String desp;
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event(int host_id, String event_name, String city, String desp) {
		super();
		this.host_id = host_id;
		this.event_name = event_name;
		this.city = city;
		this.desp = desp;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	
	@Override
	public String toString() {
		return "Event [host_id=" + host_id + ", event_name=" + event_name + ", city=" + city + ", desp=" + desp + "]";
	}
	
	

}
