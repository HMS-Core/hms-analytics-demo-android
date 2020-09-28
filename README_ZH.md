# 华为分析服务Android SDK示例代码

[![hms](https://img.shields.io/badge/hms-analytics-brightgreen)](https://developer.huawei.com/consumer/en/doc/development/HMS-References/3021004) 

[English](https://github.com/HMS-Core/hms-ananlytics-demo-android) | 中文

## 目录

* [简介](#简介)
* [快速入门](#快速入门)
* [安装](#安装)
* [配置](#配置)
* [环境要求](#环境要求)
* [操作结果](#操作结果)
* [授权许可](#授权许可)


## 简介
Hmsanalyticskitdemo提供了华为分析服务（HUAWEI Analytics Kit）与app集成的示例代码。其演示了如何通过收集预定义事件和自定义事件以提高用户参与度和用户偏好。[了解更多有关Hianalytics的信息](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/introduction-0000001050745149-V5)。

## 快速入门

更多开发指导，请参考以下链接文档：

[开发指南](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/android-dev-process-0000001050163813-V5).

[API参考](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-References-V5/android-api-analytics-overview-0000001051067140-V5).

Hmsanalyticskitdemo以Gradle构建系统为例演示了如何使用Android分析服务SDK。

首先，我们通过克隆此仓库或下载压缩包的方式来下载Hmsanalyticskitdemo。

在Android Studio中，点击“Open an existing Android Studio project”，选择“analytics-sample”。

您可以直接运行gradlew build命令构建工程。

您需要在AppGallery Connect中创建应用，获取agconnect-services.json文件，并将文件添加到项目中。此外，您还需要生成签名证书指纹，在项目中添加证书文件，并将配置添加到build.gradle文件中。[进一步了解开发流程](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/android-dev-process-0000001050163813-V5)。


## 安装
使用Android Studio打开解压后的工程。

## 配置
1. 在AppGallery Connect中创建应用，并获取项目配置文件agconnect-services.json。在Android Studio中，切换到Project视图，将agconnect-services.json文件移动到app的根目录下。 
2. 修改app的build.gradle文件中的applicationId为上一步申请的app包名。

## 环境要求
硬件要求：
1. 电脑（台式机或笔记本）
2. 华为手机，用于应用调试
    
软件要求：
1. 华为分析服务5.0.3
2. 适配Android 4.4 KitKat（API Level 19）及以上版本的设备
3. Android Studio 
4. Java JDK 1.7（推荐使用1.8版本）

## 操作结果
运行该app后，您将会看到如下页面：

<img src="https://github.com/HMS-Core/hms-ananlytics-demo-android/blob/master/images/screen_0.PNG" width=250 title="ID Photo DIY" div align=center border=5>

点击“TRUE”或“FALSE” 按钮进行答题；点击“NEXT” 按钮进入下一道题；点击“POST SCORE”按钮记录用户获得的分数。所有信息将被上传到Hianalytics控制台，您可以使用Debug View实时查看这些信息。

点击SETTINGS按钮:

<img src="https://github.com/HMS-Core/hms-ananlytics-demo-android/blob/master/images/screen_1.PNG" width=250 title="ID Photo DIY" div align=center border=5>

当点击SETTINGS按钮，您会被要求提供最喜欢的运动。您的选择将作为用户属性记录到Hianalytics中。

## 技术支持
如果您对HMS Core还处于评估阶段，可在[Reddit社区](https://www.reddit.com/r/HuaweiDevelopers/)获取关于HMS Core的最新讯息，并与其他开发者交流见解。

如果您对使用HMS示例代码有疑问，请尝试：
- 开发过程遇到问题上[Stack Overflow](https://stackoverflow.com/questions/tagged/huawei-mobile-services)，在`huawei-mobile-services`标签下提问，有华为研发专家在线一对一解决您的问题。
- 到[华为开发者论坛](https://developer.huawei.com/consumer/cn/forum/blockdisplay?fid=18) HMS Core板块与其他开发者进行交流。

如果您在尝试示例代码中遇到问题，请向仓库提交[issue](https://github.com/HMS-Core/hms-ananlytics-demo-android/issues)，也欢迎您提交[Pull Request](https://github.com/HMS-Core/hms-ananlytics-demo-android/pulls)。

## 授权许可
HmsAnalyticsKitDemo经过[Apache 2.0授权许可](http://www.apache.org/licenses/LICENSE-2.0)。

