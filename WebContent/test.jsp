<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    <title>Create</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" media="screen" href="css/reset.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/grid_12.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/slider.css">
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
                      <li><a href="index.jsp">Create</a></li>
                      <li><a href="services.jsp">Display</a></li>
                      <li><a href="products.jsp">Delete</a></li>
                      <li><a href="contacts.jsp">Logout</a></li>
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
    	<div class="container_12 top">
            <div class="grid_4">

              <%
                ArrayList list =new ArrayList();
                list=(ArrayList)request.getAttribute("maListe");
                Iterator monIterator=list.iterator();
                while(monIterator.hasNext()){
                  site Site =(site)monIterator.next();
                }
              %>
              
            	<h2>Designing</h2>
                <img src="images/page3-img1.jpg" alt="" class="img-border top-3">
                <p class="top-4"><a href="#" class="link"><%=Site.getLibelle()%></a><br>
                <%=Site.getLibelle()%></p>
                <a href="#" class="button top-4">Read More</a>
            </div>
            <div class="grid_4">
            	<h2>Programming</h2>
                <img src="images/page3-img2.jpg" alt="" class="img-border top-3">
                <p class="top-4"><a href="#" class="link"><%=Site.getLibelle()%></a><br>
                <%=Site.getLibelle()%></p>
                <a href="#" class="button top-4">Read More</a>
            </div>
            <div class="grid_4">
            	<h2>SEO</h2>
                <img src="images/page3-img3.jpg" alt="" class="img-border top-3">
                <p class="top-4"><a href="#" class="link"> </a><%=Site.getLibelle()%><br>
                <%=Site.getLibelle()%></p>
                <a href="#" class="button top-4">Read More</a>
            </div>
        </div>
        </form>
    </section> 
<!--==============================footer=================================-->
  <footer>
      <p>© 2012 Start-Up<br> Website Template by <a class="link" href="http://www.templatemonster.com/" target="_blank" rel="nofollow">www.templatemonster.com</a></p>
      <div class="soc-icons"><span>Follow Us:</span><a href="#"><img src="images/icon-1.jpg" alt=""></a><a href="#"><img src="images/icon-2.jpg" alt=""></a><a href="#"><img src="images/icon-3.jpg" alt=""></a></div>
  </footer>	
</body>
</html>
