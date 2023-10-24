package com.marcosmontiel.creditcrest.presentation.screen.account

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.component.DefaultTopBar
import com.marcosmontiel.creditcrest.presentation.screen.account.component.AccountContent

@Composable
fun AccountScreen(navController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

            DefaultTopBar(title = { DefaultText(title = stringResource(R.string.account_title)) })

        },
        bottomBar = {},
        content = {

            AccountContent(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
            )

        },
    )

}