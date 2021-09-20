package com.peerbitskuldeep.jetpackcompose.statecolorbox

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.peerbitskuldeep.jetpackcompose.statecolorbox.ui.theme.StateColorBoxTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                Modifier.fillMaxSize()
            ) {

                val color = remember {
                    mutableStateOf(Color.Yellow)
                }


                ColorBox(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()){
                    color.value = it
                }

                Box(modifier = Modifier.weight(1f)
                    .fillMaxSize()
                    .background(color.value))
            }

            
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier,
    updateColor: (Color) -> Unit)
{
    Box(modifier = modifier
        .background(Color(Random.nextFloat(),
        Random.nextFloat(),
        Random.nextFloat(),
        1f))
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )



            Log.d("TAG", "ColorBox: ${Random.nextFloat()}")
        }
    )

}
