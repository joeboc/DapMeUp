package com.dapmeup

import android.media.Image
import android.os.Bundle
import androidx.compose.material3.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dapmeup.ui.theme.DapMeUpTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var fYeah by remember {mutableStateOf("(Fuck Yeah)") }
            var message by remember { mutableStateOf("Ready to Dap") }

            Column(modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
                Text(fYeah)
                Text(message)

                Image(modifier = Modifier.padding(40.dp),
                    painter = painterResource(id = R.drawable.dap),
                    contentDescription = "dap image"
                )
                  Button(onClick = {
                    message = "Scanning for dap..."
                },
                      colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                      modifier = Modifier
                          .size(width = 300.dp, height = 100.dp)) {
                    Text(text = "Dap Em Up",
                        color = Color.Black,
                        fontSize = 30.sp)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DapMeUpTheme {
        Greeting("Android")
    }
}