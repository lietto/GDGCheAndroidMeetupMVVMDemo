package com.example.mvvm.retrofit;

import android.databinding.BaseObservable;

import com.example.mvvm.BR;
import com.example.mvvm.weather.WeatherRealm;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class WeatherViewModel extends BaseObservable implements OrderedRealmCollectionChangeListener<RealmResults<WeatherRealm>>,
		RealmChangeListener<CityInfoRealm> {

		@Override
		public void onChange(RealmResults<WeatherRealm> weatherRealms, OrderedCollectionChangeSet changeSet) {
			notifyPropertyChanged(BR._all);
		}

		@Override
		public void onChange(CityInfoRealm cityInfo) {
			notifyPropertyChanged(BR.toolbarTitle);
//			notifyPropertyChanged(BR.conditionIcon);
		}
	}