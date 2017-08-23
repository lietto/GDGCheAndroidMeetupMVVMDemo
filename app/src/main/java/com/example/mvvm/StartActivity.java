package com.example.mvvm;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mvvm.databinding.ActivityStartBinding;

/**
 * Created by lietto on 23.08.17.
 */

public class StartActivity extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActivityStartBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_start);

		binding.setHandler(new StartActivityHandler());

	}
}
