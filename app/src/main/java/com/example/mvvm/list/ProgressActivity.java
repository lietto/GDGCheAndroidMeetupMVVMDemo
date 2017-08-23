package com.example.mvvm.list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityProgressBinding;
import com.example.mvvm.databinding.ActivityWeatherBinding;
import com.example.mvvm.weather.WeatherViewModel;

/**
 * Created by lietto on 30.05.17.
 */

public class ProgressActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActivityProgressBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_progress);

		binding.setViewModel(new ListWithProgressViewModel());

//		setSupportActionBar(binding.toolbar);
	}
}
