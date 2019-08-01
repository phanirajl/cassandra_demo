package com.idenysenko.cassandra.demo.entity;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@UserDefinedType
public class Phone {

    @NotBlank
    private String number;

    public Phone() {
    }

    public Phone(@NotBlank String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return number.equals(phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                '}';
    }
}
