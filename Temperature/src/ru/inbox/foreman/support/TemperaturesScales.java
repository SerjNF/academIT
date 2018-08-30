package ru.inbox.foreman.support;

public interface TemperaturesScales {

    double convertToCelsius(double temperature);

    double convertFromCelsius(double temperature);

    String getScaleName();

}
