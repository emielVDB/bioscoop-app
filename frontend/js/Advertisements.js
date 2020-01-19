
var baseIp="http://127.0.0.1";
var ScheduleServiceAdr=baseIp+":3000/schedule/";
var AdvertisementServiceAdr=baseIp+":3000/advertisement/";


function GETScheduleByDay() {
	var date=$('#inputScheduleByDayDate').val();	

	var ourRequest=new XMLHttpRequest();
	ourRequest.open('GET',ScheduleServiceAdr+date, true);
	ourRequest.onload=function()
	{
		//alert(ourRequest.responseText);
		$('#outputGetSchedule').val(ourRequest.responseText);

	};
	ourRequest.send(); 
}



function POSTRemoveSchedule() {
	var eventId=$('#inputRemoveScheduleId').val();	

	var ourRequest=new XMLHttpRequest();
	ourRequest.open('POST',ScheduleServiceAdr+'remove', true);
	ourRequest.setRequestHeader("Content-type", "application/json");

	ourRequest.onload=function()
	{
		//alert(ourRequest.responseText);
		$('#outputRemoveSchedule').val(ourRequest.responseText);
	};
	
	var json=JSON.stringify({ "eventId": eventId });
	
	ourRequest.send(json); 
}



function POSTAddSchedule() {
	var eventBeginDate=$('#inputAddScheduleBeginDate').val();	
	var eventEndDate=$('#inputAddScheduleEndDate').val();	
	var eventHallNummer=$('#inputAddScheduleHallNummer').val();	
	var eventType=$('#inputAddScheduleEventType').val();	
	var eventMediaId=$('#inputAddScheduleMediaId').val();	




	
	var ourRequest=new XMLHttpRequest();
	ourRequest.open('POST',ScheduleServiceAdr+'add', true);
	ourRequest.setRequestHeader("Content-type", "application/json");

	ourRequest.onload=function()
	{
		//alert(ourRequest.responseText);
		$('#outputAddSchedule').val(ourRequest.responseText);
	};
	
	var json=JSON.stringify({ "beginDate": eventBeginDate, "endDate": eventEndDate , "zaalNmr": eventHallNummer , "eventType": eventType , "mediaId": eventMediaId });
	
	ourRequest.send(json); 
}



function POSTAddAdvertisement() {
	var mediaId=$('#inputAddAdvertisementMediaId').val();	
	if(mediaId=="")
		mediaId=-1;
	
	
	var AdvertisementSlotId=$('#inputAddAdvertisementAdvertisementSlotId').val();	
	

	var ourRequest=new XMLHttpRequest();
	ourRequest.open('POST',AdvertisementServiceAdr+'add', true);
	ourRequest.setRequestHeader("Content-type", "application/json");

	ourRequest.onload=function()
	{
		//alert(ourRequest.responseText);
		$('#outputAddAdvertisement').val(ourRequest.responseText);
	};
	
	var json=JSON.stringify({
		"mediaId":mediaId,
		"advertisementSlots":
		{
			"advertisementId":AdvertisementSlotId
		}
	});
	
	ourRequest.send(json); 
}





function POSTRemoveAdvertisement() {
	var id=$('#inputRemoveAdvertisementId').val();	
		

	var ourRequest=new XMLHttpRequest();
	ourRequest.open('POST',AdvertisementServiceAdr+'remove', true);
	ourRequest.setRequestHeader("Content-type", "application/json");

	ourRequest.onload=function()
	{
		//alert(ourRequest.responseText);
		$('#outputRemoveAdvertisement').val(ourRequest.responseText);
	};
	
	var json=JSON.stringify({
		"id":id
	});
	
	ourRequest.send(json); 
}


