var baseIp="http://192.168.99.100:3000/media";

function GETMedia(){
    var title=$('#generateDate').val();
    var ourRequest=new XMLHttpRequest();
    ourRequest.open('GET',baseIp + "/title/" + title, true);
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

    var json=JSON.stringify({ "media": media });

    ourRequest.send(json);
}

function POSTFile() {
    var file=$('#file').val();
    var type=$('#type').val();
    var id=$('#mediaId').val();

    var ourRequest=new XMLHttpRequest();
    ourRequest.open('POST',baseIp, + "/" + id, true);
    ourRequest.setRequestHeader("Content-type", "application/json");
    ourRequest.setRequestHeader("name", type);
    ourRequest.setRequestHeader("file", file);

    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        $('#outputPostFileResult').val(ourRequest.responseText);
    };

    ourRequest.send();
}