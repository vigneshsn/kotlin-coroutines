package com.vigneshsn

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        measureTime {
            println("Current thread ${Thread.currentThread().name}")
            val stocks = async {  getStocks() }
            val price = async { getStockPrice() }

            println(stocks)
            println(price)
            println(stocks.await())
            println(price.await())
        }
    }
    Thread.sleep(3000)
}

fun delay() {
    Thread.sleep(1000)
}

fun getStockPrice(): Int {
    println("getStockPrice Current thread ${Thread.currentThread().name}")
    delay()
    return 1234
}

fun getStocks(): String {
    println("getStocks Current thread ${Thread.currentThread().name}")
    delay()
    return "google"
}

suspend fun measureTime(block : suspend () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("timetaken to execute ${end - start}")
}