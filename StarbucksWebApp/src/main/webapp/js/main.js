function showMenu() {
	var menu = document.getElementById('menuoptions'); 
	if(menu.style.display == "none") {
		menu.style.display = "block";
		document.getElementById("menuicon").className = "fa fa-close";
		
	}
	else {
		menu.style.display = "none";
		document.getElementById("menuicon").className = "fa fa-bars";
	}
}

function incrementCappuccinoValue()
{
    var value = parseInt(document.getElementById('cappuccinonumber').value, 10);
    value = isNaN(value) ? 0 : value;
    value++;
    document.getElementById('cappuccinonumber').value = value;
}
function decrementCappuccinoValue()
{
    var value = parseInt(document.getElementById('cappuccinonumber').value, 10);
    value = isNaN(value) ? 0 : value;
    value = isNull(value) ? 0 : --value;
    document.getElementById('cappuccinonumber').value = value;
}
function isNull(value) {
return (value == 0);
}