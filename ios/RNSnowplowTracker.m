#import "RNSnowplowTracker.h"
#import <SnowplowTracker/SPTracker.h>
#import <SnowplowTracker/SPEmitter.h>
#import <SnowplowTracker/SPEvent.h>

@interface RNSnowplowTracker ()

@property (nonatomic, strong) SPTracker *tracker;

@end

@implementation RNSnowplowTracker

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(initialize:(NSDictionary *)options) {
    SPEmitter *emitter = [SPEmitter build:^(id<SPEmitterBuilder> builder) {
        [builder setUrlEndpoint:options[@"endpoint"]];
        [builder setHttpMethod:[options[@"httpMethod"] isEqualToString:@"POST"] ? SPRequestPost : SPRequestGet];
        [builder setProtocol:[options[@"protocol"] isEqualToString:@"https"] ? SPHttps : SPHttp];
    }];
    self.tracker = [SPTracker build:^(id<SPTrackerBuilder> builder) {
        [builder setEmitter:emitter];
        [builder setAppId:options[@"appId"]];
        [builder setTrackerNamespace:options[@"namespace"]];
    }];
}

RCT_EXPORT_METHOD(trackStructEvent:(NSDictionary *)options) {
    SPStructured *event = [SPStructured build:^(id<SPStructuredBuilder> builder) {
        [builder setCategory:options[@"category"]];
        [builder setAction:options[@"action"]];
        [builder setLabel:options[@"label"]];
        [builder setProperty:options[@"property"]];
        [builder setValue:[options[@"value"] floatValue]];
    }];
    [self.tracker trackStructuredEvent:event];
}

@end
  
