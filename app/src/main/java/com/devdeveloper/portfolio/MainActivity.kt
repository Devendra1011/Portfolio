package com.devdeveloper.portfolio

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devdeveloper.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfolioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CreateBizCard()
                }
            }
        }
    }
}


@Composable
fun CreateBizCard() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CreateImageProfile()
                Divider()
                ProfileInfo()
            }
        }
    }
}


@Composable
fun Divider() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth(),
        thickness = 1.dp,
        color = Color.LightGray

    )
}

@Composable
fun ProfileInfo() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Miles P.",
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Android Compose Programmer",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(3.dp),
        )
        Text(
            text = "@themilesCompose",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(3.dp)
        )
        Button(
            onClick = {
                buttonClickedState.value = !buttonClickedState.value

                Log.d("Clicked", "ProfileInfo: CreateBixCard: clicked")

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(
                text = "PortFolio",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.labelMedium
            )

        }

        if (buttonClickedState.value){
            Content()
        } else{
            Box (){


            }
        }
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(2.dp, Color.LightGray),
        shadowElevation = 5.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5F)
    ) {
        Image(
            painter = painterResource(id = R.drawable.hari),
            contentDescription = "User-Image",
            modifier = modifier
                .size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Content(){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)){


        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            shape = RoundedCornerShape(6.dp),

        ) {

            Portfolio(data= listOf("Project 1",
                "Project 2",
                "Project 3",
                "Project 3",
                "Project 3",
                "Project 3"
            ))
        }
    }
}
@Composable
fun Portfolio(data: List<String>) {

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
    ){
        items(data){ item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(Color.LightGray),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {

                Row (modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface),
                    verticalAlignment = Alignment.CenterVertically){
                        CreateImageProfile(
                            modifier = Modifier
                                .size(100.dp)
                        )
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {

                        Text(
                            text = item,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Java,Kotlin,Firebase",
                            fontWeight = FontWeight.Light,
                            style = MaterialTheme.typography.bodyMedium
                        )

                    }
                }
            }
        }
    }
}
//@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    PortfolioTheme {
        CreateBizCard()
    }
}