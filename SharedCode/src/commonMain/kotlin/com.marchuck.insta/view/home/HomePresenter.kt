package com.marchuck.insta.view.home

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kotlin.mpp.mobile.com.marchuck.insta.domain.ErrorRecognizer
import org.kotlin.mpp.mobile.com.marchuck.insta.domain.GetPokedexUseCase
import org.kotlin.mpp.mobile.com.marchuck.insta.view.home.HomeView
import org.kotlin.mpp.mobile.com.marchuck.insta.view.home.HomeViewState
import kotlin.coroutines.CoroutineContext

class HomePresenter(val getStoriesUseCase: GetPokedexUseCase,
                    val uiContext: CoroutineContext,
                    val errorRecognizer: ErrorRecognizer) {


    var view: HomeView? = null

    fun requestPokes() {

        view?.render(HomeViewState.Loading)

        GlobalScope.launch(uiContext) {
            try {
                getStoriesUseCase.execute().await().let { pokemonResponse ->

                    val entries = pokemonResponse.results

                    view?.render(HomeViewState.Content(entries))
                }
            } catch (someException: Exception) {
                view?.render(HomeViewState.Error(ErrorRecognizer.recognize(someException)))
            }
        }
    }
}