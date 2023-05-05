package com.maf.custom.views.testcomposewithxml.compose.cart.presentation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.maf.custom.views.testcomposewithxml.R
import com.maf.custom.views.testcomposewithxml.compose.cart.data.model.CartModel
import com.maf.custom.views.testcomposewithxml.compose.cart.presentation.model.CartIntent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CartItem(
    cartModel: CartModel,
    onIntent: ((CartIntent) -> Unit)
) {
    Surface(
        modifier = Modifier.wrapContentSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            var qty by rememberSaveable {
                mutableStateOf(cartModel.quantity)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                SubcomposeAsyncImage(
                    modifier = Modifier
                        .size(92.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .clipToBounds(),
                    model = cartModel.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    loading = {
                        CircularProgressIndicator(
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(
                        text = cartModel.name,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.SemiBold)),
                        color = Color(0xFF111719)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = cartModel.description,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_regular, FontWeight.Normal)),
                        color = Color(0xFF8C8A9D)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "$${cartModel.price}",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.Normal)),
                        color = Color(0xFFFE724C)
                    )
                }


            }
            Image(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 10.dp)
                    .clickable { onIntent(CartIntent.OnCloseClickClick(cartModel)) }
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 10.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        if (qty < 50) {
                            qty += 1
                            cartModel.quantity = qty
                            onIntent(CartIntent.OnPlusMinusClick)
                        }
                    }
                )
                Text(
                    text = "$qty",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_bold, FontWeight.SemiBold)),
                    color = Color(0xFF111719),
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        if (qty > 0) {
                            qty -= 1
                            cartModel.quantity = qty
                            onIntent(CartIntent.OnPlusMinusClick)
                        }

                    }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HeaderSectionPreview() {
    val cartModelPreview = CartModel(
        name = "Red n hot pizza",
        description = "Spicy chicken, beef",
        image = "https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/216054.jpg",
        price = 15.6f
    )
    CartItem(
        cartModel = cartModelPreview,
    ) {

    }
}