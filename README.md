# Appium + Cucumber + JUnit 5 Android Test Framework (Java)

An Android UI test automation framework built with Appium (UiAutomator2) for Java, Cucumber (BDD), and JUnit 5, using the Page Object Model. It runs against the built-in Android Settings app on an emulator, so no APK is needed.

## What it covers
- Opening the Settings app and reading elements by id
- Navigating into sections by their on-screen text
- A Cucumber Scenario Outline that opens several Settings sections with an Examples table
- Locators written with `AppiumBy.id` and `AppiumBy.xpath`

## Tech stack
- Java 17+, Maven
- Appium server 4.x with the UiAutomator2 driver
- Appium Java client 10.x
- Cucumber 7 with the JUnit Platform engine
- JUnit 5

## Project structure
- `src/test/resources/features`: Gherkin feature files
- `src/test/java/steps`: step definitions
- `src/test/java/pages`: page objects (`SettingsPage`)
- `src/test/java/hooks`: starts and stops the Appium session for each scenario
- `src/test/java/runners`: the Cucumber test runner
- `src/test/java/tests`: plain Appium + JUnit tests

## Prerequisites
- Node.js and the Appium server: `npm install -g appium`
- The Android driver: `appium driver install uiautomator2`
- Android Studio with an Android emulator (a Pixel 8 virtual device was used)
- `ANDROID_HOME` and `JAVA_HOME` set

## How to run
1. Start the emulator and wait for the home screen. `adb devices` should list it.
2. Start the Appium server in a separate window:

        appium

3. Run the tests:

        mvn test

The device name and app are set in `hooks/Hooks.java`. Change them there to test a different device or app.
