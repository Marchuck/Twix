package org.kotlin.mpp.mobile.com.marchuck.insta.domain

import kotlinx.coroutines.Deferred
import org.kotlin.mpp.mobile.com.marchuck.insta.data.GetPokedexApi
import org.kotlin.mpp.mobile.com.marchuck.insta.domain.model.PokemonResponse

class GetPokedexUseCase(val api: GetPokedexApi) {

    suspend fun execute(): Deferred<PokemonResponse> {
        return api.getStories()
    }
}