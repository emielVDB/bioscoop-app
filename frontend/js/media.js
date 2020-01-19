// var baseIp="http://127.0.0.1:3000/media";
var baseIp="http://localhost:3000/media";

function GETMedia(){
    var title=$('#title').val();
    var ourRequest=new XMLHttpRequest();
    ourRequest.open('GET',baseIp + "/title/" + title, true);
    console.log(baseIp + "/title/" + title);
    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        $('#outputMedia').val(ourRequest.responseText);

    };
    ourRequest.send();
}

function POSTMedia() {
    var media=$('#mediaJson').val();
    var ourRequest=new XMLHttpRequest();
    ourRequest.open('POST',baseIp, true);
    ourRequest.setRequestHeader("Content-type", "application/json");

    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        $('#outputPostResult').val(ourRequest.responseText);
    };

    // var json=JSON.stringify({"media" : media});
    // console.log(json);
    ourRequest.send(media);
}

function POSTFile() {
    var type=$('#type').val();
    var id=$('#mediaId').val();
    var formData = new FormData();
    formData.append("name", type);
    formData.append("file", document.getElementById("fileField").files[0]);
    var ourRequest=new XMLHttpRequest();
    ourRequest.open('POST',baseIp + "/" + id, true);

    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        $('#outputPostFileResult').val(ourRequest.responseText);
    };

    ourRequest.send(formData);
}