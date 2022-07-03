package com.example.demologin.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun delay(context: CoroutineContext = EmptyCoroutineContext,
          timeMillis: Long, execute: () -> Unit) {
    CoroutineScope(context).launch(context) {
        kotlinx.coroutines.delay(timeMillis)
        execute()
    }
}