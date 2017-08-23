package com.example.mvvm.weather;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityWeatherBinding;

public class WeatherActivity extends AppCompatActivity {

	private WeatherViewModel weatherViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		ActivityWeatherBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_weather);

		binding.setViewModel(weatherViewModel = new WeatherViewModel());

		setSupportActionBar(binding.toolbar);

	}

	@Override
	protected void onResume() {
		super.onResume();
		weatherViewModel.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		weatherViewModel.onPause();
	}
}
