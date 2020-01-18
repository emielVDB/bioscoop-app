var ticketaddress='http://192.168.99.100:3000/ticket/';
function bookTicket(){
    var dateEvent=$('#DateEvent').val();
    var name=$('#name').val();
    var stringseats=$('#seats').val();
    var seats=[];
    stringseats.split(",").map(Number).forEach(element => {
        seats.push({"id":element});
    });
    // console.log(seats);
    var stringconsumptions=$('#consumptions').val();
    var consumptions=[];
    stringconsumptions.split(",").map(Number).forEach(element =>{
        consumptions.push({"productid":element});
    });
    var hallnumber=$('#hallnumber').val();
    var eventid=$('#eventid').val();
    var ourRequest=new XMLHttpRequest();
	ourRequest.open('POST',ticketaddress, true);
	ourRequest.setRequestHeader("Content-type", "application/json");
	ourRequest.onload=function()
	{
		//alert(ourRequest.responseText);
		$('#outputBookTicket').val(ourRequest.responseText);
	};
	
	var json=JSON.stringify({"name":name, "seats":seats,"consumptions":consumptions,"hallnumber":hallnumber,"dateEvent":dateEvent, "eventid": eventid });
	
	ourRequest.send(json); 
}


function getTickets(){
    var ourRequest=new XMLHttpRequest();
	ourRequest.open('GET',ticketaddress, true);
	ourRequest.onload=function()
	{
		//alert(ourRequest.responseText);
		$('#outputTickets').val(ourRequest.responseText);

	};
	ourRequest.send(); 
}