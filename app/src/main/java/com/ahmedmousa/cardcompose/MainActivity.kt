package com.ahmedmousa.cardcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedmousa.cardcompose.ui.theme.AhmedsCardComposeTheme
import com.ahmedmousa.cardcompose.ui.theme.Teal700
import android.content.Intent
import android.net.Uri


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AhmedsCardComposeTheme {
                Surface(color = Teal700) {
                    CardInfo()
                }
            }
        }
    }

    private fun openMailApp(email: String) {
        val uri = Uri.parse("mailto:$email")
        Intent(Intent.ACTION_SENDTO, uri).also {
            startActivity(it)
        }
    }

    private fun openDialApp(number: String)  {
        val uri = Uri.parse("tel:$number")
        Intent(Intent.ACTION_DIAL, uri).also {
            startActivity(it)
        }
    }

    @Composable
    fun CardInfo() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 12.dp, end = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.amousa),
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .clip(shape = CircleShape)
                    .border(
                        width = 4.dp,
                        color = Color.White,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = Constans.name, color = Color.White,
                fontFamily = FontFamily.Cursive, fontSize = 38.sp
            )
            Text(
                text = Constans.title, color = Color.White,
                fontFamily = FontFamily.Monospace, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            Spacer(modifier = Modifier.height(12.dp))
            InfoView(text = Constans.email, imageResId = R.drawable.ic_email) {
                openMailApp(Constans.email)
            }
            Spacer(modifier = Modifier.height(21.dp))
            InfoView(text = Constans.mobile, imageResId = R.drawable.ic_phone) {
                openDialApp(Constans.mobile)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        AhmedsCardComposeTheme {
            Surface(color = Teal700) {
                CardInfo()
            }
        }
    }
}

