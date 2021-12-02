package com.example.account.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class reservacion {
    @Id
    private String id;
    private String usernameUbOrigin;
    private String usernameUbHotel;
    private Integer value;
    private Date date;

    public reservacion(String id, String usernameUbOrigin, String usernameUbHotel, Integer value, Date date) {
        this.id = id;
        this.usernameUbOrigin = usernameUbOrigin;
        this.usernameUbHotel = usernameUbHotel;
        this.value = value;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsernameUbOrigin() {
        return usernameUbOrigin;
    }

    public void setUsernameUbOrigin(String usernameUbOrigin) {
        this.usernameUbOrigin = usernameUbOrigin;
    }

    public String getUsernameUbHotel() {
        return usernameUbHotel;
    }

    public void setUsernameUbHotel(String usernameUbHotel) {
        this.usernameUbHotel = usernameUbHotel;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
