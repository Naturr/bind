package com.naturel.bind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.text.input.KeyboardType
import android.R.attr.password
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.input.KeyboardType.Companion.Password
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.core.view.WindowCompat
import androidx.compose.ui.text.input.VisualTransformation


val CreamBackground2 = Color(0xFFF3EFE3)
val containerColor = Color(0xFFDCD8CD)


class loginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BindLoginScreen()
        }
    }
}

@Composable
fun BindLoginScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = CreamBackground2
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {

                Text(
                    text = "Sign in",
                    color = TextColor,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = BindFont,
                    modifier = Modifier.padding(top = 50.dp),
                    letterSpacing = (-2).sp
                )
                Text(
                    text = "Hi, welcome back, you've been missed!",
                    fontSize = 18.sp,
                    color = TextColor,
                    modifier = Modifier.padding(top = 30.dp),
                    fontFamily = FontFamily.Serif,
                )
                Image(
                    painter = painterResource(id = R.drawable.log),
                    contentDescription = "Logo ",
                    modifier = Modifier
                        .size(130.dp)
                        .offset(y = -15.dp)
                )
                var email by remember { mutableStateOf("") }
                OutlinedTextField(
                    leadingIcon = {
                        Icon(
                        painter= painterResource(id = R.drawable.emaill),
                         contentDescription = "Email",
                        tint = RopeColor,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(start = 15.dp)
                        )
                    },
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text(
                        "Email",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .background(Color.Transparent)


                    ) },
                    shape = RoundedCornerShape(25.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = RopeColor,
                        unfocusedContainerColor = containerColor,
                        focusedContainerColor = containerColor,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = RopeColor,
                        focusedLabelColor = RopeColor
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .offset(y = -40.dp)


                )
                var password by remember { mutableStateOf("") }
                var password2 by remember { mutableStateOf(false) }
                OutlinedTextField(
                    leadingIcon = {
                    Icon(
                        painter= painterResource(id = R.drawable.cle),
                        contentDescription = "password",
                        tint = RopeColor,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 15.dp)
                    )

                },
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text(
                        "Password",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .background(Color.Transparent)
                    ) },
                    visualTransformation = if (password2) VisualTransformation.None
                    else PasswordVisualTransformation(mask = '*'),
                    shape = RoundedCornerShape(25.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = RopeColor,
                        unfocusedContainerColor = containerColor,
                        focusedContainerColor = containerColor,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = RopeColor,
                        focusedLabelColor = RopeColor
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .offset(y = -25.dp)


                )


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .offset(y = -30.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                TextButton(
                    onClick = {password2 = !password2
                    }

                )
                {
                    Text(
                        if (password2) "Hide password" else "Show password")}






}



            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BindLoginPreview() {
    BindLoginScreen()
}
