package com.maf.custom.views.testcomposewithxml.compose.shared.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.themeadapter.material.MdcTheme
import com.maf.custom.views.testcomposewithxml.R

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    hint: String,
    errorText: String,
    isPassword: Boolean = false,
    showError: Boolean = false,
    onTextChanged: (String) -> Unit = { }
) {
    var text by remember { mutableStateOf("") }

    Column(modifier = modifier.wrapContentSize()) {

        Text(
            text = hint,
            color = Color(0xFF9796A1),
            fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp, bottom = 10.dp)
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChanged(it)
                text = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFFEEEEEE),
                focusedBorderColor = MaterialTheme.colors.primary,
                textColor = Color.Black,
            ),
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
                fontSize = 17.sp
            ),
            shape = RoundedCornerShape(10.dp),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
        )

        AnimatedVisibility(visible = showError) {
            Text(
                text = errorText,
                color = Color.Red,
                fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }


}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewInputField() {
    MdcTheme {
        InputField(
            modifier = Modifier.wrapContentSize(),
            hint = "Email",
            errorText = "Wrong Email",
        )
    }
}