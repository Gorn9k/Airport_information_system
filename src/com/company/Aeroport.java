package com.company;

import java.util.*;

public class Aeroport {

    List<Airplane> a;
    List<Flight> f;
    List<Attachment> at;
    List<Errors> er;
    private String name;
    private String city_name;
    private String weather_at_departure;

    Aeroport(String name, String city_name, String weather_at_departure) {
        this.name = name;
        this.city_name = city_name;
        this.weather_at_departure = weather_at_departure;
        a = new ArrayList();
        f = new ArrayList();
        at = new ArrayList();
        er = new ArrayList();
    }

    public void addAirplane(Airplane airplane) {
        a.add(airplane);
    }

    public void addFlight(Flight flight) {
        f.add(flight);
    }

    public String getInfo_aboutFlight(int index) {
        --index;
        for (int i = 0; i < at.size(); i++) {
            if (index == at.get(i).getAttachment_numF()) {
                index = i;
                break;
            }

        }

        return ("Рейс №" + f.get(at.get(index).getAttachment_numF()).getNumber() + " по пути " + f.get(at.get(index).getAttachment_numF()).getDeparture_point() + "-"
                + f.get(at.get(index).getAttachment_numF()).getLanding_place() + " будет выполнен " + f.get(at.get(index).getAttachment_numF()).getDay_of_month() + "."
                + f.get(at.get(index).getAttachment_numF()).getMonth() + "." + f.get(at.get(index).getAttachment_numF()).getYear() + " в " + f.get(at.get(index).getAttachment_numF()).getHour()
                + ":" + f.get(at.get(index).getAttachment_numF()).getMinute() + " самолетом " + a.get(at.get(index).getAttachment_numA()).getName() + " вместимостью " + a.get(at.get(index).getAttachment_numA()).getCapacity() + " с дальностью полета "
                + a.get(at.get(index).getAttachment_numA()).getRange_of_flight() + " км.");

    }

    public String form_a_flight(int num_a, int num_f) {
        --num_a;
        --num_f;
        Errors errors = new Errors();
        if (a.get(num_a).getAttachment() == false && f.get(num_f).getAttachment() == false) {
            Attachment attachment = new Attachment(num_a, num_f);
            attachment.setAttachment_numA(num_a);
            attachment.setAttachment_numF(num_f);
            at.add(attachment);
            a.get(num_a).setAttachment(true);
            f.get(num_f).setAttachment(true);
            er.add(errors);
            return ("Ваш рейс №" + (num_f + 1) + " успешно сформирован.");
        } else if (a.get(num_a).getAttachment() == true && f.get(num_f).getAttachment() == true) {
            errors.setError_a(true);
            errors.setError_f(true);
            er.add(errors);
            return ("Этот рейс уже был сформирован. Этот самолет уже закреплен за другим рейсом.");
        } else if (f.get(num_f).getAttachment() == true) {
            errors.setError_f(true);
            er.add(errors);
            return ("Этот рейс уже был сформирован.");
        } else if (a.get(num_a).getAttachment() == true) {
            errors.setError_a(true);
            er.add(errors);
            return ("Этот самолет уже закреплен за другим рейсом.");
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_name() {
        return this.city_name;
    }

    public void setWeather_at_departure(String weather_at_departure) {
        this.weather_at_departure = weather_at_departure;
    }

    public String getWeather_at_departure() {
        return this.weather_at_departure;
    }

}
