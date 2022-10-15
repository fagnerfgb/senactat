/**
 * Baralho de Tarot
 * @Author: Fagner Geraldes Braga
 */

var sorteio = Math.floor(Math.random() * 22 + 1);

switch (sorteio) {
	case 1:
		document.getElementById("carta").src = "img/tarot1.jpg";
		document.getElementById("texto").innerText = "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Totam voluptate vero dolorem, dolor quibusdam odio distinctio omnis qui iste necessitatibus";
		break;
	case 2:
		document.getElementById("carta").src = "img/tarot2.jpg";
		break;
	case 3:
		document.getElementById("carta").src = "img/tarot3.jpg";
		break;
	case 4:
		document.getElementById("carta").src = "img/tarot4.jpg";
		break;
	case 5:
		document.getElementById("carta").src = "img/tarot5.jpg";
		break;
	case 6:
		document.getElementById("carta").src = "img/tarot6.jpg";
		break;
	case 7:
		document.getElementById("carta").src = "img/tarot7.jpg";
		break;
	case 8:
		document.getElementById("carta").src = "img/tarot8.jpg";
		break;
	case 9:
		document.getElementById("carta").src = "img/tarot9.jpg";
		break;
	case 10:
		document.getElementById("carta").src = "img/tarot10.jpg";
		break;
	case 11:
		document.getElementById("carta").src = "img/tarot11.jpg";
		break;
	case 12:
		document.getElementById("carta").src = "img/tarot12.jpg";
		break;
	case 13:
		document.getElementById("carta").src = "img/tarot13.jpg";
		break;
	case 14:
		document.getElementById("carta").src = "img/tarot14.jpg";
		break;
	case 15:
		document.getElementById("carta").src = "img/tarot15.jpg";
		break;
	case 16:
		document.getElementById("carta").src = "img/tarot16.jpg";
		break;
	case 17:
		document.getElementById("carta").src = "img/tarot17.jpg";
		break;
	case 18:
		document.getElementById("carta").src = "img/tarot18.jpg";
		break;
	case 19:
		document.getElementById("carta").src = "img/tarot19.jpg";
		break;
	case 20:
		document.getElementById("carta").src = "img/tarot20.jpg";
		break;
	case 21:
		document.getElementById("carta").src = "img/tarot21.jpg";
		break;
	case 22:
		document.getElementById("carta").src = "img/tarot22.jpg";
		break;
	default:
		//caso contrário	
		break;
}
