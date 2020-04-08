<%@page import="java.util.ArrayList"%>
<%@page import="com.minipro.model.Sport"%>
<%@page import="java.util.List"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<!DOCTYPE html>
	<html lang="zxx" class="no-js">
	<head>
		<!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Favicon-->
		<link rel="shortcut icon" href="img/fav.png">
		<!-- Author Meta -->
		<meta name="author" content="CodePixar">
		<!-- Meta Description -->
		<meta name="description" content="">
		<!-- Meta Keyword -->
		<meta name="keywords" content="">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>Home</title>
 
		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
			<!--
			CSS
			============================================= -->
			<link rel="stylesheet" href="css/linearicons.css">
			<link rel="stylesheet" href="css/font-awesome.min1.css">
			<link rel="stylesheet" href="css/magnific-popup.css">
			<link rel="stylesheet" href="css/nice-select.css">
			<link rel="stylesheet" href="css/owl.carousel.css">
			<link rel='stylesheet' href='css/simplelightbox.min.css' >
			<link rel="stylesheet" href="css/bootstrap.css">
			<link rel="stylesheet" href="css/main.css">

		</head>
		<body>
			<!-- Start Header Area -->
			<header class="default-header">
				<div class="container">
					<div class="header-wrap">
						<div class="header-top d-flex justify-content-between align-items-center">
							<div class="logo"style="color:white;">
								<a href="#home"><img src="img/logo.jpg" width="40px" alt=""></a>Sports 24X7
							</div>
							<div class="main-menubar d-flex align-items-center">
								<nav class="hide">
									<a href="#home">Home</a>
									<a href="#about">Login</a>
									<a href="#contact">Contact</a>
									<a href="register_form.jsp">SignUp</a>							
								</nav>
								<div class="menu-bar"><span class="lnr lnr-menu"></span></div>
							</div>
						</div>
					</div>
				</div>
			</header>
			<!-- End Header Area -->
			<!-- start banner Area -->
			<section class="banner-area relative" id="home">			
				<div class="slider"><div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
				        <div class="carousel-inner" role="listbox">
				          <!-- Slide One - Set the background image for this slide in the line below -->
				          <div class="carousel-item active" style="background-image: url('img/slider1.jpg')">
				            <div class="carousel-caption d-md-block">
				              <h2 class="text-uppercase">Play like a Champion Today</h2>
				         
				            </div>
				          </div>
				          <!-- Slide Two - Set the background image for this slide in the line below -->
				          <div class="carousel-item" style="background-image: url('img/slider3.jpg')">
				            <div class="carousel-caption d-md-block">
				              <h2 class="text-uppercase">Winning is a habit, Success is a choice</h2>
				              
				            </div>
				          </div>
				          <!-- Slide Three - Set the background image for this slide in the line below -->
				          <div class="carousel-item" style="background-image: url('img/slider4.jpg')">
				            <div class="carousel-caption d-md-block">
				              <h2 class="text-uppercase">OUT HUSTLE, OUT WORK, OUT THINK, OUTPLAY, OUTLAST!</h2>
				              
				            </div>
				          </div>
				        </div>
				        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
				          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				          <span class="sr-only">Previous</span>
				        </a>
				        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
				          <span class="carousel-control-next-icon" aria-hidden="true"></span>
				          <span class="sr-only">Next</span>
				        </a>
				      </div>
				</div>
			</section>
			<!-- End banner Area -->	
			<div class="container-fluid">
            <div class="row justify-content-center" style="width:100%"style=" background: rgba(31, 31, 31,1);border-top-right-radius: 10px;">
            
            	<div class="col-lg-9 col-7 col-sm-9 col-md-9 py-3">
            	<br><br><br>
            	<h3 class="text-center"><b>Upcoming Sports</b></h3>
            	<br><br><br>
            	
            			<%
      					List<Sport> s =new ArrayList<Sport>();
      					s=(List<Sport>)request.getAttribute("sport");
      					 
      					if(!s.isEmpty())
      					{	
	      					for(Sport m : s)
	      					{
	      						System.out.println(m.getHost_id());
	      						
	      						//System.out.println(uid);	
      							//int uid=m.getHost_id();
      				%>
      				
      						
      				
                    <div class="card mt-2" style="border-radius: 25px;overflow: hidden;">
                        <div class="card-header text-center text-white" style="background-color:rgba(52, 58, 64,1)">
                            <%=m.getEvent_name() %>
                          </div>
                          
                        <div class="card-body">
                          <div class="row justify-content-center p-2">
      
                              <div class="container bg-white p-4">
                                      
                                   
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Sport Name</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%= m.getSport_name() %></div>
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
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Date:</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=m.getSport_date() %></div>
                                      </div>
                                      
                                      <hr>
                                      <div class="row">
                                          <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3 col-3"><b>Total Participation</b></div>:
                                          <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 col-8"><%=m.gettotal_participation() %></div>
                                      </div>
                                     
                                      <div>
                                        <button class="btn btn-primary float-right mt-4 p-2"  onclick="window.location.href='login1.jsp'">Login to Register</button>
                                      </div>
          
                              </div>
                    
                              </div>
                      </div>
                      
                </div>
					
			<% } } %>
			</div>
			</div>
			</div>	



            		
			<!-- Start About Area -->
			<section class="About-area section-gap" id="about">
				<div class="container">
					<div class="row d-flex align-items-center">
						
						<div class="col-lg-6 about-left">
							<h1>
								We Believe that <br>
								
							</h1>
							<p><br>sport is for everyone<br>
								So, Here we are for Hosting and publishing of your sports event for free...
							</p>
							<button onclick="window.location.href='login.jsp'" class="submit-btn primary-btn mt-20 text-uppercase ">Host Login<span class="lnr lnr-arrow-right"></span></button>
						</div>
						<div class="col-lg-6 about-right">
							<h1>
								We Believe that <br>
							</h1>
							<p><br>
								sport makes you happy <br>
								Connect directly to the 1000's of the event running around you... 
							</p>
							<button onclick="window.location.href='login1.jsp'" class="submit-btn primary-btn mt-20 text-uppercase ">participate Login<span class="lnr lnr-arrow-right"></span></button>
						</div>
					</div>
				</div>	
			</section>
			<section class="contact-area" id="contact">
				<div class="container-fluid">
					<div class="row d-flex justify-content-end align-items-center">
						<div class="col-lg-5 col-md-12 contact-left no-padding">
							<img class="img-fluid" src="img/contact.jpg" alt="">
						</div>
						<div class="col-lg-7 col-md-12 contact-right no-padding">
							<h1>
								Feel free to contact us
							</h1>
							<form class="booking-form" id="myForm" action="contact.php">
								 	<div class="row">
								 		<div class="col-lg-12 d-flex flex-column">
							 				<input name="name" placeholder="Your name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Your name'" class="form-control mt-20" required="" type="text" required>
								 		</div>
							 			<div class="col-lg-12 d-flex flex-column">
											<input name="email" placeholder="Enter email address" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" class="common-input mt-10" required="" type="email">
										</div>									
										<div class="col-lg-12 flex-column">
											<textarea class="form-control mt-20" name="message" placeholder="Messege" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'" required=""></textarea>
										</div>
										
										<div class="col-lg-12 d-flex justify-content-end send-btn">
											<button class="submit-btn primary-btn mt-20 text-uppercase ">Send<span class="lnr lnr-arrow-right"></span></button>
										</div>

										<div class="alert-msg"></div>		
									</div>
					  		</form>
							</div>
						</div>						
					</div>	
			</section>
			
			<footer class="footer-area">
				<div class="container">
					<div class="row footer-bottom d-flex justify-content-between">
						<p class="col-lg-8 col-sm-12 footer-text m-0 text-white">Sports 24X7 provides you free publicity for your sport Events <i class="fa fa-heart-o" aria-hidden="true"></i> by Sports 24X7</p>
						<div class="col-lg-4 col-sm-12 footer-social">
							<a href="#"><i class="fa fa-facebook"></i></a>
							<a href="#"><i class="fa fa-twitter"></i></a>
							<a href="#"><i class="fa fa-dribbble"></i></a>
							<a href="#"><i class="fa fa-behance"></i></a>
						</div>
					</div>
				</div>
			</footer>
			
			<script src="js/vendor/jquery-2.2.4.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
			<script src="js/vendor/bootstrap.min.js"></script>
			<script src="js/jquery.ajaxchimp.min.js"></script>
			<script src="js/owl.carousel.min.js"></script>			
			<script src="js/jquery.nice-select.min.js"></script>
			<script src="js/jquery.sticky.js"></script>
			<script src="js/parallax.min.js"></script>
			<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
			<script type="text/javascript" src="js/simple-lightbox.min.js"></script>
			<script src="js/main.js"></script>	
		</body>
	</html>