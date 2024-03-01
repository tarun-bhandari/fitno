## Documentation

Welcome to the documentation of the fitno app  
> I am documenting development of the app in this file  

### Projects Structure

I am trying to keep the structure of the project simple and easy to understand.  
For now the project structure look like this:

```
- Fitno
    - data
        -local #local database
        -remote #remote api calling
    - di
    - ui
        - screen # screen with their components and viewmodels
            - home
            - challenge
            - login
            - onboarding
            - setting
        -theme #default
    - util # storing the helper classes and other utils
```

Where the  
data -> storing the database related file in this package  
di -> storing the dependency injection related file in this package  
ui -> storing the ui related file in this package  
util -> storing the helper class in this package  

### Library used

- [Room](https://developer.android.com/jetpack/androidx/releases/room)
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Compose Navigation](https://developer.android.com/jetpack/compose/navigation)
- [KSP](https://kotlinlang.org/docs/ksp-overview.html)


