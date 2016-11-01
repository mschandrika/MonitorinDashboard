/**
 * 
 */

$( document ).ready(function() {
	var doSearch = function() {
		var e = document.getElementById("searchCriteria");
		var searchCriteria = e.options[e.selectedIndex].value;
		var searchTerm = document.getElementById("searchTerm").value;
		var data = {
					"searchCriteria":searchCriteria, 
					"searchTerm":searchTerm
		};
		$.ajax({
			url: "/IntuitMonitoringDashboard/pageLoadData",
			cache: false,
			dataType: "json",
			data: data,
			success: function(data) {
				$.get('templates/dataBox.mst', function(template) {
					var newElementBox = Mustache.render(template, data);
					$("#searchResults").html(newElementBox);
				});
			}
		});
	};
	document.getElementById("searchButton").addEventListener('click', doSearch);
});
$(document).ready(
		function() {
			document.getElementById("searchButton").addEventListener('click',
					doSearch);
		});