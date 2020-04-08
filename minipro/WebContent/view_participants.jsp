<%@page import="java.util.ArrayList"%>
<%@page import="com.minipro.model.Participant"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/navbar.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <style type="text/css"> 
    	label{
    		color: white;
    		}
		h2{
			color: white;
			}
	</style>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="/APP/Content/Images/unipun.png" />
    <title>Landing | Student Profile System | Savitribai Phule Pune University</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/ionicons.min.css">
    <link rel="stylesheet" href="css/adminlte.min.css">
    <link href="css/googlefontcss.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/fastclick.js"></script>
    <script src="js/adminlte.min.js"></script>
    <style type="text/css">
	    label{
	   		color: black;
	    }
    </style>
</head>
<body >

<%
	if(session.getAttribute("curr_uid") == null)
	{
		response.sendRedirect("login.jsp");
		return;
	}
%>



<div class="wrapper">
       
        <nav class="main-header navbar navbar-expand navbar-fixed-top bg-dark border-bottom elevation-1">
            
          
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                          <span class="navbar-toggler-icon"></span>
                        </button>
                  <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" data-widget="pushmenu" href="#"><i class="fa fa-bars"></i></a>
                </li>
            </ul>
            <span class="ml-2" style="font-weight: 600; font-size: x-large; color: white">Your Events</span>
                        
        </nav>

        <aside class="main-sidebar sidebar-dark-info elevation-4">
            <!-- Brand Logo -->
            <a class="brand-link">
                <img src="images/lo.png" class="brand-image elevation-6" width="150px">
                <span class="brand-text font-weight-heavy ml-1" style="color: white;">Sports 24X7
                </span>
                
            </a>

            <!-- Sidebar -->
            <div class="sidebar">
                <!-- Sidebar Menu -->
                <nav class="mt-2">
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

                         <li class="nav-item">
                                      <a href="your_events_controller" class="nav-link " style="color:#fff;background-color: rgba(255,255,255,0.1)">
                                      	<i class="fa fa-database nav-icon" aria-hidden="true"></i>
                                        <p>Your Events</p>    
                                      </a>
                        </li> 
                        
                        <li class="nav-item">
                                      <a href="schedule_event" class="nav-link ">
                                      	<i class="fa fa-database nav-icon" aria-hidden="true"></i>
                                        <p>Schedule Your Event</p>    
                                      </a>
                        </li> 

                        <li class="nav-item">
                                      <a href="event_create.jsp" class="nav-link " >
                                      	<i class="fa fa-flag nav-icon" aria-hidden="true"></i>
                                                Create Event    
                                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="more_sports" class="nav-link">
                                <i class="fa fa-plus-square nav-icon"></i>
                                Add Sports
                            </a>
                        </li>
                        <li class="nav-item">
                                      <a href="history_controller" class="nav-link" >
                                      	<i class="fa fa-history nav-icon" aria-hidden="true"></i>
                                        Hosted Events History 
                                      </a>
                        </li> 
                        
                        <li class="nav-item">
                            <a href="profile_controller" class="nav-link">
                            <i class="fa fa-user-o nav-icon" aria-hidden="true"></i>
                                Profile
                            </a>
                        </li>
                         
                    
                        <li class="nav-item">

                            <a href="logout.jsp" class="nav-link">
                                <i class="fa fa-sign-in nav-icon"aria-hidden="true"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- /.sidebar-menu -->
            </div>
            <!-- /.sidebar -->
        </aside>
        
        <div class="container-fluid">
            <div class="row justify-content-center" style="width:100%"style=" background: rgba(31, 31, 31,1);border-top-right-radius: 10px;">
                <div class="col-lg-2 col-5 col-sm-3 col-md-3 justify-content-center" >      
                </div>
            
            	<div class="col-lg-10 col-7 col-sm-9 col-md-9 py-3"><br><br><br>
            	
            		
                    <%
                    	List<Participant> p_list = new ArrayList<Participant>();
                    	p_list = (List<Participant>)request.getAttribute("p_list");
                    	int i=1;
                    	if(p_list.size()!=0)
                    	{
                    %>
            		
            			<b>
            			Event Name : <%=p_list.get(0).getEventName() %> 
            			<hr>
            			Sport Name : <%=p_list.get(0).getSportName() %> 
            			<hr>
            			
            			
            			List of Participants :
            			</b>
            			<br><br>
            		<table class="table table-bordered table-hover" style="background-color:#343A40 ;color:white">
	  					<thead style="text-align:center">
						    <tr>
						    <th scope="col">Sr No</th>
						  	  <th scope="col">Team Name</th>
						      <th scope="col">Participant Name</th>
						      <th scope="col">Mobile No</th>
						      <th scope="col">Email</th>
						      <th scope="col">Registration Date</th>
						    </tr>
						  </thead>
						  
						  <tbody style="background-color:#fff ;color:black;text-align:center">
						  	<%
						  		for(Participant p : p_list)
						  		{
						  	%>
						  	
						  
						    <tr>
						      <td><%=i %></td>
						      <td><%=p.getTeam_name() %></td>
						      <td><%=p.getFname() + " "+p.getLname() %></td>
						      <td><%=p.getMobileno() %></td>
						      <td><%=p.getEmail() %></td>
						      <td><%= p.getReg_date() %></td> 
						    </tr>
						    	<% 
						    		i++;
						  		} %>
	  					</tbody>
	  					
					</table>
            		
            		<%} %>
            	
            	</div>
            </div>
         </div>
        </div>

</body>
</html>