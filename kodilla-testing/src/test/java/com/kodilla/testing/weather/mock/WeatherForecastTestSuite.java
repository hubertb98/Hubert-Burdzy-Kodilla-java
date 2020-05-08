package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Mockito.*;

public class WeatherForecastTestSuite {

    @Test
    public void testCalculateForecastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        HashMap<Integer, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put(4, 19.4);
        temperaturesMap.put(0, 26.2);
        temperaturesMap.put(1, 23.1);
        temperaturesMap.put(2, 15.6);
        temperaturesMap.put(3, 24.8);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }
}
