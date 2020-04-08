<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.ArrayList"%>
<%@page import="com.minipro.model.Sport"%>
<%@page import="java.util.List"%>   


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
    <title></title>
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
	if(session.getAttribute("admin_id") == null)
	{
		response.sendRedirect("login2.jsp");
		return ;
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
            <span class="ml-2" style="font-weight: 600; font-size: x-large; color: white">Upcoming Sports</span>
                        
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
                                      <a href="upcomingevents_controller" class="nav-link " style="color:#fff;background-color: rgba(255,255,255,0.1)">
                                      	<i class="fa fa-database nav-icon" aria-hidden="true"></i>
                                        Upcoming Events
                                      </a>
                        </li> 
							
						<li class="nav-item">
                            <a href="statistics" class="nav-link" >
                                <i class="fa fa-bar-chart nav-icon"></i>
                                Statistics
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
            	
            	<%
      					List<Sport> s =new ArrayList<Sport>();
      					s=(List<Sport>)request.getAttribute("sports_list");  
      					session.setAttribute("sportsize", s.size());
      					if(!s.isEmpty())
      					{	
	      					for(Sport m : s)
	      					{
	      						String uid=Integer.toString(m.getHost_id());
	      						System.out.println(m.getFees());	
      						
      				%>
            		
      				<c:url var="delete" value="deletesport">
  						<c:param name="eventName" value="<%=m.getEvent_name() %>"></c:param>
  						<c:param name="sportName" value="<%=m.getSport_name() %>"></c:param>
  						<c:param name="uid" value="<%=Integer.toString(m.getHost_id()) %>"></c:param>
  						<c:param name="fees" value="<%=Integer.toString(m.getFees()) %>"></c:param>
  						<c:param name="total_participant" value="<%=Integer.toString(m.getTotal_participation()) %>"></c:param>
	      			</c:url>
      			
      				<small class="mt-4 p-2" style="color:red">*If you delete sport,the total amount of fees will be refunded back to the participant as per T&c</small>
                    <div class="card mt-2" style="border-radius: 25px;overflow: hidden;">
                          <h4 style="background-color:rgba(52, 58, 64,1)"  class="card-header text-white text-center"><%=m.getEvent_name() %></h4>

                        <div class="card-body">
                          <div class="row justify-content-center p-2">
      
                              <div class="container bg-white p-4">
                             
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Sport Name</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=m.getSport_name() %></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>City</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=m.getCity() %></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Registration Fees</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=m.getFees() %></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Date</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=m.getSport_date() %></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Maximum Participation</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=m.getMax_participation() %></div>
                                      </div>
									  <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Total Participation</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=m.getTotal_participation() %></div>
                                      </div>
                                      <div>
                                        <button class="btn btn-primary float-right mt-4 p-2" href="#">View Participants</button>
                                      </div>
                                      <div>
                                        <button class="btn btn-danger float-right mt-4 mr-4 p-2" onclick="window.location.href='${delete}'">Delete</button>
                                      </div>
          
                              </div>
                    
                              </div>
                      </div>
            		</div>
            		<% } } %>
            	
            	</div>
            	
            </div>
       	</div>
       </div>
      </body>
</html>