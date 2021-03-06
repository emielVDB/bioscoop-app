var baseIp="http://192.168.99.100:3000/staff";

function GenerateTasks(){
    var date=$('#generateDate').val();
    var ourRequest=new XMLHttpRequest();
    ourRequest.open('GET',baseIp + "/generate/" + date, true);
    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        $('#output').val(ourRequest.responseText);

    };
    ourRequest.send();
}

function GETTaskByDate() {
    var date=$('#date').val();
    var ourRequest=new XMLHttpRequest();
    ourRequest.open('GET',baseIp + "/" + date, true);
    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        $('#outputGetTaskByDate').val(ourRequest.responseText);

    };
    ourRequest.send();
}

function POSTTask() {
    var task=$('#inputTask').val();

    var ourRequest=new XMLHttpRequest();
    ourRequest.open('POST',baseIp, + "/", true);
    ourRequest.setRequestHeader("Content-type", "application/json");

    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        $('#outputTask').val(ourRequest.responseText);
    };

    var json=JSON.stringify({ "task": task });

    ourRequest.send(json);
}