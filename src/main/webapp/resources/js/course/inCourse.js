function deleteMaterial(id, actionId){
    swal({
            title: "Remover Material",
            text: "Tem a certeza que quer remover este material?",
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
                url : "/teacher/deleteMaterial?materialId=" + id + "&&actionId=" + actionId,
                dataType: "text",

                error:function(){
                    alert("Ajax Error Ocurred");
                },

                success:function(data) {
                }

            });

            swal({
                title: "Sucesso",
                text: "Material Apagado",
                type: "success"

            },function(isConfirm){
                if (isConfirm) document.location.reload();
            })
        });
}