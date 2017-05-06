function deleteToy(){
	var row = this.parentElement.parentElement;
	var rowId = $(row).attr('id').split("_")[1];
	$.ajax({
		 type: "DELETE",
	     url: "admin/toys/" + rowId,
	     success: function(response){
    		 $(row).remove();
	     },
	     error: function(e){
 	        alert('Error: ' + e);
 	     }
	 });
}

function updateToy(){
	var row = this.parentElement.parentElement;
	var id = $(row).attr('id').split("_")[1];
	var name = $(row).find(".toyName").text();
	var count = $(row).find(".toyCount").text();
	var description = $(row).find(".toyDescription").text();
	var price = $(row).find(".toyPrice").text();
	$.ajax({
		 type: "PUT",
	     url: "admin/toys/"+id,
	     contentType: 'application/json',
	     data: JSON.stringify({
	    	 name: name,
	    	 price: price,
	    	 count: count,
	    	 description: description,
	     }),success: function(response){
    		 alert("Update was succesful!")
	     },
	     error: function(e){
	        alert('Error: ' + e);
	     }
	 });
}

$(document).ready(function() {
	$('#add-form').click(function() {
		$('#addDiv').css('visibility', 'visible');
	});
	
	
	$('#cancelButton').click(function() {
		$('#addDiv').css('visibility', 'hidden');
		$('.input').val('');
		validator.resetForm();
	});
	
	jQuery.validator.addMethod("lettersonly", function(value, element) {
		  return this.optional(element) || /^[a-z]+$/i.test(value);
		}, "Letters only please"); 
	
	 var validator = $("#addForm1").validate({
	        rules: {
	        	name: {
	        		required: true,
	        		lettersonly: true
	        	},
	        	price: {
	        		required: true,
	        		number: true,
	        		min: 0
	        	},
	            count: {
	                required: true,
	                number: true,
	                min: 0
	            },
	            description: {
	                required: false,
	                maxlength: 200,
	                lettersonly: true
	            },
	        },
	        messages: {
	        	name: {
	        		required: "Please enter the toy name",
	        		lettersonly: "The name must be a text"
	        	},
	            price: {
	            	required: "Please enter the toy price",
	            	number: "The price must be a number",
	            	min: "The price must be greater than 0"
	            },
	            count: {
	            	required: "Please enter the toy quantity",
	            	number: "The quantity must be a number",
	            	min: "The quantity must be greater than 0"
	            },
	            description: {
	            	required: "Please enter the toy description",
	            	maxlength: "The description must have maximum 200 characters",
	            	lettersonly: "The description must be a text"
	            },
	        },
	        
	    });
	
	$('#addButton').click(function(){
	 var isValid = $("#addForm1").valid();
	 if(isValid) {
	   	 var name = $('#iname').val();
		 var price = $('#iprice').val();
		 var count = $('#icount').val();
		 var description = $('#idescription').val();
		 var category = $('#icategory option:selected').attr('value');
		 $.ajax({
			 type: "POST",
		     url: "admin/toys",
		     contentType: 'application/json',
		     data: JSON.stringify({
		    	 name: name,
		    	 price: price,
		    	 count: count,
		    	 description: description,
		    	 category: category
		     }),
		     success: function(response){
	    		 var rowString = "";
	    		 rowString += "<tr id='toy_" + response.result.id + "'> <td contenteditable='true' class='toyName'>" + response.result.name + "</td>";
	    		 rowString += "<td contenteditable='true' class='toyPrice'>" + response.result.price + "</td>";
	    		 rowString += "<td contenteditable='true' class='toyCount'>" + response.result.count + "</td>";
	    		 rowString += "<td contenteditable='true' class='toyDescription'>" + (response.result.description ? response.result.description : "No description") + "</td>";
	    		 rowString += "<td class='toyCategory'>" + response.result.category.name + "</td>";
	    		 rowString += "<td class='update'> <input type='button' value='Update toy'/> </td>";
	    		 rowString += "<td class='delete'> <input type='button' value='Delete toy'/> </td> </tr>";
	    		 $('#toys tr:last').after(rowString);
	    		 $('#toy_'+ response.result.id +' .delete input').click(deleteToy);
	    		 $('#toy_'+ response.result.id +' .update input').click(updateToy);
	    		 $('#addDiv').css('visibility', 'hidden');
	    		 $('.input').val('');
		     },
		     error: function(e){
	 	        alert('Error: ' + e);
	 	     }
		 });
	 }
	});
	
	
	$('.update input').click(updateToy);
	
	$('.delete input').click(deleteToy);
});