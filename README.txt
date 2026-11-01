ZODIRE ANDROID PATCH

This patch contains the native Android welcome/preview screen and the Gradle settings fix.

Copy/replace these files in the root of the GitHub repository:
1. settings.gradle.kts
2. .github/workflows/android-ci.yml
3. app/src/main/java/com/zodire/app/MainActivity.kt
4. app/src/main/res/drawable-nodpi/zodire_logo.png
5. app/src/main/res/drawable-nodpi/zodire_wheel_half_speed.gif

Keep the existing root build.gradle.kts and app/build.gradle.kts. The existing app dependencies already include
Jetpack Compose Material 3 and Glide, which this screen uses.

Then commit the changes to the main branch. GitHub Actions should start automatically.
The APK artifact is named zodire-debug-apk. Download it only after the workflow completes successfully.

The preview form currently displays a preparation notice. It is a UI preview only: live user accounts,
Kundli calculation, matching, swipe profiles, and backend services are not implemented by this patch.
