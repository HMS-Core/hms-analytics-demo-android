# HMS AnalyticsKit Demo for Android

[![hms](https://img.shields.io/badge/hms-analytics-brightgreen)](https://developer.huawei.com/consumer/en/doc/development/HMS-References/3021004) 

English | [中文](https://github.com/HMS-Core/hms-ananlytics-demo-android/blob/master/README_ZH.md)

## Table of Contents

* [Introduction](#introduction)
* [Getting Started](#getting-started)
* [Installation](#installation)
* [Configuration ](#configuration )
* [Environment requirements](#environment-requirements)
* [Result](#result)
* [License](#license)


## Introduction
Hmsanalyticskitdemo provides an example of integrating HUAWEI Analytics Kit with an app. It illustrates how to collect predefined events and custom events to improve user engagement and user preference.
[Read more about Hianalytics](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/introduction-0000001050745149-V5).

## Getting Started

For more development guidance, please refer to the links below:

[Development Guide](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/android-dev-process-0000001050163813-V5).

[API References](https://developer.huawei.com/consumer/en/doc/development/HMSCore-References-V5/android-api-analytics-overview-0000001051067140-V5).

In this example, we demonstrate how to use the analytics SDK for Android by using the Gradle build system.

First download Hmsanalyticskitdemo by cloning this repository or downloading an archived snapshot.

In Android Studio, click Open an existing Android Studio project, and select analytics-sample.

You can use the gradlew build command to build the project directly.

You should create an app in AppGallery Connect, and obtain the agconnect-services.json file and add it to the project. You should also generate a signing certificate fingerprint and add the certificate file to the project, and add configuration to the build.gradle file.  More to [Development Process](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/android-dev-process-0000001050163813-V5).


## Installation
Use Android Studio to open the decompressed project.

## Configuration
1. Create an app in AppGallery Connect and obtain the project configuration file agconnect-services.json. In Android Studio, switch to the Project view and move the agconnect-services.json file to the root directory of the app.
2. Change the value of applicationId in the build.gradle file of the app to the name of the app package applied for in the preceding step.

## Environment requirements
Hardware requirements:
1. A computer (desktop or laptop)
2. A Huawei phone, which is used to debug the developed app
    
Software requirements:
1. HUAWEI Analytics Kit 5.0.3
2. Android SDK applicable to devices using Android 4.4 KitKat (API level 19) and later versions
3. Android Studio 
4. Java JDK 1.7 (JDK 1.8 is recommended.)

## Result
After running the app you should see a screen like this:

<img src="https://github.com/HMS-Core/hms-ananlytics-demo-android/blob/master/images/screen_0.PNG" width=250 title="ID Photo DIY" div align=center border=5>

Click TRUE or FALSE to answer the question; Click NEXT to show the next question; Click POST SCORE, log the score user got. All the information will be uploaded to the Hianalytics Console, and you can see these information in real time using Debug View.

Click button SETTINGS:

<img src="https://github.com/HMS-Core/hms-ananlytics-demo-android/blob/master/images/screen_1.PNG" width=250 title="ID Photo DIY" div align=center border=5>

When you click SETTINGS, you will be asked for your favorite sport. Your choice will be logged by Hianalytics as a user attribute.

## Question or issues
If you want to evaluate more about HMS Core,
[r/HMSCore on Reddit](https://www.reddit.com/r/HuaweiDevelopers/) is for you to keep up with latest news about HMS Core, and to exchange insights with other developers.

If you have questions about how to use HMS samples, try the following options:
- [Stack Overflow](https://stackoverflow.com/questions/tagged/huawei-mobile-services) is the best place for any programming questions. Be sure to tag your question with 
`huawei-mobile-services`.
- [Huawei Developer Forum](https://forums.developer.huawei.com/forumPortal/en/home?fid=0101187876626530001) HMS Core Module is great for general questions, or seeking recommendations and opinions.

If you run into a bug in our samples, please submit an [issue](https://github.com/HMS-Core/hms-ananlytics-demo-android/issues) to the Repository. Even better you can submit a [Pull Request](https://github.com/HMS-Core/hms-ananlytics-demo-android/pulls) with a fix.

##  License
HmsAnalyticsKitDemo is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
