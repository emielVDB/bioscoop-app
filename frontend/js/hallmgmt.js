
var baseIp="http://192.168.99.100:3000";
// var HallServiceAdr=baseIp+":3000/hall/";


function GETHallByNumber() {
    var hallNumber=$('#hallNumber').val();

    var ourRequest=new XMLHttpRequest();
    ourRequest.open('GET',baseIp + "/hall/" + hallNumber, true);
    ourRequest.onload=function()
    {
        //alert(ourRequest.responseText);
        $('#outputGetHallByNumber').val(ourRequest.responseText);

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
        $('#outputGetEventHallByEventId').val(ourRequest.responseText);

    };
    ourRequest.send();
}