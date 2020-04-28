package com.github.hyeyeon2371.archdemo2.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.github.hyeyeon2371.archdemo2.R;
import com.github.hyeyeon2371.archdemo2.data.model.ListItem;
import com.github.hyeyeon2371.archdemo2.data.viewmodel.MainViewModel;
import com.github.hyeyeon2371.archdemo2.databinding.ActivityMainBinding;
import com.github.hyeyeon2371.archdemo2.view.adapter.ListAdapter;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = (new ViewModelProvider(this)).get(MainViewModel.class);

        viewModel.getToastEvent().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        setList();

        binding.setViewModel(viewModel);
    }

    private void setList() {
        binding.recyclerView.setAdapter(new ListAdapter());
        viewModel.getInputItem().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String input) {
                if (binding.recyclerView.getAdapter() == null)
                    binding.recyclerView.setAdapter(new ListAdapter());


                ListItem newItem = new ListItem(input);
                ((ListAdapter) binding.recyclerView.getAdapter()).addItem(newItem);
                hideKeyboard();
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(binding.editText.getWindowToken(), 0);
    }
}
