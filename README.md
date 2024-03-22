# Weather

## Overview
This Weather App is designed to provide users with current weather data and forecasts for the next 7 days based on the input city. The app saves data locally to ensure offline access and allows users to refresh the data by swiping down, ensuring they always have up-to-date weather information.

## Features
1. **Input City:** Users can input the city for which they want to check the weather.
2. **Current Weather Data:** The app displays current weather information for the specified city, including temperature, humidity, wind speed, and conditions.
3. **7-Day Forecast:** Users can view a forecast for the next 7 days, including temperature highs and lows, and weather conditions.
4. **Local Data Storage:** Weather data is saved locally on the device, allowing users to access it even when offline.
5. **Swipe Refresh:** Users can refresh the weather data by swiping down, ensuring they have the latest information.

# UI
<div align="center">
  <img src="https://github.com/AmrMagdyElmoogy/Weather/assets/47532331/d0125c87-c1d1-4c8a-acda-1683390701b5" width="400" alt="Screenshot 2">
  <img src="https://github.com/AmrMagdyElmoogy/Weather/assets/47532331/bd0893e6-2cd2-451a-9d94-2f4a140ffa78" width="400" alt="Screenshot 1">

</div>

# Architure

## MVVM for Home Screen
For the Home Screen, we've utilized the MVVM (Model-View-ViewModel) architecture pattern. Here's how each component is structured:

1. **Model**: The Model represents the data and business logic of the application. It includes weather data fetched from the API, like temperature, humidity, wind speed, etc.

2. **View**: The View consists of the UI components of the application, created using Jetpack Compose. This includes composables like Text, TextField, Button, etc., which are used to build the user interface dynamically. In MVVM, the View observes changes in the ViewModel and updates itself accordingly.

3. **ViewModel**: Acting as a mediator between the View and the Model, the ViewModel retrieves data from the Model and prepares it for display in the View. In our Weather App, the ViewModel fetches weather data from the Model and exposes it to the View. It also handles user interactions and business logic, like input validation and data formatting.

The MVVM architecture pattern promotes separation of concerns and maintainability in the codebase. The ViewModel separates the UI logic from the UI components, simplifying testing and maintenance.

## MVI for Seven Days Weather Screen
For the Seven Days Weather Screen, we've implemented the MVI (Model-View-Intent) architecture pattern. Here's a breakdown of each component:

1. **Model**: Similar to MVVM, the Model represents the data and business logic of the application. It includes weather forecast data for the next 7 days fetched from the API.

2. **View**: The View renders the UI dynamically using Jetpack Compose and displays data to the user. Unlike MVVM, the View in MVI is passive and does not directly interact with the Model. Instead, it observes a unidirectional data flow and renders the UI based on the state received from the ViewModel.

3. **Intent**: Intents represent user actions or events that trigger state changes in the application. Examples of Intents include fetching weather forecast data, refreshing the data, or selecting a different city. Intents are dispatched by the View and consumed by the ViewModel.

4. **ViewModel**: Responsible for managing the state of the application, the ViewModel receives Intents from the View, processes them, and updates the Model accordingly. The ViewModel then emits a new state, which is observed by the View. Any UI updates are triggered based on changes in the state.

## CI/CD with GitHub Actions and Firebase App Distribution

### Continuous Integration/Continuous Deployment (CI/CD)
CI/CD is a software development practice that involves regularly integrating code changes into a shared repository (Continuous Integration) and automating the deployment of software applications (Continuous Deployment).

### GitHub Actions
GitHub Actions is a CI/CD platform provided by GitHub that allows developers to automate workflows directly within their GitHub repositories. With GitHub Actions, developers can define custom workflows using YAML configuration files, which specify the sequence of steps to be executed when certain events occur, such as pushing code changes or creating pull requests.

### Implementation with Firebase App Distribution
In our Weather App, we have implemented CI/CD using GitHub Actions to automate the deployment of the application using Firebase App Distribution. 

#### Workflow Overview:
1. **Build**: GitHub Actions triggers a build workflow whenever code changes are pushed to the repository.
2. **Test**: The build workflow runs automated tests to ensure the code changes meet quality standards.
3. **Deploy**: After successful testing, the workflow deploys the built APK to Firebase App Distribution for distribution to testers and stakeholders.


