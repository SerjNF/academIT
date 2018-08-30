package ru.inbox.foreman.model;

import ru.inbox.foreman.scales.Celsius;
import ru.inbox.foreman.scales.Fahrenheit;
import ru.inbox.foreman.scales.Kelvin;
import ru.inbox.foreman.support.TemperaturesScales;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс конвертор температуры.
 * Для добавления новых шкал необходимо создать новый класс шкалы,
 * реализовать в нем методы интерфейса TemperaturesScales,
 * добавить новый класс в метод fillScales()
 *
 * @author SergeyNF
 * @version 1.1
 * @since 30.08.18
 */
public class ConvertTemperature {
    private List<TemperaturesScales> scales;

    public ConvertTemperature() {
        this.scales = new ArrayList<>();
        fillScales();
    }

    public String[] getScaleName() {
        String[] resArray = new String[scales.size()];
        for (int i = 0; i < scales.size(); i++) {
            resArray[i] = scales.get(i).getScaleName();
        }
        return resArray;
    }

    public String convertTemp(int selectedInputScale, int selectedResultScale, String inputTemp) {
        double convertedTemp;
        try {
            convertedTemp = Double.parseDouble(inputTemp);
        } catch (Exception e) {
            return null;
        }

        double tempInCelsius = scales.get(selectedInputScale).convertToCelsius(convertedTemp);
        double tempResult = scales.get(selectedResultScale).convertFromCelsius(tempInCelsius);

        String resultString = String.valueOf(tempResult);
        int endSubstring = resultString.indexOf('.');
        int numCharAfter = 3;

        return resultString.substring(0, endSubstring + numCharAfter > resultString.length() ? resultString.length() : endSubstring + numCharAfter);
    }

    //добавление новых шкал
    private void fillScales() {
        scales.add(new Celsius());
        scales.add(new Fahrenheit());
        scales.add(new Kelvin());
    }
}
