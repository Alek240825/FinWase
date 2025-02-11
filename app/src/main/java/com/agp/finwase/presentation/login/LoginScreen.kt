package com.agp.finwase.presentation.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agp.finwase.R
import com.agp.finwase.ui.theme.background
import com.agp.finwase.ui.theme.selectedField
import com.agp.finwase.ui.theme.text
import com.agp.finwase.ui.theme.unselectedField
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(auth: FirebaseAuth) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(horizontal = 32.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .padding(vertical = 24.dp)
                .size(24.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.diseno2),
                contentDescription = "FinWase Logo",
            )
        }
        Text(
            "Correo",
            color = text,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = unselectedField,
                focusedContainerColor = selectedField,
                focusedTextColor = text,
                unfocusedTextColor = text,
            )
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            "Contraseña",
            color = text,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = unselectedField,
                focusedContainerColor = selectedField,
                focusedTextColor = text,
                unfocusedTextColor = text,
            )
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.i("Inicio de sesion", "Entro correctamente")
                        } else {
                            Log.i("Inicio de sesion", "No entro de manera correcta")
                        }
                    }
                }
            ) {
                Text(text = "Iniciar Sesión")
            }
        }
        Spacer(modifier = Modifier.height(48.dp))
    }
}