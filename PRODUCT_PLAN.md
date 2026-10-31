# Zodire product and delivery plan

## Product definition
Zodire is an 18+ dating app for adults in India. Its familiar swipe-and-match experience is enhanced with optional Vedic astrology insights. Astrology is a discovery lens, not a promise of compatibility or relationship success.

## Milestones
1. **Android foundation:** Kotlin, Compose, app identity and CI.
2. **Account and profile:** authentication, age gate, consent, photos, bio, interests, preferences and optional birth details.
3. **Discovery and matching:** swipe, like/pass, mutual matches, filters and distance preferences.
4. **Astrology compatibility:** explainable component scores and uncertainty handling.
5. **Chat and trust:** match-only chat, block, report, unmatch, moderation and deletion.
6. **Public launch:** privacy policy, terms, data safety, security review, Play Store listing and testing.

## Astrology scope
- Ashtakoota / Guna Milan (36 points): Varna (1), Vashya (2), Tara (3), Yoni (4), Graha Maitri (5), Gana (6), Bhakoot (7), Nadi (8).
- Manglik analysis with relevant Mars placements and cancellation conditions.
- Moon sign and Nakshatra comparison.
- Venus/Mars, Jupiter/Saturn and 7th-house factors where birth data supports them.
- Navamsa (D9) and Vimshottari Dasha only when accurate birth time is available.
- South Indian 10-Porutham as a possible regional view.
- Show component-level reasoning and flag missing or uncertain inputs.

## Birth-data safeguards
- Never display exact birth time or birth place on public profiles.
- Ask for consent before using birth details for compatibility.
- If birth time is unknown, do not fabricate ascendant, house placements, D9 or time-sensitive dasha results.
- Minimize stored data, apply strict access rules and support deletion.

## Architecture direction
- Android client: Kotlin, Compose, MVVM.
- Backend: Firebase Authentication, Firestore, Storage and Cloud Messaging, subject to free-tier limits and security review.
- Astrology: isolated calculation module/service with documented ephemeris, timezone and ayanamsa assumptions. Validate against trusted test charts before release.
- Keep matching and chat authorization backend-authoritative.

## Initial non-goals
- No web app or PWA.
- No claim that astrology is scientifically proven.
- No paid subscriptions in the first prototype.
- No production credentials committed to Git.
