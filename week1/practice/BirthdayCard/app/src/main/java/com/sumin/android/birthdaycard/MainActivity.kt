package com.sumin.android.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sumin.android.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayGreetingWithImage(
                        message = stringResource(id = R.string.birthdayMessage),
                        from = stringResource(id = R.string.birthdayFrom)
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(
    message: String,
    from: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 36.sp,
            lineHeight = 40.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(
    message: String,
    from: String,
    modifier: Modifier = Modifier,
) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier = modifier) {
        Image(
            painter = image,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.imageDescription)
        )
        BirthdayGreetingWithText(
            message = message,
            from = from
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardTheme {
        BirthdayGreetingWithImage(
            message = stringResource(id = R.string.birthdayMessage),
            from = stringResource(R.string.birthdayFrom)
        )
    }
}