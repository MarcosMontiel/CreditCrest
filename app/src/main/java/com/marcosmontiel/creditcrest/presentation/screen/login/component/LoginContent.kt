package com.marcosmontiel.creditcrest.presentation.screen.login.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultCard
import com.marcosmontiel.creditcrest.presentation.component.DefaultSolidBackground
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.component.DefaultTextField
import com.marcosmontiel.creditcrest.presentation.screen.login.LoginViewModel
import com.marcosmontiel.creditcrest.presentation.ui.theme.Blue800

@Composable
fun LoginContent(
    modifier: Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController,
    paddingValues: PaddingValues,
) {

    Box(modifier = modifier.padding(paddingValues)) {

        DefaultSolidBackground(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxHeight(fraction = 0.45f),
            color = Blue800,
        )

        DefaultCard(modifier = Modifier.align(Alignment.Center)) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 40.dp),
                verticalArrangement = Arrangement.Center,
            ) {

                DefaultText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold,
                    title = stringResource(R.string.login_title),
                    style = MaterialTheme.typography.h6,
                )

                Spacer(modifier = Modifier.size(48.dp))

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    placeholder = {
                        Text(text = stringResource(R.string.login_user_title))
                    },
                    valueChanged = {}
                )

                Spacer(modifier = Modifier.size(24.dp))

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    text = "",
                    placeholder = {
                        Text(text = stringResource(R.string.login_pass_title))
                    },
                    valueChanged = {}
                )

            }

        }

    }

}