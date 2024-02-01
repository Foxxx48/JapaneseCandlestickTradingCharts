package com.foxxx.japanesecandlesticktradingcharts.presentation

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.parcelize.Parcelize

@Composable
fun Test() {
    var testData1 by rememberSaveable(saver = TestData1.Saver) {
        mutableStateOf(TestData1(0, "Text"))
    }

    var testData by rememberSaveable(saver = TestData.Saver) {
        mutableStateOf(TestData(0))
    }

    var number by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Box(
            modifier = Modifier

                .clickable { testData = testData.copy(number = testData.number + 1) },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "TextData: $testData")
        }

        Box(
            modifier = Modifier

                .clickable { testData1 = testData1.copy(number = testData1.number + 1) },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "TextData1: $testData1")
        }

        Box(
            modifier = Modifier

                .clickable { number++},
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Number: $number")
        }
    }


}

data class TestData1(val number: Int, val text: String) {

    companion object {

        val Saver: Saver<MutableState<TestData1>, Any> = listSaver(
            save = {
                val testData = it.value
                listOf(testData.number, testData.text)
            },
            restore = {
                val testData = TestData1(
                    number = it[0] as Int,
                    text = it[1] as String
                )
                mutableStateOf(testData)
            }
        )
    }
}

@Parcelize
data class TestData(val number: Int) : Parcelable {

    companion object {

        val Saver: Saver<MutableState<TestData>, Int> = Saver(
            save = {
                it.value.number

            },
            restore = {
                mutableStateOf(TestData(it))
            }
        )
    }
}