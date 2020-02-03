	 function selectAll() {   
        if ($("#all").is(":checked")) {
           	$('input[name=checkbox]').prop("checked", true);
        } else{
           	$('input[name=checkbox]').prop("checked", false);
        }
     }
	 
