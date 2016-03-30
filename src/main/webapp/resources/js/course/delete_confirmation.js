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

    var i, name, position, startDate, endDate, nClasses, percentage,button;
    var row, errorColor;
    var div = document.getElementById('moduleSpot');
    var id = document.getElementById("courseIDModules").value;
    var moduleTable = document.getElementById("moduleTable");

    for(i = 1 ; i < moduleTable.rows.length; i++){
        moduleTable.deleteRow(i);
    }




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
                row = moduleTable.insertRow(i + 1);

                position = row.insertCell(0);
                name = row.insertCell(1);
                startDate = row.insertCell(2);
                endDate = row.insertCell(3);
                nClasses = row.insertCell(4);
                percentage = row.insertCell(5);
                button = row.insertCell(6);

                id =unloadedResponse[i]["id"];
                errorColor = "style='color: #d11c12;'";

                name.innerHTML          = "" + unloadedResponse[i]['name'];
                position.innerHTML      = "" + unloadedResponse[i]['pos'];
                startDate.innerHTML     = "" + new Date(Date.parse(unloadedResponse[i]['startDate'])).toDateString();
                endDate.innerHTML       = "" + new Date(Date.parse(unloadedResponse[i]['endDate'])).toDateString();
                nClasses.innerHTML      = "" + unloadedResponse[i]['nClasses'];
                percentage.innerHTML    = "" + unloadedResponse[i]['percentage'];
                button.innerHTML        = "<a " + errorColor + " onclick='deleteModuleTrigger("+id+")'> <i class='fa fa-times-circle fa-2x'></i></a>";

            }
        }
    });

}

function deleteModuleTrigger(id){
    $.ajax({
        type : "GET",
        url : "/coord/deleteModuleTrigger?module=" + id,
        dataType: "text",

        error:function(){
            alert("Ajax Error Ocurred");
        },

        success:function(data) {
            alert(data);
            loadModules();
        }

    });
}

function createAddFields() {
    alert('so far so good');

}





