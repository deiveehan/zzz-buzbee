app.Router = Backbone.Router.extend({
	routes: {
		"" : "home", 
		"contact" : "getContact", 
		"about": "aboutProject"
	}, 
	initialize : function() {
        this.headerView = new HeaderView();
        $('.header').html(this.headerView.render().el);
	}, 
	home: function() {
		alert("home clicked");
	}, 
	getContact: function() {
		alert("getContact clicked");
	}, 
	aboutProject: function() {
		alert("aboutProject clicked");
	}
})