package com.nawa.bmapp

import android.app.ServiceStartNotAllowedException
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nawa.bmapp.ui.theme.BMAppTheme
import com.nawa.bmapp.ui.theme.BmColor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMLoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun BMLoginScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp))
    {
        Spacer(modifier = Modifier.padding(top = 54.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.bm_icon),
                contentDescription = "BM Logo",
            )

            LanguagePicker()
        }

        Spacer(modifier = Modifier.padding(top = 36.dp))
        TextFieldWithButton()
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.need_help))
                withLink(
                    link = LinkAnnotation.Url(
                        "https://www.banquemisr.ae/contact-us/",
                        styles = TextLinkStyles(
                            style = SpanStyle(
                                color = BmColor,
                                textDecoration = TextDecoration.Underline
                            ),
                        ),
                    ), {
                        append(stringResource(R.string.contact_us))
                    }
                )
            }
        )
        HorizontalDivider(
            modifier = Modifier
                .padding(top = 48.dp)
                .fillMaxWidth(), thickness = 1.dp
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier =Modifier.fillMaxWidth(),
        ) {
            Services(
                painter = painterResource(R.drawable.our_products),
                contentDescription ="Our Product" ,
                firstText = stringResource(R.string.our_products),

            )
            Services(
                painter = painterResource(R.drawable.exchange_rate),
                contentDescription ="Exchange Rate" ,
                firstText = stringResource(R.string.exchange_rate),

            )
            Services(
                painter = painterResource(R.drawable.security_tips),
                contentDescription ="Security Tips" ,
                firstText = stringResource(R.string.security_tips),


            )
            Services(
                painter = painterResource(R.drawable.nearest_branch_or_atm),
                contentDescription ="Nearest branch or Atm" ,
                firstText = stringResource(R.string.nearest_atm),


            )

        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun BmLoginScreenPreview() {
    BMLoginScreen()
}
