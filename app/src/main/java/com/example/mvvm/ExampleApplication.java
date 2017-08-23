package com.example.mvvm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by lietto on 28.05.17.
 */

public class ExampleApplication extends Application {


	@Override
	public void onCreate() {
		super.onCreate();
		Realm.init(this);
		Realm.setDefaultConfiguration(new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build());
	}
}
