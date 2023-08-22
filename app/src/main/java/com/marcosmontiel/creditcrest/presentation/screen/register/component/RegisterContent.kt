package com.marcosmontiel.creditcrest.presentation.screen.register.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.*
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
            enabled = registerState.usernameEnabled,
            text = registerState.username,
            label = {
                DefaultText(title = stringResource(R.string.generic_username_title))
            },
            trailingIcon = {
                if (registerState.usernameEraser) {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = stringResource(R.string.signup_username_eraser_icon),
                        )
                    }
                }
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

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = registerState.emailEnabled,
            text = registerState.email,
            label = {
                DefaultText(title = stringResource(R.string.generic_email_title))
            },
            trailingIcon = {
                if (registerState.emailEraser) {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = stringResource(R.string.generic_email_eraser_icon),
                        )
                    }
                }
            },
            keyboardType = KeyboardType.Email,
            valueChanged = {
                viewModel.valueChanged(
                    email = it,
                    password = registerState.password,
                    passwordConfirmation = registerState.passwordConfirmation,
                    username = registerState.username,
                )
            }
        )

        Spacer(modifier = Modifier.size(24.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = registerState.passwordEnabled,
            text = registerState.password,
            label = {
                DefaultText(title = stringResource(R.string.generic_pass_title))
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = registerState.passwordIcon,
                        contentDescription = stringResource(R.string.login_pass_transformation_icon),
                    )
                }
            },
            transformation = registerState.passwordTransformation,
            keyboardType = KeyboardType.Password,
            valueChanged = {
                viewModel.valueChanged(
                    email = registerState.email,
                    password = it,
                    passwordConfirmation = registerState.passwordConfirmation,
                    username = registerState.username,
                )
            },
        )

        Spacer(modifier = Modifier.size(24.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = registerState.passwordConfirmationEnabled,
            text = registerState.passwordConfirmation,
            label = {
                DefaultText(title = stringResource(R.string.signup_pass_confirmation_title))
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = registerState.passwordConfirmationIcon,
                        contentDescription = stringResource(R.string.signup_pass_conf_transformation_icon),
                    )
                }
            },
            transformation = registerState.passwordConfirmationTransformation,
            keyboardType = KeyboardType.Password,
            valueChanged = {
                viewModel.valueChanged(
                    email = registerState.email,
                    password = registerState.password,
                    passwordConfirmation = it,
                    username = registerState.username,
                )
            },
        )

        Spacer(modifier = Modifier.size(40.dp))

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = registerState.signUpButtonEnabled,
            shape = RoundedCornerShape(percent = 50),
            content = {
                DefaultText(
                    fontWeight = FontWeight.Bold,
                    title = stringResource(R.string.signup_title_button),
                )
            },
            click = {},
        )

    }

}