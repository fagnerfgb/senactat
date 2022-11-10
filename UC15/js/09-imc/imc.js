function calcular() {
	var peso = document.querySelector("#peso")
	var altura = document.querySelector("#altura")
	var res = document.querySelector("#resp")
	if (peso.value == 0) {
		alert('Erro! Insira o peso!')
		document.querySelector("#peso").focus();
	} else if (altura.value == 0) {
		alert('Erro! Insira a altura!')
		document.querySelector("#altura").focus();
	} else {
		var imc = Number(peso.value) / (Number(altura.value) * Number(altura.value))
		res.innerHTML = `IMC = ${imc}`
		if (imc < 17) {
			res.innerHTML += `<p><img src="img/imc1.png"></p>`
		} else if (imc >= 17 && imc < 18.5) {
			res.innerHTML += `<p><img src="img/imc2.png"></p>`
		} else if (imc >= 18.5 && imc < 25) {
			res.innerHTML += `<p><img src="img/imc3.png"></p>`
		} else if (imc >= 25 && imc < 30) {
			res.innerHTML += `<p><img src="img/imc4.png"></p>`
		} else if (imc >= 30 && imc < 35) {
			res.innerHTML += `<p><img src="img/imc5.png"></p>`
		} else if (imc >= 35 && imc < 40) {
			res.innerHTML += `<p><img src="img/imc6.png"></p>`
		} else {
			res.innerHTML += `<p><img src="img/imc7.png"></p>`
		}
	}
}

function limpar() {
	document.querySelector("#peso").value = ''
	document.querySelector("#altura").value = ''
	const div = document.querySelector("#resp")
	div.innerHTML = ""
	div.innerHTML = `<p>Preencha os dados acima para ver o resultado!</p> <p><img src="img/imc.png"></p>`


	
	document.querySelector("#peso").focus()
}