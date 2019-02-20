
package com.snowplow;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class RNSnowplowTrackerModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNSnowplowTrackerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNSnowplowTracker";
  }
}