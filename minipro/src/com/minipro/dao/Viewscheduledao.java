package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minipro.model.Match;
import com.minipro.model.Participant;
import com.minipro.model.Sport;

public class Viewscheduledao {
	
		public int getmax_round(int uid,String eventname,String sportname)
		{
			int max_round = 0;
			Connection con=null;
			ResultSet rs=null;
			
			try
			{
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
				PreparedStatement p=con.prepareStatement("select max(round) as round from matches where hid=? and event_name=? and sport_name=?");
				p.setInt(1, uid);
				p.setString(2, eventname);
				p.setString(3, sportname);
				
				rs=p.executeQuery();
				if(rs.next())
					max_round = rs.getInt("round");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try 
				{
					con.close();
				} 
				catch(SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			return max_round;
		}
		
		public void updatewinner(int uid,String eventname,String sportname,int max_round,List<Match> match)
		{
			Connection con=null;
			ResultSet rs=null;
			
			try
			{
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
				PreparedStatement p = null;
				
				for(int i = 0 ; i < match.size() ; i++)
				{
					if(match.get(i).getRound() == max_round)
					{
						p=con.prepareStatement("Update matches set winner_id=? where match_id=?");
						p.setInt(1, match.get(i).getWinner_id());
						p.setInt(2, match.get(i).getMatch_id());
						
						p.execute();
					}
					
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try 
				{
					con.close();
				} 
				catch(SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		public void dropinhistory(int uid,String eventname,String sportname)
		{
			Connection con=null;
			ResultSet rs=null;
			
			try
			{
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
				PreparedStatement p=con.prepareStatement("call insertanddrop(?,?,?)");
				p.setInt(1, uid);
				p.setString(2, eventname);
				p.setString(3, sportname);
				
				rs=p.executeQuery();
				
				p=con.prepareStatement("select * from participant where uid=? and event_name=? and sport_name=?");
				p.setInt(1, uid);
				p.setString(2, eventname);
				p.setString(3, sportname);
				
				rs=p.executeQuery();
				int j= 0;
				while(rs.next())
				{
					p=con.prepareStatement("insert into participant_history values(?,?,?,?,?,?)");
					p.setInt(1, rs.getInt("participation_id"));
					p.setInt(2, uid);
					p.setString(3, eventname);
					p.setString(4, sportname);
					p.setString(5, rs.getString("reg_date"));
					p.setString(6, rs.getString("team_name"));
					
					j = p.executeUpdate();
					if(j <= 0)
						return;
				}
				
				p=con.prepareStatement("delete from participant where uid=? and event_name=? and sport_name=?");
				p.setInt(1, uid);
				p.setString(2, eventname);
				p.setString(3, sportname);
				
				p.executeUpdate();
				
				p=con.prepareStatement("delete from sport where uid=? and event_name=? and sport_name=?");
				p.setInt(1, uid);
				p.setString(2, eventname);
				p.setString(3, sportname);
				
				p.executeUpdate();
				
				p = con.prepareStatement("select * from sport where uid=? and event_name=?");
				p.setInt(1, uid);
				p.setString(2, eventname);
				rs = p.executeQuery();
				int row = 0;
				while( rs.next())
				{
					row++;
				}
				if(row == 0)
				{
					p=con.prepareStatement("call insertanddropevent(?,?)");
					p.setInt(1, uid); 
					p.setString(2, eventname);
					p.execute();
				}				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try 
				{
					con.close();
				} 
				catch(SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	

		public int getschedule(int uid,String eventname,String sportname)
		{
			System.out.println("IN GET");
			Connection con=null;
			ResultSet rs=null;
			int max_round = 0,size=0;
			String sport_date = null;
			List<Participant> participant_list = new ArrayList<Participant>();
			List<Match> match = new ArrayList<Match>();

			try
			{
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
				PreparedStatement p=con.prepareStatement("select max(round) as round from matches where hid=? and event_name=? and sport_name=?");
				p.setInt(1, uid);
				p.setString(2, eventname);
				p.setString(3, sportname);
				
				rs=p.executeQuery();
				if(rs.next())
					max_round = rs.getInt("round");
				
				
				if(max_round == 0)
				{
					max_round++;
					p=con.prepareStatement("select * from participant p Inner join sport s on (p.uid=s.uid and p.event_name=s.event_name and p.sport_name=s.sport_name) where p.uid=? and p.event_name=? and p.sport_name=?");
					p.setInt(1, uid);
					p.setString(2, eventname);
					p.setString(3, sportname);
					
					rs=p.executeQuery();
					while(rs.next())
					{
						Participant pa = new Participant();
						pa.setEventName(eventname);
						pa.setSportName(sportname);
						pa.setPid(rs.getInt("participation_id"));
						pa.setUid(uid);
						sport_date = rs.getString("sport_date");
						
						participant_list.add(pa);
					}
					size = participant_list.size();
					
				}
				else
				{
					p=con.prepareStatement("select * from matches m inner join sport s on (m.hid=s.uid and m.event_name=s.event_name and m.sport_name=s.sport_name) where s.uid=? and s.event_name=? and s.sport_name=? and round=?");
					p.setInt(1, uid);
					p.setString(2, eventname);
					p.setString(3, sportname);
					p.setInt(4, max_round);
					
					rs=p.executeQuery();
					
					while(rs.next())
					{
						Match ma = new Match();
						ma.setMatch_id(rs.getInt("match_id"));
						ma.setPid1(rs.getInt("pid1"));
						ma.setPid2(rs.getInt("pid2"));
						ma.setHid(uid);
						ma.setEvent_name(eventname);
						ma.setSport_name(sportname);
						ma.setM_date(rs.getString("m_date"));
						ma.setM_time(rs.getString("m_time"));
						ma.setRound(rs.getInt("round"));
						ma.setWinner_id(rs.getInt("winner_id"));
						sport_date = rs.getString("sport_date");
						
						match.add(ma);
					}
					if(match.get(0).getWinner_id()!=0)
						max_round++;
					else
						return max_round;
					size = match.size();
				}
				
				int j=0,cnt=0;
				String time1 = null;
				Match m = new Match();

				
				for(int i=0;i<size/2;i++)
				{
					
					if(cnt%4 == 0)
					{
						time1 = "9:00 AM";
					}
					else if((cnt%4) == 1)
					{
						time1 = "12:00 PM";
					}
					else if((cnt%4) == 2)
					{
						time1 = "3:00 PM";
					}
					else if((cnt%4) == 3)
					{
						time1 = "6:00 PM";
					}
					
					//dt = start_date + cnt/4;
					
					if(max_round == 1)
					{
						m.setPid1(participant_list.get(j).getPid()); j++;
						m.setPid2(participant_list.get(j).getPid()); j++;
					}
					else
					{
						m.setPid1(match.get(j).getWinner_id()); j++;
						m.setPid2(match.get(j).getWinner_id()); j++;
					}
					
					//m.setTeam1(participant_list.get(j-1).getTeam1Name());
					
					//m.setTeam2(participant_list.get(j-1).getTeam2Name());
					
					m.setEvent_name(eventname);
					m.setHid(uid);
					m.setM_time(time1);
					m.setRound(max_round);
					m.setSport_name(sportname);
					
					// DAO    ? + INTERVAL " + cnt/4+ " DAY .....
					PreparedStatement ps = con.prepareStatement("insert into matches(pid1,pid2,hid,event_name,sport_name,m_date,m_time,round) values(?,?,?,?,?,DATE_ADD(?,interval ? day),?,?) ");
					ps.setInt(1,m.getPid1());
					ps.setInt(2,m.getPid2());
					ps.setInt(3,uid);
					ps.setString(4,eventname);
					ps.setString(5,sportname);
					ps.setString(6,sport_date);
					ps.setInt(7, cnt/4);
					ps.setString(8,m.getM_time());
					ps.setInt(9,max_round);
					System.out.print(m + " " + uid + "  " + eventname+ " " + sportname);
					
					int row = ps.executeUpdate();
					System.out.println(row);
					cnt++;
				}
				
				if(size%2==1)
				{
					if(cnt%4 == 0)
					{
						time1 = "9:00 AM";
					}
					else if((cnt%4) == 1)
					{
						time1 = "12:00 PM";
					}
					else if((cnt%4) == 2)
					{
						time1 = "3:00 PM";
					}
					else if((cnt%4) == 3)
					{
						time1 = "6:00 PM";
					}
					
					//dt = start_date + cnt/4;
					
					if(max_round == 1)
					{
						m.setPid1(participant_list.get(j).getPid()); j++;
					}
					else
					{
						m.setPid1(match.get(j).getWinner_id()); j++;
					}
					
					//m.setTeam1(participant_list.get(j-1).getTeam1Name());
						
					
					//m.setTeam2(participant_list.get(j-1).getTeam2Name());
					
					m.setEvent_name(eventname);
					m.setHid(uid);
					m.setM_time(time1);
					m.setRound(max_round);
					m.setSport_name(sportname);
					
					// DAO    ? + INTERVAL " + cnt/4+ " DAY .....
					PreparedStatement ps = con.prepareStatement("insert into matches(pid1,hid,event_name,sport_name,m_date,m_time,round) values(?,?,?,?,DATE_ADD(?,interval ? day),?,?) ");
					ps.setInt(1,m.getPid1());
					ps.setInt(2,uid);
					ps.setString(3,eventname);
					ps.setString(4,sportname);
					ps.setString(5,sport_date);
					ps.setInt(6, cnt/4);
					ps.setString(7,m.getM_time());
					ps.setInt(8,max_round);
					
					
					int row = ps.executeUpdate();
					
					cnt++;
				}

					
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try 
				{
					con.close();
				} 
				catch(SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return max_round;
		}
		
		public List<Match> gelallmatches(int uid,String eventname,String sportname)
		{
			List<Match> match = new ArrayList<Match>();
			
			Connection con=null;
			ResultSet rs=null,rs1=null;
			
			try
			{
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
				PreparedStatement p=con.prepareStatement("select * from matches where hid=? and event_name=? and sport_name=?");
				p.setInt(1, uid);
				p.setString(2, eventname);
				p.setString(3, sportname);
				
				rs = p.executeQuery();
				
				while(rs.next())
				{
					Match m = new Match();
					m.setMatch_id(rs.getInt("match_id"));
					m.setPid1(rs.getInt("pid1"));
					m.setPid2(rs.getInt("pid2"));
					m.setHid(uid);
					m.setEvent_name(eventname);
					m.setSport_name(sportname);
					m.setM_date(rs.getString("m_date"));
					m.setM_time(rs.getString("m_time"));
					m.setWinner_id(rs.getInt("winner_id"));
					m.setRound(rs.getInt("round"));
					
					p=con.prepareStatement("select team_name from participant p where participation_id in (?,?) and p.uid=? and p.event_name=? and p.sport_name=?");
					p.setInt(1, m.getPid1());
					p.setInt(2, m.getPid2());
					p.setInt(3, m.getHid());
					p.setString(4, m.getEvent_name());
					p.setString(5, m.getSport_name());
					
					rs1 = p.executeQuery();
					
					int i=0;
					while(rs1.next())
					{
						i++;
						if(i==1)
							m.setTeam1(rs1.getString("team_name"));
						else
						{
							m.setTeam2(rs1.getString("team_name"));
							break;
						}
					}
					if(m.getTeam1() == null)
					{
						p=con.prepareStatement("select team_name from participant_history p where participation_id in (?,?) and p.uid=? and p.event_name=? and p.sport_name=?");
						p.setInt(1, m.getPid1());
						p.setInt(2, m.getPid2());
						p.setInt(3, m.getHid());
						p.setString(4, m.getEvent_name());
						p.setString(5, m.getSport_name());
						
						rs1 = p.executeQuery();
						
						i=0;
						while(rs1.next())
						{
							i++;
							if(i==1)
								m.setTeam1(rs1.getString("team_name"));
							else
							{
								m.setTeam2(rs1.getString("team_name"));
								break;
							}
						}
					}
					
					
					
					match.add(m);
					System.out.print(match);
					
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try 
				{
					con.close();
				} 
				catch(SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			return match;
		}
		
		public int getpid(int uid,String eventname,String sportname,String a)
		{
			Connection con=null;
			ResultSet rs=null;
			
			try
			{
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
				PreparedStatement p=con.prepareStatement("select p.participation_id from participant p where p.uid=? and p.event_name=? and p.sport_name=? and p.team_name=?");
				p.setInt(1, uid);
				p.setString(2, eventname);
				p.setString(3, sportname);
				p.setString(4, a);
				
				rs=p.executeQuery();
				if(rs.next())
				{
					return rs.getInt("participation_id");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try 
				{
					con.close();
				} 
				catch(SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			return 0;
		}

}
