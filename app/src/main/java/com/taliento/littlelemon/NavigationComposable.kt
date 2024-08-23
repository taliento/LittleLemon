package com.taliento.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.taliento.littlelemon.composables.Home
import com.taliento.littlelemon.composables.Onboarding
import com.taliento.littlelemon.composables.Profile

@Composable
fun NavigationComposable(context: Context,navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = determineStartDestination(context)
    ) {
        composable(com.hanna.littlelemon.Home.route) {
            Home(navController)
        }
        composable(com.hanna.littlelemon.Profile.route) {
            Profile(navController)
        }
        composable(com.hanna.littlelemon.Onboarding.route) {
            Onboarding(navController)
        }
    }
}

private fun determineStartDestination(context: Context): String {
    //check if user data is stored in shared preferences and return the appropriate start destination
    // For example, if user data exists, returns Onboarding
    // Otherwise, returns Home as the default start destination
    val sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)


    if (sharedPreferences.getBoolean("userRegistered", false)) {
        return com.hanna.littlelemon.Home.route
    }
    else{
        return com.hanna.littlelemon.Onboarding.route
    }
}