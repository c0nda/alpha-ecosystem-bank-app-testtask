package com.listener.bankapp.presentation.requesthistotyscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.listener.bankapp.domain.models.BankCardHistory
import com.listener.bankapp.domain.usecase.GetHistoryRequestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RequestHistoryViewModel @Inject constructor(
    private val getHistoryRequestUseCase: GetHistoryRequestUseCase
) : ViewModel() {

    private val _history: MutableStateFlow<List<BankCardHistory>> = MutableStateFlow(emptyList())
    val history = _history.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _history.value = getHistoryRequestUseCase.execute()
        }
    }
}