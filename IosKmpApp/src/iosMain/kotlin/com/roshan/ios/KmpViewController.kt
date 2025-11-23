package com.roshan.ios

import androidx.compose.ui.window.ComposeUIViewController
import com.roshan.core.ui.App
import com.roshan.feature.login.Greeting

fun KmpViewController() = ComposeUIViewController(
    configure = { enforceStrictPlistSanityCheck = false }
) { App(Greeting().greet()) }

