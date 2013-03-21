/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.util.Date;

/**
 *
 * @author Phanindhar Bodla
 */
public class DfuBean {

    private String DfuId;
    private String StartDate;
    private Double BaseDemand;
    private String location;
    private String DmdUnit;
    private String DmdType;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.DfuId != null ? this.DfuId.hashCode() : 0);
        hash = 41 * hash + (this.StartDate != null ? this.StartDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DfuBean other = (DfuBean) obj;
        if ((this.DfuId == null) ? (other.DfuId != null) : !this.DfuId.equals(other.DfuId)) {
            return false;
        }
        if (this.StartDate != other.StartDate && (this.StartDate == null || !this.StartDate.equals(other.StartDate))) {
            return false;
        }
        return true;
    }

    public DfuBean() {
        this.DfuId = null;
        this.StartDate = null;
        this.BaseDemand = 0.0;
        this.location = null;
        this.DmdUnit = null;
        this.DmdType = null;
    }

    public String getDfuId() {
        return DfuId;
    }

    public void setDfuId(String DfuId) {
        this.DfuId = DfuId;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public Double getBaseDemand() {
        return BaseDemand;
    }

    public void setBaseDemand(Double BaseDemand) {
        this.BaseDemand = BaseDemand;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDmdUnit() {
        return DmdUnit;
    }

    public void setDmdUnit(String DmdUnit) {
        this.DmdUnit = DmdUnit;
    }

    public String getDmdType() {
        return DmdType;
    }

    public void setDmdType(String DmdType) {
        this.DmdType = DmdType;
    }
}
