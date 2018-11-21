package org.kotlin.mpp.mobile.com.marchuck.insta.domain

class ErrorRecognizer() {

    fun recognize(t: Throwable): String {

        if (t is NullPointerException) {
            return "Something is null"
        }
        return t.message ?: "Unknown error"
    }

}