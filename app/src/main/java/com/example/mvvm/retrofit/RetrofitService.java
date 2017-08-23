package com.example.mvvm.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by lietto on 28.05.17.
 */

public class RetrofitService {

	public static Retrofit get() {
		return new Retrofit.Builder()
				.baseUrl("http://api.openweathermap.org/")
				.addConverterFactory(JacksonConverterFactory.create())
				.build();
	}

}
