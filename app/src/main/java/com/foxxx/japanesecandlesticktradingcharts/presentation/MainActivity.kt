package com.foxxx.japanesecandlesticktradingcharts.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.foxxx.japanesecandlesticktradingcharts.ui.theme.JapaneseCandlestickTradingChartsTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JapaneseCandlestickTradingChartsTheme {
                val viewModel: TerminalViewModel = viewModel()
                val screenState = viewModel.state.collectAsState()

                when(val currentState = screenState.value) {

                    is TerminalScreenState.Content -> {
                        Terminal(bars = currentState.barList)
                        Log.d("TAG", "TerminalScreenState.Content: ")
                    }

                    is TerminalScreenState.Initial -> {
                        Log.d("TAG", "TerminalScreenState.Initial: ")
                    }
                }
            }
        }
    }
}



