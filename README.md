  [![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
  [![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=16)
  [![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
  ![Maven Central](https://img.shields.io/maven-central/v/io.github.DevComm-in/Toaster)
  [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Asyncer-green.svg?style=flat )]( https://android-arsenal.com/details/1/6357 )

<!-- <a href="https://www.linkedin.com/in/"> -->
<!--    <img src="https://img.shields.io/badge/Support-Recommed%2FEndorse%20me%20on%20Linkedin-yellow?style=for-the-badge&logo=linkedin" alt="Connect with us" /></a> -->


# Asyncer (Backgrounnd Task Manager Library)
- It let you do your task in background thread with callback of completion or failure.<br>
- It is Light weight, super easy to implement (See Example)<br>
- It is based on android's modern Architecture: Coroutine<br>


### How to use this library,<br>
1. Add it in your `setting.gradle` in project view:
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
	...
	(maven { url 'https://jitpack.io' }) 
    }
}
```


2. Add the dependency in app level `build.gradle`:
```bash
  dependencies {
	  implementation 'com.github.DevComm-in:Asyncer:v1.0.0'
  }
```



## Example Use Case:
```kotlin
class MainActivity : AppCompatActivity() {

    // start btn
    private lateinit var btn : Button
    
    //progressbar
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn)
        progressBar = findViewById(R.id.progress_bar)


        btn.setOnClickListener{
            onClick()
        }

    }


    //when start btn is clicked
    private fun onClick(){
    
        //showing indicator that background task is started
        progressBar.visibility = View.VISIBLE
        
        Asyncer().init(object : Task {
        
            //your background task
            override fun backgroundTask() {
                for(i in 1..100000){
                    Log.d("count", "backgroundTask: $i")
                }
            }

            /** what do you wanna do when task is cmpleted
            *   I am turning off progressBar and toasting a message 
            */
            override fun onTaskCompletion() {
                progressBar.visibility = View.GONE
                Toast.makeText(this@MainActivity, "Done", Toast.LENGTH_SHORT).show()
                Log.d("TAG", "onTaskCompletion")
            }
        })
    }

}

```

## Contributing<br>
Contributions are always welcome!
<br>See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.
