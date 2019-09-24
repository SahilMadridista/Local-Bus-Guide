package com.example.localbustransport;

public class City {

    private String Stop_1;
    private String Stop_2;
    private String Stop_3;
    private String Stop_4;
    private String Stop_5;

    public City() {

    }

    public City(String stop_1, String stop_2, String stop_3, String stop_4, String stop_5) {
        this.Stop_1 = stop_1;
        this.Stop_2 = stop_2;
        this.Stop_3 = stop_3;
        this.Stop_4 = stop_4;
        this.Stop_5 = stop_5;
    }

    public String getStop_1() {
        return Stop_1;
    }

    public void setStop_1(String stop_1) {
        this.Stop_1 = stop_1;
    }

    public String getStop_2() {
        return Stop_2;
    }

    public void setStop_2(String stop_2) {
        this.Stop_2 = stop_2;
    }

    public String getStop_3() {
        return Stop_3;
    }

    public void setStop_3(String stop_3) {
        this.Stop_3 = stop_3;
    }

    public String getStop_4() {
        return Stop_4;
    }

    public void setStop_4(String stop_4) {
        this.Stop_4 = stop_4;
    }

    public String getStop_5() {
        return Stop_5;
    }

    public void setStop_5(String stop_5) {
        this.Stop_5 = stop_5;
    }

}
