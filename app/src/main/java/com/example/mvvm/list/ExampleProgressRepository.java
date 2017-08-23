package com.example.mvvm.list;

import android.util.Log;

import java.util.Random;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;

/**
 * Created by lietto on 30.05.17.
 */

public class ExampleProgressRepository {

	private final Realm mainInstance;

	public ExampleProgressRepository() {
		mainInstance = Realm.getDefaultInstance();
	}

	public void updateProgress(final int progress, final long id) {
		mainInstance.executeTransactionAsync(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				ProgressRealmObject object = realm.where(ProgressRealmObject.class).equalTo("id", id).findFirst();

				if (object != null) {
					object.setProgress(progress);
				}
			}
		});
	}

	public OrderedRealmCollection<ProgressRealmObject> getExampleList() {
		return mainInstance.where(ProgressRealmObject.class).findAll();
	}

	public void addItemToList() {
		Log.e("ExampleProgress", "addItemToList");
		mainInstance.executeTransactionAsync(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				ProgressRealmObject object = new ProgressRealmObject();
				object.setId(new Random().nextInt(Integer.MAX_VALUE));
				object.setProgress(0);
				object.setName("Item N." + object.getId());
				realm.insertOrUpdate(object);
				Log.e("ExampleProgress", "addItemToList: " + object.getId());
			}
		});
	}

	public void deleteItem(final long id) {
		mainInstance.executeTransactionAsync(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				ProgressRealmObject object = realm.where(ProgressRealmObject.class).equalTo("id", id).findFirst();

				if (object != null) {
					object.deleteFromRealm();
				}
			}
		});
	}
}
