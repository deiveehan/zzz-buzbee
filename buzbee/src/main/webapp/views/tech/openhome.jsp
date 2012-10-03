<!DOCTYPE html>
<%@ include file="tagincludes.jsp"%>
<%@ include file="resourceincludes.jsp"%>
<%@ include file="scriptincludes.jsp"%>

<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Scribbles</title>
<script type="text/javascript" src="../js/tech/signup.js"></script>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" id="readerHeader" href="#"><img
					src="../resources/images/ereaderlogo.png" width="35" height="35"
					longdesc="asdf">&nbsp;&nbsp;&nbsp;&nbsp;Scribbles</a>
				<div class="nav-collapse">
					<ul class="nav pull-right">

						<li><a href="#about">How It Works</a></li>
						<li><a href="#contact"> <span class="add-on"> <i
									class="icon-white icon-envelope"> </i>
							</span> Contact Us
						</a></li>
					</ul>

				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">

			<div class="span8">
				<p>
				<h3>Scribbles</h3>
				Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam
				nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
				volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation
				ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
				consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate
				velit esse molestie consequat, vel illum dolore eu feugiat nulla
				facilisis at vero eros et accumsan et iusto odio dignissim qui
				blandit praesent luptatum zzril delenit augue duis dolore te feugait
				nulla facilisi. Nam liber tempor cum soluta nobis eleifend option
				congue nihil imperdiet doming id quod mazim placerat facer possim
				assum. Typi non habent claritatem insitam; est usus legentis in iis
				qui facit eorum claritatem. Investigationes demonstraverunt lectores
				legere me lius quod ii legunt saepius. Claritas est etiam processus
				dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est
				notare quam littera gothica, quam nunc putamus parum claram,
				anteposuerit litterarum formas humanitatis per seacula quarta decima
				et quinta decima. Eodem modo typi, qui nunc nobis videntur parum
				clari, fiant sollemnes in futurum.
			</div>
			<div class="span4">
				<p>
				<h4>Login</h4>
				<form class="well" name="loginForm" id="loginForm"
					action="<c:url value='../j_spring_security_check'></c:url>"
					method="POST">

					<input type="text" class="span3" placeholder="User id(Email)"
						name="j_username" value="deivee@scr.com"> <input
						type="password" class="span3" placeholder="Password"
						name="j_password" value="deivee">
					<!-- <label	class="checkbox"> <input type="checkbox"> Rememberme </label> -->
					<input type="submit" value="Sign in" class="btn btn-primary "></input>
					<input type="reset" value="Reset" class="btn">
				</form>
			</div>
		</div>
		<div class="row">
			<p>
		</div>

		<div class="row">
			<div class="span8">
				<p>
				<h3>How it works</h3>


				Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam
				nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
				volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation
				ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
				consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate
				velit esse molestie consequat, vel illum dolore eu feugiat nulla
				facilisis at vero eros et accumsan et iusto odio dignissim qui
				blandit praesent luptatum zzril delenit augue duis dolore te feugait
				nulla facilisi. Nam liber tempor cum soluta nobis eleifend option
				congue nihil imperdiet doming id quod mazim placerat facer possim
				assum. Typi non habent claritatem insitam; est usus legentis in iis
				qui facit eorum claritatem. Investigationes demonstraverunt lectores
				legere me lius quod ii legunt saepius. Claritas est etiam processus
				dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est
				notare quam littera gothica, quam nunc putamus parum claram,
				anteposuerit litterarum formas humanitatis per seacula quarta decima
				et quinta decima. Eodem modo typi, qui nunc nobis videntur parum
				clari, fiant sollemnes in futurum.

			</div>
			<div class="span4">
				<h4>Signup</h4>

				<sf:form id="signupForm" modelAttribute="appUser">
					<sf:input id="firstName" class="span3" required="true"
						placeholder="First Name" path="firstName" />
					<sf:input id="lastName" class="span3" required="true"
						placeholder="Last Name" path="lastName" />
					<sf:input type="email" id="userId" class="span3" required="true"
						placeholder="User id(Email)" path="userId" />
					<sf:password id="password" class="span3" required="true"
						path="password" placeholder="Password" />
					<br>
					<button type="submit" id="butSignup" class="btn btn-primary ">Signup</button>
					<button type="reset" id="resetButton" class="btn">Reset</button>
				</sf:form>
			</div>
		</div>
		<HR>

		<footer id="footer" class="bar bottom">
			<div class="modal-footer">
				<div class="container">
					<div class="row">
						<div class="span3">
							<h4>E-Reader</h4>
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

	<script type="text/javascript">
		$('#signupForm').submit(function() {
			$.ajax({
				type : 'POST',
				url : "../open/createUser.json",
				data : $("#signupForm").serialize(),
				datatype : "json",
				success : function(response) {
					alert(response.message);
					return false;
				},
				error : function(response) {
					alert(response.message);
					return false;
				}
			});
		});
	</script>
</body>
</html>