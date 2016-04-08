var int_percentage = 0;


function loadModules(){
    int_percentage = 0;
    var divPercentage = document.getElementById("percentageBarLocal");
    divPercentage.innerHTML = '';

    document.getElementById("addModulesDiv").style.display = "none";

    var i;
    var id = document.getElementById("courseIDModules").value;
    var moduleTable = document.getElementById("moduleTable");
    var moduleTableBody = document.getElementById("moduleTableBody");
    var new_tbody = document.createElement('tbody');

    document.getElementById("courseIdModule").value = id;

    if(parseInt(id) != "0"){
        document.getElementById("percentageBarLocal").style.display = "inline";
        document.getElementById("addModuleButton").style.display = "inline";
    }
    else{
        document.getElementById("addModuleButton").style.display = "none";
        document.getElementById("percentageBarLocal").style.display = "none";
    }


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
            putPercentageBar();

        }
    });

}

function putPercentageBar(){
    var divPercentage = document.getElementById("percentageBarLocal");
    var child1 = document.createElement("div");
    var child2 = document.createElement("div");

    child1.setAttribute("class", "progress");

    child2.setAttribute("class", "progress-bar progress-bar-success progress-bar-striped active");
    child2.setAttribute("role", "progressbar");
    child2.setAttribute("aria-valuenow", int_percentage.toString());
    child2.setAttribute("aria-valuemin", "0");
    child2.setAttribute("aria-valuemax", "100");
    child2.setAttribute("style", "width:"+int_percentage.toString()+"%");
    child2.innerHTML = int_percentage.toString() + "% of Course is Set";

    child1.appendChild(child2);
    divPercentage.appendChild(child1);


}

function prepareTable(module, i, len){
    var name, position, startDate, endDate, accordion_handler, percentage,button;
    var row, row2, id;
    var moduleTable = document.getElementById("moduleTableBody");
    var child1 = document.createElement("div");

    int_percentage = int_percentage + parseInt(module['percentage']);

    id =module["id"];

    row = moduleTable.insertRow(i * 2);

    accordion_handler = row.insertCell(0);
    position = row.insertCell(1);
    name = row.insertCell(2);
    startDate = row.insertCell(3);
    endDate = row.insertCell(4);
    percentage = row.insertCell(5);
    button = row.insertCell(6);

    accordion_handler.innerHTML= "<a data-toggle='collapse'' href= '#"+id+"' data-parent= '#"+id+"' data-target = '#"+id+"' aria-expanded='true' aria-controls='"+id+"'><li class='fa fa-arrow-right'></li></a>";
    name.innerHTML          = "" + module['name'];
    position.innerHTML      = "" + module['pos'];
    startDate.innerHTML     = "" + new Date(Date.parse(module['creationDate'])).toDateString();
    endDate.innerHTML       = "" + new Date(Date.parse(module['lastChangeDate'])).toDateString();
    percentage.innerHTML    = "" + module['percentage'] + "%";
    button.innerHTML = createButtons(button, id,len,i);


    row2 = moduleTable.insertRow(i * 2 + 1);
    child1.setAttribute("class", "accordian-body collapse");
    child1.setAttribute("id",id);
    child1.innerHTML = module['description'];
    var newCell = row2.insertCell(0);
    newCell.setAttribute("colspan", "12");
    newCell.style.padding = 0;
    newCell.appendChild(child1);

}

