//valida o nome
function validarNome() {
	var campo = document.getElementById('formulario:nome');
	if (campo.value.length == 0) {
		alert('O campo nome deve ser preenchido.');
		campo.focus();
		return false;
	}
	return true;
}
// ---------------------aceita somente numero validando pelo numero decimal
function SomenteNumero(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58))
		return true;
	else {
		if (tecla == 8 || tecla == 0)
			return true;
		else
			return false;
	}
}
// -------- aceita somete letras validando pelo o codigo decimal na tabela
function SomenteLetras(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 64 && tecla < 89) || (tecla > 96 && tecla < 123)
			|| (tecla > 31 && tecla < 33))
		return true;
	else {
		if (tecla != 8)
			return false; // 8 decimal na tabela ascii e o backspace

		else
			return true;
	}
}
