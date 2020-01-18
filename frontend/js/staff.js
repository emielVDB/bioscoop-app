var baseIp="http://192.168.99.100:3000/staff";

function GenerateTasks(){
    var date=$('#generateDate').val();
    var ourRequest=new XMLHttpRequest();
    ourRequest.open('GET',baseIp + "/generate/" + date, true);
    console.log(baseIp + "/generate/" + date);
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