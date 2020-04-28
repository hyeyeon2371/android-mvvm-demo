package com.github.hyeyeon2371.archdemo.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.hyeyeon2371.archdemo.data.viewmodel.MainViewModel
import com.github.hyeyeon2371.archdemo.R
import com.github.hyeyeon2371.archdemo.databinding.ActivityMainBinding
import com.github.hyeyeon2371.archdemo.view.adapter.ListAdapter
import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.github.hyeyeon2371.archdemo.data.model.ListItem

/**
 * @author Hyeyeon Park
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.toastEvent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })


        setList()

        binding.viewModel = viewModel
    }

    private fun setList() {
        binding.recyclerView.adapter = ListAdapter()
        viewModel.inputItem.observe(this, Observer { input ->
            if (binding.recyclerView.adapter == null)
                binding.recyclerView.adapter = ListAdapter()

            val newItem = ListItem(text = input)
            (binding.recyclerView.adapter as ListAdapter).addItem(newItem)
            hideKeyboard()
        })
    }

    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.editText.windowToken, 0)
    }
}
