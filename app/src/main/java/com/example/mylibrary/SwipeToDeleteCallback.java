package com.example.mylibrary;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {

    private AbstractAdapter mAdapter;

    public SwipeToDeleteCallback(AbstractAdapter adapter) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        mAdapter = adapter;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.removeItem(viewHolder.getAdapterPosition());
    }
}

abstract class AbstractAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    abstract void removeItem(int index);
}

