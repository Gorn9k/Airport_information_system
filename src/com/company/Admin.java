package com.company;

import java.util.*;

public class Admin {

    List<Team> t;
    List<Attachment> at;
    List<Errors> er;
    private String name;

    Admin(String name) {

        t = new ArrayList();
        at = new ArrayList();
        er = new ArrayList();
        this.name = name;
    }

    public void addTeam(Team team) {
        t.add(team);
    }

    public String getInfo_aboutTeam(int index) {
        int index1 = index;
        --index;
        for (int i = 0; i < at.size(); i++) {
            if (index == at.get(i).getAttachment_numF()) {
                index = i;
                break;
            }

        }
        return ("Во время полета по рейсу №" + index1 + " вас будут сопровождать: Первый пилот: "
                + t.get(at.get(index).getAttachment_numT()).getPilot1() + ", Второй пилот: " + t.get(at.get(index).getAttachment_numT()).getPilot2() + ", Радист: "
                + t.get(at.get(index).getAttachment_numT()).getRadio_operator1() + ", Штурман: " + t.get(at.get(index).getAttachment_numT()).getNavigator() + ", Стюардесса(ы): "
                + t.get(at.get(index).getAttachment_numT()).getStewadress1() + ", " + t.get(at.get(index).getAttachment_numT()).getStewadress2() + ", " + t.get(at.get(index).getAttachment_numT()).getStewadress3() + ".");

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String bind_team(int num_t, int index, boolean airplane, boolean flight) {
        --num_t;
        --index;
        Errors errors = new Errors();
        if (t.get(num_t).getAttachment() == false) {
            Attachment attachment = new Attachment(num_t);
            attachment.setAttachment_numT(num_t);
            attachment.setAttachment_numF(index);
            t.get(num_t).setAttachment(true);
            at.add(attachment);
            er.add(errors);
            if (airplane != true && flight != true) {
                return ("Ваша летная бригада успешно закреплена за рейсом №" + (index + 1) + ".");
            }
        } else {

            errors.setError_T(true);
            er.add(errors);
            if (airplane != true && flight != true) {
                return ("Эта летная бригада уже закреплена за другим самолетом.");
            }
        }
        return ("Невозможно закрепить летную бригаду.");
    }
}
