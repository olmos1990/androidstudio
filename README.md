# android studio
fixed: 
  
added the code below to program
```
dependencies {
   ... ... ...
   implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
   implementation 'com.android.volley:volley:1.2.1'
   ... ... ...
}
```
```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
  ...
    <uses-permission android:name="android.permission.INTERNET"/>
  ... ... ...
```
