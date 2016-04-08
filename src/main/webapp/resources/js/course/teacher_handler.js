var module_editing = 0;

function setId(id){
    module_editing = id;
    document.getElementById("MpaId").value = module_editing;
    document.getElementById("MpaId2").value = module_editing;
}


function setValues(name, percentage, description, sDate, eDate){
    var dayStart = ("0" +  new Date(Date.parse(sDate)).getDate()).slice(-2);
    var monthStart = ("0" + (new Date(Date.parse(sDate)).getMonth() +1)).slice(-2);

    var dayEnd = ("0" +  new Date(Date.parse(eDate)).getDate()).slice(-2);
    var monthEnd = ("0" + (new Date(Date.parse(eDate)).getMonth() +1)).slice(-2);


    document.getElementById("moduleName").value = name;
    document.getElementById("moduleDescription").value = description;
    document.getElementById("percentage").value = percentage;

    document.getElementById("startMPA").value =  new Date(Date.parse(sDate)).getFullYear() +"-" + monthStart + "-" +  dayStart;
    document.getElementById("endMPA").value =  new Date(Date.parse(eDate)).getFullYear() +"-" + monthEnd + "-" +  dayEnd;
}

function removeTeacherDialog(teachId){
    swal({
            title: "Remover Formador Deste Módulo",
            text: "Tem a certeza que quer remover este formador deste módulo?",
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
                url : "/coord/deleteTeacher?teacherId=" + teachId,
                dataType: "text",

                error:function(){
                    alert("Ajax Error Ocurred");
                },

                success:function(data) {
                }

            });

            swal({
                title: "Sucesso",
                text: "Formador Apagado",
                type: "success"

            },function(isConfirm){
                if (isConfirm) document.location.reload();
            })
        });
}




function checkMPA(){
    var name = document.getElementById("moduleName");
    var description = document.getElementById("moduleDescription");
    var percentage = document.getElementById("percentage");
    var sDate = document.getElementById("startMPA");
    var eDate = document.getElementById("endMPA");


    if( !checkDates(sDate,eDate)                        ||
        !checkPercentage(percentage)                    ||
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

    if(intpercentage > 100){
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

function deleteModuleTrigger2(id){
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

                }

            });

            swal({
                title: "Sucesso",
                text: "Modulo Apagado",
                type: "success"

            },function(isConfirm){
                if (isConfirm) document.location.reload();
            })


        });
}