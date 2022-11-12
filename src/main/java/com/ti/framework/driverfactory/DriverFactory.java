package com.ti.framework.driverfactory;

public interface DriverFactory {
    Object getDriver();
    void setDriver(String browserType);
    void removeDriver();
}
