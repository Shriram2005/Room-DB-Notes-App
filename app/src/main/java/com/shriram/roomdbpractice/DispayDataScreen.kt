package com.shriram.roomdbpractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun DisplayDataScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var userName by remember { mutableStateOf("") }
        var userEmail by remember { mutableStateOf("") }
        var userPassword by remember { mutableStateOf("") }


        Text(text = "Enter Details : ")
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(value = userName, onValueChange = { userName = it })

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = userEmail, onValueChange = { userEmail = it })

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = userPassword, onValueChange = { userPassword = it })

        Button(
            modifier = Modifier
                .padding(vertical = 32.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6F3DFF),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = {
                /*TODO*/
            }

        ) {
            Text(text = "SAVE")
        }


    }

}