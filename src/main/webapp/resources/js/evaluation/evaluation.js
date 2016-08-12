function checkFields(){
    var correct = document.getElementById("correct");
    var b = document.getElementById("b");
    var c = document.getElementById("c");
    var d = document.getElementById("d");

    if( !verifyNull(correct) 								||
        !verifyNull(b) 						        ||
        !verifyNull(c) 						        ||
        !verifyNull(d) 						        ||
        !check_minSize(correct, 3, "questao") 				||
        !check_minSize(b, 3, "b") 				||
        !check_minSize(c, 3, "c") 				||
        !check_minSize(d, 3, "d")
    )return false;

    return true;
}
function check_minSize(field, size, name){
    if(field.value.length >= size)	return true
    alerts("Campo " +name + " tem de ter pelo menos "+size+" digitos");
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

function verifyNull(InputBox){
    if (InputBox.value == ""){
        alerts("Preencha todos os campos");
        return false
    }
    return true
}

function deleteQuestion(questionId, evalId){
    swal({
            title: "Remover questao",
            text: "Tem a certeza que quer remover esta questao?",
            confirmButtonColor: "#DD6B55",
            type: "warning",
            confirmButtonText: "Sim, remover!",
            cancelButtonText: "Não, cancelar!",
            showCancelButton: true,
            closeOnConfirm: false
        },
        function(){
            $.ajax({
                type : "GET",
                url : "/teacher/deleteQuestion?questionId=" + questionId + "&&evalId=" + evalId,
                dataType: "text",

                error:function(){
                    alert("Ajax Error Ocurred");
                },

                success:function(data) {
                }

            });

            swal({
                title: "Sucesso",
                text: "Questao apagada",
                type: "success"

            },function(isConfirm){
                if (isConfirm) document.location.reload();
            })
        });
}