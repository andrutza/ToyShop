$(document).ready(function() {
	function disableSelling(isDisabled) {
		$('#sell-toys').attr('disabled', isDisabled);
		$('#cancel').attr('disabled', isDisabled);
		$('#calculate-total').attr('disabled', !isDisabled);
		$('.sell-quantity').find(":first").attr('disabled', !isDisabled);
	}
	
	$('#get-toys').click(function() {
		var categoryId = $('#categories option:selected').attr('value');
		$.ajax({
			url: "seller/"+categoryId,
			type: "GET",			
			dataType: "json",
    	     success: function(response){
				var toyList = response.list;
				var htmlBody = "";
				$.each(toyList, function(index, toy){
					htmlBody += '<tr id="toy_' + toy.id + '">';
					htmlBody += '<td class="toyName">' + toy.name + '</td>';
					htmlBody += '<td class="toyPrice">' + toy.price + ' RON</td>';
					htmlBody += '<td class="toyCount">' + toy.count + '</td>'
					htmlBody += '<td class="toyDecription">' + (toy.description ? toy.description : "No description") + '</td>'
					htmlBody += '<td class="sell-quantity"><input type="text" value="0"></input></td>'
					htmlBody += '</tr>';
				});
				$('#toys-body').html(htmlBody);
    	     },
    	     error: function(e){
    	        alert('Error: ' + e);
    	     }
		});
	});
	
	$('#calculate-total').click(function() {
		var sum = 0;
		var rows = $('#toys-body tr');
		$.each(rows, function(index, row){
			sum += parseInt($(row).find(".toyPrice").text()) * parseInt(row.lastChild.firstChild.value);
		});
		$('#total-price').text(sum);
		disableSelling(false);
	});
	
	$('#cancel').click(function() {
		$('#total-price').text(0);
		disableSelling(true);
	});
	
	$('#sell-toys').click(function() {
		var rows = $('#toys-body tr').filter(function(){
			return this.lastChild.firstChild.value != "0";
		});
		var toyList = $.map(rows, function(element, index) {
			return {id: element.id.split("_")[1], count: element.lastChild.firstChild.value};
		});
		$.ajax({
			url: "seller/toys/",
			type: "POST",
			contentType: 'application/json',
			data: JSON.stringify({list: toyList}),
        	success: function(response){
				$.each(rows, function(index, row) {
					var countColumn = $(row).find('.toyCount');
					var oldQuantity = parseInt(countColumn.text());
					countColumn.text(oldQuantity - toyList[index].count);
				});
    	     },
    	     error: function(e){
    	        alert('Error: ' + e);
    	     }
		});
		$('#total-price').text(0);
		$('.sell-quantity :first-child').val('0');
		disableSelling(true);
	});
	
});