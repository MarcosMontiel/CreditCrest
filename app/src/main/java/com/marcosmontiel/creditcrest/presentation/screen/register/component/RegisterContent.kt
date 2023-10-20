package com.marcosmontiel.creditcrest.presentation.screen.register.component

import android.app.Activity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.marcosmontiel.creditcrest.presentation.enum.PasswordStrength.*
import com.marcosmontiel.creditcrest.presentation.navigation.AuthRoutes.Login
import com.marcosmontiel.creditcrest.presentation.screen.register.RegisterState
import com.marcosmontiel.creditcrest.presentation.screen.register.RegisterViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray500
import com.marcosmontiel.creditcrest.presentation.ui.theme.Green500
import com.marcosmontiel.creditcrest.presentation.ui.theme.Red400
import com.marcosmontiel.creditcrest.presentation.ui.theme.Yellow800

@Composable
fun RegisterContent(
    modifier: Modifier,
    viewModel: RegisterViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val registerState = viewModel.registerState
    val activity = LocalContext.current as Activity

    Box(modifier = modifier.padding(16.dp)) {

        RegisterHeader(
            modifier = Modifier.align(Alignment.TopEnd),
            activity = activity,
        )

        RegisterBody(
            modifier = Modifier.align(Alignment.Center),
            viewModel = viewModel,
            registerState = registerState,
        )

        RegisterFooter(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navController,
            registerState = registerState,
        )

    }

}

@Composable
fun RegisterHeader(modifier: Modifier, activity: Activity) {

    DefaultIcon(
        modifier = modifier.clickable { activity.finish() },
        icon = Icons.Rounded.Close,
        description = stringResource(R.string.generic_close_app_icon),
    )

}

@Composable
fun RegisterBody(
    modifier: Modifier,
    viewModel: RegisterViewModel,
    registerState: RegisterState,
) {

    Column(modifier = modifier.fillMaxWidth()) {

        DefaultText(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            title = stringResource(R.string.auth_login_title),
        )

        Spacer(modifier = Modifier.size(56.dp))

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

                AnimatedVisibility(visible = registerState.usernameEraser) {
                    DefaultIconButton(
                        icon = Icons.Rounded.Close,
                        description = stringResource(R.string.auth_signup_username_eraser_icon),
                    ) {
                        viewModel.usernameEraser()
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
            }
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

                AnimatedVisibility(visible = registerState.emailEraser) {
                    DefaultIconButton(
                        icon = Icons.Rounded.Close,
                        description = stringResource(R.string.generic_email_eraser_icon),
                    ) {
                        viewModel.emailEraser()
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

                    DefaultIconButton(
                        icon = registerState.passwordIcon,
                        description = stringResource(R.string.auth_login_pass_transformation_icon),
                    ) {
                        viewModel.passwordTransformation()
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
                }
            )

            AnimatedVisibility(visible = registerState.password.isNotBlank()) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {

                    Spacer(modifier = Modifier.size(16.dp))

                    DefaultText(
                        fontSize = 12.sp,
                        title = stringResource(R.string.auth_signup_strong_password_level),
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    when (registerState.passwordStrength) {
                        STRONG -> {

                            DefaultText(
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Green500,
                                title = stringResource(R.string.auth_signup_strong_password),
                            )

                        }
                        MEDIUM -> {

                            DefaultText(
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Yellow800,
                                title = stringResource(R.string.auth_signup_medium_password),
                            )

                        }
                        WEAK -> {

                            DefaultText(
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Red400,
                                title = stringResource(R.string.auth_signup_weak_password),
                            )

                        }
                        else -> {}
                    }

                }

            }

        }

        Spacer(modifier = Modifier.size(24.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = registerState.passwordConfirmationEnabled,
            text = registerState.passwordConfirmation,
            label = {
                DefaultText(title = stringResource(R.string.auth_signup_pass_confirm_title))
            },
            trailingIcon = {

                DefaultIconButton(
                    icon = registerState.passwordConfirmationIcon,
                    description = stringResource(R.string.auth_signup_pass_confirm_transformation_icon),
                ) {
                    viewModel.passwordConfirmationTransformation()
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
            }
        )

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

            }
        ) {
            viewModel.register()
        }
    }

}

@Composable
fun RegisterFooter(
    modifier: Modifier,
    navController: NavHostController,
    registerState: RegisterState,
) {

    Column(modifier = modifier.fillMaxWidth()) {

        Divider()

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
        modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
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

            }
        ) {
            navController.navigate(Login.route)
        }

    }

}