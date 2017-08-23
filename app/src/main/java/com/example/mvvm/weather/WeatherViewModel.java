package com.example.mvvm.weather;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.mvvm.BR;
import com.example.mvvm.ObservableString;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmResults;

/**
 * Created by lietto on 28.05.17.
 */

public class WeatherViewModel extends BaseObservable implements OrderedRealmCollectionChangeListener<RealmResults<WeatherRealm>> {

	private final WeatherCaller weatherCaller;
	private final WeatherRepository weatherRepository;
	public ObservableString searchCity = new ObservableString("Cherkasy");

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

	@Bindable
	public String getToolbarTitle() {
		return "Weather in " + searchCity.get();
	}

	@Bindable
	public String getTemperature() {
		return weatherRepository.getTemperatureIn(searchCity.get());
	}

	@Bindable
	public String getWeatherConditions() {
		return weatherRepository.getWeatherConditionsIn(searchCity.get());
	}

	@Bindable
	public String getCity() {
		return searchCity.get();
	}

	public void onRefreshClick(String city) {
		notifyPropertyChanged(BR._all);
		weatherCaller.getWeatherForCity(city);
	}

	@Override
	public void onChange(RealmResults<WeatherRealm> weatherRealms, OrderedCollectionChangeSet changeSet) {
		notifyPropertyChanged(BR._all);
	}

	public boolean onTouch() {
		return true;
	}





}
