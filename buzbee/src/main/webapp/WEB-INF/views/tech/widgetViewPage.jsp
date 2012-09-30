<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>CRUD</title>
<%@ include file="../tech/tagincludes.jsp"%>
<link rel="stylesheet" href="../resources/css/jqgrid/ui.jqgrid.css">
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12" id="widgetView">
				<table id="viewWidgetTable">
				</table>
				<div id="pager"></div>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="../js/tech/widgetViewPage.js"></script>
	<script type="text/javascript">
		application.showHeading("View Widgets");
	</script>
</body>

</html>