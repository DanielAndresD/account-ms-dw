package models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class account {
    @Id
    private String username;
    private Integer reservacion;
    private Date lastChange;

    public account(String username, Integer reservacion, Date lastChange) {
        this.username = username;
        this.reservacion = reservacion;
        this.lastChange = lastChange;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getReservacion() {
        return reservacion;
    }

    public void setReservacion(Integer reservacion) {
        this.reservacion = reservacion;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}
