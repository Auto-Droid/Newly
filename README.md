![newly 2](https://cloud.githubusercontent.com/assets/2684979/20462091/9357647c-af38-11e6-992f-07b9c263bb59.png)

<a href="https://raw.githubusercontent.com/xmartlabs/Eureka/master/LICENSE"><img src="http://img.shields.io/badge/license-MIT-blue.svg?style=flat" alt="License: MIT" /></a>
<a href="http://kotlinlang.org/"><img src="https://img.shields.io/badge/kotlin-compatable-blue.svg?style=flat" alt="kotlin" /></a>
<a href="https://www.android.com"><img src="https://img.shields.io/badge/Android-v0.1-brightgreen.svg?style=flat" alt="Android" /></a>


`Newly` is a drop in solution to add Twitter/Facebook/Linkedin style, new updates/tweets/posts available button. It can be used to notify user about new content availability and other actions by just calling methods in kotlin

- [Requirements](#requirements)
- [Installation](#installation)

## Requirements

- Android version 5.0 and above (Work in progress to support lower versions 🙏)

## Installation

In your Project's build.gradle file:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

In your Application's or Module's build.gradle file:
```gradle

	dependencies {
		        compile 'com.github.Auto-Droid:Newly:0.1'
		}

```

In your Kotlin class:
 Initialize library using builder pattern.

```kotlin

  var newly = Newly.Build(activity as MainActivity)
                    .setText("  ↑ New Tweets  ")
                    .setBackgroundDrawable(R.drawable.rectangle)
                    .setTextColor("#FFFFFF")
                    .setHeightOffset(250)
                    .build();
            newly.show()

```


##Ios compatible 
https://github.com/dhirajjadhao/Newly

This project is licensed under<a href="https://github.com/Auto-Droid/Newly/blob/master/LICENSE">MIT LICENSE</a> 
- see the <a href="https://github.com/Auto-Droid/Newly/blob/master/LICENSE">LICENSE.md</a> file for details


@Contributor <a href="https://github.com/advait-android">Advait Pakhode</a>

