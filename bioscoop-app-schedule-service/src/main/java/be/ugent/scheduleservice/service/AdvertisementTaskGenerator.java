package be.ugent.scheduleservice.service;

import be.ugent.scheduleservice.persistence.ScheduleRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AdvertisementTaskGenerator {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Value("${advertisement.url}")
    private String advertisementUrl;

    public String getAdvertisementUrl(){
        return advertisementUrl;
    }

    public String PostAdvertisementSlots(String eventId, String seconds){
        final String uri = getAdvertisementUrl();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header=new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        JSONObject personJsonObject=new JSONObject();

        try {
            personJsonObject.put("eventId",eventId);
            personJsonObject.put("seconds",seconds);

            HttpEntity<String> request=new HttpEntity<String>(personJsonObject.toString(),header);

            String result = restTemplate.postForObject(uri,request, String.class);
            return result;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}