function somar() {
    var tn1 = document.querySelector("#tn1")
    var tn2 = document.querySelector("#tn2")
    var resp = document.querySelector("#resp")

    var n1 = Number(tn1.value)
    var n2 = Number(tn2.value)

    var soma = n1 + n2

    resp.innerHTML = `A soma entre <strong> ${n1} </strong> e <strong> ${n2} </strong> é = <strong> ${soma} </strong>`

}