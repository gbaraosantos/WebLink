var defaultBorders;


function defaultSave(){
	var email = document.getElementById("email");

	defaultBorders = email.style.border
}

function verify_login(){
	var mail = document.getElementById("login_email");
	var password = document.getElementById("login_password");

	if(!verifyNull(mail) || !verifyNull(password)) return false

	return true;
}

function verify_registry(){

	var name = document.getElementById("nome");
	var email = document.getElementById("email");
	var email_again = document.getElementById("re_mail");
	var password = document.getElementById("password");
	var re_password = document.getElementById("re_password");
	var day_birth = document.getElementById("dia_reg");
	var month_birth = document.getElementById("mes_reg");
	var year_birth = document.getElementById("ano_reg");
	var nacionality = document.getElementById("nacionalidade");
	var address = document.getElementById("morada");
	var postal1 = document.getElementById("postal1");
	var postal2 = document.getElementById("postal2");
	var city = document.getElementById("city");


	

	setDefaultBorder(password, defaultBorders );
	setDefaultBorder(re_password , defaultBorders );
	setDefaultBorder(name, defaultBorders );
	setDefaultBorder(email , defaultBorders );
	setDefaultBorder(email_again, defaultBorders );
	setDefaultBorder(day_birth, defaultBorders );
	setDefaultBorder(month_birth, defaultBorders );
	setDefaultBorder(year_birth, defaultBorders );
	setDefaultBorder(nacionality, defaultBorders );
	setDefaultBorder(address, defaultBorders );
	setDefaultBorder(postal1, defaultBorders );
	setDefaultBorder(postal2, defaultBorders );
	setDefaultBorder(city, defaultBorders );

	if(		!verifyNull(name) 								||
			!verifyNull(email) 								||
			!verifyNull(email_again)						||
			!verifyNull(password)							||
			!verifyNull(re_password)						||
			!check_minSize(password, 6) 					||
			!compare_strings(password,re_password) 			||
			!compare_strings(email,email_again) 			||
			!check_emailFormation(email)					||
			!verify_selected(day_birth) 					||
			!verify_selected(month_birth) 					||
			!verify_selected(year_birth) 					||
			!verify_selected(nacionality) 					||
			!verifyNull(address) 							||
			!check_minSize(address, 3) 						||
			!check_minSize(email, 3) 						||
			!check_minSize(name, 3) 						||
			!verifyNull(postal1) 							||
			!verifyNull(postal2)							||
			!verifyNull(city)								)return false

	return true;
}

function check_minSize(field, size){
	if(field.value.length >= size)	return true

	alerts("Campo tem de ter pelo menos"+size+" digitos");
	setInputBorderRed (field);

	return false
}

function compare_strings(field1, field2){
	if (field1.value === field2.value)	return true

	setInputBorderRed (field1);
	setInputBorderRed(field2)
	alerts("Campos não estão iguais");
	return false
}

function check_emailFormation(email){
	var email_formation = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	if (email_formation.test(email.value)) return true;
	
	alerts("Email malformado");
	setInputBorderRed (email);
	return false;
}
function verifyNull(InputBox){	
	if (InputBox.value == ""){
		setInputBorderRed(InputBox);
		alerts("Preencha todos os campos")
		return false
	}
	return true}
function verify_selected(selectBox){
	if (selectBox.value === "0") {
		setInputBorderRed(selectBox);
		alerts("Preencha todos os campos");
		return false
	}
	return true}

function alerts(text){	
	swal({   
		confirmButtonColor: 'ffbf80',
		title: 'Oops...',   
		text: text,   
		type: 'error',   	
		animation: true });


}
function setDefaultBorder(inputBox, defaultBox){	inputBox.style.border = defaultBox;	}
function setInputBorderRed(inputBox){	inputBox.style.border = "thin solid #CD5555";	}

