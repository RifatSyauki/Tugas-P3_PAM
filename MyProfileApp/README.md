# My Profile App

## Deskripsi
My Profile App adalah aplikasi sederhana yang dibuat menggunakan Kotlin Multiplatform dan Compose Multiplatform. Aplikasi ini menampilkan informasi profil pengguna dalam sebuah halaman profil dengan tampilan sederhana dan terstruktur.
Aplikasi ini dibuat sebagai tugas praktikum Pengembangan Aplikasi Mobile dengan menerapkan dasar-dasar Jetpack Compose, seperti layout, reusable composable, dan state.

## Fitur
- Menampilkan foto profil dalam bentuk circular.
- Menampilkan nama pengguna.
- Menampilkan bio atau deskripsi singkat.
- Menampilkan informasi Email.
- Menampilkan informasi Phone.
- Menampilkan informasi Location.
- Tombol Follow yang dapat mengubah status menjadi Following.
- Menampilkan pesan setelah tombol Follow ditekan.

## Reusable Composable
Aplikasi menggunakan beberapa reusable composable, yaitu:

### ProfileHeader
Digunakan untuk menampilkan foto profil, nama, dan informasi program studi.

### InfoItem
Digunakan untuk menampilkan informasi profil seperti Email, Phone, dan Location.

### ProfileCard
Digunakan sebagai container untuk mengatur tampilan informasi profil dalam sebuah Card.

## Layout yang Digunakan
Aplikasi menggunakan beberapa komponen dasar Compose:
- Column
- Row
- Box
- Card
- Text
- Button
- Image
- Spacer

Kombinasi `Box` dan `Column` digunakan untuk mengatur posisi foto profil dan informasi pengguna secara vertikal dan terpusat.

## Teknologi yang Digunakan
- Kotlin
- Kotlin Multiplatform
- Compose Multiplatform
- Material 3
- Android Studio
- Android Emulator

## ScreenShot
Berikut adalah tampilan aplikasi My Profile App pada Android Emulator.
![My Profile App](screenshots/img.png)

## Cara Menjalankan
1. Clone repository GitHub:
```bash
git clone <URL_REPOSITORY>