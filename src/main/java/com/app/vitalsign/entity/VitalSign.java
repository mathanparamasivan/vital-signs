package com.app.vitalsign.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class VitalSign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pulse;            // Heartbeat per minute
    private String bloodPressure;     // Example: "120/80"
    private Double temperature;       // In Celsius or Fahrenheit
    private Integer respirations;     // Breaths per minute
    private Double bloodSugar;        // mg/dL
    private Double weight;            // kg or lbs
    private Double height;            // cm or inches
    private Integer spo2Sat;          // Oxygen saturation (0-100%)
    private Double ptInr;             // Prothrombin Time / INR (Clotting rate)

    private LocalDateTime recordedAt; // Timestamp when recorded

    @PrePersist
    protected void onCreate() {
        recordedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getRespirations() {
        return respirations;
    }

    public void setRespirations(Integer respirations) {
        this.respirations = respirations;
    }

    public Double getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Double bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getSpo2Sat() {
        return spo2Sat;
    }

    public void setSpo2Sat(Integer spo2Sat) {
        this.spo2Sat = spo2Sat;
    }

    public Double getPtInr() {
        return ptInr;
    }

    public void setPtInr(Double ptInr) {
        this.ptInr = ptInr;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}
