
var baseIp="http://192.168.99.100:3000";
// var baseIp="http://localhost:3000";


function GETHallByNumber() {
    var hallNumber=$('#hallNumber').val();

    var ourRequest=new XMLHttpRequest();
    ourRequest.open('GET',baseIp + "/hall/" + hallNumber, true);
    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        if(ourRequest.responseText == ""){
            $('#outputGetHallByNumber').val("geen hall voor nummer " + hallNumber);
        }else{
            $('#outputGetHallByNumber').val(ourRequest.responseText);
        }

    };
    ourRequest.send();
}

function GETEventHallByeventId() {
    var eventId=$('#eventId').val();

    var ourRequest=new XMLHttpRequest();
    ourRequest.open('GET',baseIp + "/eventhall/" + eventId, true);
    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        if(ourRequest.responseText == ""){
            $('#outputGetEventHallByEventId').val("geen eventid voor id " + eventId);
        }else{
            $('#outputGetEventHallByEventId').val(ourRequest.responseText);
        }


    };
    ourRequest.send();
}