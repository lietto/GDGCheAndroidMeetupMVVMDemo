package com.example.mvvm.list;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by lietto on 30.05.17.
 */

public class ItemViewModel extends BaseObservable {

	private final ProgressRealmObject object;
	private final ExampleProgressRepository repository;
	private Handler handler = new Handler();

	public ItemViewModel(ProgressRealmObject object, ExampleProgressRepository repository) {
		this.object = object;
		this.repository = repository;
	}

	@Bindable
	public int getProgress() {
		if (object == null || !object.isValid()) {
			return 0;
		}
		return object.getProgress();
	}

	public String getName() {
		if (object == null || !object.isValid()) {
			return "";
		}
		return object.getName();
	}

	public void startProgress() {
		handler.post(runnable);
	}

	public void clearProgress() {
		repository.updateProgress(0, object.getId());
	}

	public void deleteItem() {
		repository.deleteItem(object.getId());
	}

	private Runnable runnable = new Runnable() {
		@Override
		public void run() {

			repository.updateProgress(getProgress() + 10, object.getId());

			if (getProgress() <= 100)
				handler.postDelayed(runnable, 1000);
		}
	};

}

