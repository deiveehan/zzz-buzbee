$(document).ready(function() {
	var lastsel2;
	$("#viewArticleTable").jqGrid({
		url : '../article/viewArticles',
		datatype : "json",
		colNames : [ 'ID', 'Article Title', 'Created By', 'Updated Date', 'Status' ],
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
			name : 'updatedDate',
			index : 'updatedDate'
		}, {
			name : 'status',
			index : 'status'
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
				jQuery('#viewArticleTable').restoreRow(lastsel2);
				jQuery('#viewArticleTable').editRow(id, true);
				lastsel2 = id;
			}*/
		}/*,
		caption : 'Article caption'*/
	});

	$("#viewArticleTable").jqGrid('navGrid', '#pager', {
		edit : false,
		add : true,
		del : true,
		search : false
	}, {}, {}, {
		url : 'article/delete'
	});

});