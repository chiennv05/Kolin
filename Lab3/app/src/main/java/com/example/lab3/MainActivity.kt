    package com.example.lab3

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.layout.*
    import androidx.compose.material3.*
    import androidx.compose.runtime.*
    import androidx.compose.runtime.saveable.rememberSaveable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.example.lab3.lab5.Bai2
    import com.example.lab3.lab5.Bai3
    import com.example.lab3.ui.theme.Lab3Theme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                Lab3Theme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MyApp(

                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }


    @Composable
    fun MyApp( modifier: Modifier = Modifier ) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "Bai3") {
            composable("Bai2") {
                Bai2()
            }

            composable("Bai3") {
                Bai3()
            }



        }
    }



    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun GreetingPreview() {
        Lab3Theme {
            MyApp()
        }
    }