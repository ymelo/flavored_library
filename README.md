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
