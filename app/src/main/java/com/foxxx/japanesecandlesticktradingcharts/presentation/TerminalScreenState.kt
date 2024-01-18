package com.foxxx.japanesecandlesticktradingcharts.presentation

import com.foxxx.japanesecandlesticktradingcharts.data.Bar

sealed interface TerminalScreenState {

    object Initial : TerminalScreenState

    data class Content(val barList: List<Bar>) : TerminalScreenState
}