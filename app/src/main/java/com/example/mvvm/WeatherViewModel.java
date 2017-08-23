package com.example.mvvm;

import android.databinding.BaseObservable;

import com.example.mvvm.weather.WeatherCaller;
import com.example.mvvm.weather.WeatherRepository;
import com.example.mvvm.weather.WeatherRealm;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmResults;

public class WeatherViewModel extends BaseObservable implements OrderedRealmCollectionChangeListener<RealmResults<WeatherRealm>> {
	private final WeatherRepository weatherRepository;
	private final WeatherCaller weatherCaller;

	public WeatherViewModel() {
		weatherRepository = new WeatherRepository();
		weatherCaller = new WeatherCaller(weatherRepository);
	}

	public void onResume() {
		weatherRepository.addChangeListener(this);
	}

	public void onPause() {
		weatherRepository.clearListeners();
	}

	@Override
	public void onChange(RealmResults<WeatherRealm> weatherRealms, OrderedCollectionChangeSet changeSet) {
		notifyPropertyChanged(BR._all);
	}



}
