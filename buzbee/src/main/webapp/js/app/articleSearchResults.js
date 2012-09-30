$(document).ready(function() {
});

var TOTAL_ARTICLES_IN_SYSTEM = 0; // total number of articles in the system
var MAX_COUNT_PAGES_TO_DISPLAY = 8;
var PAGE_SET_TO_DISPLAY = 1;

function getInitialData()
{
	application.showHeading("Article reslts page");
    if(TOTAL_ARTICLES_IN_SYSTEM > NO_OR_ROWS_PER_PAGE)
    {
    	TOTAL_PAGES_IN_SYSTEM = Math.ceil(TOTAL_ARTICLES_IN_SYSTEM/NO_OR_ROWS_PER_PAGE);
    }
	renderResults(1);
	
	renderPagination();
}
function renderPagination() {
	// Clear pagination bar
	$("#paging").html('');
	
	var lastPageNumber = 0;


	
	// first page number calculation.. 
	firstPageNumber = ((PAGE_SET_TO_DISPLAY-1) * MAX_COUNT_PAGES_TO_DISPLAY) + 1; 
	
	// last page number calculation.. 
	if(TOTAL_PAGES_IN_SYSTEM > (MAX_COUNT_PAGES_TO_DISPLAY * PAGE_SET_TO_DISPLAY)) {
		lastPageNumber = (firstPageNumber + MAX_COUNT_PAGES_TO_DISPLAY) - 1;
	} else {
		lastPageNumber = TOTAL_PAGES_IN_SYSTEM;
	}
	
	console.log('*********************************************************************');
	console.log('PAGE_SET_TO_DISPLAY to be displayeds: ' + PAGE_SET_TO_DISPLAY); 
	console.log('TOTAL_PAGES_IN_SYSTEMs: ' + TOTAL_PAGES_IN_SYSTEM);
	console.log('MAX_COUNT_PAGES_TO_DISPLAYs: ' + MAX_COUNT_PAGES_TO_DISPLAY);
	console.log('-----------------------------------------------------');
	console.log('firstPageNumber: ' + firstPageNumber);
	console.log('lastPageNumber: ' + lastPageNumber);
	console.log('-----------------------------------------------------');
	console.log('*********************************************************************');
	
	// Render Previous Link..
	if(firstPageNumber > MAX_COUNT_PAGES_TO_DISPLAY) {
		$("#paging").append('<li><a href="#" onclick="previousSetOfPages()"><span class="tab">Prev</span></a></li>');
	}
	
	// Render pagination bar..
	renderPaginationBar(firstPageNumber, lastPageNumber);
	
	// Render Next Link..
	if(lastPageNumber < TOTAL_PAGES_IN_SYSTEM) {
		$("#paging").append('<li><a href="#" onclick="nextSetOfPages()"><span class="tab">Next</span></a></li>');
	}
}

function renderPaginationBar(firstPageNumber, lastPageNumber) {
	for (var i = firstPageNumber; i <= lastPageNumber; i++)
	{
		$("#paging").append('<li><a href="#" onclick="renderResults('+i+')"><span class="tab">'+i+'</span></a></li>');
	}
}

function nextSetOfPages() {	
	PAGE_SET_TO_DISPLAY = PAGE_SET_TO_DISPLAY + 1; 
	renderPagination();
}

function previousSetOfPages() {
	PAGE_SET_TO_DISPLAY = PAGE_SET_TO_DISPLAY - 1; 
	renderPagination();
}

function renderResults(pageNumber) {
	$.ajax({
		url : '../article/viewArticles/' + pageNumber,
		type : 'GET',
		datatype : "json",
		success : function(response) {
			$("#contentToc").html('');
			$("#tocView").tmpl(response).appendTo("#contentToc");
		},
		error : function(response, ajaxOptions, thrownError) {
			alert("error in creating table");
		}
	});
}

/*
 * function readDirect(contentId)
 *  { var url ="../reader/"+contentId; window.open(url, '_blank'); } function
 * getContent(num) {
 * 
 * CurrenPagenum = num;
 * 
 * 
 * 
 * $.ajax({
 * 
 * url: '../content/count',
 * 
 * type: 'GET',
 * 
 * datatype: "json",
 * 
 * success: function (response) {
 * 
 * contentCount=response;
 * 
 * 
 * 
 * $.ajax({
 * 
 * url: '../content/viewContents/'+num,
 * 
 * type: 'GET',
 * 
 * datatype: "json",
 * 
 * success: function (response) {
 * 
 * createTable(response);
 *  },
 * 
 * error: function(response, ajaxOptions, thrownError) {
 * 
 * alert("error in creating table");
 *  }
 * 
 * });
 *  },
 * 
 * error: function(response, ajaxOptions, thrownError) {
 * 
 * alert("error in creating table");
 *  }
 * 
 * });
 * 
 * 
 *  }
 */