# Zodire Android

Native Android dating app foundation built with Kotlin, Jetpack Compose and Material 3.

## Current milestone
A native Android shell and initial CI workflow. Authentication, profiles, discovery, matching, chat and astrology calculations are planned as separate milestones.

## Stack
- Kotlin + Jetpack Compose
- MVVM / repository boundaries
- Firebase Authentication, Firestore, Storage and Cloud Messaging (not connected yet)
- Separate, validated Vedic astrology calculation module/service

## Open and run
Open this folder in Android Studio, sync Gradle, then run the `app` configuration on an Android device or emulator.

Package: `com.zodire.app`

## Firebase setup
Create a Firebase project, register `com.zodire.app`, and place the downloaded `google-services.json` in `app/` when Firebase integration is implemented. Never commit service-account keys or production secrets.

## Product principles
- 18+ only.
- Obtain consent before processing birth details.
- Allow birth time to be unknown.
- Never expose exact birth time/place on public profiles.
- Provide block, report, moderation, and account/data deletion before public launch.
- Astrology is an interpretive feature, not a guarantee of relationship outcomes.

See `docs/PRODUCT_PLAN.md`.
