package com.vigneshsn


class Sample{
    fun main() {
        println("Current thread ${Thread.currentThread().name}")
        val start = System.currentTimeMillis()
        getStocks()
        getStockPrice()
        val end = System.currentTimeMillis()
        println("timetaken to execute ${end - start}")
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
}
