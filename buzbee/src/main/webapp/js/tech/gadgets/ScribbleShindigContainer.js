/* -------------- Defining Scribbles container  -------------- */
shindig.ScribblesContainer = function() {
	shindig.IfrContainer.call(this);
	this.view_ = "profile";
};
shindig.ScribblesContainer.inherits(shindig.IfrContainer);
shindig.container = new shindig.ScribblesContainer();

/* -------------- Defining Scribbles Gadget -------------- */
shindig.ScribblesGadget = function(object) {
	shindig.BaseIfrGadget.call(this, object);
	this.setServerBase("http://"+application.hostName+":"+application.hostPort+"/gadgets" + "/");
};
shindig.ScribblesGadget.inherits(shindig.BaseIfrGadget);
shindig.IfrContainer.prototype.gadgetClass = shindig.ScribblesGadget;

// ---------------------- Rendering Profile mode --------------------
shindig.IfrContainer.prototype.renderGadget = function(currentGadget, viewMode, cobj, aobj) {
	if (viewMode == "canvas") {
		 gadgetTimer.startTimer("canvas", "canvas", currentGadget.id);
		 currentGadget.renderCanvas(cobj, currentGadget);
		 
	} else {
		var gadgetChrome = this.layoutManager.getGadgetChrome(currentGadget);
		currentGadget.render(gadgetChrome);
	}
};

shindig.FloatLeftLayoutManager.prototype.getGadgetChrome = function(gadget) {
	var parentGadgetChrome = jQuery("#" + this.layoutRootId_);

	if (parentGadgetChrome) {
		var gadgetChrome = document.createElement("div");
		gadgetChrome.id = "scribbleChrome_" + gadget.scribbleID;
		gadgetChrome.className = "shindig-gadget-chrome";

		parentGadgetChrome.append(gadgetChrome);
		return gadgetChrome;
	} else {
		return null;
	}
};

// Override this method if you want to provide a custom behaviour)
shindig.IfrGadget.getMainContent = function(createDivForMainContent) {
	var gadgetIframeId = this.getIframeId();
	console.log("this.cssClassGadgetContent: " + this.cssClassGadgetContent);
	console.log("this.cssClassGadget:"  + this.cssClassGadget);

	// Setting relay url, passing gadgetframe id, server info and rpc relay
	gadgets.rpc.setRelayUrl(gadgetIframeId, this.serverBase_ + this.rpcRelay);
	
	// setting auth token
	gadgets.rpc.setAuthToken(gadgetIframeId, this.rpcToken);
	var divForMainContent = '<div id="' + "mainContent" + gadgetIframeId + '"class="'
	+ this.cssClassGadgetContent + '"><iframe id="' + gadgetIframeId
	+ '" name="' + gadgetIframeId + '" class="' + this.cssClassGadget
	+ '" src="' + this.getIframeUrl()
	+ '" frameborder="no" scrolling="no"'
	+ (this.height ? ' height="' + this.height + '"' : '')
	+ (this.width ? ' width="' + this.width + '"' : '')
	+ '></iframe></div>';
	
	createDivForMainContent(divForMainContent);
};

