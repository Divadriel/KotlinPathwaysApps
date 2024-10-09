package eu.exploptimist.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.exploptimist.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrant(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeCard(modifier: Modifier = Modifier, title: String, text: String, color: Color){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    bottom = 16.dp
                )
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier){
    Column (modifier = Modifier.fillMaxWidth()){
        Row(modifier = Modifier.weight(1f)) {
            ComposeCard(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.first_quadrant_title),
                text = stringResource(R.string.first_quadrant_desc),
                color = colorResource(R.color.purple_very_light)
            )
            ComposeCard(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.second_quadrant_title),
                text = stringResource(R.string.second_quadrant_desc),
                color = colorResource(R.color.purple_lighter)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            ComposeCard(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.third_quadrant_title),
                text = stringResource(R.string.third_quadrant_desc),
                color = colorResource(R.color.purple_light)
            )
            ComposeCard(
                modifier = Modifier.weight(1f),
                title = stringResource(R.string.fourth_quadrant_title),
                text = stringResource(R.string.fourth_quadrant_desc),
                color = colorResource(R.color.purple_white)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant(
        )
    }
}