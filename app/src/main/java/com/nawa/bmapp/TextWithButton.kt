package com.nawa.bmapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nawa.bmapp.ui.theme.BmColor


@Composable
fun TextFieldWithButton(modifier: Modifier = Modifier) {
    val userState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()
    Column() {
        CustomTextField(
            state = userState,
            label = stringResource(R.string.username),
            keyboardType = KeyboardType.Email,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(top = 28.dp))

        CustomTextField(
            state = passwordState,
            label = stringResource(R.string.password),
            keyboardType = KeyboardType.Password,
            isPassword = true,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(
            text = stringResource(R.string.forgot_username_password),
            fontSize = 14.sp,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.padding(top = 32.dp))


        Button(
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BmColor, // Background color
                contentColor = Color.White // Text/Icon color
            ),
            enabled = userState.text.isNotBlank() && passwordState.text.isNotBlank(),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = stringResource(R.string.login),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White
            )
        }
    }
}
