package com.idenysenko.cassandra.demo.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("journal")
public class Journal {

    @Column
    private UUID id;

    @NotNull
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID clientId;

    @NotBlank
    @Column
    private String callerPhone;

    @NotBlank
    @Column
    private String recipientPhone;

    @FutureOrPresent
    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private LocalDateTime createDate;

    @NotNull
    @Column
    private Duration callDuration;

    @Column
    private City city;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getCallerPhone() {
        return callerPhone;
    }

    public void setCallerPhone(String callerPhone) {
        this.callerPhone = callerPhone;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Duration getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Duration callDuration) {
        this.callDuration = callDuration;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", client_id=" + clientId +
                ", callerPhone='" + callerPhone + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", createDate=" + createDate +
                ", callDuration=" + callDuration +
                ", city=" + city +
                '}';
    }
}
