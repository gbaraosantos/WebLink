

function verify_newCourse(){
    var area = document.getElementById("area");
    var name = document.getElementById("courseName");
    var description = document.getElementById("description");
    var startDate = document.getElementById("startDate");
    var Price = document.getElementById("price");
    var classTime = document.getElementById("tClass");

    if( !verifyNull(name) 								||
        !verifyNull(description) 						||
        !verifyNull(startDate)						    ||
        !verifyNull(area)							    ||
        !verifyNull(Price)						        ||
        !verifyNull(classTime)						    ||
        !check_minSize(name, 3, "Name") 				||
        !check_minSize(area, 3, "area") 				||
        !check_minSize(description, 6, "description")   ||
        !checkDates(startDate)                          ||
        !check_min(Price, 0, "price")                   ||
        !check_min(classTime, 1, "tempo de Aula")
    )return false;

    return true;
}

function check_minSize(field, size, name){
    if(field.value.length >= size)	return true
    alerts("Campo " +name + " tem de ter pelo menos "+size+" digitos");
    return false
}

function check_min(value, min, name){
    if(parseInt(value.value) >= min) return true;
    alerts("O campo " + name + " não pode ter esse valor");
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