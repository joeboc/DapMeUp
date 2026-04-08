package com.dapmeup

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DapScreen()
        }
    }
}

@Composable
fun DapScreen(){
    val fYeah = "(Fuck Yeah)"
    var message by remember { mutableStateOf("Ready to Dap") }
    var isScanning by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

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
            isScanning = true
            message = "Scanning for dap..."

            scope.launch {
                delay(1500)
                message = "DAP DETECTED 👊"
                isScanning = false
            }
        },
            enabled = !isScanning,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .size(width = 300.dp, height = 100.dp)) {
            Text(text = "Dap Em Up",
                color = Color.Black,
                fontSize = 30.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DapScreenPreview() {
    DapScreen()
}