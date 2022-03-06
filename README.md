# PokemonApp
an idea of the app is to display pokemons and it's name use different libs and Design pattern user can see and \n check
## Retrofit 
- At the first we must add Dependencies of Retrofit 
```
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0"
```

## Dagger-hilt

- At the first we must add Dependencies of hilt 
```
    implementation "com.google.dagger:hilt-android:2.28-alpha"
    annotationProcessor 'com.google.dagger:hilt-android-compiler:2.28-alpha'
    implementation 'androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01'
    annotationProcessor 'androidx.hilt:hilt-compiler:1.0.0-alpha01'
```

## RxJava
- At the first we must add Dependencies of RxJava 
```
    implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
    implementation 'io.reactivex.rxjava3:rxjava:3.0.0'
```

## RoomDB
- At the first we must add Dependencies of RoomDB 
```
    def room_version = "2.2.5"

    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"
    implementation "androidx.room:room-rxjava2:$room_version"
```

## MVVM
#### it is a software design pattern that is structured to separate program logic and user interface controls. MVVM is also known as model-view-binder and was created by Microsoft architects Ken Cooper and John Gossman.

The separation of the code in MVVM is divided into View, ViewModel and Model:

- View is the collection of visible elements, which also receives user input. This includes user interfaces (UI), animations and text. The content of View is not interacted with directly to change what is presented.

- ViewModel is located between the View and Model layers. This is where the controls for interacting with View are housed, while binding is used to connect the UI elements in View to the controls in ViewModel.

- Model houses the logic for the program, which is retrieved by the ViewModel upon its own receipt of input from the user through View.

##  Repository pattern
#### Here we will write the Repository pattern and it's Dependcies

##  Glide
- At the first we must add Dependencies of Glide
```
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
```

## ViewModel
- At the first we must add Dependency of ViewModel
```
    implementation 'androidx.lifecycle:lifecycle-viewmodel:2.2.0'
```
## Other usable Dependcies
```
 def nav_version = "2.3.0-beta01"

    implementation "androidx.recyclerview:recyclerview:1.1.0"
    implementation "androidx.cardview:cardview:1.0.0"
    implementation 'com.google.android.material:material:1.1.0'
    implementation 'com.android.support:multidex:1.0.3'```
    
    // Navigation
    implementation "androidx.navigation:navigation-fragment:$nav_version"
    implementation "androidx.navigation:navigation-ui:$nav_version"
```

