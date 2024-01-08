package com.marcosmontiel.creditcrest.presentation.screen.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.domain.model.Settings
import com.marcosmontiel.creditcrest.presentation.component.DefaultIcon
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.screen.settings.SettingsViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray500
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray600

@Composable
fun SettingsContent(
    modifier: Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val settings: List<Settings> = Settings.getItems()

    Box(modifier = modifier.padding(top = 16.dp, bottom = 32.dp)) {
        SettingsOptions(modifier = Modifier.fillMaxWidth(), settings = settings)
    }
}

@Composable
fun SettingsOptions(modifier: Modifier, settings: List<Settings>) {
    LazyColumn(
        modifier = modifier,
        content = {
            items(settings) { item ->
                SettingsItem(modifier = Modifier.fillMaxWidth(), item = item)
            }
        }
    )
}

@Composable
fun SettingsItem(modifier: Modifier, item: Settings) {
    Box(modifier = modifier.clickable(role = Role.Button, onClick = { item.click?.invoke() })) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultIcon(
                color = if (isSystemInDarkTheme()) Gray600 else Gray500,
                icon = item.icon,
                description = item.iconDescription
            )

            Spacer(modifier = Modifier.size(24.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                DefaultText(style = MaterialTheme.typography.body1, title = item.title)

                DefaultText(
                    fontSize = 12.sp,
                    color = if (isSystemInDarkTheme()) Gray500 else Gray600,
                    title = item.description
                )
            }
        }
    }
}