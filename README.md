
# @datacamp/react-native-snowplow-tracker

Please note this currently only binds very basic tracker features.

## Getting started

Install the native Snowplow Tracker in your project by following the official instructions [[iOS](https://github.com/snowplow/snowplow/wiki/iOS-Tracker)/[Android](https://github.com/snowplow/snowplow/wiki/Android-Tracker)].

`$ npm install @datacamp/react-native-snowplow-tracker --save`

### Mostly automatic installation

`$ react-native link @datacamp/react-native-snowplow-tracker`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-snowplow-tracker` and add `RNSnowplowTracker.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSnowplowTracker.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.snowplow.RNSnowplowTrackerPackage;` to the imports at the top of the file
  - Add `new RNSnowplowTrackerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':@datacamp_react-native-snowplow-tracker'
  	project(':@datacamp_react-native-snowplow-tracker').projectDir = new File(rootProject.projectDir, 	'../node_modules/@datacamp/react-native-snowplow-tracker/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':@datacamp_react-native-snowplow-tracker')
  	```

## Usage
```javascript
import Snowplow from 'react-native-snowplow-tracker';

// Initialize
Snowplow.initialize({
  endpoint: 'com.acme.net',
  protocol: 'https',
  httpMethod: 'POST',
  namespace: 'your-namespace',
  appId: 'your-app',
})

// Track structured events
Snowplow.trackStructEvent({
    category: 'shop',
    action: 'add-to-basket',
    label: 'Add To Basket',
    property: 'pcs',
    value: 2.0,
})
```
  
