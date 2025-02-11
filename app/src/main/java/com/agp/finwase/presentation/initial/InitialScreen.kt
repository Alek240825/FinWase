package com.agp.finwase.presentation.initial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agp.finwase.R
import com.agp.finwase.ui.theme.background
import com.agp.finwase.ui.theme.primary
import com.agp.finwase.ui.theme.text

@Preview
@Composable
fun InitialScreen(navigationToLogin: () -> Unit = {}, navigationToSignUp: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        // Opciones mas acertadas son el dos y el tres
        Image(
            painter = painterResource(id = R.drawable.diseno2),
            contentDescription = "FinWase Logo"
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "Organiza Tu Economia",
            color = text,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Con FinWase",
            color = text,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navigationToSignUp() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = primary)
        ) {
            Text("Comenzar gratis", color = text, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        CostomButton()
        Text(
            "Iniciar sesion",
            color = text,
            modifier = Modifier
                .padding(24.dp)
                .clickable { navigationToLogin() }
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun CostomButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 32.dp)
            .background(background)
            .border(2.dp, text, CircleShape),
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "Google",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(16.dp)
        )
        Text(
            text = "Continuar con Google",
            color = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}
