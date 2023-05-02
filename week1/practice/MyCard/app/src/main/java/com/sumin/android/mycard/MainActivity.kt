package com.sumin.android.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sumin.android.mycard.ui.theme.Android
import com.sumin.android.mycard.ui.theme.MyCardTheme
import com.sumin.android.mycard.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardTheme {
                MyCardApp()
            }
        }
    }
}

@Composable
fun MyCardApp(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Profile()
            Contact()
        }
    }
}

@Composable
fun Profile(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(5.dp, Android, CircleShape),
            contentScale = ContentScale.Crop,
            contentDescription = "a picture of Arale",
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Sumin Bae",
            style = Typography.headlineLarge
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "Growing Android Developer",
            style = Typography.bodySmall,
            color = Android
        )
    }
}

@Composable
fun Contact(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier,
    ) {
        ContactItem(image = R.drawable.ic_phone, contact = "010 1234 5678")
        ContactItem(image = R.drawable.ic_github, contact = "@waterminn")
        ContactItem(image = R.drawable.ic_email, contact = "minee1913@gmail.com")
    }
}

@Composable
fun ContactItem(
    image: Int,
    contact: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .padding(vertical = 4.dp)
            .padding(start = 10.dp)
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = contact,
                style = Typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCardTheme {
        ContactItem(image = R.drawable.ic_phone, contact = "010 1234 5678")
    }
}