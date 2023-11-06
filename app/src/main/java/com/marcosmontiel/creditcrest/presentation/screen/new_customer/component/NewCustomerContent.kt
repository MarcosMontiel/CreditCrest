package com.marcosmontiel.creditcrest.presentation.screen.new_customer.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.creditcrest.R
import com.marcosmontiel.creditcrest.presentation.component.DefaultButton
import com.marcosmontiel.creditcrest.presentation.component.DefaultIconButton
import com.marcosmontiel.creditcrest.presentation.component.DefaultText
import com.marcosmontiel.creditcrest.presentation.component.DefaultTextField
import com.marcosmontiel.creditcrest.presentation.screen.new_customer.NewCustomerState
import com.marcosmontiel.creditcrest.presentation.screen.new_customer.NewCustomerViewModel

@Composable
fun NewCustomerContent(
    modifier: Modifier,
    viewModel: NewCustomerViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val newCustomerState = viewModel.newCustomerState

    Box(modifier = modifier.padding(16.dp)) {

        NewCustomerBody(
            modifier = Modifier.fillMaxWidth(),
            viewModel = viewModel,
            newCustomerState = newCustomerState,
        )

    }

}

@Composable
fun NewCustomerBody(
    modifier: Modifier,
    viewModel: NewCustomerViewModel,
    newCustomerState: NewCustomerState,
) {

    Column(modifier = modifier) {

        Spacer(modifier = Modifier.size(16.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = newCustomerState.nameEnabled,
            text = newCustomerState.name,
            label = {
                DefaultText(title = stringResource(R.string.new_customer_name_title))
            },
            trailingIcon = {

                AnimatedVisibility(visible = newCustomerState.nameEraser) {

                    DefaultIconButton(
                        icon = Icons.Rounded.Close,
                        description = stringResource(R.string.new_customer_name_eraser_icon),
                        click = { viewModel.nameEraser() }
                    )

                }

            },
            valueChanged = {

                viewModel.valueChanged(
                    name = it,
                    lastName = newCustomerState.lastName,
                    curp = newCustomerState.curp,
                )

            }
        )

        Spacer(modifier = Modifier.size(24.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = newCustomerState.lastNameEnabled,
            text = newCustomerState.lastName,
            label = {
                DefaultText(title = stringResource(R.string.new_customer_last_name_title))
            },
            trailingIcon = {

                AnimatedVisibility(visible = newCustomerState.lastNameEraser) {

                    DefaultIconButton(
                        icon = Icons.Rounded.Close,
                        description = stringResource(R.string.new_customer_last_name_eraser_icon),
                        click = { viewModel.lastNameEraser() }
                    )

                }

            },
            valueChanged = {

                viewModel.valueChanged(
                    name = newCustomerState.name,
                    lastName = it,
                    curp = newCustomerState.curp,
                )

            }
        )

        Spacer(modifier = Modifier.size(24.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = newCustomerState.curpEnabled,
            text = newCustomerState.curp,
            label = {
                DefaultText(title = stringResource(R.string.new_customer_curp_title))
            },
            trailingIcon = {

                AnimatedVisibility(visible = newCustomerState.curpEraser) {

                    DefaultIconButton(
                        icon = Icons.Rounded.Close,
                        description = stringResource(R.string.new_customer_curp_eraser_icon),
                        click = { viewModel.curpEraser() }
                    )

                }

            },
            valueChanged = {

                viewModel.valueChanged(
                    name = newCustomerState.name,
                    lastName = newCustomerState.lastName,
                    curp = it,
                )

            }
        )

        Spacer(modifier = Modifier.size(40.dp))

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = newCustomerState.saveButtonEnabled,
            shape = RoundedCornerShape(percent = 50),
            content = {

                DefaultText(
                    fontWeight = FontWeight.Bold,
                    title = stringResource(R.string.generic_save_title_button),
                )

            },
            click = {}
        )

    }

}