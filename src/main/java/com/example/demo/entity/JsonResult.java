package com.example.demo.entity;

public class JsonResult {
    private String code;
    private String msg;
    private long count;
    private int page;
    private int limit;
    private Object data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult(String code, String msg, long count, int page, int limit, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.page = page;
        this.limit = limit;
        this.data = data;
    }

    public JsonResult(String code, String msg, long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}