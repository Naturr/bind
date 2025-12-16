package com.naturel.bind
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naturel.bind.R

val CreamBackground = Color(0xFFF3EFE3)
val RopeColor = Color(0xFFC46C4F)
val TextColor = Color(0xFF0D0D0D)
val BindFont = FontFamily( Font(R.font.braah))
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BindLogoScreen()
    }}}
@Composable
fun BindLogoScreen() {
    val textAnim = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        textAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 700,
                delayMillis = 500,
                easing = LinearOutSlowInEasing
            )
        )}


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = CreamBackground
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {


                Image(
                    painter = painterResource(id = R.drawable.log),
                    contentDescription = "Logo ",
                    modifier = Modifier
                        .size(160.dp)
                        .offset(y =8.dp)
                )



                Spacer(modifier = Modifier.width(16.dp))


                Text(
                    text = "Bind",
                    color = TextColor,
                    fontSize = 100.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = BindFont,
                    letterSpacing = (-2).sp,
               modifier = Modifier.drawWithContent {
                    clipRect(
                            left = 0f,
                            top = 0f,
                            right = size.width * textAnim.value,
                            bottom = size.height
                        ){this@drawWithContent.drawContent()
                        }
                    }
                )
            }
        }
    }
}
        @Preview(showBackground = true)
@Composable
fun BindLogoPreview() {
    BindLogoScreen()
}