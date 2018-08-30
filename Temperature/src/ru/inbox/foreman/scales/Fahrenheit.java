package ru.inbox.foreman.scales;

import ru.inbox.foreman.support.TemperaturesScales;

public class Fahrenheit implements TemperaturesScales {

    @Override
    public double convertToCelsius(double temperature) {
        return (temperature - 32.0) * 5/9;
    }

    @Override
    public double convertFromCelsius(double temperature) {
        return temperature * 9 / 5 + 32.0;
    }
    @Override
    public String getScaleName() {
        return "Фаренгейт";
    }
}
