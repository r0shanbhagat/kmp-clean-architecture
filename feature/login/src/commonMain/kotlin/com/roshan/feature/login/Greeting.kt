package com.roshan.feature.login

import com.roshan.core.network.networkModule
import com.roshan.core.ui.uiModule
import com.roshan.data.dataModule

class Greeting {
    private val platform = featurePlatform()
    private val network = networkModule()
    private val ui = uiModule()
    private val data = dataModule()

    fun greet(): String {
        return "Feature Module: ${platform}!\n" +
                "Network Module: $network\n" +
                "UI Module: $ui\n" +
                "Data Module: $data"
    }
}