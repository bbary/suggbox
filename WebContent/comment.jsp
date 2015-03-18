<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="model.Comment"%>
<%@ page import="model.Idea"%>
<html lang="en">
<head>
<title>Create</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/grid_12.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/css/slider.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/comments.css">
<link href='http://fonts.googleapis.com/css?family=Lato:300italic'
	rel='stylesheet' type='text/css'>
<script src="js/jquery-1.7.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/cufon-yui.js"></script>
<script src="js/cufon-replace.js"></script>
<script src="js/Bilbo_400.font.js"></script>
<script src="js/tms-0.4.1.js"></script>
<script>
	$(document).ready(function() {
		$('.slider')._TMS({
			show : 0,
			pauseOnHover : true,
			prevBu : false,
			nextBu : false,
			playBu : false,
			duration : 800,
			preset : 'fade',
			pagination : true,
			pagNums : false,
			slideshow : 7000,
			numStatus : false,
			banners : 'fade',
			waitBannerAnimation : false,
			progressBar : false
		})
	});
</script>
		<script 
			src="${pageContext.request.contextPath}/csscomments/search.js"></script>
		<link media="screen"
			href="${pageContext.request.contextPath}/csscomments/style.css"
			rel="stylesheet">
		
		<link href="http://html5doctor.com/feed/" title="HTML5 Doctor » Feed"
			type="application/rss+xml" rel="alternate">
		<link href="http://html5doctor.com/comments/feed/"
			title="HTML5 Doctor » Comments Feed" type="application/rss+xml"
			rel="alternate">
		<link href="http://html5doctor.com/designing-a-blog-with-html5/feed/"
			title="HTML5 Doctor » Designing a blog with html5 Comments Feed"
			type="application/rss+xml" rel="alternate">
		<link media="all" type="text/css"
			href="${pageContext.request.contextPath}/csscomments/styles.css"
			id="contact-form-7-css" rel="stylesheet">
		<link media="all" type="text/css"
			href="${pageContext.request.contextPath}/csscomments/pagenavi-css.css"
			id="wp-pagenavi-css" rel="stylesheet">
		<script type="text/javascript" async=""
			src="${pageContext.request.contextPath}/csscomments/ga.js"></script>
		<script
			src="${pageContext.request.contextPath}/csscomments/jquery.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/csscomments/jquery-migrate.js"
			type="text/javascript"></script>
		<link href="http://html5doctor.com/xmlrpc.php?rsd" title="RSD"
			type="application/rsd+xml" rel="EditURI">
		<link href="http://html5doctor.com/the-footer-element/"
			title="The footer element" rel="prev">
		<link href="http://html5doctor.com/html-5-xml-xhtml-5/"
			title="HTML 5 + XML = XHTML 5" rel="next">
		<meta content="WordPress 3.9.1" name="generator">
		<link href="http://html5doctor.com/designing-a-blog-with-html5/"
			rel="canonical">
		<link href="http://html5doctor.com/?p=47" rel="shortlink">
<style type="text/css">
.recentcomments a {
	display: inline !important;
	padding: 0 !important;
	margin: 0 !important;
}
</style>
		<script type="text/javascript" 
			src="${pageContext.request.contextPath}/csscomments/bsa.js"></script>
		<script type="text/javascript" 
			src="//s3.buysellads.com/ac/bsa.js"></script>
		<script type="text/javascript"
			id="_bsap_js_ab161e2bf71edb940eeca26a4739f522"
			src="//s3.buysellads.com/r/s_ab161e2bf71edb940eeca26a4739f522.js?v=1426694400000"
			async="async"></script>
		<script id="_fbn_projs" type="text/javascript"
			src="//srv.buysellads.com/ads/.json?segment=placement:&amp;callback=_fbn_go"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ListeEtoile.js"></script>
	<style type="text/css">
		.listeEtoile ul {
			margin: 0;
			padding: 0;
			list-style-type: none;
		}
		.listeEtoile ul li {
			display:inline-block;
			width: 16px;
			text-align: left;
			list-style-type: none;
		}
		.listeEtoile ul li img {
			border: 0;
			margin: 0;
			padding: 0;
		}
		#tableau-sondage{
			font-family:verdana;
			font-size:12px;
		}
		#tableau-sondage th{
			font-size:13px;
			border:solid 1px black;
			padding:8px;
			cursor:default;
		}
		#tableau-sondage td{
			border:solid 1px black;
			padding:12px 3px;
			text-align:center;
		}
	</style>


