package com.github.hyeyeon2371.archdemo2.data.viewmodel;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.github.hyeyeon2371.archdemo2.data.model.ListItem;

/**
 * @author Hyeyeon Park
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<String> toastEvent = new MutableLiveData<>();
    private ObservableBoolean imgVisible = new ObservableBoolean(true);

    public void onClickImageButton() {
        imgVisible.set(!imgVisible.get());
    }

    // Progress
    private int progress = 0;

    public void showProgress() {
        toastEvent.postValue("progress is " + progress);
    }

    // List
    private ObservableField<String> input = new ObservableField<>();
    private MutableLiveData<String> inputItem = new MutableLiveData<>();

    public void onClickInputButton() {
        if (input.get() != null && input.get().isEmpty())
            toastEvent.postValue("Text is Empty");
        else
            inputItem.postValue(input.get());
    }

    public void onClickListItem(ListItem item) {
        toastEvent.postValue("position:" + item.getPosition() + "   text: " + item.getText());
    }

    // Checkbox
    private ObservableBoolean isChecked = new ObservableBoolean(false);

    public void onChecked(boolean checked) {
        isChecked.set(checked);
        toastEvent.postValue(checked ? "checked!!" : "unchecked!!");
    }

    ////


    public MutableLiveData<String> getToastEvent() {
        return toastEvent;
    }

    public void setToastEvent(MutableLiveData<String> toastEvent) {
        this.toastEvent = toastEvent;
    }

    public ObservableBoolean getImgVisible() {
        return imgVisible;
    }

    public void setImgVisible(ObservableBoolean imgVisible) {
        this.imgVisible = imgVisible;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public ObservableField<String> getInput() {
        return input;
    }

    public void setInput(ObservableField<String> input) {
        this.input = input;
    }

    public MutableLiveData<String> getInputItem() {
        return inputItem;
    }

    public void setInputItem(MutableLiveData<String> inputItem) {
        this.inputItem = inputItem;
    }

    public ObservableBoolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(ObservableBoolean isChecked) {
        this.isChecked = isChecked;
    }
}