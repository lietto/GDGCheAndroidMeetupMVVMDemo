package com.example.mvvm;

import android.databinding.BaseObservable;

import com.example.mvvm.weather.WeatherCaller;
import com.example.mvvm.weather.WeatherDAO;
import com.example.mvvm.weather.WeatherRealm;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmResults;

public class WeatherViewModel extends BaseObservable implements OrderedRealmCollectionChangeListener<RealmResults<WeatherRealm>> {
	private final WeatherDAO weatherDAO;
	private final WeatherCaller weatherCaller;

	public WeatherViewModel() {
		weatherDAO = new WeatherDAO();
		weatherCaller = new WeatherCaller(weatherDAO);
	}

	public void onResume() {
		weatherDAO.addChangeListener(this);
	}

	public void onPause() {
		weatherDAO.clearListeners();
	}

	@Override
	public void onChange(RealmResults<WeatherRealm> weatherRealms, OrderedCollectionChangeSet changeSet) {
		notifyPropertyChanged(BR._all);
	}



}
