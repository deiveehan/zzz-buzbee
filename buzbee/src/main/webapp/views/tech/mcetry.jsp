<!DOCTYPE html>
<%@ include file="tagincludes.jsp"%>
<%@ include file="resourceincludes.jsp"%>
<%@ include file="scriptincludes.jsp"%>


<html>
<head>
<!-- <script type="text/javascript"
	src="../js/jquery/jqueryui/jquery-ui-1.8.20.custom.min.js"></script> -->
<script type="text/javascript" src="../js/app/articlePage.js"
	defer="defer"></script>
<script type="text/javascript"
	src="../js/tinymce/jscripts/tiny_mce/tiny_mce.js"></script>
<!-- <script type="text/javascript" src="../js/tinymce/jscripts/tiny_mce/basic_config.js"></script> -->	
<script>
	$(document).ready(function() {
		tinyMCE.init({
			mode : "textareas",
			theme : "simple" //(n.b. no trailing comma, this will be critical as you experiment later)
		});
		 
	});
</script>
</head>
<body>
	<form>
		<textarea name="content" cols="50" rows="15"> 
        hehehehehehe This is some content that will be editable with TinyMCE.
        </textarea>
	</form>
</body>
</html>