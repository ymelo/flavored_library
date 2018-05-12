# Flavored libraries
This example shows how to add different implementations depending on the library's flavor.  

The main use case for doing this, is to distribute libraries with different implementation (restricted features or noop implementations,
invisible features to some flavors of the library and other cases).

## Gradle, Android plugin, and other considerations
This example was made using gradle 4.6, the latest 3+ Android plugin.
This example will not work with gradle 3+ due to the restrictions related to the available Android plugins for this version of gradle.

## Full vs restricted
The library was split into two version, full, which contains an extra class, and restricted.
Full and restricted both have a Configuration class, but with different implementations.
This could be used in real life scenario to have different behaviours depending flavor (different authentication mechanism for example).

The full library contains a SuperConfiguration class, not accessible from the restricted.  
This shows the use case where one version of the library comes with a feature absolutely not visible with the restricted version. This could be used during development (even on the release).

## Library setup
Since we are using a version of the Android plugin higher than 3.0.0, we need to add a flavorDimensions with any name you want (make it relevant to what you are doing :)).  
Assign your flavors to that dimension.   
```groovy
    flavorDimensions "mode"
    productFlavors  {
        restricted {
            dimension "mode"
        }
        full {
            dimension "mode"
        }
    }
```
## App setup
The app setup needs to mimic the library. When done this way, Android studio will automatically set both the app and the library to the same flavor.  
```groovy
    flavorDimensions "mode"
    productFlavors  {
        restricted {
            dimension "mode"
            applicationId = "com.ymelo.moduletest.restricted"
        }
        full {
            dimension "mode"
            applicationId = "com.ymelo.moduletest.full"
        }
    }
```

Give it a try, and set the app flavor to fullDebug. You will see that the library flavor will switch to fullDebug as well.  
You are ready to start implementation your library.
