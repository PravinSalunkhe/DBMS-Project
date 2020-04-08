<%@page import="java.util.ArrayList"%>
<%@page import="com.minipro.model.Sport"%>
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
<body>

	<% String eventName=request.getParameter("eventName");
	   String sportName=request.getParameter("sportName");
	   int uid =Integer.parseInt(request.getParameter("uid"));
	   String sdate=request.getParameter("sdate");
	   int fees=Integer.parseInt(request.getParameter("fees"));
	   String city=request.getParameter("city");
	   int total_participation=Integer.parseInt(request.getParameter("total_participation"));
	   
	    System.out.println(uid);
	   	System.out.println(eventName);
		System.out.println(sportName);
		System.out.println(sdate);
		System.out.println(fees);
		System.out.println(city);
		System.out.println(total_participation);
		
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
            <span class="ml-2" style="font-weight: 600; font-size: x-large; color: white">Ongoing Events</span>
                        
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
                                      <a href="Ongoing" class="nav-link">
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
                            <a href="registeredevents_controller" class="nav-link" style="color:#fff;background-color: rgba(255,255,255,0.1)">
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
                <div class="col-lg-3 col-5 col-sm-3 col-md-3 justify-content-center" >      
                </div>
            
            	<div class="col-lg-9 col-7 col-sm-9 col-md-9 py-3"><br><br><br>
            	
            		<div class="container-fluid mt-2">
		
		
			<form action="reg_participant_controller" method="post" id="form1" >
			    
			      
	       		 <h4 class="text-center text-dark"><b>Registration Confirmation</b> </h4>
			       
			         
			      <div class="container-fluid ">
			      		  
			      		  
			      		  
		             <input type="hidden" id="uid" name="uid" value="<%=uid %>">
		             <input type="hidden" id="eventName" name="eventName" value="<%=eventName %>">
		              <input type="hidden" id="sportName" name="sportName" value="<%=sportName %>">
		             <input type="hidden" id="sdate" name="sdate" value="<%=sdate %>">
		               <input type="hidden" id="total_participation" name="total_participation" value="<%=total_participation %>">
              
              
			      		<div class="container-fluid border border-secondary rounded px-3 py-3">
				      		<h5>Event Details</h5>
							 <hr>
							 <div class="row">
	                            <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Event Name</b></div>:
	                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=eventName%></div>
	                         </div>			       		
	                         <div class="row">
	                            <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Sport Name</b></div>:
	                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=sportName %></div>
	                         </div>
	                         <div class="row">
	                            <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Registration Fees</b></div>:
	                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=fees %></div>
	                         </div>
	                          <div class="row">
	                             <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Date:</b></div>:
	                             <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=sdate %></div>
	                          </div>
	                           <div class="row">
	                             <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>City:</b></div>:
	                             <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=city %></div>
	                          </div>
                          </div>
                           <br>
                          <div class="container-fluid border border-secondary rounded px-3 py-3">
                         
                          	<div class="row">
	                            <label for="inputTeamName" >Enter Team/Individual Name </label>:
	                         	<input class ="ml-4" type="text" name="teamName" id="teamName" placeholder="Team Name" required> 
	                        </div>		
                         
                          </div> 
                          <br>
                          <div class="container-fluid border border-secondary rounded px-3 py-3">
                         
	                           <h5>Terms & Conditions</h5>
	                           <hr>
	                           <p>1. It is the responsibility of the Participant to reach at the given Venue on time.  </p>
	                           <p>2. Organizers hold all the rights to cancel/postpone the event/sport at any time.In case the event is cancelled, all the fees paid shall be refunded to the participant.</p> 
	                           <hr>
	                           <h5>Refund Policy</h5>
	                           <hr>
	                           <p>1. No Refund will be given in case the participant cancels the registration from 2 days before the event till the start of the event.</p>
	                           <p>2. 50% of the Fees paid will be refunded in case the participant cancels the registration from 5 days before the event till 2 days before the event.</p>
	                           <p>3. 80% of the Fees paid will be refunded in case the participant cancels the registration before 5 days from the start of the event.</p>   
                          </div>
                           
			     
			   		<hr>
			 		<div class="container-fluid">
			        <button type="button" class="btn btn-secondary" onclick="window.location.href='Ongoing'">Cancel</button>
			        <button type="submit" class="btn btn-primary" >Confirm and Pay</button>
			  		</div>
			      </div>
				   </form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>