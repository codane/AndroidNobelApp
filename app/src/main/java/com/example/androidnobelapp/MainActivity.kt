package com.example.androidnobelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidnobelapp.ui.theme.AndroidNobelAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidNobelAppTheme {
                val categories: List<String> = listOf("Physics", "Chemistry", "Medicine", "Literature", "Peace", "Economic Sciences")

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(40.dp))
                        HomeScreenText()
                        Spacer(modifier = Modifier.height(40.dp))
                        LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                            items(categories) { item ->
                                GridItem(item = item)
                                
                            }
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreenText() {
    Text(text = "Choose the category and start exploring the world of Nobel laureates")
}

@Composable
fun GridItem(item: String){
    Card(
        modifier = Modifier.padding(8.dp),
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 6.dp) 
    {   
        Text(text = item)

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidNobelAppTheme {
        Greeting("Android")
    }
}