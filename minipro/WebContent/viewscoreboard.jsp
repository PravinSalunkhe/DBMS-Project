<%@page import="com.minipro.model.Match"%>
<%@page import="java.util.List"%>
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
            <span class="ml-2" style="font-weight: 600; font-size: x-large; color: white">Scoreboard</span>
                        
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
                                      <a href="your_events_controller" class="nav-link ">
                                      	<i class="fa fa-database nav-icon" aria-hidden="true"></i>
                                        <p>Your Events</p>    
                                      </a>
                        </li> 
                        
                        <li class="nav-item">
                                      <a href="schedule_event" class="nav-link" >
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
                                      <a href="history_controller" class="nav-link " style="color:#fff;background-color: rgba(255,255,255,0.1)">
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
        
        <%
        	String eventname = (String)request.getParameter("eventname");
    		String sportname = (String)request.getParameter("sportname");
    		String city = (String)request.getParameter("city");
    		int fees = (int)request.getAttribute("fees");
    		String date = (String)request.getParameter("date");
    		int totalparti = (int)request.getAttribute("totalparti");
    		int max_round = (int)request.getAttribute("max_round");
    		List<Match> match = (List<Match>)request.getAttribute("match");
    		int index = 0;
        %>
        
        <div class="container-fluid">
            <div class="row justify-content-center" style="width:100%"style=" background: rgba(31, 31, 31,1);border-top-right-radius: 10px;">
                <div class="col-lg-3 col-5 col-sm-3 col-md-3 justify-content-center" >      
                </div>
            
            	<div class="col-lg-9 col-7 col-sm-9 col-md-9 py-3"><br><br><br>
            	
            		<div class="container bg-white p-4">
                             
                             		<hr>
                             			
                             		<div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Event Name</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=eventname %></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Sport Name</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=sportname %></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>City</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=city %></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Registration Fees</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=fees %></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Date</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=date %></div>
                                      </div>
                                      <hr>
									  <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Total Participation</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=totalparti %></div>
                                      </div>
          							<hr>      
                              </div>
    				
    				
            		<div class="accordion" id="accordionExample">
            		
            				<% if(max_round > 0)
            					{
            				%>
							  <div class="card">
							    <div class="card-header" id="headingOne">
							      <h2 class="mb-0">
							        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							          <b>Round 1</b>
							        </button>
							      </h2>
							    </div>
							
							    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
							      <div class="card-body">
							  <table class="table table-bordered table-hover" style="background-color:#343A40 ;color:white">
			  					<thead style="text-align:center">
								    <tr>
								  	  <th scope="col">Match No.</th>
								      <th scope="col">Team A</th>
								      <th scope="col">Team B</th>
								      <th scope="col">Date</th>
								      <th scope="col">Time</th>
								      <th scope="col">Match Winner</th>
								    </tr>
								  </thead>
								  
								  <tbody style="background-color:#fff ;color:black;text-align:center">
								  
								  	<%
								  		for(int i=0 ; i<match.size() ; i++)
								  		{
								  			if(match.get(i).getRound() == 1)
								  			{
								  	%>
								  
								  	<tr>
								  		<td><%=i+1 %></td>
								  		<td><%=match.get(i).getTeam1() %></td>
								  		<td>
								  		<% if(match.get(i).getPid2()!=0 ) {%>
								  			<%=match.get(i).getTeam2() %>
								  		<% }else{ %>
								  		 	-----
								  		<%} %>
								  		</td>
								  		<td><%=match.get(i).getM_date() %></td>
								  		<td><%=match.get(i).getM_time() %></td>
								  		<td><% 
								  			if(match.get(i).getWinner_id() == match.get(i).getPid1())
								  			{
								  			%>
								  				<%=match.get(i).getTeam1() %>
								  			<% }else{ %>
								  				<%=match.get(i).getTeam2() %>
								  			<%} %>
								  		</td>
								  		
								  		<%
								  				index = i;
								  		%>
								  	</tr>
								  	
								  	<% } } %>
								  	
								  	
								  	
			  					</tbody>
			  					
							</table>
							       </div>
							    </div>
							  </div>
							  
						<% } %>
							  
							<% if(max_round > 1)
            				{
            				%>
							  
							  <div class="card">
							    <div class="card-header" id="headingTwo">
							      <h2 class="mb-0">
							        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
							          <b>Round 2</b>
							        </button>
							      </h2>
							    </div>
							    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
							      <div class="card-body">
							      	
							      		<table class="table table-bordered table-hover" style="background-color:#343A40 ;color:white">
			  					<thead style="text-align:center">
								    <tr>
								  	  <th scope="col">Match No.</th>
								      <th scope="col">Team A</th>
								      <th scope="col">Team B</th>
								      <th scope="col">Date</th>
								      <th scope="col">Time</th>
								      <th scope="col">Match Winner</th>
								    </tr>
								  </thead>
								  
								  <tbody style="background-color:#fff ;color:black;text-align:center">
								  
								  <%
								  		for(int i=0 ; i<match.size() ; i++)
								  		{
								  			if(match.get(i).getRound() == 2)
								  			{
								  	%>
								  
								  	<tr>
								  		
								  		<td><%=i+1 %></td>
								  		<td><%=match.get(i).getTeam1() %></td>
								  		<td>
								  		<% if(match.get(i).getPid2()!=0 ) {%>
								  			<%=match.get(i).getTeam2() %>
								  		<% }else{ %>
								  		 	-----
								  		<%} %>
								  		</td>
								  		<td><%=match.get(i).getM_date() %></td>
								  		<td><%=match.get(i).getM_time() %></td>
								  		<td><% 
								  			if(match.get(i).getWinner_id() == match.get(i).getPid1())
								  			{
								  			%>
								  				<%=match.get(i).getTeam1() %>
								  			<% }else{ %>
								  				<%=match.get(i).getTeam2() %>
								  			<%} %>
								  		</td>
								  		
								  		<%
								  				index = i;
								  		%>
								  	
								  	</tr>
								  	
								  	<% } } %>
								  	
			  					</tbody>
			  					
							</table>
							      
							      </div>
							    </div>
							  </div>
							 <% } %>
							  
							<% if(max_round > 2)
            				{
            				%>
							  
							  <div class="card">
							    <div class="card-header" id="headingThree">
							      <h2 class="mb-0">
							        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
							          <b>Round 3</b>
							        </button>
							      </h2>
							    </div>
							    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
							      <div class="card-body">
								  <table class="table table-bordered table-hover" style="background-color:#343A40 ;color:white">
				  					<thead style="text-align:center">
									    <tr>
									  	  <th scope="col">Match No.</th>
									      <th scope="col">Team A</th>
									      <th scope="col">Team B</th>
									      <th scope="col">Date</th>
									      <th scope="col">Time</th>
									      <th scope="col">Match Winner</th>
									    </tr>
									  </thead>
									  
									  <tbody style="background-color:#fff ;color:black;text-align:center">
									  
									  	<%
								  		for(int i=0 ; i<match.size() ; i++)
								  		{
								  			if(match.get(i).getRound() == 3)
								  			{
								  	%>
								  
								  	<tr>
								  		
								  		<td><%=i+1 %></td>
								  		<td><%=match.get(i).getTeam1() %></td>
								  		<td>
								  		<% if(match.get(i).getPid2()!=0 ) {%>
								  			<%=match.get(i).getTeam2() %>
								  		<% }else{ %>
								  		 	-----
								  		<%} %>
								  		</td>
								  		<td><%=match.get(i).getM_date() %></td>
								  		<td><%=match.get(i).getM_time() %></td>
								  		<td><%=match.get(i).getWinner_id() %></td>
								  		
								  		<%
								  				index = i;
								  		%>
								  	
								  	</tr>
								  	
								  	<% } } %>
									  	
				  					</tbody>
				  					
								</table>
							      </div>
							    </div>
							  </div>
							  
							<%} %>
							  
							<% if(max_round > 3)
            				{
            				%>
							  
							  <div class="card">
							    <div class="card-header" id="headingFour">
							      <h2 class="mb-0">
							        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
							          <b>Round 4</b>
							        </button>
							      </h2>
							    </div>
							    <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
							      <div class="card-body">
								  <table class="table table-bordered table-hover" style="background-color:#343A40 ;color:white">
				  					<thead style="text-align:center">
									    <tr>
									  	  <th scope="col">Match No.</th>
									      <th scope="col">Team A</th>
									      <th scope="col">Team B</th>
									      <th scope="col">Date</th>
									      <th scope="col">Time</th>
									      <th scope="col">Match Winner</th>
									    </tr>
									  </thead>
									  
									  <tbody style="background-color:#fff ;color:black;text-align:center">
									  
									  	<%
								  		for(int i=0 ; i<match.size() ; i++)
								  		{
								  			if(match.get(i).getRound() == 2)
								  			{
								  		%>
								  
									  	<tr>
									  		
									  		<td><%=i+1 %></td>
									  		<td><%=match.get(i).getTeam1() %></td>
									  		<td>
									  		<% if(match.get(i).getPid2()!=0 ) {%>
									  			<%=match.get(i).getTeam2() %>
									  		<% }else{ %>
									  		 	-----
									  		<%} %>
									  		</td>
									  		<td><%=match.get(i).getM_date() %></td>
									  		<td><%=match.get(i).getM_time() %></td>
									  		<td><% 
								  			if(match.get(i).getWinner_id() == match.get(i).getPid1())
								  			{
								  			%>
								  				<%=match.get(i).getTeam1() %>
								  			<% }else{ %>
								  				<%=match.get(i).getTeam2() %>
								  			<%} %>
								  			</td>
									  		
									  		<%
								  				index = i;
								  			%>
								  	</tr>
									  	
									  	
									  	<% } } %>
									  	
									  	
				  					</tbody>
				  					
								</table>
							      </div>
							    </div>
							  </div>
							  
						<%} %>
						
						
							
							<% if(max_round > 4)
            				{
            				%>	  
							  <div class="card">
							    <div class="card-header" id="headingFive">
							      <h2 class="mb-0">
							        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
							          <b>Round 5</b>
							        </button>
							      </h2>
							    </div>
							    <div id="collapseFive" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
							      <div class="card-body">
								  <table class="table table-bordered table-hover" style="background-color:#343A40 ;color:white">
				  					<thead style="text-align:center">
									    <tr>
									  	  <th scope="col">Match No.</th>
									      <th scope="col">Team A</th>
									      <th scope="col">Team B</th>
									      <th scope="col">Date</th>
									      <th scope="col">Time</th>
									      <th scope="col">Match Winner</th>
									    </tr>
									  </thead>
									  
									  <tbody style="background-color:#fff ;color:black;text-align:center">
									  
										<%
								  		for(int i=0 ; i<match.size() ; i++)
								  		{
								  			if(match.get(i).getRound() == 2)
								  			{
								  		%>
								  
									  	<tr>
									  	
									  		<td><%=i+1 %></td>
									  		<td><%=match.get(i).getTeam1() %></td>
									  		<td>
									  		<% if(match.get(i).getPid2()!=0 ) {%>
									  			<%=match.get(i).getTeam2() %>
									  		<% }else{ %>
									  		 	-----
									  		<%} %>
									  		</td>
									  		<td><%=match.get(i).getM_date() %></td>
									  		<td><%=match.get(i).getM_time() %></td>
									  		<td><% 
								  			if(match.get(i).getWinner_id() == match.get(i).getPid1())
								  			{
								  			%>
								  				<%=match.get(i).getTeam1() %>
								  			<% }else{ %>
								  				<%=match.get(i).getTeam2() %>
								  			<%} %>
								  			</td>
									  		<%
								  				index = i;
								  			%>
								  		</tr>
									  	
								  	
								  		<% } } %>
									  	
				  					</tbody>
				  					
								</table>
							      </div>
							    </div>
							  </div>
							 
							 <%} %>
							
					</div>
					
						<hr>
						
					  	 <div class="row">
                               <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Winner</b></div>:
                               <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%
                               			if(match.get(index).getWinner_id() == match.get(index).getPid1())
                               			{%>
                               				<%=match.get(index).getTeam1() %>
                               			<%}
                               			else
                               			{%>
                               				<%=match.get(index).getTeam2() %>
                               			<%}%> Team
                               	</div>
                         </div>
                      	<hr>         
                            
  			`	</div>
  				</div>
  			</div>
  		</div>
</body>
</html>