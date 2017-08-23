package com.example.mvvm.list;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm.BR;
import com.example.mvvm.databinding.ListItemProgressBinding;

import java.util.ArrayList;

import io.realm.OrderedRealmCollection;

/**
 * Created by lietto on 30.05.17.
 */

public class ExampleListAdapter extends RealmRecyclerViewAdapter<ProgressRealmObject, ExampleListAdapter.ExampleListViewHolder> {

	private final ExampleProgressRepository repository;
	private ArrayMap<Long, ItemViewModel> viewModels = new ArrayMap<>();

	public ExampleListAdapter(ExampleProgressRepository repository) {
		super(repository.getExampleList(), true);
		this.repository = repository;
	}

	@Override
	public ExampleListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ExampleListViewHolder(ListItemProgressBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
	}

	@Override
	public void onBindViewHolder(ExampleListViewHolder holder, int position) {
		ItemViewModel itemViewModel = viewModels.get(getItem(position).getId());
		if (itemViewModel == null) {
			itemViewModel = new ItemViewModel(getItem(position), repository);
			viewModels.put(getItem(position).getId(), itemViewModel);
		}
		holder.bind(itemViewModel);
	}

	@Override
	protected void rangeRemoved(int startIndex, int length) {

		super.rangeRemoved(startIndex, length);
	}

	@Override
	protected void rangeChanged(int startIndex, int length) {
		ProgressRealmObject object = null;
		for (int i = startIndex; i < startIndex+length; i++) {
			object = getItem(i);
			if (object != null && object.isValid()) {
				if (object.getProgress() >= 0 && object.getProgress() <= 100) {
					viewModels.get(object.getId()).notifyPropertyChanged(BR.progress);
				}
			}
		}
	}


	public static class ExampleListViewHolder extends RecyclerView.ViewHolder {

		ListItemProgressBinding binding;

		public ExampleListViewHolder(ListItemProgressBinding b) {
			super(b.getRoot());
			binding = b;
		}

		public void bind(ItemViewModel vm) {
			binding.setViewModel(vm);
			binding.executePendingBindings();
		}
	}

}
