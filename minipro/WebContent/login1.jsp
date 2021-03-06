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
<body>
	<div class="container-fluid bg-light p-4">
	                    <h2 style="text-align: center">Sports 24x7</h2>
	                </div>
  

                  <nav class="navbar navbar-expand-lg navbar-dark navbar-dark" *ngIf="show" style="background-color: #22313F">
                  		<img src="images/lo.png" class="brand-image elevation-6" width="40px">
                        <a class="navbar-brand" href="#">Sports 24x7</a>    
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                          <span class="navbar-toggler-icon"></span>
                        </button>
                  
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                          <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                              <a class="nav-link" href="">Login for Participant </a>
                            </li>
                          </ul>
                        </div>
                      </nav>


	
	<div class="container-fluid py-3">
	
		<form method="post" action="logincontroller1">
			<div class="container border border-info rounded px-3 py-3">
			<h2 align="center">Login for Participant</h2>
			<br>
			
	 		  <input type="hidden" name="Participant" class="form-c	ontrol" value="Participant" id="inputRole">
			  <div class="row justify-content-md-center justify-content-sm-center justify-content-xs-center">
			    <label for="inputEmail" class="col-form-label-lg col-xs-5 col-sm-2 col-md-2 col-lg-2">Email</label>
			    <div class="col-xs-5 col-sm-7 col-md-7 col-lg-7">
			      <input type="email" name="email" class="form-control form-control-lg" id="inputEmail3" placeholder="Email">
			    </div>
			  </div>
			  <div class="row justify-content-md-center justify-content-sm-center justify-content-xs-center">
			    <label for="inputPassword" class="col-form-label-lg col-xs-5 col-sm-2 col-md-2 col-lg-2">Password</label>
			    <div class="col-xs-5 col-sm-7 col-md-7 col-lg-7">
			      <input type="password" name="pwd" class="form-control form-control-lg" id="inputPassword3" placeholder="Password">
			    </div>
			  </div>
			  <div class="row justify-content-md-center justify-content-sm-center justify-content-xs-center">
			      <button type="submit" class="btn btn-primary">Sign in</button>
			  </div>
			 </div>
 		 </form>
	</div>

</body>
</html>