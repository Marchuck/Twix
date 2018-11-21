package org.kotlin.mpp.mobile.com.marchuck.insta.domain.model

import kotlinx.serialization.Serializable


@Serializable
open class PokeEntry(val name: String,
                     val url: String)