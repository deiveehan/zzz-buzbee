<!DOCTYPE html>
<%@ include file="../tech/tagincludes.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Scribbles</title>
<script type="text/javascript" src="../js/jquery/jquery.tmpl-min.js"></script>
<script type="text/javascript">
	function subscribeWidget(widgetID) {
    	$.ajax({
            url: '../widget/subscribeWidget/' + widgetID,
            type: 'GET',
            datatype: "json", 
            success: function (response) {
            	application.showSuccessMessage(response.message);
            },
            error:	 function(response) {
            	application.showErrorMessage(response.message);
     		 }
        });
	}
	function unsubscribeWidget(widgetID) {
    	$.ajax({
            url: '../widget/unsubscribeWidget/' + widgetID,
            type: 'GET',
            datatype: "json", 
            success: function (response) {
            	application.showSuccessMessage(response.message);
            },
            error:	 function(response) {
            	application.showErrorMessage(response.message);
     		 }
        });
	}
</script>

<script id="subScribeWidget" type ="text/x-jquery-tmpl">
		
		     <li class="span3">  
				          <div class="thumbnail">  
				            <img src="\${screenshotUrl}" width="160" height="200" title="\${description}" alt="\${title}">  </img>
				            <div class="caption">  
				              <h4>\${title}</h4>
								<p><h5>\${author}</h5></p>  
				              <p><a href="#" onclick="javascript:subscribeWidget('\${id}')"  class="btn btn-success">Subscribe</a> <a href="#" onclick="javascript:unsubscribeWidget('\${id}')" class="btn btn-warning">Unsubscribe</a></p>  
				            </div>  
				          </div>  
			</li> 
			
		</script>
</head>
<body onLoad="loadWidgets()";>
	<div class="container-fluid">
		<div class="row-fluid">
				<div id="subscriptionDiv" class="span12">
				<ul class="thumbnails" id="widgetList">  
				         
				         
				</ul>  
				</div>
		</div>
	</div>

	<script type="text/javascript">
		application.showHeading("Widget Subscription");
		loadWidgets();
		
		function loadWidgets() {
	    	$.ajax({
	            url: '../widget/getAllWidgets.json',
	            type: 'GET',
	            datatype: "json", 
	            success: function (response) {
	            	successWidget(response);
	            },
	            error:	 function(response) {
	            	failureWidget(response);
	     		 }
	        });
		}
		function successWidget(data) {
			$("#widgetList").html('');
			$("#subScribeWidget").tmpl(data).appendTo("#widgetList");
			var data = $("#widgetList").html();
		}
		function failureWidget(response) {
        	application.showErrorMessage(response.message);
		}
	</script>

</body>
</html>