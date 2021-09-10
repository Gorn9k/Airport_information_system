package com.company;

import java.util.Scanner;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner s_a = new Scanner(new File("airplanes.txt")).useDelimiter(" *;");
        Scanner s_f = new Scanner(new File("flights.txt")).useDelimiter(" *;");
        Scanner s_t = new Scanner(new File("teams.txt")).useDelimiter(" *;");
        Scanner s_for_calendar = new Scanner(new File("calendar.txt")).useDelimiter(" *;");
        BufferedReader br = null;
        File file = new File("newFile.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (PrintWriter pw = new PrintWriter(file)) {
            br = new BufferedReader(new FileReader("newFile.txt"));
            Scanner in = new Scanner(System.in);
            int quantity_a, quantity_f, quantity_t;
            try {
                System.out.print("Введите кол-во самолетов, которые хотите создать: ");
                quantity_a = in.nextInt();
                System.out.print("Введите кол-во рейсов, которые хотите создать: ");
                quantity_f = in.nextInt();
                System.out.print("Введите кол-во команд, которые хотите создать: ");
                quantity_t = in.nextInt();
            } catch (Throwable e) {
                pw.println("Некорректно введено число. Повторите попытку.");
                pw.close();
                String line = br.readLine();
                System.out.println(line);
                return;
            }
            Aeroport aeroport = new Aeroport("VSTU", "Vitebsk", "good");
            Admin admin = new Admin("Alexei");
            Dispatcher disp = new Dispatcher("Pavel");
            Airplane[] airplane = new Airplane[quantity_a];
            try {
                for (int i = 0; i < airplane.length; i++) {
                    if (i == 0) {
                        s_a.nextLine();
                    } else {
                        s_a.next();
                    }
                    airplane[i] = new Airplane(s_a.next(), s_a.next(), s_a.nextInt(), s_a.nextInt());
                    aeroport.addAirplane(airplane[i]);
                }
            } catch (Throwable e) {
                System.out.println("Невозможно создать такое кол-во самолетов. Причина: нехватка информации.");
                return;
            }
            Flight[] flight = new Flight[quantity_f];
            Calendar calendar = new GregorianCalendar();
            try {
                for (int i = 0; i < flight.length; i++) {
                    if (i == 0) {
                        s_f.nextLine();
                        s_for_calendar.nextLine();
                    } else {
                        s_for_calendar.next();
                        s_f.next();
                    }
                    calendar.set(Calendar.DAY_OF_MONTH, s_for_calendar.nextInt());
                    calendar.set(Calendar.MONTH, s_for_calendar.nextInt());
                    calendar.set(Calendar.YEAR, s_for_calendar.nextInt());
                    calendar.set(Calendar.HOUR_OF_DAY, s_for_calendar.nextInt());
                    calendar.set(Calendar.MINUTE, s_for_calendar.nextInt());
                    flight[i] = new Flight(s_f.nextInt(), aeroport.getCity_name(), s_f.next(), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), s_f.nextInt());
                    aeroport.addFlight(flight[i]);
                }
            } catch (Throwable e) {
                System.out.println("Невозможно создать такое кол-во рейсов. Причина: нехватка информации.");
                return;
            }
            Team[] team = new Team[quantity_t];
            try {
                for (int i = 0; i < team.length; i++) {
                    if (i == 0) {
                        s_t.nextLine();
                    } else {
                        s_t.next();
                    }
                    team[i] = new Team(s_t.next(), s_t.next(), s_t.next(), s_t.next(), s_t.next(), s_t.next(), s_t.next());
                    admin.addTeam(team[i]);
                }
            } catch (Throwable e) {
                System.out.println("Невозможно создать такое кол-во летных команд. Причина: нехватка информации.");
                return;
            }
            int[] a = new int[quantity_f];
            int numA, numF, numT;
            for (int i = 0; i < quantity_f; i++) {
                System.out.println("-------------------------------------------------------------------");
                System.out.print("Введите номер рейса, который хотите сформировать: ");
                numF = in.nextInt();
                a[i] = numF - 1;
                System.out.print("Введите номер самолета, который хотите закрепить за рейсом: ");
                numA = in.nextInt();
                System.out.print("Введите номер летной бригады, которую вы хотите закрепить за самолетом: ");
                numT = in.nextInt();
                if (numA <= aeroport.a.size() && numF <= aeroport.f.size()) {
                    pw.println(aeroport.form_a_flight(numA, numF));
                } else if (numF > aeroport.f.size() || numA > aeroport.a.size()) {
                    if (numF > aeroport.f.size()) {
                        System.out.println("Рейс, который вы хотите сформировать, не существует.");
                    }
                    if (numA > aeroport.a.size()) {
                        System.out.println("Самолет, который вы хотите закрепить за рейсом, не существует.");
                    }
                    i--;
                }
                if (numT <= admin.t.size() && numA <= aeroport.a.size() && numF <= aeroport.f.size()) {
                    pw.println(admin.bind_team(numT, numF, aeroport.er.get(i).getError_a(), aeroport.er.get(i).getError_f()));
                } else if (numT > admin.t.size()) {
                    System.out.println("Летной бригады, которую вы хотите закрепить за самолетом, не существует.");
                }
            }
            System.out.println("-------------------------------------------------------------------");
            System.out.print("Введите номер рейса, о котором вы хотите получить информацию: ");
            int index;
            try {
                index = in.nextInt();
                System.out.println("-------------------------------------------------------------------");
                for (int i = 0; i < quantity_f - 1; i++) {
                    if (a[i] == a[i + 1]) {
                        quantity_f = 1;
                    }
                }
                int search = 0;
                for (int i = 0; i < quantity_f; i++) {
                    if ((a[i] + 1) == index) {
                        search = 1;
                    }
                }
                try {
                    quantity_f = 1;
                    if ((aeroport.er.get(a[index - 1]).getError_f() == true && quantity_f != 1) || search != 1) {
                        pw.println("Рейс №" + index + " не может быть выполнен. Причина: рейс не сформирован.");
                        index = 0;
                    } else if (aeroport.er.get(a[index - 1]).getError_a() == true && quantity_f != 1) {
                        pw.println("Рейс №" + index + " не может быть выполнен. Причина: самолет не закреплен за рейсом.");
                        index = 0;
                    } else if (admin.er.get(a[index - 1]).getError_t() == true && quantity_f != 1) {
                        pw.println("Рейс №" + index + " не может быть выполнен. Причина: летная бригада не закреплена за самолетом.");
                        index = 0;
                    } else {
                        pw.println(disp.report_a_problem(index, aeroport.getWeather_at_departure(), aeroport.a.get(index - 1), aeroport.f.get(index - 1).getRange_of_flight()));
                    }
                } catch (Throwable e) {
                    pw.println("Такого рейса не существует.");
                }
                index = (disp.getProblem() == false) ? index : 0;
                if (index > 0 && index <= aeroport.f.size()) {
                    pw.println(aeroport.getInfo_aboutFlight(index));
                    pw.println(admin.getInfo_aboutTeam(index));
                }
                pw.close();
            } catch (Throwable e) {
                System.out.println("Такого рейса не существует.");
            }
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
