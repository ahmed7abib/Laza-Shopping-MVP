package com.example.laza

import androidx.lifecycle.ViewModel
import com.example.common.SingleMutableLiveData

class LazaSharedViewModel : ViewModel() {

    private var _hideUnNecessaryView = SingleMutableLiveData<Boolean?>()
    val hideUnNecessaryView get() = _hideUnNecessaryView

    fun hideUnNecessaryView(value: Boolean?) {
        _hideUnNecessaryView.value = value
    }
}
