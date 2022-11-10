function verificar() {
	var data = new Date()
	var anoatual = data.getFullYear()
	var anodig = document.querySelector("#tano")
	var res = document.querySelector("#resp")

	if (anodig.value == 0 || Number(anodig.value) > anoatual) {
		alert('Erro! Verifique os dados e tente novamente!')
		document.querySelector("#tano").focus()
	}
	else {
		/*var sexo = document.querySelector('input[name="sexo"]:checked')
		for (var i = 0; i < sexo.length; i++) {
			if (sexo[i].checked) {
				sexo[i].value
			}
		}*/
		if (!document.querySelector("#masc").checked && !document.querySelector("#fem").checked) {
			alert('Erro! Verifique os dados e tente novamente!')
		} else {
			if (document.querySelector("#masc").checked) {
				var sexo = masc
			}
			var idade = anoatual - Number(anodig.value)
			res.innerHTML = `<p>A sua idade é: ${idade} anos</p>`
			if (idade < 11) {
				if (sexo == masc) {
					res.innerHTML += `<img src=img/menino.png><p>Você é um menino!</p>`
				} else {
					res.innerHTML += `<img src=img/menina.png><p>Você é uma menina!</p>`
				}
			}
			else if (idade >= 11 && idade < 24) {
				if (sexo == masc) {
					res.innerHTML += `<img src=img/jovem_m.png><p>Você é um rapaz!</p>`
				} else {
					res.innerHTML += `<img src=img/jovem_f.png><p>Você é uma moça!</p>`
				}
			}
			else if (idade >= 24 && idade < 64) {
				if (sexo == masc) {
					res.innerHTML += `<img src=img/adulto.png><p>Você é um adulto!</p>`
				} else {
					res.innerHTML += `<img src=img/adulta.png><p>Você é uma adulta!</p>`
				}
			} else {
				if (sexo == masc) {
					res.innerHTML += `<img src=img/idoso.png><p>Você é um senhor de respeito!</p>`
				} else {
					res.innerHTML += `<img src=img/idosa.png><p>Você é uma senhora de respeito!</p>`
				}
			}
		}
	}
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

