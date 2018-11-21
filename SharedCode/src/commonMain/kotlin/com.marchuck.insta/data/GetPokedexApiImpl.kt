package org.kotlin.mpp.mobile.com.marchuck.insta.data

import com.marchuck.insta.data.ExpectSuccess
import com.marchuck.insta.data.JsonKotlinxSerializer
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.http.takeFrom
import kotlinx.coroutines.Deferred
import org.kotlin.mpp.mobile.com.marchuck.insta.domain.model.PokemonResponse


class GetPokedexApiImpl : GetPokedexApi {

    val endPoint = "https://pokeapi.co/api/v2/"


    private val client = HttpClient {
        install(JsonFeature) {
            serializer = JsonKotlinxSerializer().apply {
                setMapper<PokemonResponse>(PokemonResponse.serializer())
            }
        }
        install(ExpectSuccess)
    }


    override suspend fun getStories(): Deferred<PokemonResponse> {
        return client.get {
            url {
                takeFrom(endPoint)
                path("pokemon")
            }
        }
    }
}