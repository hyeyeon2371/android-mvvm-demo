package com.github.hyeyeon2371.archdemo2.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.github.hyeyeon2371.archdemo2.R;
import com.github.hyeyeon2371.archdemo2.data.model.ListItem;
import com.github.hyeyeon2371.archdemo2.data.viewmodel.MainViewModel;
import com.github.hyeyeon2371.archdemo2.databinding.ItemListBinding;
import com.github.hyeyeon2371.archdemo2.view.activity.MainActivity;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {
    private ArrayList<ListItem> list = new ArrayList<>();

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(ListItem item) {
        this.list.add(item);
        notifyItemInserted(getItemCount() - 1);
    }

    class Holder extends RecyclerView.ViewHolder {
        private ItemListBinding binding;

        private Holder(ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(ListItem item) {
            item.setPosition(getAdapterPosition());
            binding.setItem(item);

            ViewModelProvider viewModelProvider = new ViewModelProvider((MainActivity) binding.getRoot().getContext());
            MainViewModel viewModel = viewModelProvider.get(MainViewModel.class);
            binding.setViewModel(viewModel);
        }

    }
}
