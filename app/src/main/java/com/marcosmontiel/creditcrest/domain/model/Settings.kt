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
    val descIcon: String,
    val title: String,
    val description: String,
    var click: (() -> Unit)? = null
) {
    companion object {
        fun getItems(): List<Settings> {
            return listOf(
                Settings(
                    action = ACCOUNT,
                    icon = Icons.Rounded.Person,
                    descIcon = "account settings icon",
                    title = "Cuenta",
                    description = ""
                ),
                Settings(
                    action = HELP,
                    icon = Icons.Rounded.Help,
                    descIcon = "help settings icon",
                    title = "Ayuda",
                    description = "Centro de ayuda, contáctanos, políticas de privacidad"
                )
            )
        }
    }
}
