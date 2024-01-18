package com.foxxx.japanesecandlesticktradingcharts.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.foxxx.japanesecandlesticktradingcharts.ui.theme.JapaneseCandlestickTradingChartsTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JapaneseCandlestickTradingChartsTheme {
                val viewModel = TerminalViewModel()
                val screenState = viewModel.state.collectAsState()

                when(val currentState = screenState.value) {
                    is TerminalScreenState.Content -> {
                        Log.d("MainActivity", currentState.barList.toString())
                    }

                    is TerminalScreenState.Initial -> {

                    }
                }
            }
        }
    }
}



