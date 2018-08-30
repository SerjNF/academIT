package ru.inbox.foreman.support;

public interface TemperaturesScales {

    public double convertToCelsius(double temperature);

    public double convertFromCelsius(double temperature);

    public String getScaleName();

}
