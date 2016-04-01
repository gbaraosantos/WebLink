

function verify_newAction(){
    var discount = document.getElementById("discount");
    var startDate = document.getElementById("startDateAction");

    if( !verifyNull(discount) 								||
        !verifyNull(startDate) 						        ||
        !checkDates(startDate)                              ||
        !checkPercentage(discount)
    )return false;

    return true;
}


function checkPercentage(percentage){
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