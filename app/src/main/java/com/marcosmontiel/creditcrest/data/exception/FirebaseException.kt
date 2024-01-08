package com.marcosmontiel.creditcrest.data.exception

import com.google.firebase.auth.FirebaseAuthException

class FirebaseException {
    companion object {
        fun message(e: Exception): String {
            return when (e) {
                is FirebaseAuthException -> {

                    when (e.errorCode) {
                        "ERROR_INVALID_EMAIL" -> "El correo electrónico no tiene un formato válido"

                        "ERROR_USER_NOT_FOUND" -> "El correo electrónico o la contraseña son incorrectos"

                        "ERROR_WRONG_PASSWORD" -> "El correo electrónico o la contraseña son incorrectos"

                        else -> "Se ha producido un error inesperado ${e.errorCode}"
                    }

                }

                else -> e.message ?: "Se ha producido un error inesperado"
            }
        }
    }
}