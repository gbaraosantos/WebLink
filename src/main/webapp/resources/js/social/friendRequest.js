function deleteRequestAjax(id){
    swal({
            title: "Apagar Request",
            text: "Tem a certeza que quer apagar a request?",
            confirmButtonColor: "#DD6B55",
            type: "warning",
            confirmButtonText: "Sim, apagar!",
            cancelButtonText: "Não, cancelar!",
            showCancelButton: true,
            closeOnConfirm: false
        },
        function(){
            $.ajax({
                type : "GET",
                url : "/weblink/deleteFriendRequest?id=" + id,
                dataType: "text",

                error:function(){
                    alert("Ajax Error Ocurred");
                },

                success:function(data) {
                    document.location.href = '/weblink/social';
                }

            });

            swal("Sucesso!", "Request Apagada.", "success");
        });
}

function acceptRequestAjax(id){
    swal({
            title: "Aceitar Request",
            text: "Tem a certeza que quer aceitar a request?",
            confirmButtonColor: "#DD6B55",
            type: "warning",
            confirmButtonText: "Sim, aceitar!",
            cancelButtonText: "Não, cancelar!",
            showCancelButton: true,
            closeOnConfirm: false
        },
        function(){
            $.ajax({
                type : "GET",
                url : "/weblink/acceptFriendRequest?id=" + id,
                dataType: "text",

                error:function(){
                    alert("Ajax Error Ocurred");
                },

                success:function(data) {
                    document.location.href = '/weblink/social';
                }

            });

            swal("Sucesso!", "Request Aceite.", "success");
        });
}

function checkOfferCourse(){


    swal({
            title: "Oferecer Curso",
            text: "Tem a certeza que quer oferecer esse curso?",
            confirmButtonColor: "#DD6B55",
            type: "warning",
            confirmButtonText: "Sim, oferecer!",
            cancelButtonText: "Não, cancelar!",
            showCancelButton: true,
            closeOnConfirm: false
        },
        function(){
            $.ajax({
                type : "GET",
                url : "/weblink/offerCourse?friend=" + document.getElementById("friendToOffer").value + "&action="+document.getElementById("actionToOffer").value ,
                dataType: "text",

                error:function(){
                    alert("Ajax Error Ocurred");
                },

                success:function(data) {
                    document.location.href = '/weblink/social';
                }

            });
            swal("Sucesso!", "Curso oferecido", "success");
        });
}

function sendPrivate(){
    $.ajax({
        type : "GET",

        url :
            "/weblink/message?friend="
            + document.getElementById("messageDestination").value
            + "&message="
            + document.getElementById("privateMessage").value
            + "&subject="
            + document.getElementById("subject").value  ,

        dataType: "text",

        error:function(){
            alert("Ajax Error Ocurred");
        },

        success:function(data) {
            swal("Sucesso!", "Enviada", "success");
        }

    });
}

function markAsRead(id){
    $.ajax({
        type : "GET",
        url : "/weblink/messageCheck?id=" + id,
        dataType: "text",

        error:function(){
            alert("Ajax Error Ocurred");
        },

        success:function(data) {
            swal("Sucesso!", "Mensagem Marcada como lida", "success");
        }

    });
}

function deleteMessage(id){
    $.ajax({
        type : "GET",
        url : "/weblink/messageDelete?id=" + id,
        dataType: "text",

        error:function(){
            alert("Ajax Error Ocurred");
        },

        success:function(data) {
            swal("Sucesso!", "Mensagem Apagada", "success");
        }

    });
}




