$(document).ready(function() {
	$('#bootstrap-table').bdt();
});

$(document).ready(function() {
	$("#myBtn").click(function() {
		$("#myModal").modal();
	});
});

$(document).ready(function() {
	$('#delete-modal').on('show.bs.modal', function(e) {
		var $modal = $(this),
		id = e.relatedTarget.id;

		$(this).find("#deletar").attr("href", "remove?id=" + id);

	});
});

$(document).ready(function() {
	$('#insere-tema').on('show.bs.modal', function(e) {
		var $modal = $(this),
		id = e.relatedTarget.id;

		$(this).find("#trabalhoId").attr("value", id);

	});
})

$(document).ready(function() {
	$("#adicionarTema").click(function(){
		$("#novoTema").modal();
	});
});

$(document).ready(function() {
	$("#adicionarPerfil").click(function(){
		$("#novoPerfil").modal();
	});
});