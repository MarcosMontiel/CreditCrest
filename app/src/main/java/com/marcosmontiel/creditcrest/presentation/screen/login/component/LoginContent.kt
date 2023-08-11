package com.marcosmontiel.creditcrest.presentation.screen.login.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
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
import com.marcosmontiel.creditcrest.presentation.navigation.AuthRoutes.Register
import com.marcosmontiel.creditcrest.presentation.screen.login.LoginState
import com.marcosmontiel.creditcrest.presentation.screen.login.LoginViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.Gray500

@Composable
fun LoginContent(
    modifier: Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController,
    paddingValues: PaddingValues,
) {

    val loginState = viewModel.loginState

    Box(modifier = modifier.padding(paddingValues)) {

        DefaultSolidBackground(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxHeight(fraction = 0.45f),
        )

        DefaultCard(modifier = Modifier.align(Alignment.Center)) {

            LoginContentCard(
                modifier = Modifier.fillMaxWidth(),
                viewModel = viewModel,
                navController = navController,
                loginState = loginState,
            )

        }

    }

}

@Composable
fun LoginContentCard(
    modifier: Modifier,
    viewModel: LoginViewModel,
    navController: NavHostController,
    loginState: LoginState,
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

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            text = loginState.email,
            placeholder = {
                Text(text = stringResource(R.string.generic_email_title))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = stringResource(R.string.login_email_icon_desc),
                )
            },
            keyboardType = KeyboardType.Email,
            valueChanged = { viewModel.valueChanged(it, loginState.password) }
        )

        Spacer(modifier = Modifier.size(24.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            text = loginState.password,
            placeholder = {
                Text(text = stringResource(R.string.generic_pass_title))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Lock,
                    contentDescription = stringResource(R.string.login_pass_icon_desc),
                )
            },
            trailingIcon = {
                IconButton(onClick = { viewModel.visualPasswordChanged() }) {
                    Icon(
                        imageVector = loginState.passwordIcon,
                        contentDescription = stringResource(R.string.login_pass_transformation_icon),
                    )
                }
            },
            transformation = loginState.passwordTransformation,
            keyboardType = KeyboardType.Password,
            valueChanged = { viewModel.valueChanged(loginState.email, it) }
        )

        Spacer(modifier = Modifier.size(40.dp))

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(percent = 50),
            content = {
                DefaultText(
                    fontWeight = FontWeight.Bold,
                    title = stringResource(R.string.login_title_button),
                )
            },
            click = {},
        )

        Spacer(modifier = Modifier.size(8.dp))

        DefaultTextButton(
            modifier = Modifier.align(Alignment.End),
            colors = ButtonDefaults.textButtonColors(
                contentColor = Gray500,
            ),
            content = {
                DefaultText(
                    fontSize = 12.sp,
                    title = stringResource(R.string.login_forgot_pass_title),
                )
            },
            click = {},
        )

        Spacer(modifier = Modifier.size(24.dp))

        LoginSignUpContent(modifier = Modifier.fillMaxWidth(), navController = navController)

    }

}

@Composable
fun LoginSignUpContent(modifier: Modifier, navController: NavHostController) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        DefaultText(
            style = MaterialTheme.typography.body2,
            color = Gray500,
            title = stringResource(R.string.login_signup_action_title),
        )

        Spacer(modifier = Modifier.size(8.dp))

        DefaultTextButton(
            content = {
                DefaultText(
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                    title = stringResource(R.string.login_signup_title_button),
                )
            },
            click = {
                navController.navigate(Register.route)
            },
        )
    }

}