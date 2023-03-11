package com.example.bookmycar.component

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookmycar.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import java.lang.Thread.yield

@ExperimentalPagerApi
@Preview
@Composable
fun AutoSliding() {
    val pagerState = rememberPagerState(
        pageCount = 3,
        initialOffscreenLimit = 2
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }

    Column(
        modifier = Modifier.height(280.dp).background(Color.Transparent)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(5.dp, 5.dp, 5.dp, 0.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 5.dp, 8.dp, 0.dp),
                shape = RoundedCornerShape(20.dp),

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .align(Alignment.Center)
                ) {
                    Image(
                        painter = painterResource(
                            id = when (page) {
                                1 -> R.drawable.car2
                                2 -> R.drawable.car3
                                3 -> R.drawable.car4
                                else -> R.drawable.car
                            }
                        ),
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(15.dp)
                    ) {
                        Text(
                            text = "hii",
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )


                        Text(
                            text = "ddsvdzgdfgfs",
                            style = MaterialTheme.typography.body1,
                            color = Color.White,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
                        )
                    }
                }
            }
        }

        //Horizontal dot indicator
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)

        )
    }
}