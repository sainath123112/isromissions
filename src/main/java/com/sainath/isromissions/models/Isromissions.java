package com.sainath.isromissions.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="isromissions")
public class Isromissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mission_name;
    private String launch_date;
    private String launch_vehicle;
    private String orbit_type;
    private String application;
    private String remarks;

    public Isromissions() {
    }

    public Isromissions(int id, String mission_name, String launch_date, String launch_vehicle, String orbit_type, String application, String remarks) {
        this.id = id;
        this.mission_name = mission_name;
        this.launch_date = launch_date;
        this.launch_vehicle = launch_vehicle;
        this.orbit_type = orbit_type;
        this.application = application;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    public String getLaunch_vehicle() {
        return launch_vehicle;
    }

    public void setLaunch_vehicle(String launch_vehicle) {
        this.launch_vehicle = launch_vehicle;
    }

    public String getOrbit_type() {
        return orbit_type;
    }

    public void setOrbit_type(String orbit_type) {
        this.orbit_type = orbit_type;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Isromissions{" +
                "id=" + id +
                ", mission_name='" + mission_name + '\'' +
                ", launch_date='" + launch_date + '\'' +
                ", launch_vehicle='" + launch_vehicle + '\'' +
                ", orbit_type='" + orbit_type + '\'' +
                ", application='" + application + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
