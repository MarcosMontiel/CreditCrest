package com.marcosmontiel.creditcrest.presentation.screen.register.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultCard
import com.marcosmontiel.creditcrest.presentation.component.DefaultSolidBackground
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.component.DefaultTextField
import com.marcosmontiel.creditcrest.presentation.screen.register.RegisterState
import com.marcosmontiel.creditcrest.presentation.screen.register.RegisterViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray500

@Composable
fun RegisterContent(
    modifier: Modifier,
    viewModel: RegisterViewModel = hiltViewModel(),
    navController: NavHostController,
    paddingValues: PaddingValues,
) {

    val registerState = viewModel.registerState

    Box(modifier = modifier.padding(paddingValues)) {

        DefaultSolidBackground(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxHeight(fraction = 0.45f),
        )

        DefaultCard(modifier = Modifier.align(Alignment.Center)) {

            RegisterContentCard(
                modifier = Modifier.fillMaxWidth(),
                viewModel = viewModel,
                registerState = registerState,
            )

        }

    }

}

@Composable
fun RegisterContentCard(
    modifier: Modifier,
    viewModel: RegisterViewModel,
    registerState: RegisterState,
) {

    Column(
        modifier = modifier.padding(horizontal = 24.dp, vertical = 40.dp),
        verticalArrangement = Arrangement.Center,
    ) {

        DefaultText(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            title = stringResource(R.string.login_title),
            style = MaterialTheme.typography.h6,
        )

        Spacer(modifier = Modifier.size(48.dp))

        DefaultText(
            style = MaterialTheme.typography.body2,
            color = Gray500,
            title = stringResource(R.string.signup_subtitle),
        )

        Spacer(modifier = Modifier.size(16.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            text = registerState.username,
            placeholder = {
                Text(text = stringResource(R.string.generic_username_title))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = stringResource(R.string.signup_username_icon_desc),
                )
            },
            valueChanged = {
                viewModel.valueChanged(
                    email = registerState.email,
                    password = registerState.password,
                    passwordConfirmation = registerState.passwordConfirmation,
                    username = it,
                )
            },
        )

        Spacer(modifier = Modifier.size(24.dp))

    }

}