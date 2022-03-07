# PokemonApp
an idea of the app is to display Pokemons and it's name use different libs and Design pattern user can see.

we will use [PokeApi](https://pokeapi.co/) to retrive the data and display it into our application.

At the end i need to thank [Aly El Hamalawey](https://github.com/Alinasser96) for this great tutorial on [coding with nerds](https://www.youtube.com/channel/UCnDAXfhnL5j-KhHc1KhvXHw).

## Retrofit 
- At the first we must add Dependencies of Retrofit 
```
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0"
```

## [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android#groovy) 

- At the first we must add Dependencies of hilt 
```
    implementation "com.google.dagger:hilt-android:2.28-alpha"
    annotationProcessor 'com.google.dagger:hilt-android-compiler:2.28-alpha'
    implementation 'androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01'
    annotationProcessor 'androidx.hilt:hilt-compiler:1.0.0-alpha01'
```
- add the plugin of that liberary
```
plugins {
  id 'kotlin-kapt'
  id 'dagger.hilt.android.plugin'
}
```
- add complier java8 into android {} object
```
   compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
```
- add classPath on build.gradle in project not module
```
   classpath 'com.google.dagger:hilt-android-gradle-plugin:2.38.1'
```

very good now we need to make hilt run all over the application let me explain more 
, I need to change the defualt Application class which runs before any Activity or fragment to know 
that so we will use @HiltAndroidApp Annotation for my Base Applicaiton new calss
```
@HiltAndroidApp
public class BaseApplication extends Application {

}
```

so then we will draw the Acyclic graph and get the dependent and dependencies :

![The Acyclic Graph ](https://github.com/mohamedgomaa23722/PokemonApp/blob/master/Unnamed%20File.png)

To draw this diagram i used [EdrawMax](https://www.edrawmax.com/online/en/) to draw it.

> As you see at the graph repo depend on retrofit so we need to ask about that class
is not main which mean that i can't change any thing on it so at this case we need to use 
@module, @Provides and @Singelton annotations to create an module class for retrofit called [RetrofitModule](https://github.com/mohamedgomaa23722/PokemonApp/blob/master/app/src/main/java/com/pok/pokemonapp/di/RetrofitModule.java).

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
- we will use glide to set the pokemon Image into our image view 
 >  Glide.with(Context).load(Url)
                .into(pokemonImageView);
## ViewModel
- At the first we must add Dependency of ViewModel
```
    implementation 'androidx.lifecycle:lifecycle-viewmodel:2.2.0'
```

- Second thing As we know that this view model depend on repository so we will create a constructor 
with this repo and activity depend on view model so we will add new annotation used for this view model with hilt
>    @ViewModelInject

- Then we find some problem on the api that the url doesn't belong to the image path so we need to find 
  the path to observe the image of pokemon.
  > I noticed that the url has the item id so we will use it with image path 
  > The path will be like that URL / PokemonID.png 
  
 - so the steps for that process to get the id from the url:
   - split the url into String array
   - Add ( real image url + last element in that array + .png )
 
          ```
         .map(new Function<PokemonResponse, ArrayList<Pokemon>>() {
                    @Override
                    public ArrayList<Pokemon> apply(PokemonResponse pokemonResponse) throws Throwable {
                        ArrayList<Pokemon> list = pokemonResponse.getResults();
                        for (Pokemon pokemon : list) {
                            String url = pokemon.getUrl();
                            String[] pokemonIndex = url.split("/");
                            pokemon.setUrl(IMAGE_URL + pokemonIndex[pokemonIndex.length - 1] + ".png");
                        }
                        return list;
                    }
                })
                
                ```
    Real Image Url is : [Go the Real Image url](https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/1.png) 
 
 - now we can use this view model now congratulation

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

