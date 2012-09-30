		$("#publishedDate").datepicker({
			maxDate : "+0M +0D"
	});
	
	$("#contentForm").validator().submit(function f(event){
	//$("#basicForm").submit(function f(event){
		 application.clearMessage(); 
		 if (!event.isDefaultPrevented()) {
			 $.ajax({ 
				 type: 'POST', 
				 url: "../content/save.json", 
				 data: $("#contentForm").serialize(), 
				 datatype: "json", 
				 success: function (response) {
					 application.showSuccessMessage(response.message);
				 }, 
				 error:	 function(response, ajaxOptions, thrownError) {
					 //$('#appBodyContent').html(application.showErrorMessage(response.message));
					 application.showErrorMessage(response.message);
				 }
			});
			 event.preventDefault();
		 }
		 else {
			 event.preventDefault();
			 application.clearMessage();
			 application.showErrorMessage("Please correct the below form errors"); 
		 }
	});