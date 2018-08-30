package ru.inbox.foreman.scales;

import ru.inbox.foreman.support.TemperaturesScales;

public class Celsius implements TemperaturesScales {

    @Override
    public double convertToCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double convertFromCelsius(double temperature) {
        return temperature;
    }
    @Override
    public String getScaleName() {
        return "Цельсия";
    }
}
