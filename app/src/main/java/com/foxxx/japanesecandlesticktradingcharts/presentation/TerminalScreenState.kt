package com.foxxx.japanesecandlesticktradingcharts.presentation

import com.foxxx.japanesecandlesticktradingcharts.data.Bar

sealed class TerminalScreenState {

    object Initial : TerminalScreenState()

    object Loading : TerminalScreenState()

    data class Content(val barList: List<Bar>, val timeFrame: TimeFrame) : TerminalScreenState()
}