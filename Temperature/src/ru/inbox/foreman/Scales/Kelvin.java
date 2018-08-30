package ru.inbox.foreman.Scales;

import ru.inbox.foreman.support.TemperaturesScales;

public class Kelvin implements TemperaturesScales {
    @Override
    public double convertToCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double convertFromCelsius(double temperature) {
        return temperature + 273.15;
    }

    @Override
    public String getScaleName() {
        return "Кельвин";
    }
}
