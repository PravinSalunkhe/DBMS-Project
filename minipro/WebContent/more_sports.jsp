<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="java.util.ArrayList"%>
<%@page import="com.minipro.model.Event"%>
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
		return ;
	}
	
%>
<% 
		String eventName=(String)request.getAttribute("event_name");
		System.out.println(eventName);
%>
	
<c:url var="templink" value="eventcreate_controller">
	<c:param name="eventName" value="<%=eventName %>"></c:param>
</c:url>


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
            <span class="ml-2" style="font-weight: 600; font-size: x-large; color: white">Home</span>
                        
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
                                      <a href="event_create.jsp" class="nav-link "  style="color:#fff;background-color: rgba(255,255,255,0.1)">
                                      	<i class="fa fa-flag nav-icon" aria-hidden="true"></i>
                                                <p>Create Events</p>    
                                            </a>
                        </li> 
                        
                          <li class="nav-item">
                                      <a href="more_sports" class="nav-link " >
                                      	<i class="fa fa-plus-square nav-icon" aria-hidden="true"></i>
                                                <p>Add Sports</p>    
                                            </a>
                        </li> 
                        <li class="nav-item">
                                      <a href="history_controller" class="nav-link ">
                                      	<i class="fa fa-history nav-icon" aria-hidden="true"></i>
                                        <p>Hosted Events History</p>    
                                      </a>
                        </li> 
                        
                        <li class="nav-item">
                            <a href="profile_controller" class="nav-link">
                            <i class="fa fa-user-o nav-icon" aria-hidden="true"></i>
                                <p>Profile</p>
                            </a>
                        </li>
                    
                        <li class="nav-item">

                            <a href="" class="nav-link">
                                <i class="fa fa-sign-in nav-icon"aria-hidden="true"></i>
                                <p>Logout</p>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- /.sidebar-menu -->
            </div>
            <!-- /.sidebar -->
        </aside>
        
	</div>
		
	<div class="container-fluid">
            <div class="row justify-content-center" style="width:100%"style=" background: rgba(31, 31, 31,1);border-top-right-radius: 10px;">
                <div class="col-lg-2 col-5 col-sm-3 col-md-3 justify-content-center" >      
                </div>
                <div class="col-lg-10 col-7 col-sm-9 col-md-9 py-3">
                <br><br><br>
               		<form id="myform1" action="${templink}" method="post">
	
						<div class="container border border-info rounded px-3 py-3">
								<h2 style="text-align: center">Sport Details</h2>
							<br>
							 <input type="hidden" name="command" value="add more sports">	
							  	
							  <div class="row justify-content-md-center justify-content-sm-center justify-content-xs-center">
							   <label for="inputSportName" class="col-form-label-lg col-xs-5 col-sm-2 col-md-2 col-lg-2">Sport Name :</label>
								    <div class="col-xs-5 col-sm-7 col-md-7 col-lg-7">
								      <input type="text" name="sportName" class="form-control form-control-lg" id="sportName" placeholder="Sport Name">
								    </div>
							  </div>
							  <div class="row justify-content-md-center justify-content-sm-center justify-content-xs-center">
							   <label for="inputSportDate" class="col-form-label-lg col-xs-5 col-sm-2 col-md-2 col-lg-2">Date :</label>
								    <div class="col-xs-5 col-sm-7 col-md-7 col-lg-7">
								      <input type="date" name="sportDate" class="form-control form-control-lg" id="sportDate" placeholder="Date">
								    </div>
							  </div>
							  <div class="row justify-content-md-center justify-content-sm-center justify-content-xs-center">
							   <label for="inputSportFees" class="col-form-label-lg col-xs-5 col-sm-2 col-md-2 col-lg-2">Fees :</label>
								    <div class="col-xs-5 col-sm-7 col-md-7 col-lg-7">
								      <input type="number" name="sportFees" class="form-control form-control-lg" id="sportFees" placeholder="Fees">
								    </div>
							  </div>
							   <div class="row justify-content-md-center justify-content-sm-center justify-content-xs-center">
							   <label for="inputMaxParticipation" class="col-form-label-lg col-xs-5 col-sm-2 col-md-2 col-lg-2">Max Participation:</label>
								    <div class="col-xs-5 col-sm-7 col-md-7 col-lg-7">
								      <input type="number" name="maxParticipation" class="form-control form-control-lg" id="maxParticipation" placeholder="Max Participation">
								    </div>
							  </div> 
							  <div class="row justify-content-md-center justify-content-sm-center justify-content-xs-center">
							  	<button type="submit" class=" btn btn-dark">Add Sport</button>
							  </div>
						</div>		 
				</form> 
				</div>
			</div>
	</div>

	<script type="text/javascript">
		    $(window).on('load',function(){
		        $('#exampleModal').modal('show');
		    });
	</script>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Add more sports</h5>
		       <!--  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>  -->
		      </div>
	
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Yes</button>
		       <a href="your_events_controller" class="btn btn-secondary" role="button" >No,I want to finish</a>
		      </div>
		    </div>
		  </div>
		</div>
	
</body>
</html>







