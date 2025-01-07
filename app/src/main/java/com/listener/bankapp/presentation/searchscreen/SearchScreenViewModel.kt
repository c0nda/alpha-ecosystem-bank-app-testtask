package com.listener.bankapp.presentation.searchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.domain.usecase.GetBankCardInfoUseCase
import com.listener.bankapp.utils.Request
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchScreenViewModel @Inject constructor(
    private val getBankCardInfoUseCase: GetBankCardInfoUseCase
) : ViewModel() {

    private val _bankCardInfo: MutableStateFlow<Request<BankCard>> =
        MutableStateFlow(Request.Success(BankCard()))
    val bankCardInfo: StateFlow<Request<BankCard>> = _bankCardInfo

    fun getBankCardInfoByBin(bin: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            getBankCardInfoUseCase.execute(bin).collect { request ->
                _bankCardInfo.value = request
            }
        }
    }
}