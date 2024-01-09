package com.marcosmontiel.creditcrest.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Help
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.marcosmontiel.creditcrest.presentation.enum.ActionSettings
import com.marcosmontiel.creditcrest.presentation.enum.ActionSettings.ACCOUNT
import com.marcosmontiel.creditcrest.presentation.enum.ActionSettings.HELP

data class Settings(
    val action: ActionSettings,
    val icon: ImageVector,
    val iconDescription: String,
    val title: String,
    val description: String,
    var click: (() -> Unit)? = null
) {
    companion object {
        fun getMainSettings(): List<Settings> {
            return listOf(
                Settings(
                    action = ACCOUNT,
                    icon = Icons.Rounded.Person,
                    iconDescription = "account settings icon",
                    title = "Cuenta",
                    description = "Notificaciones de seguridad, eliminar cuenta, cerrar sesión"
                ),
                Settings(
                    action = HELP,
                    icon = Icons.Rounded.Help,
                    iconDescription = "help settings icon",
                    title = "Ayuda",
                    description = "Centro de ayuda, contáctanos, políticas de privacidad"
                )
            )
        }
    }
}