function edit(id){
    var url_change = "/coord/updateModule?module=" + id;

    document.getElementById("formModule").action = url_change;
    document.getElementById("titleModule").innerHTML = "Modificar um Módulo";

    document.getElementById("addModulesDiv").style.display = "inline";
    document.getElementById("addModuleButton").style.display = "none";



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


function createButtons(button, id, len,i){

    var errorColor = "style='color: #d11c12;'";

    if(len == 1)
        button.innerHTML        =
            "<a onclick='edit("+id+")'><span class='glyphicon glyphicon-pencil'></span></a>"                                        +
            "&nbsp;"                                                                                                                +
            "<span><a " + errorColor + " onclick='deleteModuleTrigger("+id+")'> <i class='table-remove glyphicon glyphicon-remove'></i></a></span>";
    else if(i != 0 && i != len - 1)
        button.innerHTML        =   "<span class='table-up glyphicon glyphicon-arrow-up' onclick='moveUp("+id+")'></span>"          +
            "<span class='table-down glyphicon glyphicon-arrow-down' onclick='moveDown("+id+")'></span>"                            +
            "&nbsp;"                                                                                                                +
            "<a onclick='edit("+id+")'><span class='glyphicon glyphicon-pencil'></span></a>"                                        +
            "&nbsp;"                                                                                                                +
            "<span><a " + errorColor + " onclick='deleteModuleTrigger("+id+")'> <i class='table-remove glyphicon glyphicon-remove'></i></a></span>";
    else if(i == 0)
        button.innerHTML        =   "<span class='table-down glyphicon glyphicon-arrow-down' onclick='moveDown("+id+")'></span>"    +
            "&nbsp;"                                                                                                                +
            "<a onclick='edit("+id+")'><span class='glyphicon glyphicon-pencil'></span></a>"                                        +
            "&nbsp;"                                                                                                                +
            "<span><a " + errorColor + " onclick='deleteModuleTrigger("+id+")'> <i class='table-remove glyphicon glyphicon-remove'></i></a></span>";
    else if(i == len - 1)
        button.innerHTML        =   "<span class='table-up glyphicon glyphicon-arrow-up' onclick='moveUp("+id+")'></span>"          +
            "&nbsp;"                                                                                                                +
            "<a onclick='edit("+id+")'><span class='glyphicon glyphicon-pencil'></span></a>"                                        +
            "&nbsp;"                                                                                                                +
            "<span><a " + errorColor + " onclick='deleteModuleTrigger("+id+")'> <i class='table-remove glyphicon glyphicon-remove'></i></a></span>"


    return button.innerHTML;
}

function createAddFields() {
    var url_add = "/coord/addModule";
    document.getElementById("formModule").action = url_add;
    document.getElementById("titleModule").innerHTML = "Adicionar um Módulo";

    document.getElementById("addModulesDiv").style.display = "inline";
    document.getElementById("addModuleButton").style.display = "none";
}

function addClick(){
    var url_add = "/coord/addModule";
    document.getElementById("formModule").action = url_add;
    document.getElementById("titleModule").innerHTML = "Adicionar um Módulo";

    document.getElementById("addModulesDiv").style.display = "none";
    document.getElementById("addModuleButton").style.display = "inline";
}



function validateNewModule(){
    var name = document.getElementById("moduleName");
    var description = document.getElementById("moduleDescription");
    var percentage = document.getElementById("percentage");


    if(document.getElementById("titleModule").innerHTML == "Modificar um Módulo") return true;

    if( !checkPercentage(percentage)                    ||
        !verifyNull(name) 								||
        !verifyNull(description) 						||
        !verifyNull(percentage)						    ||
        !check_minSize(name, 3, "Name") 				||
        !check_minSize(description, 6, "description")

                                                            )return false;

    return true;
}

function check_min(value, min, name){
    if(parseInt(value.value) >= min) return true;
    alerts("O campo " + name + " não pode ter esse valor");
    return false;
}

function checkPercentage(percentage){
    var intpercentage = parseInt(percentage.value);

    if(intpercentage + int_percentage > 100){
        alerts("Percentagem ultrapassa os 100% totais");
        return false;
    }

    if(intpercentage <= 100 && intpercentage > 0) return true;

    alerts("Percentagem não está dentro dos limites aceitáveis");
    return false;

}

function checkDates(startDate, endDate){
    var date1 = new Date(Date.parse(startDate.value));
    var date2 = new Date(Date.parse(endDate.value));


    if(date1.getTime() < new Date().getTime()){
        alerts("Vão haver formações no passado?");
        return false;
    }

    if(date1.getTime() < date2.getTime()) return true;

    alerts("Data inicial não pode ser depois da final");
    return false;

}

function check_minSize(field, size, name){
    if(field.value.length >= size)	return true
    alerts("Campo " +name + " tem de ter pelo menos "+size+" digitos");
    return false
}

function verifyNull(InputBox){
    if (InputBox.value == ""){
        alerts("Preencha todos os campos");
        return false
    }
    return true
}

function alerts(text){
    swal({
        confirmButtonColor: 'ffbf80',
        title: 'Oops...',
        text: text,
        type: 'error',
        animation: true });
}








