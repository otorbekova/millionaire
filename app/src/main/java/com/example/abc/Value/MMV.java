package com.example.abc.Value;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MMV extends ViewModel {
    public MutableLiveData<Integer> mResult = new MutableLiveData();// изменение

    public void plus() {
        if (mResult.getValue() == null) {
            mResult.setValue(0);
        }
        mResult.setValue(mResult.getValue() + 100);
    }
}
