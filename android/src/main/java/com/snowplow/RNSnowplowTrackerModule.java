
package com.snowplow;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.snowplowanalytics.snowplow.tracker.Emitter;
import com.snowplowanalytics.snowplow.tracker.Tracker;
import com.snowplowanalytics.snowplow.tracker.emitter.HttpMethod;
import com.snowplowanalytics.snowplow.tracker.emitter.RequestSecurity;
import com.snowplowanalytics.snowplow.tracker.events.Structured;

public class RNSnowplowTrackerModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private Tracker tracker;

    public RNSnowplowTrackerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNSnowplowTracker";
    }

    @ReactMethod
    public void initialize(ReadableMap options) {
        Emitter emitter = new Emitter.EmitterBuilder(options.getString("endpoint"), this.reactContext)
                .method(options.getString("httpMethod").equals("POST") ? HttpMethod.POST : HttpMethod.GET)
                .security(options.getString("protocol").equals("https") ? RequestSecurity.HTTPS : RequestSecurity.HTTP)
                .build();

        this.tracker = Tracker.init(new Tracker
                .TrackerBuilder(emitter, options.getString("namespace"), options.getString("appId"), this.reactContext)
                .base64(false)
                .build()
        );
    }

    @ReactMethod
    public void trackStructEvent(ReadableMap options) {
        if (this.tracker == null) {
            return;
        }

        Structured event = Structured.builder()
                .category(options.getString("category"))
                .action(options.getString("action"))
                .label(options.getString("label"))
                .property(options.getString("property"))
                .value(Double.parseDouble(options.getString("value")))
                .build();

        this.tracker.track(event);
    }
}