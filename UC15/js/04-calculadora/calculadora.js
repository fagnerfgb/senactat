var etanol, gasolina;
function calcular() {
    gasolina = parseFloat(frmFlex.txtGasolina.value.replace(",", "."))
    etanol = parseFloat(frmFlex.txtEtanol.value.replace(",", "."))
    if (etanol < 0.7 * gasolina) {
        alert("Vai de etanol");
        document.getElementById("status").src = "img/etanol.png";
    }
    else {
        alert("Vai de gasolina");
        document.getElementById("status").src = "img/gasolina.png";
    }
}
function resetar() {
    document.getElementById("status").src = "img/neutro.png";
    frmFlex.reset();
}