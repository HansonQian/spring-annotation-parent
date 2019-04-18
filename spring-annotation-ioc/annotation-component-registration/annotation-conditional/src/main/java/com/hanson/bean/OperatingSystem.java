package com.hanson.bean;

/**
 * 操作系统
 */
public class OperatingSystem {

    private String osName;


    public OperatingSystem() {
    }

    public OperatingSystem(String osName) {
        this.osName = osName;
    }

    @Override
    public String toString() {
        return "OperatingSystem{" +
                "osName='" + osName + '\'' +
                '}';
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }
}
