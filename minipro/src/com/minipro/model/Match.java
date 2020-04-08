package com.minipro.model;

public class Match {
	
	public int match_id;
	private String team1;
	private int  pid1;
	private int pid2;
	private String team2;
	private int hid;
	private String event_name;
	private String sport_name;
	private int round;
	private String m_date;
	private String m_time;
	private int winner_id;
	
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Match(int match_id, String team1, int pid1, int pid2, String team2, int hid, String event_name,
			String sport_name, int round, String m_date, String m_time, int winner_id) {
		super();
		this.match_id = match_id;
		this.team1 = team1;
		this.pid1 = pid1;
		this.pid2 = pid2;
		this.team2 = team2;
		this.hid = hid;
		this.event_name = event_name;
		this.sport_name = sport_name;
		this.round = round;
		this.m_date = m_date;
		this.m_time = m_time;
		this.winner_id = winner_id;
	}



	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public int getPid1() {
		return pid1;
	}

	public void setPid1(int pid1) {
		this.pid1 = pid1;
	}

	public int getPid2() {
		return pid2;
	}

	public void setPid2(int pid2) {
		this.pid2 = pid2;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
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

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public String getM_date() {
		return m_date;
	}

	public void setM_date(String m_date) {
		this.m_date = m_date;
	}

	public String getM_time() {
		return m_time;
	}

	public void setM_time(String m_time) {
		this.m_time = m_time;
	}



	public int getWinner_id() {
		return winner_id;
	}



	public void setWinner_id(int winner_id) {
		this.winner_id = winner_id;
	}



	@Override
	public String toString() {
		return "Match [match_id=" + match_id + ", team1=" + team1 + ", pid1=" + pid1 + ", pid2=" + pid2 + ", team2="
				+ team2 + ", hid=" + hid + ", event_name=" + event_name + ", sport_name=" + sport_name + ", round="
				+ round + ", m_date=" + m_date + ", m_time=" + m_time + ", winner_id=" + winner_id + "]";
	}

	

}
