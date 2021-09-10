package com.company;

public class Team {

    private String pilot1;
    private String pilot2;
    private String radio_operator;
    private String stewadress1;
    private String stewadress2;
    private String stewadress3;
    private String navigator;
    private boolean attachment = false;

    Team(String... team) {
        try {
            this.pilot1 = team[0];
        } catch (Throwable e) {
            this.pilot1 = "-";
        }
        try {
            this.pilot2 = team[1];
        } catch (Throwable e) {
            this.pilot2 = "-";
        }
        try {
            this.radio_operator = team[2];
        } catch (Throwable e) {
            this.radio_operator = "-";
        }
        try {
            this.navigator = team[3];
        } catch (Throwable e) {
            this.navigator = "-";
        }

        try {
            this.stewadress1 = team[4];
        } catch (Throwable e) {
            this.stewadress1 = "-";
        }
        try {
            this.stewadress2 = team[5];
        } catch (Throwable e) {
            this.stewadress2 = "-";
        }
        try {
            this.stewadress3 = team[6];
        } catch (Throwable e) {
            this.stewadress3 = "-";
        }

    }

    public void setPilot1(String pilot1) {
        this.pilot1 = pilot1;
    }

    public String getPilot1() {
        return this.pilot1;
    }

    public void setPilot2(String pilot2) {
        this.pilot2 = pilot2;
    }

    public String getPilot2() {
        return this.pilot2;
    }

    public void setRadio_operator1(String radio_operator) {
        this.radio_operator = radio_operator;
    }

    public String getRadio_operator1() {
        return this.radio_operator;
    }

    public void setNavigator(String navigator) {
        this.navigator = navigator;
    }

    public String getNavigator() {
        return this.navigator;
    }

    public void setStewadress1(String stewadress1) {
        this.stewadress1 = stewadress1;
    }

    public String getStewadress1() {
        return this.stewadress1;
    }

    public void setStewadress2(String stewadress2) {
        this.stewadress2 = stewadress2;
    }

    public String getStewadress2() {
        return this.stewadress2;
    }

    public void setStewadress3(String stewadress3) {
        this.stewadress3 = stewadress3;
    }

    public String getStewadress3() {
        return this.stewadress3;

    }

    public void setAttachment(boolean attachment) {
        this.attachment = attachment;
    }

    public boolean getAttachment() {
        return this.attachment;
    }

}
