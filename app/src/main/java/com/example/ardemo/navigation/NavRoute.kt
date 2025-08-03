package com.example.ardemo.navigation

import kotlinx.serialization.Serializable


@Serializable
object HomeScreen

@Serializable
data class ARScreen(val model: String)

@Serializable
object ProtoScreen

@Serializable
object AboutScreen