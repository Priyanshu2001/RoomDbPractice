package com.prbansal.roomdbpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.prbansal.roomdbpractice.bahikhata.UserData;
import com.prbansal.roomdbpractice.databinding.ItemRecyclerViewBinding;

import java.util.List;

public class WordAdapter extends ListAdapter<UserData, WordAdapter.WordViewHolder> {
    Context context;

    public WordAdapter(@NonNull WordDiff diffCallback, Context context) {
        super(diffCallback);
        this.context = context;
    }


    @NonNull
    @Override
    public WordAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerViewBinding binding = ItemRecyclerViewBinding.inflate(LayoutInflater.from(context),parent,false);
        return new WordViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        UserData current = getItem(position);
        holder.b.textView.setText(position + ". " + current.name + " (unique id :- " + current.uniqueID + ")");
    }



    public class WordViewHolder extends RecyclerView.ViewHolder {
        ItemRecyclerViewBinding b;

        public WordViewHolder(@NonNull ItemRecyclerViewBinding b) {
            super(b.getRoot());
            this.b = b;
        }
    }
    static class WordDiff extends DiffUtil.ItemCallback<UserData> {

        @Override
        public boolean areItemsTheSame(@NonNull UserData oldItem, @NonNull UserData newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull UserData oldItem, @NonNull UserData newItem) {
            return oldItem.name.equals(newItem.name);
        }
    }
}
