package com.centroid.slassessment.entity;

import jakarta.persistence.*;
import net.postgis.jdbc.geometry.Polygon;

@Entity
@Table(name = "dfw_demo")
public class CensusPolygon {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "income")
    private int income;
    @Column(name = "population")
    private int population;
    @Column(name = "`SpatialObj`")
    private Polygon spatialObj;

    public CensusPolygon() {
    }

    public CensusPolygon(Integer income, int population, Polygon spatialObj) {
        this.income = income;
        this.population = population;
        this.spatialObj = spatialObj;
    }

    public long getId() {
        return id;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Polygon getSpatialObj() {
        return spatialObj;
    }

    public void setSpatialObj(Polygon spatialObj) {
        this.spatialObj = spatialObj;
    }

    public String toString() {
        return "censusPolygon ["
                + "id=" + id
                + ", income=" + income
                + ", population=" + population
                + ", Polygon=" + spatialObj + "]";
    }
}
