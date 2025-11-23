package com.roshan.data

import com.roshan.core.network.networkModule
import com.roshan.core.ui.uiModule

/**
 * @Details :DataGreeting
 * @Author Roshan Bhagat
 */
class DataGreeting {

    fun greetNetwork(): String {
        val network = networkModule()
        return "Network Module: $network\n"
    }

    fun greetData(): String {
        val data = dataModule()
        return "Data Module: $data"
    }

    fun greetUI(): String {
        val ui = uiModule()
        return "UI Module: $ui"
    }

    fun greetEmpty(): String {
        return "Hello Empty"
    }

    fun greet(): String {
        val network = networkModule()
        val ui = uiModule()
        val data = dataModule()

        return "Network Module: $network\n" +
                "UI Module: $ui\n" +
                "Data Module: $data"
    }
}