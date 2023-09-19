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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.*
import com.marcosmontiel.creditcrest.presentation.navigation.AuthRoutes
import com.marcosmontiel.creditcrest.presentation.screen.register.RegisterState
import com.marcosmontiel.creditcrest.presentation.screen.register.RegisterViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray500
import com.marcosmontiel.creditcrest.presentation.ui.theme.Red400

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
                navController = navController,
                registerState = registerState,
            )

        }

    }

}

@Composable
fun RegisterContentCard(
    modifier: Modifier,
    viewModel: RegisterViewModel,
    navController: NavHostController,
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
            title = stringResource(R.string.auth_login_title),
            style = MaterialTheme.typography.h6,
        )

        Spacer(modifier = Modifier.size(40.dp))

        DefaultText(
            style = MaterialTheme.typography.body2,
            color = Gray500,
            title = stringResource(R.string.auth_signup_subtitle),
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
                    IconButton(onClick = { viewModel.usernameEraser() }) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = stringResource(R.string.auth_signup_username_eraser_icon),
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
                    IconButton(onClick = { viewModel.emailEraser() }) {
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

        Column(modifier = Modifier.fillMaxWidth()) {

            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                enabled = registerState.passwordEnabled,
                text = registerState.password,
                label = {
                    DefaultText(title = stringResource(R.string.generic_pass_title))
                },
                trailingIcon = {
                    IconButton(onClick = { viewModel.passwordTransformation() }) {
                        Icon(
                            imageVector = registerState.passwordIcon,
                            contentDescription = stringResource(R.string.auth_login_pass_transformation_icon),
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

        }

        Spacer(modifier = Modifier.size(24.dp))

        Column(modifier = Modifier.fillMaxWidth()) {

            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                enabled = registerState.passwordConfirmationEnabled,
                text = registerState.passwordConfirmation,
                label = {
                    DefaultText(title = stringResource(R.string.auth_signup_pass_confirm_title))
                },
                trailingIcon = {
                    IconButton(onClick = { viewModel.passwordConfirmationTransformation() }) {
                        Icon(
                            imageVector = registerState.passwordConfirmationIcon,
                            contentDescription = stringResource(R.string.auth_signup_pass_confirm_transformation_icon),
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

            if (!registerState.passwordMatch &&
                registerState.password.isNotBlank() &&
                registerState.passwordConfirmation.isNotBlank()
            ) {

                Spacer(modifier = Modifier.height(8.dp))

                DefaultText(
                    modifier = Modifier.fillMaxWidth(),
                    title = stringResource(R.string.auth_signup_warning_password_not_match),
                    fontSize = 12.sp,
                    color = Red400,
                )

            }

        }

        Spacer(modifier = Modifier.size(40.dp))

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = registerState.signUpButtonEnabled,
            shape = RoundedCornerShape(percent = 50),
            content = {
                DefaultText(
                    fontWeight = FontWeight.Bold,
                    title = stringResource(R.string.auth_signup_title_button),
                )
            },
            click = { viewModel.register() },
        )

        Spacer(modifier = Modifier.size(24.dp))

        SignUpLoginContent(
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            registerState = registerState,
        )

    }

}

@Composable
fun SignUpLoginContent(
    modifier: Modifier,
    navController: NavHostController,
    registerState: RegisterState,
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        DefaultText(
            style = MaterialTheme.typography.body2,
            color = Gray500,
            title = stringResource(R.string.auth_signup_action_title),
        )

        Spacer(modifier = Modifier.size(8.dp))

        DefaultTextButton(
            enabled = registerState.loginButtonEnabled,
            content = {
                DefaultText(
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                    title = stringResource(R.string.auth_signup_login_title_button),
                )
            },
            click = {
                navController.navigate(AuthRoutes.Login.route)
            },
        )
    }

}