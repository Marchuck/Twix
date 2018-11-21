package org.kotlin.mpp.mobile.com.marchuck.insta.view.home

import org.kotlin.mpp.mobile.com.marchuck.insta.domain.model.PokeEntry

sealed class HomeViewState {

    object Loading : HomeViewState()

    data class Content(val response: List<PokeEntry>) : HomeViewState()

    data class Error(val errorMessage: String) : HomeViewState()
}