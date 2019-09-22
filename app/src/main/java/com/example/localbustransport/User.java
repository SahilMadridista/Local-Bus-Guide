package com.example.localbustransport;

public class User {

    private String BusStopNumber;
    private String BusStopName;

    public User(){

    }

    public User(String busStopNumber, String busStopName) {
        BusStopNumber = busStopNumber;
        BusStopName = busStopName;
    }

    public String getBusStopNumber() {
        return BusStopNumber;
    }

    public String getBusStopName() {
        return BusStopName;
    }

    public void setBusStopNumber(String busStopNumber) {
        BusStopNumber = busStopNumber;
    }

    public void setBusStopName(String busStopName) {
        BusStopName = busStopName;
    }
}