shindig.ScribblesGadget.prototype.getTitleBarContent = function(gadget) {
	var shindigGadgetId = this.id;
	var toggleimgSrc = "http://"+application.hostName+":"+application.hostPort+"/resources/images/restore.png";
	var toggleimageTitle = "Open this widget in maximized mode";
	var titleBarHTML = "";
	var titleBarDivID = this.cssClassTitleBar + "-" + +shindigGadgetId;
	titleBarHTML += "<div class='titleBarProfileMode visibleWidget  sgfOpen' id=" + titleBarDivID + ">";
	titleBarHTML += "<img border='none' title='"+ this.title+"' class='titleBarIcon' src='"+ this.iconUrl+"'/>";
	titleBarHTML += "<h3 class='scribblegadgetheader truncateTitle' id='GadgetName'" + shindigGadgetId;
	titleBarHTML += "title='Move Application'>"+this.title+"</h3><div align='right' class='Controls' id='Controls'"
			+ shindigGadgetId;
	titleBarHTML += "style='display: ;'>";
	// Define all the menu items here 
	titleBarHTML += "<ul class='menu'>"; 
	// Open canvas view icon
	titleBarHTML +='<li> <a href="#" onclick="shindig.container.getGadget('+this.id+').openCanvasView();"><img style="border: 0px;" width="18" height="18" src="http://png-5.findicons.com/files//icons/1722/gnome_2_18_icon_theme/32/view_fullscreen.png" title="Open the widget in a maximized mode"/></a></li>';
	// Close window icon
	titleBarHTML += '<li><a href="#" onclick="shindig.container.getGadget(' + this.id + ').removeGadget();return false;"><img style="border: 0px;" width="22" height="22" src="http://png-2.findicons.com/files//icons/2162/minimal_perception/64/gtk_close.png" title="Remove this widget and unsubscribe"/></a></li>';
	titleBarHTML += "</div>";
	titleBarHTML += "</div>";
	
	$(titleBarDivID).hover(
			  function () {
			    //$(this).append($("<span> ***</span>"));
				  alert('hi');
			  }/*, 
			  function () {
			    $(this).find("span:last").remove();
			  }*/
			);

	gadget(titleBarHTML);
};

shindig.ScribblesGadget.prototype.removeGadget = function () {
	   
    var cnfrm = confirm("Are you sure that you want to unsubscribe and remove this application?");
    if (cnfrm) {
        jQuery("#" + "scribbleChrome_" + this.scribbleID).remove();
        var g="deletedGadgetId="+this.scribbleID;
        jQuery.ajax({
            url: '../widget/unsubscribeWidget/' + this.scribbleID,
            type: 'GET',
            datatype: "json", 
        	async:true,
        	data:g
        	});
    }
};


// ---------------------- Rendering Canvas mode --------------------
shindig.ScribblesGadget.prototype.renderCanvas = function(a, b) {
	this.getCanvasDataAndRender(a, function(c) {
		jQuery("#canvas").html(c);
	});
};

var canvasUrl = "";
shindig.ScribblesGadget.prototype.getCanvasDataAndRender = function(url, aObj) {
	canvasUrl = url;
	shindig.callAsyncAndJoin([ this.getTitleBarDataForFullScreenMode,
			this.getDataForFullScreenMode ], function(cont) {
		aObj(cont.join(""))
	}, this)
};

shindig.ScribblesGadget.prototype.openCanvasView = function(c) {
	var d = document.createElement("div");
	d.id = "canvas";
	var b;
	currentCanvasHolder = this.scribbleID;
	jQuery("body").prepend('<div id=canvas></div><div class="clear"></div>');
	shindig.container.layoutManager = new shindig.FloatLeftLayoutManager(d.id);
	var a = shindig.container.createGadget({
		specUrl : this.specUrl,
		title : this.title,
		userPrefs : this.userPrefs
	});
	a.scribbleID = this.scribbleID;
	a.iconURL = this.iconUrl;
	shindig.container.addGadget(a);
	a.getIFrameURLAndRenderGadget("canvas", d, c);
	
	
};

shindig.ScribblesGadget.prototype.getIFrameURLAndRenderGadget = function(c, a, b) {
	var d = this.getIframeUrl();
	d = buildIframeURL(d, c, b);
	shindig.container.renderGadget(this, c, d, a, location)
};

shindig.ScribblesGadget.prototype.closeFullScreenmode = function(e) {
	var g = false;
	var h = "SubmitActionUsage";
	var b = "";
	var d = false;
	if (jQuery(e).children()[0] != null
			&& jQuery(e).children()[0].tagName == "IMG") {
		g = true
	}
	if (g) {
		b = "closeCanvas"
	} else {
		b = "openCanvas"
	}
	var c = jQuery("#canvas");
	c.children().remove();
	c.remove();
	
	
	var a;
	var f = this.location;
	if (f != null && f.indexOf("resultsView") != -1) {
		a = "resultsView"
	} else {
		a = this.location
	}
	if (jQuery("#sb-" + this.getUserPrefsDialogId()).css("display") == "block") {
		jQuery("#sb-" + this.getUserPrefsDialogId()).toggle()
	}
	
};

