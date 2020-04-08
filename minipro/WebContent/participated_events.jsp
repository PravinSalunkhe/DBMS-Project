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


</head>
    <body class="bg-light">
     <%
	if(session.getAttribute("participant_id") == null)
	{
		response.sendRedirect("login1.jsp");
		return ;
	}
	
	%>

        	<div class="container-fluid bg-light p-4">
                    <h2 style="text-align: center">Sports 24x7</h2>
                </div>
  

                  <nav class="navbar navbar-expand-lg navbar-dark navbar-dark" *ngIf="show" style="background-color: #22313F">
                        <a class="navbar-brand" href="#">Sports 24x7</a>    
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                          <span class="navbar-toggler-icon"></span>
                        </button>
                  
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                          <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                              <a class="nav-link" href="">Home </a>
                            </li>
                          </ul>
                  
                          <ul class="navbar-nav navbar-right">
                            <button class="btn btn-outline-success mr-2 mt-1">Register</button>
                            <button class="btn btn-outline-success mt-1">Login</button>
                          </ul>
                        </div>
                      </nav>


        <div class="container-fluid">

            <div class="row justify-content-center" style="width:100%">
      
                <div class="col-lg-3 col-5 col-sm-3 col-md-3 justify-content-center" style=" background-color: #f1f0fe">
      
                        <div class="vertical-nav navigate" id="sidebar">
      
                                <ul class="navbar-nav ">
                                  <li class="nav-item" >
                                    <a href="<%=request.getContextPath()%>/Ongoing" class="nav-link  p-2 " style="text-align: center">
                                              <b>Ongoing Events</b>    
                                          </a>
                                  </li> 
                                  <li class="nav-item" >
                                      <a href="<%=request.getContextPath()%>/registeredevents_controller" class="nav-link p-2" style="text-align: center">
                                                <b>Registered Events</b>    
                                            </a>
                                    </li> 
                                    <li class="nav-item" style="background-color: #6A5ACD">
                                        <a href="participated_events.jsp" class="nav-link p-2 text-white active" style="text-align: center">
                                                  <b>Participated Sports</b>    
                                              </a>
                                      </li> 
                                      <li class="nav-item">
                                          <a href="notifications_controller" class="nav-link p-2" style="text-align: center">
                                                    <b>Notifications</b>    
                                                </a>
                                        </li> 
                                </ul>                      
                              </div>
                </div>
                <div class="col-lg-9 col-7 col-sm-9 col-md-9">
                

                                
                
      
             <div class="container-fluid mt-2">
                            
<div class="card border-primary mb-3"  style="border-radius: 25px ; overflow: hidden;" >
  <h4 style="background-color:#d4f8f8"  class="card-header text-center">Event name</h4>
  <div class="card-body px-5" >
<div class="row justify-content-center p-2">
      
                              <div class="container bg-white p-4">
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Sport Name</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>City</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Registration Fees</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Date:</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8">24/10-/019</div>
                                      </div>
                                      <hr>
                               </div>
  </div>                              
    </div>
</div>



<div class="card border-primary mb-3"  style="border-radius: 25px ; overflow: hidden;" >
  <h4 style="background-color:#d4f8f8"  class="card-header text-center">Event name</h4>
  <div class="card-body px-5" >
<div class="row justify-content-center p-2">
      
                              <div class="container bg-white p-4">
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Sport Name</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>City</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Registration Fees</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"></div>
                                      </div>
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Date:</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8">24/10-/019</div>
                                      </div>
                                      <hr>
                               </div>
  </div>                              
    </div>
</div>





</div>                            
        
            </div>
          </div>


                         
    </body>
</html>








