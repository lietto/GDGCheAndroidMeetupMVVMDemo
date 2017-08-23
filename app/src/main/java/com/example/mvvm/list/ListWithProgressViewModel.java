package com.example.mvvm.list;

import android.databinding.BindingAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by lietto on 30.05.17.
 */

public class ListWithProgressViewModel {

	private final ExampleProgressRepository repository;

	public ListWithProgressViewModel() {
		repository = new ExampleProgressRepository();
	}

	public ExampleListAdapter getAdapter() {
		return new ExampleListAdapter(repository);
	}

	public void addItemClick() {
		repository.addItemToList();
	}

	@BindingAdapter({"recyclerViewAdapter"})
	public static void bindAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
		recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.setHasFixedSize(true);
		recyclerView.setAdapter(adapter);
	}

}
