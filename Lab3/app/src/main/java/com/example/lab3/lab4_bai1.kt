package com.example.lab3

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.lab3.ui.theme.Lab3Theme

class lab4_bai1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab3Theme {
                    LoginApp(

                    )

            }
        }
    }
}

@Composable
fun LoginApp () {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.LightGray),
        contentAlignment = Alignment.Center,
    ) {
        Card (
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            colors = CardDefaults.cardColors(containerColor =
            Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation =
            4.dp)
        ) {
            Login()
        }
    }
}

@Composable
fun Login( modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    if (showDialog) {
        DialogLogin(
            onConfirmation = { showDialog = false },
            dialogTitle = "Notification",
            dialogMessage = dialogMessage
        )
    }
    Column (modifier = modifier
        .fillMaxWidth().padding(32.dp, 24.dp)
        , verticalArrangement = Arrangement.Center
    , horizontalAlignment = Alignment.CenterHorizontally)


    {
        Image(painter = painterResource(id =
        R.drawable.ic_launcher_foreground), contentDescription =
        "Logo")
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier.width(1000.dp). padding(10.dp),
            value = userName, onValueChange = {
            userName = it }, label = { Text(text = "UserName") })
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            modifier = Modifier.width(1000.dp). padding(10.dp),
            value = password, onValueChange = {
            password = it }, label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(10.dp))
        RememberMeSwitch()
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (userName.isNotBlank() && password.isNotBlank()) {
                    dialogMessage = "Login successfully"

                } else {
                    dialogMessage = "Please enter username and password"

                }
                showDialog = true
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White)) {
            Text("Login")
        }
    }
}

@Composable
fun DialogLogin(onConfirmation: () -> Unit, dialogTitle: String, dialogMessage: String) {
    Dialog(onDismissRequest = {}) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,

            ),
            modifier = Modifier.padding(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column (
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(dialogTitle, style =
                MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(20.dp))
                Text(dialogMessage, style =
                MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = onConfirmation,
                    modifier = Modifier.align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.White
                    )
                )  {
                    Text("OK")
                }
            }
        }
    }

}

@Composable
fun RememberMeSwitch () {
    var isChecked by remember { mutableStateOf(false) }
    Row (Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        ) {
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
        )
        Text("Remember Me?", modifier = Modifier.padding(start =
        12.dp))
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    Lab3Theme {
        LoginApp()
    }
}