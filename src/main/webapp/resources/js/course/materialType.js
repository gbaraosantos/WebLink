function activateVideos(){
    document.getElementById("Videos").style.display = "inline";
    document.getElementById("Sounds").style.display = "none";
    document.getElementById("Images").style.display = "none";
    document.getElementById("Downloadables").style.display = "none";
}

function activateSound(){
    document.getElementById("Videos").style.display = "none";
    document.getElementById("Sounds").style.display = "inline";
    document.getElementById("Images").style.display = "none";
    document.getElementById("Downloadables").style.display = "none";
}

function activateImages(){
    document.getElementById("Videos").style.display = "none";
    document.getElementById("Sounds").style.display = "none";
    document.getElementById("Images").style.display = "inline";
    document.getElementById("Downloadables").style.display = "none";
}

function activateDownloadables(){
    document.getElementById("Videos").style.display = "none";
    document.getElementById("Sounds").style.display = "none";
    document.getElementById("Images").style.display = "none";
    document.getElementById("Downloadables").style.display = "inline";
}