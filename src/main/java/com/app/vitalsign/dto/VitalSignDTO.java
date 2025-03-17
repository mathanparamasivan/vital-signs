package com.app.vitalsign.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Objects;

public class VitalSignDTO {

    private Long id;

    @NotNull(message = "Pulse cannot be null")
    @Positive(message = "Pulse must be a positive number")
    private Integer pulse;

    @NotBlank(message = "Blood pressure cannot be blank")
    private String bloodPressure;  // Example: "120/80"

    @NotNull(message = "Temperature cannot be null")
    @Positive(message = "Temperature must be a positive number")
    private Double temperature;

    @NotNull(message = "Respiration rate cannot be null")
    @Positive(message = "Respiration rate must be a positive number")
    private Integer respirations;

    @NotNull(message = "Blood sugar level cannot be null")
    @Positive(message = "Blood sugar level must be a positive number")
    private Double bloodSugar;

    @NotNull(message = "Weight cannot be null")
    @Positive(message = "Weight must be a positive number")
    private Double weight;

    @NotNull(message = "Height cannot be null")
    @Positive(message = "Height must be a positive number")
    private Double height;

    @Min(value = 0, message = "SpO2 cannot be below 0%")
    @Max(value = 100, message = "SpO2 cannot be above 100%")
    private Integer spo2Sat;  // Oxygen saturation (0-100%)

    @NotNull(message = "PT/INR cannot be null")
    @Positive(message = "PT/INR must be a positive number")
    private Double ptInr;

    private LocalDateTime recordedAt;// Timestamp when recorded

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VitalSignDTO that = (VitalSignDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(pulse, that.pulse) && Objects.equals(bloodPressure, that.bloodPressure) && Objects.equals(temperature, that.temperature) && Objects.equals(respirations, that.respirations) && Objects.equals(bloodSugar, that.bloodSugar) && Objects.equals(weight, that.weight) && Objects.equals(height, that.height) && Objects.equals(spo2Sat, that.spo2Sat) && Objects.equals(ptInr, that.ptInr) && Objects.equals(recordedAt, that.recordedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pulse, bloodPressure, temperature, respirations, bloodSugar, weight, height, spo2Sat, ptInr, recordedAt);
    }

    @Override
    public String toString() {
        return "VitalSignDTO{" +
                "id=" + id +
                ", pulse=" + pulse +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", temperature=" + temperature +
                ", respirations=" + respirations +
                ", bloodSugar=" + bloodSugar +
                ", weight=" + weight +
                ", height=" + height +
                ", spo2Sat=" + spo2Sat +
                ", ptInr=" + ptInr +
                ", recordedAt=" + recordedAt +
                '}';
    }
}
