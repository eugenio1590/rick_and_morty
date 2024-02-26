package com.app.rickandmorty.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.rickandmorty.R
import com.app.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun Splash(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.splash),
            contentDescription = stringResource(R.string.app_name),
            contentScale = ContentScale.FillHeight,
            modifier = modifier
                .padding(8.dp)
                .size(300.dp)
                .clip(CircleShape)
        )

        Spinner(modifier.padding(top = 20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SplashDefaultPreview() {
    RickAndMortyTheme {
        Splash()
    }
}