package com.nawa.bmapp

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.nawa.bmapp.ui.theme.BmColor

@Composable
fun LanguagePicker(modifier: Modifier = Modifier) {

    val appLocales = AppCompatDelegate.getApplicationLocales()
    val currentLocaleTag = appLocales.get(0)?.toLanguageTag() ?: "en"

    Text(
        if (currentLocaleTag=="en") "العربية" else "En",
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = BmColor,
        modifier=modifier.clickable(
            onClick = {
                AppCompatDelegate.setApplicationLocales(
                    if (currentLocaleTag=="en") {
                        LocaleListCompat.forLanguageTags("ar")
                    } else {
                        LocaleListCompat.forLanguageTags("en")
                    }
                )
            }
        )
    )
}