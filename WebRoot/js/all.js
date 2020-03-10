	 function selectAll() {   
        if ($("#all").is(":checked")) {
           	$('input[name=checkbox]').prop("checked", true);
			$("#tablelinkdelete1").attr("disabled", false).css("background-color","#3d96c9"); 
        } else{
           	$('input[name=checkbox]').prop("checked", false);
			$("#tablelinkdelete1").attr("disabled", true).css("background-color","#c9cdcf");
        }
     }
	 
	 
