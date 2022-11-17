function verificar() {
	var data = new Date()
	var anoatual = data.getFullYear()
	var anodig = document.querySelector("#tano")
	var res = document.querySelector("#resp")

	if (anodig.value == 0 || Number(anodig.value) > anoatual) {
		alert('Erro! Verifique os dados e tente novamente!')
		//document.querySelector("#tano").focus()
	}
	else {
		var fsexo = document.getElementsByName('sexo')
		var idade = anoatual - Number(anodig.value)
		var genero = ""

		var img = document.createElement('img')
		img.setAttribute('id', 'foto')
	}
	if (fsexo[0].checked) {
		genero = 'Homem'
		if (idade >= 0 && idade < 10) {
			img.setAttribute('src', 'img/menino.png')
		} else if (idade >= 10 && idade < 21) {
			img.setAttribute('src', 'img/jovem_m.png')
		} else if (idade >= 21 && idade < 50) {
			img.setAttribute('src', 'img/adulto.png')
		} else {
			img.setAttribute('src', 'img/idoso.png')
		}
	} else {
		genero = 'Mulher'
		if (idade >= 0 && idade < 10) {
			img.setAttribute('src', 'img/menina.png')
		} else if (idade >= 10 && idade < 21) {
			img.setAttribute('src', 'img/jovem_f.png')
		} else if (idade >= 21 && idade < 50) {
			img.setAttribute('src', 'img/adulta.png')
		} else {
			img.setAttribute('src', 'img/idosa.png')
		}
	}
	//res.innerHTML = `Sua idade é ${idade}`
	res.innerHTML = `<p>É um(a) ${genero} com ${idade} anos.</p>`
	res.appendChild(img)
}


	function limpar() {
		document.querySelector("#tano").value = ''
		var limpaSexo = document.querySelectorAll('input[name="sexo"]:checked')
		for (var i = 0; i < limpaSexo.length; i++) {
			limpaSexo[i].checked = false
		}
		const div = document.querySelector("#resp")
		div.innerHTML = ""
		div.innerHTML = `<p>Preencha os dados acima para ver o resultado!</p>`
		document.querySelector("#tano").focus()
	}
