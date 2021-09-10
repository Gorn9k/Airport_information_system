package com.company;

public class Dispatcher {

    private String name;

    private boolean problem = false;

    Dispatcher(String name) {
        this.name = name;
    }

    String report_a_problem(int index, String weather_at_departure, Airplane airplane, int range_of_flight) {
        if (weather_at_departure.equals("bad") || !airplane.getTechnical_issues().equals("no") || airplane.getRange_of_flight() < range_of_flight) {
            this.problem = true;
        }
        if (this.problem == false) {
            return ("Рейс №" + index + " может быть выполнен.");
        } else if (weather_at_departure.equals("bad")) {
            return ("Рейс №" + index + " не может быть выполнен. Причиной для этого стала плохая погода.");
        } else if (!airplane.getTechnical_issues().equals("no")) {
            return ("Рейс №" + index + " не может быть выполнен. Причиной для этого стали технические неисправности рода: "
                    + airplane.getTechnical_issues() + ".");
        } else if (airplane.getRange_of_flight() < range_of_flight) {
            return ("Рейс №" + index + " не может быть выполнен. Причина: недостаточно дальности полета.");
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setProblem(Boolean problem) {
        this.problem = problem;
    }

    public Boolean getProblem() {
        return this.problem;
    }
}
