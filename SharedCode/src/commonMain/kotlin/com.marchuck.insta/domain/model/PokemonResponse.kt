package org.kotlin.mpp.mobile.com.marchuck.insta.domain.model

import kotlinx.serialization.Serializable

@Serializable
open class PokemonResponse(val count: Int, val results: List<PokeEntry>)