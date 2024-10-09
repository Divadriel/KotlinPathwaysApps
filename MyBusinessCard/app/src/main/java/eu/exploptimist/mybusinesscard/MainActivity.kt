package eu.exploptimist.mybusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.exploptimist.mybusinesscard.ui.theme.MyBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column (
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Column (
            modifier = modifier
                .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(
                        bottom = 8.dp
                    )
            )
            Text(
                text = "David Rei",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                modifier = modifier
                    .padding(
                        bottom = 8.dp
                    )
            )
            Text(
                text = "Docteur en Informatique",
                fontSize = 20.sp
            )
        }
        Column (
            modifier = modifier,
            verticalArrangement = Arrangement.Bottom
        ){
            ContactRow(
                modifier = modifier,
                icon = Icons.Filled.Phone,
                content = "+33637045263"
            )
            ContactRow(
                modifier = modifier,
                icon = Icons.Filled.Search,
                content = "https://exploptimist.eu",
                color = colorResource(R.color.main_color)
            )
            ContactRow(
                modifier = modifier,
                icon = Icons.Filled.Email,
                content = "david.rei@exploptimist.eu"
            )
        }
    }
}

@Composable
fun ContactRow(modifier: Modifier = Modifier, icon: ImageVector, content: String, color: Color = Color.Black){
    Row (
        modifier = modifier
            .padding(2.dp)
    ){
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color
        )
        Text(
            text = content,
            fontSize = 18.sp,
            modifier = Modifier.padding(
                start = 8.dp
            ),
            color = color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBusinessCardTheme {
        BusinessCard()
    }
}