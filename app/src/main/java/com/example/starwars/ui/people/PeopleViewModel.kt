package com.example.starwars.ui.people

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import com.example.starwars.data.error.CallbackWrapper
import com.example.starwars.data.people.PeopleRepository
import com.example.starwars.data.people.objects.People
import com.example.starwars.data.people.objects.PeopleListResponse
import com.example.starwars.ui.common.BaseViewModel
import kotlinx.coroutines.launch

class PeopleViewModel(application: Application): BaseViewModel(application), LifecycleObserver {
    var people = MutableLiveData<List<People>>()

    fun getPeople(refresh: Boolean) {
        if (refresh) {
            isLoading.value = true
        }

        noDataAvailable.value = false
        people.value = emptyList()

        viewModelScope.launch {
            val peopleResponse = PeopleRepository.getPeople()

            val result =
                object: CallbackWrapper<PeopleListResponse>(this@PeopleViewModel, peopleResponse) {
                    override fun onSuccess(data: PeopleListResponse) {
                        people.value = data
                        isLoading.value = false
                        isRefreshing.value = false
                        data.let {
                            if (it.isEmpty()) {
                                noDataAvailable.value = true
                            }
                        }
                    }

                }
        }
    }

    override fun onError(message: String?, validationErrors: Map<String, ArrayList<String>>?) {
        isLoading.value = false
        isRefreshing.value = false
        people.value = arrayListOf()
    }

    fun onRefresh() {
        getPeople(refresh = false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        getPeople(true)
    }
}