function buildIframeURL(b, a, d) {
	var e = buildURLUsingRegexp("view", b);
	if (e) {
		var b = b.replace("view=" + e, "view=" + a)
	} else {
		b += "&view=" + encodeURIComponent(a)
	}
	if (d) {
		var c = gadgets.json.stringify(d);
		if (c.length > 0) {
			b += "&view-params=" + encodeURIComponent(c)
		}
	}
	return b
}

function buildURLUsingRegexp(c, b) {
	c = c.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var a = "[\\?&]" + c + "=([^&#]*)";
	var e = new RegExp(a);
	var d = e.exec(b);
	if (d == null) {
		return ""
	} else {
		return d[1]
	}
}



shindig.ScribblesGadget.prototype.getTitleBarDataForFullScreenMode = function(a) {
	if (this.includeChrome == false) {
		a("");
		return
	}
	var c;
	if (this.title) {
		c = this.title
	} else {
		c = "canvas Title";
	}
	var b = '<div id="footer' + this.cssClassTitleBar + "-" + this.id
			+ '" class="curveBoxRight visibleWidget" >';
	b += '<img src="' + this.iconURL
			+ '"  border="none" class="titleBarIcon" title="' + this.title
			+ '">';
	b += '<h3 id="GadgetName' + this.id + '" class="scribblegadgetheader">' + c
			+ '</h3><div class="fullScreenToolbarIcons"><ul class="menu">';
	b += '<li> <a href="javascript:void(0);" onclick="shindig.container.getGadget('
			+ this.id
			+ ').closeFullScreenmode(this);"><img id="img_'
			+ this.id
			+ '" style="border: 0px;" width="22" height="22"  src="'
			+ "http://png-1.findicons.com/files//icons/1676/primo/48/windows.png"
			+ '" title="Close this application"/></a></li>';
	b += "</ul>";
	b += "</div>";
	b += '<div class="clear"></div>';
	b += "</div>";
	a(b)
};

shindig.IfrGadget.getDataForFullScreenMode = function(b) {
	var d = this.getIframeId();
	
	var c = '<div id="maincont' + d
			+ '" class="fullScreenModeContainer" style="height:100%"';
	c += (this.height ? ' style="height: ' + this.height + 'px;"' : "")
			+ '><iframe id="' + d
			+ "\" onload=\"gadgetTimer.killTimer('canvas', 'canvas')\" name=\"" + d
			+ '" class="gadgets-gadgetCanvas ' + this.cssClassGadget
			+ '" src="' + canvasUrl
			+ '" frameborder="no" scrolling="auto" width="100%" height="100%"></iframe>';
	c += "</div>";
	b(c);
	gadgets.rpc.setRelayUrl(d, this.serverBase_ + this.rpcRelay);
	gadgets.rpc.setAuthToken(d, this.rpcToken)
};

// ---------------------- Common utility methods --------------------
var gadgetTimer = gadgetTimer || {};
	gadgetTimer.startTimer = function(b, a, c) {
		 if (typeof (timers_) == "undefined" || timers_ == null) { 
			 timers_ = new Array() } timers_[a + b] = setTimeout("gadgetTimer.timeout('" + b + "', '" + a + "', '" + c + "')", 10000) 
	}; 
	
	gadgetTimer.timeout = function(c, b, d) {
		 jQuery("#Close_" + d).css("display", ""); 
		 var a = jQuery("#maincontremote_iframe_" + d); a.css("height", "125px");
		 a.html("Gadget took lot of time to load. ");  
	};
	
	gadgetTimer.killTimer = function(b, a) { clearTimeout(timers_[a + b]);
};

// ------------ Unused methods -----------------------
shindig.ScribblesGadget.prototype.queryIfrGadgetType_ = function() {
	var c = this;
	var b = c.requiresPubSub2 ? shindig.OAAIfrGadget : shindig.IfrGadget;
	for ( var a in b) {
		if (b.hasOwnProperty(a)) {
			this[a] = b[a];
		}
	}
};

// ------------ End of Unused methods ---------
