package com.mahmudul.rickandmortyapi.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahmudul.rickandmortyapi.domain.models.ResultById
import com.mahmudul.rickandmortyapi.domain.use_cases.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private var compositeDisposable = CompositeDisposable()
    private val _newCharacterDetail = MutableLiveData<ResultById>()
    val newCharacterDetail: LiveData<ResultById> = _newCharacterDetail

    fun getCharacterById(id: Int?) {
        val disposable = id?.let { characterId ->
            getCharacterByIdUseCase(characterId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ character ->
                    _newCharacterDetail.value = character
                }, {
                    Log.e("TAG", "Не удалось получить персонажа")
                })
        }
        disposable.let {
            if (it != null) {
                compositeDisposable.add(it)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
