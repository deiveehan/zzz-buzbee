function Application() {
	this.hostName = "localhost", 
	this.hostPort = "8080",
	this.loadPage = function(urlValue) {
		this.clearMessage();
		$
				.ajax({
					url : urlValue,
					success : function(data) {
						$('#appBodyContent').html(data);
					},
					statusCode : {
						404 : function() {
							$("#errormessage").html("Page not found ");
							$("#errorDiv").show();
						},
						403 : function() {
							$("#errormessage").html("Unathorized operation performed");
							$("#errorDiv").show();
						}
					}
				});
	};
	/*
	 * this.newWindow = function(urlValue) { $.ajax({ url : urlValue, success :
	 * function(data) { $('#appBodyContent').html(data); }, statusCode : { 404 :
	 * function() { this.showErrorMessage('page not found'); } } }); };
	 */
	this.openArticle = function(urlValue) {
		this.clearMessage();
		$
				.ajax({
					url : urlValue,
					success : function(data) {
						$('#appArticleContent').html(data);
					},
					statusCode : {
						404 : function() {
							$("#errormessage").html("Page not found ");
							$("#errorDiv").show();
						},
						403 : function() {
							$("#errormessage").html("Unathorized operation performed");
							$("#errorDiv").show();
						}
					}
				});
	};
	this.showSuccessMessage = function(message) {
		this.clearMessage();
		$('#successmessage').html(message);
		$("#successDiv").show();
	};
	this.showErrorMessage = function(message) {
		$("#errormessage").html(message);
		$("#errorDiv").show();
	};
	this.showHeading = function(heading) {
		$('#appPageHeading').html("<h4>" + heading + "</h4>");
	};
	this.clearMessage = function() {
		$("#successDiv").hide();
		$("#errorDiv").hide();
		$("#warningDiv").hide();
	}
}