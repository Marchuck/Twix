package org.kotlin.mpp.mobile.com.marchuck.insta.data

import kotlinx.coroutines.Deferred
import org.kotlin.mpp.mobile.com.marchuck.insta.domain.model.PokemonResponse

interface GetPokedexApi {

    suspend fun getStories() : Deferred<PokemonResponse>
}