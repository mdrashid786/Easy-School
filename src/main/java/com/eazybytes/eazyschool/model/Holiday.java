package com.eazybytes.eazyschool.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="holidays")
public class Holiday extends BaseEntity {

    @Id
    private String day;

    private String reason;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }

	public String getDay() {
		return day;
	}

	public String getReason() {
		return reason;
	}

	public Type getType() {
		return type;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setType(Type type) {
		this.type = type;
	}

	
}
