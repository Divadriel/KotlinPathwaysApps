package eu.exploptimist.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.exploptimist.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun StepWithImageAndText(modifier: Modifier = Modifier){
    var currentStep by remember { mutableStateOf(0) }
    var clicks = 0
    var targetClicks = (2..4).random()
    val imageResource = when(currentStep){
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val contentDesc = when(currentStep){
        0 -> R.string.lemon_tree_content_desc
        1 -> R.string.lemon_content_desc
        2 -> R.string.glass_content_desc
        else -> R.string.empty_glass_content_desc
    }
    val textResource = when(currentStep){
        0 -> R.string.select_lemon
        1 -> R.string.squeeze_lemon
        2 -> R.string.drink
        else -> R.string.restart
    }

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                when(currentStep){
                    0 -> currentStep++
                    1 -> {
                        clicks++
                        if(clicks == targetClicks){
                            currentStep++
                        }
                    }
                    2 -> currentStep++
                    else -> currentStep = 0
                }
            },
            shape = RoundedCornerShape(16.dp)

        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(contentDesc)
            )
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(textResource),
            fontSize = 18.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun LemonadeApp(){
    StepWithImageAndText(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}