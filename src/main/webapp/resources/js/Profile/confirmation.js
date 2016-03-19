function deleteConfirm(email){
    alerts_confirm(email)
}

function verify_profileUpdate(){
    var name = document.getElementById("nome");
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    var re_password = document.getElementById("re_password");
    var nacionality = document.getElementById("nacionalidade");
    var address = document.getElementById("morada");
    var postal1 = document.getElementById("postal1");
    var postal2 = document.getElementById("postal2");


    if(	!verifyNull(name) 								&&
        !verifyNull(email) 								&&
        !verifyNull(nacionality)						&&
        !verifyNull(password)							&&
        !verifyNull(re_password)						&&
        !verifyNull(address)						    &&
        !verifyNull(postal1)						    &&
        !verifyNull(postal2)
            ){

                alerts("Preencha Pelo menos 1 campo");
                return false;
            }

    if(verifyNull(password) && !verifyNull(re_password)){ alerts("Repita a password para sua proteccao"); return false;   }
    else if(verifyNull(re_password) && !verifyNull(password)){ alerts("Preencha o campo de Password"); return false;   }
    else if(verifyNull(re_password) && verifyNull(password)){
        if(!compare_strings(password, re_password) || !check_minSize(password, 6) ) return false;

    }

    if(verifyNull(email) ){
        if(!check_minSize(email, 3)) return false;
    }
    if(verifyNull(address) ){
        if(!check_minSize(address, 3)) return false;
    }


    return true;
}

function verifyNull(InputBox){
    return InputBox.value != "";
}

function check_minSize(field, size){
    if(field.value.length >= size)	return true

    alerts("Campo tem de ter pelo menos "+size+" digitos");

    return false
}

function alerts(text){
    swal({
        confirmButtonColor: 'ffbf80',
        title: 'Oops...',
        text: text,
        type: 'error',
        animation: true });


}

function compare_strings(field1, field2){
    if (field1.value === field2.value)	return true

    alerts("Campos de password não estão iguais");
    return false
}



function request_delete(){
    console.log("well im lost");

    $.ajax({
        type : "GET",
        url : "/weblink/profile/deleteUser",

        success:function(data){
            console.log(data);
        }

    });
}
function alerts_confirm(email) {

    swal({
        title: "Account deleting",
        text: "Are you sure about deleting your account? You will need an admin to restore it.",
        confirmButtonColor: "#DD6B55",
        type: "input",
        confirmButtonText: "Yes, delete it!",
        cancelButtonText: "No, cancel!",
        imageUrl: "../../resources/images/Common/ftwarning.png",
        showCancelButton: true,
        closeOnConfirm: false,
        inputPlaceholder: "Your Email Address",
        showLoaderOnConfirm: true
    },
        function(inputValue){
            if (inputValue === false) return false;
            if (inputValue === "") {
                swal.showInputError("You need to write your Email!");
                return false
            }

            if(inputValue == email){
                request_delete(email);
                setTimeout(function(){

                    swal({
                        title: "Deleted",
                        text: "Your account has been deleted",
                        type: "success"

                    },function(isConfirm){
                        if (isConfirm) document.location.href = '/logout';
                    })
                }, 2000);


            }
            else{
                swal.showInputError("Incorrect Email!");
                return false
            }

        });

}