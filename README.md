Sitecore Mobile SDK for Android 1.1
===================================

Sitecore Mobile SDK for Android, is a framework that is designed to help the developer produce Android based applications that use and serve content that is managed by Sitecore. 

This enables developers to rapidly develop Android applications (across multiple Android devices with differing screen sizes) that fully utilize the features of the device, for example, camera, location, accelerometer, and gestures. 

## The SDK includes the following features:

### JavaScript API
 * Show native alert
 * Accelerometer
 * Device information
 * Access to camera and media library
 * Share to social networks
 * Send emails
 * Access to the device address book
 * Open native Google Maps navigation
 * Create calendar events

### Java/Android API
 * Access data from Sitecore CMS
    * Authentication
    * CRUD operations on items
    * Access item fields and properties
    * Upload media items
    * Getting html rendering of an item
 * Items Browser component for browsing through content tree with customizable UI
 * QR Code reader
 * A local SQLite DB can be used with the SDK for easy access of Sitecore items offline

As a part of the release we have created a sample application that can be used as a starting point to understand the Mobile SDK for Android and the features available. 
This project can be found [on Github][4]

All documentation, including installation and developer guides can be found on the [Sitecore Developer Network (SDN)][6]

This repository contains:
 * Source code of the Sitecore SDK for Android framework
 * Binaries of the Sitecore SDK for Android framework in [releases section][5]

## Download

Sitecore SDK for Android framework can be downloaded from [releases section][5] or Maven repository:

```groovy
repositories {
    mavenCentral()
    maven { url "http://sitecore.github.io/sitecore-android-sdk/aar" }
}
dependencies {
    compile 'net.sitecore.android.sdk:sitecore-api-android:1.1'
    
    compile 'net.sitecore.android.sdk:sitecore-js-android:1.1'
    compile 'com.android.support:support-v4:18.0.0'

    compile 'net.sitecore.android.sdk:sitecore-qr-reader:1.1'
    compile 'com.google.zxing:core:2.2'
}
```


## Further Information

 * [Product page on SDN][1]
 * [Sitecore Item Web API module page on SDN][2]
 * [Javadocs documentation][3]
 * [Sample App – SDK for Android][4]

# Licence
```
SITECORE SHARED SOURCE LICENSE
```

 [1]: http://sdn.sitecore.net/Products/Sitecore%20Mobile%20SDK/Sitecore%20Mobile%20SDK%20for%20Android/Mobile%20SDK%201,-d-,1%20for%20Android.aspx
 [2]: http://sdn.sitecore.net/Products/Sitecore%20Item%20Web%20API.aspx
 [3]: http://sitecore.github.io/sitecore-android-sdk/javadoc
 [4]: http://github.com/Sitecore/sitecore-android-sdk-sample
 [5]: https://github.com/Sitecore/sitecore-android-sdk/releases
 [6]: http://sdn.sitecore.net/Products/Sitecore%20Mobile%20SDK/Sitecore%20Mobile%20SDK%20for%20Android/Mobile%20SDK%201,-d-,1%20for%20Android/Documentation.aspx
 