$(document).ready(function(){
	$('.datepicker').datepicker({
		format: "dd/mm/yyyy",
        language: "pt-BR"
    });
	
	$('.form-control').mask("999.999.999-99");
});
