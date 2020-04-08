<%@page import="com.minipro.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
	if(session.getAttribute("curr_uid") == null && session.getAttribute("participant_id") == null)
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
        
        <% if(session.getAttribute("curr_uid") != null)
        	{
        %>

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
                                      <a href="your_events_controller" class="nav-link ">
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
                                      <a href="history_controller" class="nav-link ">
                                      	<i class="fa fa-history nav-icon" aria-hidden="true"></i>
                                        Hosted Events History 
                                      </a>
                        </li> 
                        
                        <li class="nav-item">
                            <a href="profile_controller" class="nav-link" style="color:#fff;background-color: rgba(255,255,255,0.1)">
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
        <% }
        else
        {
        %>
        
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
                                      <a href="Ongoing" class="nav-link ">
                                      	<i class="fa fa-database nav-icon" aria-hidden="true"></i>
                                        Ongoing Events
                                      </a>
                        </li> 
                        
                        <li class="nav-item">
                                      <a href="ongoingsport" class="nav-link ">
                                      	<i class="fa fa-database nav-icon" aria-hidden="true"></i>
                                        Ongoing Sports
                                      </a>
                        </li>
							
						<li class="nav-item">
                            <a href="registeredevents_controller" class="nav-link">
                                <i class="fa fa-plus-square nav-icon"></i>
                                Registered Sports
                            </a>
                        </li>

                        <li class="nav-item">
                                      <a href="history_controller" class="nav-link ">
                                      	<i class="fa fa-history nav-icon" aria-hidden="true"></i>
                                               History  
                                      </a>
                        </li>
                        
                        <li class="nav-item">
                                      <a href="notifications_controller" class="nav-link ">
                                      	<i class="fa fa-bell nav-icon" aria-hidden="true"></i>
                                       Notifications
                                      </a>
                        </li> 
                        
                        <li class="nav-item">
                            <a href="profile_controller" class="nav-link" style="color:#fff;background-color: rgba(255,255,255,0.1)">
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
        
        <%
        }
        %>
        
        <%
        	User u = new User();
        	u = (User)request.getAttribute("usr");
        %>
        
        <div class="container-fluid">
            <div class="row justify-content-center" style="width:100%"style=" background: rgba(31, 31, 31,1);border-top-right-radius: 10px;">
                <div class="col-lg-2 col-5 col-sm-3 col-md-3 justify-content-center" >      
                </div>
            
            	<div class="col-lg-10 col-7 col-sm-9 col-md-9 py-3"><br><br>
            		<div class="container-fluid mt-2">



						<div style="">
							<img style="width:70px;height:70px; float:left" src="images/account.png" >
  							<h2 style="color:blue; float:left ; line-height:70px; vertical-align: middle; margin-left:5%">${usr.firstName} ${usr.lastName}</h2>	
						</div>


						<table style="background-color:#edffff" class="table  border border-bottom-2 rounded mt-4">
 							<tbody>

						    <thead>
						    <tr >
						      <th width="20%" scope="row">First Name</th>
						      <td width="10%" >:</td>
						      <td width="70%" >${usr.firstName} </td>
						    </tr>
						    </thead>
						
						    <tr>
						      <th scope="row" >Last Name</th>
						      <td  >:</td>
						      <td >${usr.lastName}</td>
						    </tr>
						    <tr>
						      <th scope="row" >Email</th>
						      <td >:</td>
						      <td >${usr.email} </td>
						    </tr>
						
						    <tr>
						      <th scope="row" >role</th>
						      <td  >:</td>
						      <td >${usr.role} </td>
						    </tr>
						    <tr>
						      <th scope="row" >Mobile No</th>
						      <td >:</td>
						      <td >${usr.mobileno}</td>
						    </tr>
						
						<% if (u.getOrganization() != null)
						{
						%>
						    <tr>
						      <th scope="row" >Organization</th>
						      <td  >:</td>
						      <td >${usr.organization}</td>
						    </tr>
						  <% } %>
 
  						</tbody>
					</table>

				<button type="button" class="btn btn-primary float-right" onclick="window.location.href='edit_profile_controller'">Edit</button>


			</div>                         
           </div>
          </div>
         </div>
      </div>
      </body>
</html>



<script>$(".btn-group, .dropdown").hover(
        function () {
            $('>.dropdown-menu', this).stop(true, true).fadeIn("fast");
            $(this).addClass('open');
        },
        function () {
            $('>.dropdown-menu', this).stop(true, true).fadeOut("fast");
            $(this).removeClass('open');
        });</script>



