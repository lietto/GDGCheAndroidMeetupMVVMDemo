package com.example.mvvm.weather;

import com.example.mvvm.retrofit.Weather;

import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by lietto on 28.05.17.
 */

public class WeatherRepository {

	private final Realm realmInstane;
	private final RealmResults<WeatherRealm> weatherRealm;

	public WeatherRepository() {
		realmInstane = Realm.getDefaultInstance();
		weatherRealm = realmInstane.where(WeatherRealm.class).findAll();
	}

	public void addChangeListener(OrderedRealmCollectionChangeListener<RealmResults<WeatherRealm>> listener) {
		weatherRealm.addChangeListener(listener);
	}
	public void clearListeners() {
		weatherRealm.removeAllChangeListeners();
	}


	public void saveCityWeatherToRealm(final Weather body) {
		realmInstane.executeTransactionAsync(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				WeatherRealm weatherRealm = new WeatherRealm(body);
				realm.insertOrUpdate(weatherRealm);
			}
		});
	}


	public String getTemperatureIn(String s) {
		WeatherRealm w = weatherRealm.where().equalTo("city", s).findFirst();
		return w == null || !w.isValid() ? "--" : String.valueOf(w.getTemperature());
	}

	public String getWeatherConditionsIn(String s) {
		WeatherRealm w = weatherRealm.where().equalTo("city", s).findFirst();
		return w == null || !w.isValid() ? "--" : w.getWeatherConditions();
	}

	public void onDestroy() {realmInstane.close();}
}
