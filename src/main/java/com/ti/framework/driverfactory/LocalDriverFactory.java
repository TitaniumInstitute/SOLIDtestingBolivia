package com.ti.framework.driverfactory;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;

import java.util.Set;

//Open/Close
public class LocalDriverFactory implements DriverFactory{
    private static LocalDriverFactory instance = new LocalDriverFactory();

    public static LocalDriverFactory getInstance(){
        return instance;
    }

    ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();

    /**
     * Method to get the driver object and launch the browser
     * @return
     */
    @Override
    public synchronized WebDriver getDriver(){
        return drivers.get();
    }

    /**
     * Method to set the driver object and select the browser
     * @param browser
     * @return
     */
    @SneakyThrows
    @Override
    public void setDriver(String browser) {
        Set<Class<? extends IDriver>> driverInterfaces = new Reflections(IDriver.class).getSubTypesOf(IDriver.class);

        for (var driverManager:driverInterfaces) {
            if (driverManager.getName().contains(browser)){
                drivers.set((WebDriver) driverManager.getMethod("createDriver").invoke(Class.forName(driverManager.getName()).getConstructor().newInstance()));
            }
        }

        drivers.get().manage().window().maximize();
    }

    /**
     * Method to quits the driver and closes the browser
     */
    @Override
    public void removeDriver(){
        if (null != drivers.get()) {
            try {
                drivers.get().quit();
                drivers.remove();
            } catch (Exception e) {
                System.err.println("Unable to gracefully quit WebDriver." + e);
            }
        }
    }
}
