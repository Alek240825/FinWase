package com.agp.finwase

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.agp.finwase.presentation.initial.InitialScreen
import com.agp.finwase.presentation.login.LoginScreen
import com.agp.finwase.presentation.register.RegisterScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth) {
    NavHost(navController = navHostController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(
                navigationToLogin = { navHostController.navigate("Login") },
                navigationToSignUp = { navHostController.navigate("Register") }
            )
        }
        composable("Login") {
            LoginScreen(auth)
        }
        composable("Register") {
            RegisterScreen(auth)
        }
    }
}