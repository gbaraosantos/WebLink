function deleteConfirm(id){
    alerts_confirm("Delete" , id);
}

function request_delete(id){
    console.log("well im lost");

    $.ajax({
        type : "GET",
        url : "/coord/deleteAction?Action=" + id,

        success:function(data){
            console.log(data);
        }

    });
}
function alerts_confirm(name,id) {

    swal({
            title: "Apagar Acção",
            text: "Tem a certeza que quer apagar essa acção? Se sim escreva: Delete",
            confirmButtonColor: "#DD6B55",
            type: "input",
            confirmButtonText: "Sim, apagar!",
            cancelButtonText: "Não, cancelar!",
            imageUrl: "../../resources/images/Common/ftwarning.png",
            showCancelButton: true,
            closeOnConfirm: false,
            inputPlaceholder: "Delete",
            showLoaderOnConfirm: true
        },
        function(inputValue){
            if (inputValue === false) return false;
            if (inputValue === "") {
                swal.showInputError("Tem de Escrever Delete!");
                return false
            }

            if(inputValue == name){
                request_delete(id);
                setTimeout(function(){

                    swal({
                        title: "Apagada",
                        text: "A Acção foi apagada",
                        type: "success"

                    },function(isConfirm){
                        if (isConfirm) document.location.href = '/weblink/courses';
                    })
                }, 2000);


            }
            else{
                swal.showInputError("Palavra Incorrecta!");
                return false
            }

        });

}

function loadModules(){
    var i, unloadedResponse;
    var id = document.getElementById("courseIDModules").value;

    $.ajax({
        type : "GET",
        url : "/coord/getModules?Course=" + id,
        dataType: "text",

        error:function(){
            alert("Ajax Error Ocurred");
            return "Well i Know What is Happening now";
        },

        success:function(data){
            var unloadedResponse = jQuery.parseJSON(data);

            for(i = 0; i < unloadedResponse.length; i++){
                console.log(unloadedResponse[i]);
            }
        }
    });

}






