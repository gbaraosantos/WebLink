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

function ajax_load_modules(id){

    $.ajax({
        type : "GET",
        url : "/coord/getModules?Course=" + id,

        success:function(data){
            console.log(data);
        }

    });
}

function loadModules(){
    var id = document.getElementById("courseIDModules").value;
    ajax_load_modules(id);

    var Courses = '${courses}';

    console.log(Courses)



}