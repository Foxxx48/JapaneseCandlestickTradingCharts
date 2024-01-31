package com.foxxx.japanesecandlesticktradingcharts.presentation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.foxxx.japanesecandlesticktradingcharts.data.Bar
import kotlinx.parcelize.Parcelize
import kotlin.math.roundToInt

@Parcelize
data class TerminalState(
    val barsList: List<Bar>,
    val visibleBarsCount: Int = 100,
    val terminalWidth: Float = 0f,
    val scrolledBy: Float = 0f
) : Parcelable {
    val barWidth: Float
        get() = terminalWidth / visibleBarsCount

    val visibleBars: List<Bar>
        get() {
            val startIndex = (scrolledBy / barWidth).roundToInt().coerceAtLeast(0)
            val endIndex = (startIndex + visibleBarsCount).coerceAtMost(barsList.size)
            return barsList.subList(startIndex, endIndex)
        }
}

@Composable
fun rememberTerminalState(bars: List<Bar>): MutableState<TerminalState> {
    return rememberSaveable {
        mutableStateOf(TerminalState(bars))
    }
}
