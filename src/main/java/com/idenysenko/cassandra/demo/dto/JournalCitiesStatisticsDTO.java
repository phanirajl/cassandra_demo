package com.idenysenko.cassandra.demo.dto;

import com.idenysenko.cassandra.demo.entity.City;

public class JournalCitiesStatisticsDTO {

    private City city;
    private int calls;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }

    @Override
    public String toString() {
        return "JournalCitiesStatisticsDTO{" +
                "city=" + city +
                ", calls=" + calls +
                '}';
    }
}
