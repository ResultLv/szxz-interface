package com.example.demo.service;

public interface MouldService {
    Object getID();

    Object getAll(String ID, int pageNum, int pageSize);

    Object getWeek(String ID, int pageNum, int pageSize);

    Object getBetween(String ID, String start, String end, int pageNum, int pageSize);

    Object getLatest(String ID, String start);

    Object getDay(String ID, int pageNum, int pageSize);

    Object getIpChanged(String ID, int pageNum, int pageSize, int latest);

    Object getRemoved(String ID, int pageNum, int pageSize, int latest);

}
