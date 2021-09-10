package com.company;

public class Airplane {

    private String name;
    private String technical_issues;
    private int capacity;
    private int range_of_flight;
    private boolean attachment = false;

    Airplane(String name, String technical_issues, int capacity, int range_of_flight) {
        this.name = name;
        this.technical_issues = technical_issues;
        this.capacity = capacity;
        this.range_of_flight = range_of_flight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTechnical_issues(String technical_issues) {
        this.technical_issues = technical_issues;
    }

    public String getTechnical_issues() {
        return this.technical_issues;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setRange_of_flight(int range_of_flight) {
        this.range_of_flight = range_of_flight;
    }

    public int getRange_of_flight() {
        return this.range_of_flight;
    }

    public void setAttachment(boolean attachment) {
        this.attachment = attachment;
    }

    public boolean getAttachment() {
        return this.attachment;
    }

}
