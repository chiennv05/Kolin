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
    import com.example.lab3.ui.theme.Lab3Theme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                MyApp("Nguyễn Văn Chiến - PH50713")
            }
        }
    }

    @Composable
    fun MyApp(Name: String) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            GreetingMessageCard("Hello, $Name")
            CounterCard()
        }



    }

    @Composable
    fun GreetingMessageCard(msg: String) {
        var text by remember { mutableStateOf(msg) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MessageTextCard(msg = text)
            Button(onClick = { text = "Hi!" }) {
                Text("Say Hi!")
            }
        }
    }


    @Composable
    fun MessageTextCard(msg: String) {
        Text(
            text = msg,
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .fillMaxWidth(),
            color = Color.DarkGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }

    @Composable
    fun CounterCard() {
        var count by rememberSaveable { mutableIntStateOf(0) }
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MessageTextCard(    "You have clicked the button $count times.")
            Button(onClick = { count++ }) {
                Text("Click me")
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        Lab3Theme {
            MyApp("Nguyễn Văn Chiến - PH50713")
        }
    }
