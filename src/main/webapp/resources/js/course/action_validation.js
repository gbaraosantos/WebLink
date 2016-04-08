

function verify_newAction(){
    var discount = document.getElementById("discount");
    var startDate = document.getElementById("startDateAction");

    if( !verifyNull(discount) 								||
        !verifyNull(startDate) 						        ||
        !checkDates(startDate)                              ||
        !checkPercentage2(discount)
    )return false;

    return true;
}


function checkPercentage2(percentage){
    if(parseInt(percentage.value) <= 100 && parseInt(percentage.value) >= 0) return true;

    alerts("Percentagem não está dentro dos limites aceitáveis");
    return false;
}

function checkDates(startDate){
    var date1 = new Date(Date.parse(startDate.value));


    if(date1.getTime() >= new Date().getTime()) return true;

    alerts("Vão haver formações no passado?");
    return false;
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

function triggerVisibleWarning(){
    var a = document.getElementById("visibilityWarning").innerHTML;

    if(parseInt(a) == 1){
        alerts("O total da percentagem desses Módulos não é 100%")
    }else if (parseInt(a) == 2){
        alerts("As Datas dos módulos desta acção não estão preenchidos");
    }else if (parseInt(a) == 3){
        alerts("As Datas dos módulos desta acção cruzam-se");
    }else if (parseInt(a) == 4) {
        alerts("Posição Não Respeitada");
    }


}