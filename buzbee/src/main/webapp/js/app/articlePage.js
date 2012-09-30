$("#articlePageForm").submit(
		function f(event) {
			if (!event.isDefaultPrevented()) {
				$.ajax({
					type : 'POST',
					url : "../article/savePage.json",
					data : $("#articlePageForm").serialize(),
					datatype : "json",
					success : function(response) {
						if(response.error=="TRUE") {
							application.showErrorMessage(response.message);	
						} else {
							application.showSuccessMessage(response.message);	
						}
					},
					error : function(response) {
						application.showErrorMessage(response.message);
					}
				});
				event.preventDefault();
			} else {
				event.preventDefault();
				// alert("Please correct the below form errors");
			}
		});
