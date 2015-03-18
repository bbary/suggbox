<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="model.Idea"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <title>Display</title>
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
                      <li><a href="display">Display</a></li>
                      <li><a href="delete">Delete</a></li>
                      <li><a href="login.jsp">Logout</a></li>
                  </ul>
              </nav>
              <div class="clear"></div>
          </div>
      </div>
    </header>
  <!--==============================content================================-->
  </table>
    <section id="content"></div>
      <form>
      
      <cufon class="cufon cufon-canvas" alt="Start-Up" style="width: 142px; height: 50px;">
<canvas width="189" height="53" style="width: 189px; height: 53px; top: 5px; left: -9px;"></canvas>
<cufontext>Start-Up</cufontext>
</cufon>
    	<div class="container_12 top">
            <div class="grid_4">
            <div class="grid_12 box-2 pad-1">
			<%
			ArrayList test=new ArrayList();
			
                ArrayList list =new ArrayList();
                list=(ArrayList<Idea>)request.getAttribute("ideas");
                Iterator monIterator=list.iterator();
                while(monIterator.hasNext()){
                     Idea i=(Idea)monIterator.next();
                %>     
              		<div>
				<p class="text-3"><%= i.getIdeaTitle() %></p>
				<p class="text-4"><%= i.getIdeaText() %></p>
				<!-- <p class="top-4"><a href="#" class="link">df </a><br></p> -->
                <a href="comment?ideaTitle=<%= i.getIdeaTitle() %>" class="button top-4">Read Comments</a>
            		</div>
              
              <%  }
              %>
              
              
				
			</div>
        </div>
        </form>
    </section> 
<!--==============================footer=================================-->
  <footer>
      
      <div class="soc-icons"><span>Follow Us:</span><a href="#"><img src="images/icon-1.jpg" alt=""></a><a href="#"><img src="images/icon-2.jpg" alt=""></a><a href="#"><img src="images/icon-3.jpg" alt=""></a></div>
  </footer>	
</body>
</html>
