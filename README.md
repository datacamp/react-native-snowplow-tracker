
# react-native-snowplow-tracker

## Getting started

`$ npm install react-native-snowplow-tracker --save`

### Mostly automatic installation

`$ react-native link react-native-snowplow-tracker`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-snowplow-tracker` and add `RNSnowplowTracker.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSnowplowTracker.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNSnowplowTrackerPackage;` to the imports at the top of the file
  - Add `new RNSnowplowTrackerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-snowplow-tracker'
  	project(':react-native-snowplow-tracker').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-snowplow-tracker/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-snowplow-tracker')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNSnowplowTracker.sln` in `node_modules/react-native-snowplow-tracker/windows/RNSnowplowTracker.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Snowplow.Tracker.RNSnowplowTracker;` to the usings at the top of the file
  - Add `new RNSnowplowTrackerPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNSnowplowTracker from 'react-native-snowplow-tracker';

// TODO: What to do with the module?
RNSnowplowTracker;
```
  