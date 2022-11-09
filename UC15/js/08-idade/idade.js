function verificar() {
    var data = new Date()
    var anoatual = data.getFullYear()
    var anodig = document.querySelector("#tano")
    var res = document.querySelector("#resp")

    if (anodig.value == 0 || Number(anodig.value)> anoatual) {
        alert('Erro! Verifique os dados e tente novamente!')
    }
}