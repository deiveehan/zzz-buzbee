$(document).ready(function() {

	registerServicesForGadgets();
	loadHomeRightGadgets();
	$("#homeRightBar").sortable({
		handle : "h3",
		placeholder: 'ui-state-highlight'
	});
	
});

function loadHomeRightGadgets() {
	$.ajax({
        url: '../widget/getMyWidgets.json',
        type: 'GET',
        datatype: "json", 
        success: function (response) {
        		var gadgetDetails = response;
        		var len = gadgetDetails.length;
        		
        		shindig.container.layoutManager = new shindig.FloatLeftLayoutManager(
				'homeRightBar');

				for ( var i = 0; i < len; i++) {
					var gadget = shindig.container.createGadget({
						specUrl : gadgetDetails[i].widgetURL
					});
					gadget.scribbleID = gadgetDetails[i].id;
					gadget.title = gadgetDetails[i].title;
					gadget.iconUrl = gadgetDetails[i].thumbnailUrl;
					shindig.container.addGadget(gadget);
					shindig.container.renderGadget(gadget);
		
				}
            console.log("response: " + response); 
        	//application.showSuccessMessage(response.message);
        },
        error:	 function(response) {
        	console.log("response: " + response); 
 		 }
    });
}

gadgets.pubsubrouter.init(function(id) {
    var gadgetId = shindig.container.gadgetService.getGadgetIdFromModuleId(id);
    var gadget = shindig.container.getGadget(gadgetId);
    return gadget.specUrl;
  }, {
    onSubscribe: function(sender, channel) {
  //    log(sender + " subscribes to channel '" + channel + "'");
      // return true to reject the request.
      return false;
    },
    onUnsubscribe: function(sender, channel) {
  //    log(sender + " unsubscribes from channel '" + channel + "'");
      // return true to reject the request.
      return false;
    },
    onPublish: function(sender, channel, message) {
   //   log(sender + " publishes '" + message + "' to channel '" + channel + "'");
      // return true to reject the request.
      return false;
    }
  });

function registerServicesForGadgets() {
	gadgets.rpc.register('get_user_pid', getUserPID);
	gadgets.rpc.register('registerForPublishing', registerForPublishing);
	
}

// ------------------------------- Gadget Services methods
// ----------------------
var registryArray=new Array();
function registerForPublishing(){
	registryArray.push(this.f);
	
}

function callSubscribedGadgetsFromContainer(){
	for(var x=0;x<registryArray.length;x++){
		gadgets.rpc.call(registryArray[x], "doSomethingWhenContainerAsks",null,"container has called");
		
	}
	
}
function getUserPID() {
	
	
	return "32oiuwer38212a";
}