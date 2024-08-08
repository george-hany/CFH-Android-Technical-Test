package com.core.utils

fun String?.isInputEmpty(): Boolean {
    return this == null || this.trim().isEmpty()
}

fun String?.isEmailValid(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this ?: "").matches()
}

fun String?.isAgeValid(): Boolean {
    return (this?.toIntOrNull() ?: 0) >= 18
}

fun String?.isPasswordValid(): Boolean {
    val regex = Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*\\W).{8,}$")
    return regex.matches(this ?: "")
}