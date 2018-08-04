# DriverTracker

Sample Android project showing a Google Map with polygons for fields and markers for locations, using Trecker API.

<p align="center">
 <img width="400" alt="Screenshot of some fields" src="https://github.com/sigute/DriverTracker/blob/master/map.png">
</p>

Used Kotlin, MVP architecture, Google Map, common libraries such as Dagger, Retrofit and RxJava.

Time taken: **~3 hours**

Added TODOs where things could be improved given more time, such as handling rotation, adding additional information to the polygons/markers, adding a new screen for login, nicer error handling (invluding auth errors).

To run the project, add Google maps key and client credentials to gradle.properties file in the following format:
```
USERNAME=username
PASSWORD=password
MAPS_API_KEY=mapskey
```

Or try apk: https://github.com/sigute/DriverTracker/blob/master/app-release.apk

### Full library/resource list

- https://github.com/ReactiveX/RxAndroid
- https://github.com/ReactiveX/RxJava
- https://github.com/square/retrofit
- https://github.com/google/dagger
- https://developers.google.com/maps/documentation/android-sdk/intro
- https://github.com/googlemaps/android-maps-utils
- https://www.materialpalette.com
- https://appicon.co
