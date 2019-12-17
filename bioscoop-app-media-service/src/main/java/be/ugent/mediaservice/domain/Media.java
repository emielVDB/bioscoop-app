package be.ugent.mediaservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Document(collection = "media") //MongoDB
public class Media {

    @Id
    private String id;
    @Indexed
    private String title;
    private HashMap<String, Object> properties;

    public Media(){}

    public Media(String id, String title, HashMap<String, Object> properties) {
        this.id = id;
        this.title = title;
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }
}

