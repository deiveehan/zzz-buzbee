<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="tagincludes.jsp"%>
<%@ include file="resourceincludes.jsp"%>
<%@ include file="scriptincludes.jsp"%>
<%@ include file="gadgetincludes.jsp"%>

<script type="text/javascript" src="../js/tech/Application.js"></script>
<script type="text/javascript"
	src="../js/tech/gadgets/homegadgetcontainer.js" defer="defer"></script>
<script type="text/javascript" src="../js/tech/home.js"></script>
<script>
	application = new Application();
	$(document).ready(function() {
		application.showHeading("Home page");
	});
</script>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<ul class="nav">
					<li><a class="brand" id="readerHeader" href="#"><img
							src="../resources/images/scribblelogo.png" width="35" height="35"
							longdesc="http://www.scribbles.com">&nbsp;&nbsp;&nbsp;&nbsp;Scribbles</a>
					</li>
				</ul>

				<ul class="nav">
					<li><a href="#"
						onclick="application.loadPage('../article/loadArticleCreationPage')">
							<span class="add-on"> <i class="icon-white icon-plus">
							</i>
						</span> Create Article
					</a></li>
					<li><a href="#"
						onclick="application.loadPage('../article/loadArticleSearchResults')">
							<span class="add-on"> <i class="icon-white icon-plus">
							</i>
						</span> View Articles
					</a></li>
					<li><a href="#"
						onclick="application.loadPage('../widget/loadWidgetEdit')"> <span
							class="add-on"> <i class="icon-white icon-picture"> </i>
						</span> Create Widget
					</a></li>
					<li><a href="#"
						onclick="application.loadPage('../widget/loadWidgetViewPage')"> <span
							class="add-on"> <i class="icon-white icon-picture"> </i>
						</span> View Widget
					</a></li>
					<li><a href="#" onclick="application.loadPage('../widget/loadSubscribeWidget')">
							<span class="add-on"> <i class="icon-white icon-check">
							</i>
						</span> Subscribe
					</a></li>

				</ul>

<!-- 				<ul class="nav">
					<li>
						<form class="form-search" id="searchCriteriaForm"
							name="searchCriteriaForm">
							<input type="text" id="searchTerm"
								class="input-medium search-query">
						</form>
					</li>
				</ul> -->
				<ul class="nav pull-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <i class="icon-white icon-user"></i> <c:out
								value="${userValue.firstName}"></c:out> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/j_spring_security_logout'/>">
									<span class="add-on"> <i
										class="icon-white icon-share-alt"> </i>
								</span> Logout
							</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>


	<div class="container" id="mainBody">

		<div class="row">
			<div id="homeLeftBar" class="span2">
<!-- 				<div>
					<input type="button" value="sendMessageToGadget"
						onclick="callSubscribedGadgetsFromContainer()" />
				</div> -->
				<b>Profile </b> <br> <br> Menus
			</div>

			<div id="appBodyContentBox" class="span7">
				<div class="row">
					<div id="appPageHeading" class="span3"></div>
					<div id="appMessageBar" class="span4">
						<div id="errorDiv" hidden="true" class="alert alert-error">
							<img height="12" width="12" alt=""
								src="../resources/images/error.gif"> <a class="close"
								data-dismiss="alert">×</a> <span id="errormessage"></span>
						</div>
						<div id="successDiv" hidden="true" class="alert alert-success">
							<img height="12" width="12" alt=""
								src="../resources/images/success.gif"> <a class="close"
								data-dismiss="alert">×</a> <span id="successmessage"></span>
						</div>
						<div id="warningDiv" hidden="true" class="alert alert-info">
							<a class="close" data-dismiss="alert">×</a> <span
								id="warningmessage"></span>
						</div>
					</div>

				</div>
				<div class="row" id="appBodyContent">
					<b>Home page content goes here</b> <br> <br> Lorem ipsum
					dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh
					euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut
					wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper
					suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis
					autem vel eum iriure dolor in hendrerit in vulputate velit esse
					molestie consequat, vel illum dolore eu feugiat nulla facilisis at
					vero eros et accumsan et iusto odio dignissim qui blandit praesent
					luptatum zzril delenit augue duis dolore te feugait nulla facilisi.
					Nam liber tempor cum soluta nobis eleifend option congue nihil
					imperdiet doming id quod mazim placerat facer possim assum. Typi
					non habent claritatem insitam; est usus legentis in iis qui facit
					eorum claritatem. Investigationes demonstraverunt lectores legere
					me lius quod ii legunt saepius. Claritas est etiam processus
					dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est
					notare quam littera gothica, quam nunc putamus parum claram,
					anteposuerit litterarum formas humanitatis per seacula quarta
					decima et quinta decima. Eodem modo typi, qui nunc nobis videntur
					parum clari, fiant sollemnes in futurum. <br> <br> Lorem
					ipsum dolor sit amet, consectetuer adipiscing elit, sed diam
					nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
					volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation
					ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
					consequat. Duis autem vel eum iriure dolor in hendrerit in
					vulputate velit esse molestie consequat, vel illum dolore eu
					feugiat nulla facilisis at vero eros et accumsan et iusto odio
					dignissim qui blandit praesent luptatum zzril delenit augue duis
					dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis
					eleifend option congue nihil imperdiet doming id quod mazim
					placerat facer possim assum. Typi non habent claritatem insitam;
					est usus legentis in iis qui facit eorum claritatem.
					Investigationes demonstraverunt lectores legere me lius quod ii
					legunt saepius. Claritas est etiam processus dynamicus, qui
					sequitur mutationem consuetudium lectorum. Mirum est notare quam
					littera gothica, quam nunc putamus parum claram, anteposuerit
					litterarum formas humanitatis per seacula quarta decima et quinta
					decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant
					sollemnes in futurum.
				</div>
			</div>
			<div id="homeRightBar" class="span3"></div>
		</div>
	</div>


	<HR>

	<footer id="footer" class="bar bottom">
		<div class="modal-footer">
			<div class="container">
				<div class="row">
					<div class="span3">
						<h4>Scribbles</h4>
						<ul class="unstyled">
							<li><a href="#">How it works</a></li>
							<li><a href="#">Users</a></li>
							<li><a href="#">Technologies used</a></li>
						</ul>
					</div>

					<div class="span3">
						<h4>Other applications</h4>
						<ul class="unstyled">
							<li><a href="#">Application 1</a></li>
							<li><a href="#">Application 2</a></li>
							<li><a href="#">Application 3</a></li>
						</ul>
					</div>
					<div class="span5">
						<h4>Follow Us</h4>
						<ul class="unstyled">
							<li><a href="#" class="social-icon twitter push-right-half">Twitter</a>
								<a href="#" class="social-icon facebook push-right-half">Facebook</a>
							</li>
						</ul>
						</li>
					</div>
				</div>
			</div>
		</div>
	</footer>
	</div>
	<!-- /container -->


</body>
</html>