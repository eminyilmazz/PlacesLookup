package com.emin.placeslookup.model;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
public class Location {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "latitude")
    private String lat;

    @Column(name = "longitude")
    private String lng;

    @Column(name = "created_date")
    @CreatedDate
    private String createdDate;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
