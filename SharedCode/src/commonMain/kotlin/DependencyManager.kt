package org.kotlin.mpp.mobile

import com.marchuck.insta.view.home.HomePresenter
import kotlinx.coroutines.Dispatchers
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton
import org.kotlin.mpp.mobile.com.marchuck.insta.data.GetPokedexApi
import org.kotlin.mpp.mobile.com.marchuck.insta.data.GetPokedexApiImpl
import org.kotlin.mpp.mobile.com.marchuck.insta.domain.ErrorRecognizer
import org.kotlin.mpp.mobile.com.marchuck.insta.domain.GetPokedexUseCase
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmStatic


class DependencyManager {

    companion object {
        val instance = DependencyManager()

        @JvmStatic
        fun getProvider(): Provider {
            return instance.provider
        }
    }

    val kodein = Kodein {

        bind<GetPokedexApi>() with singleton { GetPokedexApiImpl() }

        bind<GetPokedexUseCase>() with singleton { GetPokedexUseCase(instance()) }

        bind<ErrorRecognizer>() with singleton { ErrorRecognizer() }

        bind<CoroutineContext>() with singleton { Dispatchers.Main }

        bind<HomePresenter>() with provider { HomePresenter(instance(), instance(), instance()) }
    }

    val provider = Provider(kodein)

    class Provider(override val kodein: Kodein) : KodeinAware {
        val homePresenter: HomePresenter by instance()
    }

}