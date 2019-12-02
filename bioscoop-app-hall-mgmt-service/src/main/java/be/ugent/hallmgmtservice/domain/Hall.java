package be.ugent.hallmgmtservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Document //MongoDB
public class Hall {

    @Id
    private String id;
    private String name;
    private List<Row> rows;
    private String screenSize;
    private List<String> facilities;
    private List<String> technologies;

    public Hall(String name, List<Row> rows, String screenSize, List<String> facilities, List<String> technologies) {
        this.name = name;
        this.rows = rows;
        this.screenSize = screenSize;
        this.facilities = facilities;
        this.technologies = technologies;
    }

    public Hall(String name, List<Row> rows, String screenSize){
        this.name = name;
        this.rows = rows;
        this.screenSize = screenSize;
        this.facilities = Arrays.asList("toegankelijk voor andersvaliden", "test");
        this.technologies = Arrays.asList("Dolby 5.1", "HFR");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }
}

