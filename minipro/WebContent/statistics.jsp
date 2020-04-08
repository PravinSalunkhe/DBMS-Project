<%@page import="com.minipro.model.Sport"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
 <%@ page import="java.util.*" %>

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
	
	List<Sport> sport = new ArrayList<Sport>();
	List<Sport> sport1 = new ArrayList<Sport>();
	List<Sport> sport2 = new ArrayList<Sport>();
	sport = (List<Sport>)request.getAttribute("sport");
	sport1 = (List<Sport>)request.getAttribute("sport1");
	sport2 = (List<Sport>)request.getAttribute("sport2");
	
%>			


<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>


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
            <span class="ml-2" style="font-weight: 600; font-size: x-large; color: white">Statistics</span>
                        
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
                                      <a href="upcomingevents_controller" class="nav-link ">
                                      	<i class="fa fa-database nav-icon" aria-hidden="true"></i>
                                        Upcoming Events
                                      </a>
                        </li> 
							
						<li class="nav-item">
                            <a href="statistics" class="nav-link"  style="color:#fff;background-color: rgba(255,255,255,0.1)">
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
                <div class="col-lg-2 col-5 col-sm-3 col-md-3 justify-content-center" >      
                </div>
                
                
            
            	<div class="col-lg-10 col-7 col-sm-9 col-md-9 py-3"><br><br><br>
            		<hr style="border: 1px solid #000">
            		<center><h3 style="color:green">Maximum Registered Events</h3></center>
            		<hr style="border: 1px solid #000">
            			<div id="chartContainer1" style="height: 600px; width: 100%;margin-top:20px;margin-left:70px;margin-right:100px"></div>				
				
				<br><br>
				
				<hr style="border: 1px solid #000">
            		<center><h3 style="color:green">Maximum Registered Sports</h3></center>
            	<hr style="border: 1px solid #000">
            	
            	<div id="chartContainer2" style="height: 600px; width: 100%;margin-top:20px;margin-left:70px;margin-right:100px"></div>
            	
            	<br><br>
            	
            	<hr style="border: 1px solid #000">
            		<center><h3 style="color:green">Maximum Participated User</h3></center>
            	<hr style="border: 1px solid #000">
            	
            	<div id="chartContainer3" style="height: 600px; width: 100%;margin-top:20px;margin-left:70px;margin-right:100px"></div>
            			<script>
							window.onload = function () {
								
								CanvasJS.addColorSet("greenShades",
							            [//colorSet Array
							
							            
							            "yellow",
							            "cyan"                
							            ]);
							
							var chart1 = new CanvasJS.Chart("chartContainer1", {
								animationEnabled: true,
								colorSet: "greenShades",
								
								theme: "dark2", // "light1", "light2", "dark1", "dark2"
								 backgroundColor: "black",
								 width : 1200,
								title: {
									margin:100,
									text: "Max Registered Events",
									fontSize: 50,
									padding : 20
								},
								axisY: {
									margin:50,
									title: "Registration Count",
									titleFontSize: 20
									
								},
								axisX: {
									title: "Events",
									margin:100,
									titleFontSize: 20
										
								},
								data: [{
									type: "column",
									indexLabel: "{y}",
									dataPoints: [
										<%  int i;
										for(i = 0 ; i<sport.size() ; i++)
											{
										%>
										{ label: "<%=sport.get(i).getEvent_name() %>", y: <%=sport.get(i).getTotal_participation() %> },
										<% } %>
										
										
									]
								}]
							});
							
							var chart2 = new CanvasJS.Chart("chartContainer2", {
								animationEnabled: true,
								colorSet: "greenShades",
								
								theme: "dark2", // "light1", "light2", "dark1", "dark2"
								 backgroundColor: "black",
								 width : 1200,
								title: {
									margin:100,
									text: "Max Registered Sports",
									fontSize: 50,
									padding : 20
								},
								axisY: {
									margin:50,
									title: "Registration Count",
									titleFontSize: 20
									
								},
								axisX: {
									title: "Sports",
									margin:100,
									titleFontSize: 20
										
								},
								data: [{
									type: "column",
									indexLabel: "{y}",
									dataPoints: [
										<% 
										for(i = 0 ; i<sport1.size() ; i++)
											{
										%>
										{ label: "<%=sport1.get(i).getSport_name() %>", y: <%=sport1.get(i).getTotal_participation() %> },
										<% } %>
										
										
									]
								}]
							});
							
							var chart3 = new CanvasJS.Chart("chartContainer3", {
								animationEnabled: true,
								colorSet: "greenShades",
								
								theme: "dark2", // "light1", "light2", "dark1", "dark2"
								 backgroundColor: "black",
								 width : 1200,
								title: {
									margin:100,
									text: "Max Participated User",
									fontSize: 50,
									padding : 20
								},
								axisY: {
									margin:50,
									title: "Participation Count",
									titleFontSize: 20
									
								},
								axisX: {
									title: "User",
									margin:100,
									titleFontSize: 20
										
								},
								data: [{
									type: "column",
									indexLabel: "{y}",
									dataPoints: [
										<% 
										for(i = 0 ; i<sport2.size() ; i++)
											{
										%>
										{ label: "<%=sport2.get(i).getEvent_name() %>", y: <%=sport2.get(i).getTotal_participation() %> },
										<% } %>
										
										
									]
								}]
							});
							chart1.render();
							chart2.render();
							chart3.render();
					
						}
				</script>
            	
            	</div>
            </div>
        </div>
      </div>
  </body>
</html>