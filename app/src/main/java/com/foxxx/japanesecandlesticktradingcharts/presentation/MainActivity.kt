package com.foxxx.japanesecandlesticktradingcharts.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.foxxx.japanesecandlesticktradingcharts.ui.theme.JapaneseCandlestickTradingChartsTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JapaneseCandlestickTradingChartsTheme {

                val viewModel: TerminalViewModel = viewModel()
                val screenState = viewModel.state.collectAsState()

                when (val currentState = screenState.value) {

                    is TerminalScreenState.Content -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Gray),
                            contentAlignment = Alignment.Center,

                            ) {
                            Box(
                                modifier = Modifier
                                    .size(350.dp),
                                ) {
                                Terminal(
                                    bars = currentState.barList
                                )
                            }
                        }

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



