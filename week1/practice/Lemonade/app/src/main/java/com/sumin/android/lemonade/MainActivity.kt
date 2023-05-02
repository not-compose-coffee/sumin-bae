package com.sumin.android.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sumin.android.lemonade.ui.theme.LemonadeTheme
import com.sumin.android.lemonade.ui.theme.SkyBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var step by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(1) }
    fun onClick() {
        if (step == 4) step = 1
        else step++
    }

    when(step) {
        1 -> {
            LemonadeCard(
                imageId = R.drawable.lemon_tree,
                howtoId = R.string.step_1,
                descriptionId = R.string.step_1_description,
                onImageClick = {
                    onClick()
                    squeezeCount = (2..5).random()
                }
            )
        }
        2 -> {
            LemonadeCard(
                imageId = R.drawable.lemon_squeeze,
                howtoId = R.string.step_2,
                descriptionId = R.string.step_2_description,
                onImageClick = {
                    squeezeCount--
                    if (squeezeCount == 0) onClick()
                }
            )
        }
        3 -> {
            LemonadeCard(
                imageId = R.drawable.lemon_drink,
                howtoId = R.string.step_3,
                descriptionId = R.string.step_3_description,
                onImageClick = {
                    onClick()
                }
            )
        }
        else -> {
            LemonadeCard(
                imageId = R.drawable.lemon_restart,
                howtoId = R.string.step_4,
                descriptionId = R.string.step_4_description,
                onImageClick = {
                    onClick()
                }
            )
        }
    }
}

@Composable
fun LemonadeCard(
    imageId: Int,
    howtoId: Int,
    descriptionId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = howtoId),
            fontSize = 18.sp
        )
        Spacer(modifier = modifier.padding(16.dp))
        Image(
            painter = painterResource(id = imageId),
            contentDescription = stringResource(id = descriptionId),
            modifier = modifier
                .clip(RoundedCornerShape(4.dp))
                .border(2.dp, SkyBlue, RoundedCornerShape(4.dp))
                .clickable(onClick = onImageClick)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LemonadeApp()
        }
    }
}