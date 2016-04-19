$(document).ready(function(){
	$('.datepicker').datepicker({
		format: "dd/mm/yyyy",
        language: "pt-BR"
    });
});

$(document).ready(function() {
    $('.table').DataTable();
} );

$(document).ready(function($){   
    $('.cpf').mask("999.999.999-99");
});