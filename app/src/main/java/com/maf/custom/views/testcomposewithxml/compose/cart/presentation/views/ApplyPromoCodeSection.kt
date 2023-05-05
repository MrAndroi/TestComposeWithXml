package com.maf.custom.views.testcomposewithxml.compose.cart.presentation.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model.CartIntent

@Composable
fun ApplyPromoCodeSection(
    onIntent: ((CartIntent) -> Unit)
) {

    Surface {
        val maxLength = 5
        var textState by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFEEEEEE),
                    shape = RoundedCornerShape(100.dp)
                )
                .clipToBounds(),
        ) {
            TextField(
                value = textState,
                onValueChange = {
                    if (it.length <= maxLength) textState = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                placeholder = {
                    Text(
                        text = "Enter Promo Code",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Thin)),
                        style = TextStyle(
                            color = Color(0xFFBEBEBE)
                        )
                    )
                }
            )
            Button(
                onClick = { onIntent(CartIntent.OnApplyPromoCodeClick(textState)) },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp, top = 10.dp, bottom = 10.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                ),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 25.dp)
            ) {
                Text(
                    text = "Apply",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Thin)),
                    style = TextStyle(
                        color = Color.White
                    )
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ApplyPromoCodeSectionPreview() {
    ApplyPromoCodeSection {}
}