package com.jetbrains.jonnyzzz.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import org.kotlin.mpp.mobile.DependencyManager
import org.kotlin.mpp.mobile.com.marchuck.insta.view.home.HomeView
import org.kotlin.mpp.mobile.com.marchuck.insta.view.home.HomeViewState
import org.kotlin.mpp.mobile.createApplicationScreenMessage

class MainActivity : AppCompatActivity(), HomeView {

    val presenter = DependencyManager.getProvider().homePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.main_text).text = createApplicationScreenMessage()

        presenter.view = this

        presenter.requestPokes()
    }

    override fun render(state: HomeViewState) {
        when (state) {
            is HomeViewState.Loading -> {
                printOut("loading")
            }
            is HomeViewState.Content -> {
                printOut("content ${state.response.size}")
            }
            is HomeViewState.Error -> {
                printOut("error ${state.errorMessage}")
            }
        }
    }

    private fun printOut(s: String) {
        Log.d("MainActivity", s)
    }
}
