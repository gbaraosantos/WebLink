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

    var i;
    var id = document.getElementById("courseIDModules").value;
    var moduleTable = document.getElementById("moduleTable");
    var moduleTableBody = document.getElementById("moduleTableBody");
    var new_tbody = document.createElement('tbody');

    moduleTableBody.parentNode.replaceChild(new_tbody, moduleTableBody);
    new_tbody.id = "moduleTableBody";

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
                prepareTable(unloadedResponse[i], i, unloadedResponse.length)

            }
        }
    });

}

function prepareTable(module, i, len){
    var name, position, startDate, endDate, nClasses, percentage,button;
    var row, errorColor, id, order;
    var moduleTable = document.getElementById("moduleTableBody");

    row = moduleTable.insertRow(i);

    position = row.insertCell(0);
    name = row.insertCell(1);
    startDate = row.insertCell(2);
    endDate = row.insertCell(3);
    nClasses = row.insertCell(4);
    percentage = row.insertCell(5);
    button = row.insertCell(6);

    id =module["id"];
    errorColor = "style='color: #d11c12;'";


    name.innerHTML          = "<a onclick='tooltipFunc('name')'>" + module['name'] + "</a>";
    position.innerHTML      = "" + module['pos'];
    startDate.innerHTML     = "" + new Date(Date.parse(module['startDate'])).toDateString();
    endDate.innerHTML       = "" + new Date(Date.parse(module['endDate'])).toDateString();
    nClasses.innerHTML      = "" + module['nClasses'];
    percentage.innerHTML    = "" + module['percentage'] + "%";


    if(len == 1)
        button.innerHTML        =   "<span><a " + errorColor + " onclick='deleteModuleTrigger("+id+")'> <i class='table-remove glyphicon glyphicon-remove'></i></a></span>";


    else if(i != 0 && i != len - 1)
        button.innerHTML        =   "<span class='table-up glyphicon glyphicon-arrow-up' onclick='moveUp("+id+")'></span>"          +
                                    "<span class='table-down glyphicon glyphicon-arrow-down' onclick='moveDown("+id+")'></span>"    +
                                    "&nbsp;"                                                                                        +
                                    "<span><a " + errorColor + " onclick='deleteModuleTrigger("+id+")'> <i class='table-remove glyphicon glyphicon-remove'></i></a></span>";
    else if(i == 0)
        button.innerHTML        =   "<span class='table-down glyphicon glyphicon-arrow-down' onclick='moveDown("+id+")'></span>"    +
                                    "&nbsp;"                                                                                        +
                                    "<span><a " + errorColor + " onclick='deleteModuleTrigger("+id+")'> <i class='table-remove glyphicon glyphicon-remove'></i></a></span>";
    else if(i == len - 1)
        button.innerHTML        =   "<span class='table-up glyphicon glyphicon-arrow-up' onclick='moveUp("+id+")'></span>"          +
                                    "&nbsp;"                                                                                        +
                                    "<span><a " + errorColor + " onclick='deleteModuleTrigger("+id+")'> <i class='table-remove glyphicon glyphicon-remove'></i></a></span>"


}

function tooltipFunc(name){
    alert(name);
}

function moveUp(id){
    $.ajax({
        type : "GET",
        url : "/coord/ChangeUp?module=" + id,
        dataType: "text",

        error:function(){
            alert("Ajax Error Ocurred");
        },

        success:function(data) {
            loadModules();
        }

    });

}

function moveDown(id){
    $.ajax({
        type : "GET",
        url : "/coord/ChangeDown?module=" + id,
        dataType: "text",

        error:function(){
            alert("Ajax Error Ocurred");
        },

        success:function(data) {
            loadModules();
        }

    });
}

function deleteModuleTrigger(id){
    swal({
            title: "Apagar Modulo",
            text: "Tem a certeza que quer apagar o Módulo?",
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
                url : "/coord/deleteModuleTrigger?module=" + id,
                dataType: "text",

                error:function(){
                    alert("Ajax Error Ocurred");
                },

                success:function(data) {
                    loadModules();
                }

            });

            swal("Sucesso!", "Modulo Apagado.", "success");
        });
}

function createAddFields() {
    alert('so far so good');

}



