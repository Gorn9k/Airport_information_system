package com.company;

public class Flight {

    private String departure_point;
    private String landing_place;
    private int day_of_month;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int range_of_flight;
    private int number;
    private boolean attachment = false;

    Flight(int number, String departure_point, String landing_place, int day_of_month, int month, int year, int hour, int minute, int range_of_flight) {

        this.number = number;
        this.departure_point = departure_point;
        this.landing_place = landing_place;
        this.day_of_month = day_of_month;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.range_of_flight = range_of_flight;
    }

    public void setDeparture_point(String departure_point) {
        this.departure_point = departure_point;
    }

    public String getDeparture_point() {
        return this.departure_point;
    }

    public void setLanding_place(String landing_place) {
        this.landing_place = landing_place;
    }

    public String getLanding_place() {
        return this.landing_place;
    }

    public void setDay_of_month(int day_of_month) {
        this.day_of_month = day_of_month;
    }

    public int getDay_of_month() {
        return this.day_of_month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return this.month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return this.hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setRange_of_flight(int range_of_flight) {
        this.range_of_flight = range_of_flight;
    }

    public int getRange_of_flight() {
        return this.range_of_flight;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setAttachment(boolean attachment) {
        this.attachment = attachment;
    }

    public boolean getAttachment() {
        return this.attachment;
    }

}
