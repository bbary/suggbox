<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<head>
    <title>Create</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/grid_12.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/slider.css">
    <link href='http://fonts.googleapis.com/css?family=Lato:300italic' rel='stylesheet' type='text/css'>
    <script src="js/jquery-1.7.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/cufon-yui.js"></script>
    <script src="js/cufon-replace.js"></script>
    <script src="js/Bilbo_400.font.js"></script>
    <script src="js/tms-0.4.1.js"></script>
    <script>
		$(document).ready(function(){				   	
			$('.slider')._TMS({
				show:0,
				pauseOnHover:true,
				prevBu:false,
				nextBu:false,
				playBu:false,
				duration:800,
				preset:'fade',
				pagination:true,
				pagNums:false,
				slideshow:7000,
				numStatus:false,
				banners:'fade',
				waitBannerAnimation:false,
				progressBar:false
			})		
		});
	</script>
	<!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
      </div>
    <![endif]-->
    <!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
    	<link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
	<![endif]-->
</head>
<body>
   <header> 
       <div> 
          <div>                 	
              <h1><a href="index.html"><img src="images/logo.png" alt=""></a></h1> 
              <nav>  
                <ul class="menu">
                      <li><a href="create.jsp">Create</a></li>
                      <li><a href="display.jsp">Display</a></li>
                      <li><a href="products.jsp">Delete</a></li>
                      <li><a href="login.jsp">Logout</a></li>
                  </ul>
              </nav>
              <div class="clear"></div>
          </div>
      </div>
    </header>  
<section id="content">
    <div id="slider">
       <div class="slider">
          <ul class="items">
              <li><img src="images/slider-1.jpg" alt="" /><div class="banner"><p class="text-1">We've Got <strong>an Idea!</strong></p><p class="text-2"></p></div></li>
              <li><img src="images/slider-2.jpg" alt="" /><div class="banner"><p class="text-1">Here We <strong>Are!</strong></p><p class="text-2"></p></div></li>
              <li><img src="images/slider-3.jpg" alt="" /><div class="banner"><p class="text-1">Stay <strong>Creative!</strong></p><p class="text-2"></p></div></li>
          </ul>
       </div>
    </div>
<FORM method="post" action="">
<table width="247" height="10" border="0">
   <div class="container_12 top">
            	<h2>Title of Idea</h2>
            	<form id="form" method="post" >

                      <label><input type="text" value="Title" size="35" onBlur="if(this.value=='') {this.value='Title'}" onFocus="if(this.value =='Title' ) this.value=''"></label><br>
                      <h2>Idea</h2>
                      <label><textarea rows="4" cols="100" onBlur="if(this.value=='') {this.value='Idea'}" onFocus="if(this.value =='Idea' ) this.value=''"></textarea></label>

                      <div class="btns"><a href="#" class="button">Clear</a><a href="#" class="button" onClick="document.getElementById('form').submit()">Send</a></div> 
                  </form> 
            </div>
</table>
</section>
</body>
</html>
