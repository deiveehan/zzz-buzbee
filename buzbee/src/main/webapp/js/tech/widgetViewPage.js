$(document).ready(function() {
	var lastsel2;
	$("#viewWidgetTable").jqGrid({
		url : '../widget/viewWidgets',
		datatype : "json",
		colNames : [ 'ID', 'Widget Title', 'Author', 'Screenshot' ],
		colModel : [ {
			name : 'id',
			index : 'id',
			editable : false,
			editoptions : {	
				readonly : true,
				size : 10
			},
			hidden : true
		}, {
			name : 'title',
			index : 'title'
		}, {
			name : 'createdby',
			index : 'appUser.firstName'
		}, {
			name : 'screenshotUrl',
			index : 'screenshotUrl'
		} ],
		pager : '#pager',
		rowNum : 10,
		rowList : [ 10, 20, 30 ],
		sortname : 'id',
		height : 'auto',
		sortorder : 'desc',
		viewrecords : true,
		emptyrecords : 'No Records found',
		gridview : true,
		jsonReader : {
			repeatitems : false
		},
		onSelectRow : function(id) {
			/*if (id && id !== lastsel2) {
				jQuery('#viewWidgetTable').restoreRow(lastsel2);
				jQuery('#viewWidgetTable').editRow(id, true);
				lastsel2 = id;
			}*/
		}/*,
		caption : 'Widget caption'*/
	});

	$("#viewWidgetTable").jqGrid('navGrid', '#pager', {
		edit : false,
		add : true,
		del : true,
		search : false
	}, {}, {}, {
		url : 'widget/delete'
	});

});