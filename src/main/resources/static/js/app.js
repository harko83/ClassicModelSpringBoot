/* JS ClassicModel by Vladirius
 * 2020 
 */

// Slider menu responsive
const navSlide = () => {
	const burger = document.querySelector('.burger');
	const nav = document.querySelector('.nav-links');
	const navLinks = document.querySelectorAll('.nav-links li');
	
	burger.addEventListener('click', () => {
		nav.classList.toggle('nav-active');
		
		//Animate links
		navLinks.forEach((link, index) => {
			if(link.style.animation){
				link.style.animation = '';
			} else {
				link.style.animation = 'navLinkFade 0.5s ease forward ${index / 7 + 1.5}s';
			}
		});
		// burger Animaation
		burger.classList.toggle('toggle');
	});
}

navSlide();

// Form contact regexp
function contactValidate(){
	//recover the value
	var email = document.getElementById('email').value;
	
	//assign the correct patttern for a mail adress
	var emailRGEX = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|'(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*')@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/
	
	//recover the value
	var name = document.getElementById('firstname').value;
	//assign the correct patttern only alphanumeric
	var nameRGEX = /^[a-zA-Z0-9]*$/;
	
	// compare the variable value to the regex if false return an error
	if(nameRGEX.test(name)){
		document.getElementById('nameError').innerHTML = "";
	} else {
		document.getElementById('nameError').innerHTML = "*Name is invalid-Don't use special character";
		return false;
	}
	
	// compare the variable value to the regex if false return an error
	if(emailRGEX.test(email)){
		document.getElementById('emailError').innerHTML = "";
	} else {
		document.getElementById('emailError').innerHTML = "*Email is invalid";
		return false;
	}
	
}