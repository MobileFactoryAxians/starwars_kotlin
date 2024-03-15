package com.example.starwars.ui.people.details

import android.app.Application
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.starwars.data.error.CallbackWrapper
import com.example.starwars.data.people.PeopleRepository
import com.example.starwars.data.people.objects.People
import com.example.starwars.data.people.objects.Specie
import com.example.starwars.ui.common.BaseViewModel
import kotlinx.coroutines.launch

class PeopleDetailViewModel(application: Application): BaseViewModel(application), LifecycleObserver {
    //Mutables change things directly in the View
    var bio_born = MutableLiveData<String>().apply { value = "born" }
    var bio_species = MutableLiveData<String>().apply { value = "species" }
    var bio_gender = MutableLiveData<String>().apply { value = "gender" }
    var bio_height = MutableLiveData<String>().apply { value = "height" }
    var bio_mass = MutableLiveData<String>().apply { value = "mass" }
    var bio_homeworld = MutableLiveData<String>().apply { value = "homeworld" }
    var bio_title = MutableLiveData<String>().apply { value = "Title" }

    private fun getPeopleDetail(peopleNAME: String) {
        var species: List<Specie>
        isLoading.value = true

        viewModelScope.launch {
            val peopleResponse = PeopleRepository.getCachedPeople(peopleNAME)
            var result =
                object: CallbackWrapper<People?>(this@PeopleDetailViewModel, peopleResponse) {
                    override fun onSuccess(data: People?) {
                        if (data != null) {
                            bio_title.value = data.name
                            bio_born.value = data.birthYear
                            bio_gender.value = data.gender
                            bio_height.value = data.height
                            bio_mass.value = data.mass

                            getSpeciesDetail(data.species.get(0))
                            getHomeworldDetail(data.homeworld)

                            isLoading.value = false
                        }

                        Log.i("TAG", "--> Resposta da API")
                    }
                }
        }
    }

    private fun getSpeciesDetail(speciesURL: String) {
        viewModelScope.launch {
            val speciesResponse = PeopleRepository.getSpecie(speciesURL)
            bio_species.value = (speciesResponse.result)?.name
            isLoading.value = false
        }
    }

    private fun getHomeworldDetail(homeworldURL: String) {
        viewModelScope.launch {
            val homeworldResponse = PeopleRepository.getHomeworld(homeworldURL)
            bio_homeworld.value = (homeworldResponse.result)?.name
            isLoading.value = false
        }
    }

    override fun onError(message: String?, validationErrors: Map<String, ArrayList<String>>?) {
        isLoading.value = false
        isRefreshing.value = false
    }

    fun initialize(peopleNAME: String) {
        getPeopleDetail(peopleNAME)
    }
}