</head>
<body>
	<header>
		<div>
			<div>
				<h1>
					<a href="index.html"><img src="images/logo.png" alt=""></a>
				</h1>
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
		
    	<div class="container_12 top">
            <div class="grid_4">
            <div class="grid_12 box-2 pad-1">
			   <div>
				<p class="text-3"><%=((Idea)request.getAttribute("idea")).getIdeaTitle() %></p>
				<p class="text-4"><%=((Idea)request.getAttribute("idea")).getIdeaText() %></p>
				
               </div>

					
					<section id="comments">

						<h3>${nbr_comments} comments on this idea</h3></center>
						<center>
						
									<%
			ArrayList<Comment> list=new ArrayList<Comment>();
			list=(ArrayList<Comment>)request.getAttribute("comments");
                Iterator monIterator=list.iterator();
                while(monIterator.hasNext()){
                     Comment com=(Comment)monIterator.next();
                %>     
              		<article id="comment" class="comment even thread-even depth-1">
							<div class="comment-meta">
								<a class="url" rel="external nofollow" href="http://ocean90.de/"><%= com.getCommentator().getLogin() %></a>
							</div>

							<div class="comment-body">
								<p>
									<%=com.getComment() %>
								</p>
								
							</div>
						</article>
              
              <%  }
              %>
						

						<div id="form">
							<h3>Add comment</h3>

							<form id="commentform" method="post"
								action="comment">
								<p>
									<label for="author">Login (required)</label><input type="text"
										aria-required="true" tabindex="1" size="22"
										id="author" name="author">
								</p>

								<p>
									<label for="email">Mail (will not be published)
										(required)</label><input type="email"  aria-required="true"
										tabindex="2" size="22" id="email" name="email">
								</p>


								
								<p>
									<label for="comment" class="screenreader">Enter comment</label>
									<textarea tabindex="4" rows="10" cols="100%" id="comment"
										name="comment" required="" aria-required="true"></textarea>
								</p>

								<p>
									<input type="submit" value="Submit Comment" name="submit">
									 	 
								</p>

								<p>${success }</p>
			

								<script
									src="${pageContext.request.contextPath}/csscomments/form.js"
									type="text/javascript"></script>

							</form>
								<p class="text-3"> 
									Evaluate this Idea <div id='A1'><script type='text/javascript'>CreateListeEtoile('A1',5);</script></div>
									 	 
								</p>
						</div>

					</section>
			</div>
			</div>
			</div>
					
			
			<!-- END BuySellAds.com Ad Code -->
			<script
				src="${pageContext.request.contextPath}/csscomments/jquery_002.js"></script>
			<!-- TODO: move scripts in head to before /body —oli -->

			<script
				src="${pageContext.request.contextPath}/csscomments/searchhi.js"></script>
			<script
				src="${pageContext.request.contextPath}/csscomments/prettify.js"></script>
			<script
				src="${pageContext.request.contextPath}/csscomments/master.js"></script>
			<script type="text/javascript">
				var _gaq = _gaq || [];
				_gaq.push([ '_setAccount', 'UA-8916679-1' ]);
				_gaq.push([ '_setDomainName', 'html5doctor.com' ]);
				_gaq.push([ '_trackPageview' ]);

				(function() {
					var ga = document.createElement('script');
					ga.type = 'text/javascript';
					ga.async = true;
					ga.src = ('https:' == document.location.protocol ? 'https://ssl'
							: 'http://www')
							+ '.google-analytics.com/ga.js';
					var s = document.getElementsByTagName('script')[0];
					s.parentNode.insertBefore(ga, s);
				})();
			</script>
			<script id="_fancybar_js"
				src="${pageContext.request.contextPath}/csscomments/fancybar.js"
				type="text/javascript" async=""></script>

<!--==============================footer=================================-->
<footer>
	<p>
		 2012 Start-Up<br> Website Template by <a class="link"
			href="http://www.templatemonster.com/" target="_blank" rel="nofollow">www.templatemonster.com</a>
	</p>
	<div class="soc-icons">
		<span>Follow Us:</span><a href="#"><img src="images/icon-1.jpg"
			alt=""></a><a href="#"><img src="images/icon-2.jpg" alt=""></a><a
			href="#"><img src="images/icon-3.jpg" alt=""></a>
	</div>
</footer>
</body>
</html>
