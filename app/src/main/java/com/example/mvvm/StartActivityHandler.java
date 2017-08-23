package com.example.mvvm;

import android.content.Intent;
import android.view.View;

import com.example.mvvm.list.ProgressActivity;

/**
 * Created by lietto on 23.08.17.
 */

public class StartActivityHandler {


	public void onStartProgressClick(View view) {
		view.getContext().startActivity(new Intent(view.getContext(), ProgressActivity.class));
	}


	public void onStartWeatherClick(View view) {
		view.getContext().startActivity(new Intent(view.getContext(), ProgressActivity.class));
	}

}
