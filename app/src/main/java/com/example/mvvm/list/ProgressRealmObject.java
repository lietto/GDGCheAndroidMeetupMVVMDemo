package com.example.mvvm.list;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by lietto on 30.05.17.
 */
@RealmClass
public class ProgressRealmObject extends RealmObject {

	@PrimaryKey
	private long id;
	private String name;
	private int progress;

	public ProgressRealmObject(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
}
