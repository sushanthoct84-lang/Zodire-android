ZODIRE NATIVE ANDROID HOME SCREEN PATCH

Files:
- app/src/main/java/com/zodire/app/MainActivity.kt
- app/build.gradle.kts
- app/src/main/res/drawable-nodpi/zodire_logo.png
- app/src/main/res/drawable-nodpi/zodire_wheel_half_speed.gif

Apply to the existing Zodire-android project by replacing the matching MainActivity.kt and app/build.gradle.kts files, and copying the two drawable assets into the matching drawable-nodpi folder. Keep the existing project-level Gradle files and AndroidManifest.xml.

The wheel GIF is the supplied animation re-encoded at half speed and reduced to 480x480 for a smaller app asset. The supplied original Zodire logo is included as a transparent PNG.

The Home screen's sample preview fields are UI only. The live matching/backend flow is not implemented by this patch. The Continue button currently displays a clear beta notice rather than pretending that matching is live.
