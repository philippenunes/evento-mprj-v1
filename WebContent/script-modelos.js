var modelos_1 = new Array("-", "Daten Novo", "Daten antigo", "Positivo Black")
var modelos_2 = new Array("-", "Lenovo T61", "Daten", "Itautec")
var modelos_3 = new Array("-", "OKI B431", "Xerox 3250")
var modelos_4 = new Array("-", "Positivo", "AOC", "Daten")


function muda_modelo() {

	var tipo
	tipo = document.f1.tipo[document.f1.tipo.selectedIndex].value

	if (tipo != 0) {
		meus_modelos = eval("modelos_" + tipo)
		num_modelos = meus_modelos.length
		document.f1.modelo.length = num_modelos

		for (i = 0; i < num_modelos; i++) {
			document.f1.modelo.options[i].value = meus_modelos[i]
			document.f1.modelo.options[i].text = meus_modelos[i]
		}
	} else {
		document.f1.modelo.length = 1
		document.f1.modelo.options[0].value = "-"
		document.f1.modelo.options[0].text = "-"
	}
	document.f1.modelo.options[0].selected = true
}