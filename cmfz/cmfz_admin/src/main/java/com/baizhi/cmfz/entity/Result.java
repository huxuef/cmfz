package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Result implements Serializable {

    private Integer errno;
    private String[] data;

    public Result() {
    }

    public Result(Integer errno, String[] data) {
        this.errno = errno;
        this.data = data;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "errno=" + errno +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
