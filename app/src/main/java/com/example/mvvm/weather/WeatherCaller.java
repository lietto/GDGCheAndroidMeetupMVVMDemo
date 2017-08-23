package com.example.mvvm.weather;

import android.util.Log;

import com.example.mvvm.retrofit.RetrofitService;
import com.example.mvvm.retrofit.Weather;
import com.example.mvvm.retrofit.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lietto on 28.05.17.
 */

public class WeatherCaller implements Callback<Weather> {

	private final WeatherDAO weatherDAO;

	public WeatherCaller(WeatherDAO repository) {
		this.weatherDAO = repository;
	}

	public void getWeatherForCity(final String city) {
		WeatherService service = RetrofitService.get().create(WeatherService.class);
		service.getWeather(city).enqueue(this);
	}

	@Override
	public void onResponse(Call<Weather> call, Response<Weather> response) {
		if (response.isSuccessful())
			weatherDAO.saveCityWeatherToRealm(response.body());
	}

	@Override
	public void onFailure(Call<Weather> call, Throwable t) {
		Log.e("Retrofit", "onFailure: " + t.getLocalizedMessage());
	}
}
