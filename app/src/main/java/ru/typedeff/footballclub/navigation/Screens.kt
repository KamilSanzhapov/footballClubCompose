package ru.typedeff.footballclub.navigation



sealed class Screen(val screenName: String) {
    object Main: Screen("main")
    object Settings: Screen("settings")
    object Area: Screen("area")
    object Competition: Screen("competition")
}