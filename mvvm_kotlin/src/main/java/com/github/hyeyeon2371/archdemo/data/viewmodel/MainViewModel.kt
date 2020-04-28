package com.github.hyeyeon2371.archdemo.data.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.hyeyeon2371.archdemo.data.model.ListItem

/**
 * @author Hyeyeon Park
 */
class MainViewModel : ViewModel() {
    var toastEvent = MutableLiveData<String>()

    // ImageView Visibility
    var imgVisible = ObservableBoolean(true)

    fun onClickImageButton() = imgVisible.set(!imgVisible.get())

    // Progress
    var progress = 0

    fun showProgress() = toastEvent.postValue("progress is $progress")

    // List
    var input = ObservableField<String>()
    var inputItem = MutableLiveData<String>()
    fun onClickInputButton() {
        if (input.get().isNullOrEmpty())
            toastEvent.postValue("Text is Empty")
        else
            inputItem.postValue(input.get())
    }
    fun onClickListItem(item : ListItem){
        toastEvent.postValue("position: ${item.position}    text: ${item.text}")
    }

    // Checkbox
    var isChecked = ObservableBoolean(false)

    fun onChecked(checked: Boolean) {
        isChecked.set(checked)

        val msg = if (checked) "checked!!" else "unchecked!!"
        toastEvent.postValue(msg)
    }

}