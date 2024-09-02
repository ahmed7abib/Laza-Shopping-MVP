package com.example.laza

import androidx.lifecycle.ViewModel
import com.example.common.SingleMutableLiveData

class LazaSharedViewModel : ViewModel() {

    private var _hideUnNecessaryView = SingleMutableLiveData<Boolean?>()

    var hideUnNecessaryView: SingleMutableLiveData<Boolean?>
        get() = _hideUnNecessaryView
        set(value) {
            _hideUnNecessaryView.value = value.value
        }
}
