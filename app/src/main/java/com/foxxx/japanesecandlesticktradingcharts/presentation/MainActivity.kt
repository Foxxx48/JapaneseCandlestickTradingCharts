package com.foxxx.japanesecandlesticktradingcharts.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.foxxx.japanesecandlesticktradingcharts.ui.theme.JapaneseCandlestickTradingChartsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JapaneseCandlestickTradingChartsTheme {
                Terminal()
            }
        }
    }
}



