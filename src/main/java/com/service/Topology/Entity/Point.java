package com.service.Topology.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Point {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "xPosition")
    private String xposition;
    @JacksonXmlProperty(localName = "yPosition")
    private String yposition;
    @JacksonXmlProperty(localName = "zPosition")
    private String zposition;
    @JacksonXmlProperty(localName = "vehicleOrientationAngle")
    private String vehicleorientationangle;
    @JacksonXmlProperty(localName = "type")
    private String type;

    @Override
    public String toString() {
        return "Point{" +
                ", name='" + name + '\'' +
                ", xposition='" + xposition + '\'' +
                ", yposition='" + yposition + '\'' +
                ", zposition='" + zposition + '\'' +
                ", vehicleorientationangle='" + vehicleorientationangle + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
