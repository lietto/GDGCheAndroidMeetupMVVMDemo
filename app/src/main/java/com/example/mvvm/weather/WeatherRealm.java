package com.example.mvvm.weather;

import com.example.mvvm.retrofit.Weather;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by lietto on 28.05.17.
 */
@RealmClass
public class WeatherRealm extends RealmObject{

	@PrimaryKey
	private String city;

	private double temperature;
	private String weatherConditions;
	private String icon;

	public WeatherRealm() {
	}

	public WeatherRealm(Weather weather) {
		setCity(weather.getName());
		setTemperature(weather.getMain().getTemp());
		setWeatherConditions(weather.getWeather().get(0).getDescription());
		setIcon("http://openweathermap.org/img/w/" + weather.getWeather().get(0).getIcon() + ".png");
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getWeatherConditions() {
		return weatherConditions;
	}

	public void setWeatherConditions(String weatherConditions) {
		this.weatherConditions = weatherConditions;
	}
}
