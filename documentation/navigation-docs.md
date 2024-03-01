### Setup Navigation

In this, I will describes how i have setup the navigation using the **compose navigation**  

#### Screens

First, i have created **Screen** file which is a sealed class where, 
I am storing the the route information of the screen.  

Below is the code of Screen file

```kotlin
sealed class Screen(val route: String) {
    object OnBoarding: Screen("onboarding")
    object Login: Screen("onboarding")
    object Home: Screen("home")
}
```

### Setting uo the NavHost

As following the documentation of the compose navigation, I haved created the navgraph, 
and navHost  

This is my NavGraph which I have created
```kotlin
fun MyAppNavGraph(navController: NavHostController, sharedPreferenceHelper: SharedPreferenceHelper) {
    NavHost(navController = navController, startDestination = Screen.OnBoarding.route) {
        composable(Screen.OnBoarding.route) {
            OnBoardingScreen(navController,sharedPreferenceHelper)
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }

    }
}
```

