package com.example.mvvm.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lietto on 28.05.17.
 */

public interface WeatherService {
		@GET("data/2.5/weather?units=metric&APPID=e27b6679afa6807ee2cabe55d0f14629&lang=ua")
		Call<Weather> getWeather(@Query("q") String city);
}
