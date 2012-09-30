
$("#appBodyContent").ajaxStart(function() {
	//alert('hi..');
	$("#loadingIcon").show();
	$("#messageBar").text('');
	$("#successIcon").hide();
	$("#errorIcon").hide();
});
$("#appBodyContent").ajaxSuccess(function(event, xhr, settings) {
	$("#loadingIcon").hide();
});

$('#searchCriteriaForm').submit(function() {
	$.ajax({
		type : 'GET',
		url : "../open/createUser.json",
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

/*
 * $("#appMessageBar").ajaxError(function(event,xhr,settings) {
 * $("#loadingIcon").hide(); $("#errorIcon").show();
 * alert('xhr.response'+xhr.responseText); });
 */
