function media() {
    var tn1 = document.querySelector("#tn1")
    var tn2 = document.querySelector("#tn2")
    var tn3 = document.querySelector("#tn3")
    var tn3 = document.querySelector("#tn4")
    var resp = document.querySelector("#resp")
    var aluno = document.querySelector("#aluno")


    var n1 = Number(tn1.value)
    var n2 = Number(tn2.value)
    var n3 = Number(tn3.value)
    var n4 = Number(tn4.value)

    var media = (n1 + n2 + n3 + n4) / 4
    var mediaf = media.toFixed(1)

    resp.innerHTML = `Média = <strong> ${mediaf} </strong>`

    if (mediaf >= 7) {
        resp.innerHTML += `<p>Parabéns, <strong> ${aluno.value} </strong>! <br> Você está aprovado. </p>`
    } else {
        resp.innerHTML += `<p> <strong>${aluno.value} </strong>, você está reprovado! <br> Esforce-se mais no ano que vem.</p>`
    }

}