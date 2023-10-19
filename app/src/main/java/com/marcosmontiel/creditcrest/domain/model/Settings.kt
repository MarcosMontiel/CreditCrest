package com.marcosmontiel.creditcrest.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.ui.graphics.vector.ImageVector

data class Settings(
    val icon: ImageVector,
    val title: String = "",
) {

    companion object {
        fun getShortcutsSettings(): List<Settings> = listOf(
            Settings(icon = Icons.Rounded.AccountCircle, title = "Perfil")
        )
    }

}
