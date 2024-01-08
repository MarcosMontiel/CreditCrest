package com.marcosmontiel.creditcrest.presentation.screen.login.component

import android.app.Activity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
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
import com.marcosmontiel.creditcrest.presentation.navigation.AuthRoutes.Register
import com.marcosmontiel.creditcrest.presentation.screen.login.LoginState
import com.marcosmontiel.creditcrest.presentation.screen.login.LoginViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray500

@Composable
fun LoginContent(
    modifier: Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val loginState = viewModel.loginState
    val activity = LocalContext.current as Activity

    Box(modifier = modifier.padding(16.dp)) {
        LoginHeader(modifier = Modifier.align(Alignment.TopEnd), activity = activity)

        LoginBody(
            modifier = Modifier.align(Alignment.Center),
            viewModel = viewModel,
            loginState = loginState
        )

        LoginFooter(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navController,
            loginState = loginState
        )
    }
}

@Composable
fun LoginHeader(modifier: Modifier, activity: Activity) {
    DefaultIcon(
        modifier = modifier.clickable { activity.finish() },
        icon = Icons.Rounded.Close,
        description = stringResource(R.string.generic_close_app_icon),
    )
}

@Composable
fun LoginBody(
    modifier: Modifier,
    viewModel: LoginViewModel,
    loginState: LoginState
) {
    Column(modifier = modifier.fillMaxWidth()) {
        DefaultText(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            title = stringResource(R.string.generic_application_name),
        )

        Spacer(modifier = Modifier.size(48.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = loginState.emailEnabled,
            text = loginState.email,
            label = { DefaultText(title = stringResource(R.string.generic_email_label)) },
            trailingIcon = {
                AnimatedVisibility(visible = loginState.emailEraser) {
                    DefaultIconButton(
                        icon = Icons.Rounded.Close,
                        description = stringResource(R.string.generic_email_eraser_icon),
                        click = { viewModel.emailEraser() }
                    )
                }
            },
            keyboardType = KeyboardType.Email,
            valueChanged = { viewModel.valueChanged(email = it, password = loginState.password) }
        )

        Spacer(modifier = Modifier.size(24.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = loginState.passwordEnabled,
            text = loginState.password,
            label = { DefaultText(title = stringResource(R.string.auth_password_label)) },
            trailingIcon = {
                DefaultIconButton(
                    icon = loginState.passwordIcon,
                    description = stringResource(R.string.auth_password_visibility_icon),
                    click = { viewModel.passwordTransformation() }
                )
            },
            transformation = loginState.passwordTransformation,
            keyboardType = KeyboardType.Password,
            valueChanged = { viewModel.valueChanged(email = loginState.email, password = it) }
        )

        Spacer(modifier = Modifier.size(40.dp))

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = loginState.loginButtonEnabled,
            shape = RoundedCornerShape(percent = 50),
            content = {
                DefaultText(
                    fontWeight = FontWeight.Bold,
                    title = stringResource(R.string.auth_main_login_button)
                )
            },
            click = { viewModel.login() }
        )

        Spacer(modifier = Modifier.size(8.dp))

        DefaultTextButton(
            modifier = Modifier.align(Alignment.End),
            enabled = loginState.forgotPasswordButtonEnabled,
            colors = ButtonDefaults.textButtonColors(contentColor = Gray500),
            content = {
                DefaultText(
                    fontSize = 12.sp,
                    title = stringResource(R.string.auth_forgot_my_password_button),
                )
            },
            click = {}
        )
    }
}

@Composable
fun LoginFooter(
    modifier: Modifier,
    navController: NavHostController,
    loginState: LoginState
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider()

        LoginSignUpContent(
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            loginState = loginState,
        )
    }
}

@Composable
fun LoginSignUpContent(
    modifier: Modifier,
    navController: NavHostController,
    loginState: LoginState
) {
    Row(
        modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        DefaultText(
            style = MaterialTheme.typography.body2,
            color = Gray500,
            title = stringResource(R.string.auth_footer_sign_up_title)
        )

        Spacer(modifier = Modifier.size(8.dp))

        DefaultTextButton(
            enabled = loginState.signUpButtonEnabled,
            content = {
                DefaultText(
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                    title = stringResource(R.string.auth_footer_sign_up_button)
                )
            },
            click = { navController.navigate(Register.route) }
        )
    }
}