# My First App

This Android app is a feature-rich student dashboard built with Kotlin. It helps users toggle a light bulb ON/OFF, manage student information, and keep track of tasks via an interactive to-do list. The app is designed with a modern, user-friendly interface and demonstrates key Android and Kotlin concepts, making it ideal for beginners.

---

## Features

### 🔆 Light Bulb Toggles
- Switch a light bulb image ON and OFF using a `SwitchCompat` toggle.
- Real-time visual update between `on_bulb` and `off_bulb` images.

### 🧑‍🎓 Student Information Form
- Enter Student ID, School Name, and Class.
- Select a subject from a dropdown spinner.
- Review entered information on a summary page before final submission.

### 📝 To-Do List
- Add, check off, and delete tasks with a Floating Action Button (FAB).
- Swipe left to delete any task.
- Task state (checked/unchecked) is visually updated.

### 🔐 Login & Logout System
- Email and password login screen with "Remember Me" option.
- Secure login state saved with SharedPreferences.
- Logout button clears login state.

### 🏁 Splash Screen
- Clean splash screen on startup with automatic navigation based on login state.

---

## Screenshots

![Login Dash board](https://github.com/user-attachments/assets/38683b17-160f-4e7a-a734-a384b8eb5aca)


---

## Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/MohsinMuzamil/My-First-App.git
   ```

2. **Open in Android Studio**
   - Open the project folder in Android Studio.

3. **Build & Run**
   - Connect your device or start an emulator, then run the app.

---

## Folder Structure (Key Files)

- `DashboardActivity.kt` – Main dashboard for student info and bulb toggle.
- `MainActivity.kt` – Login logic.
- `SplashActivity.kt` – App splash and auto-login handling.
- `SubmitActivity.kt` – Displays student info summary and submission.
- `ToDo_List.kt` – To-do list logic.
- `TaskAdapter.kt`, `Task.kt`, `SwipeToDeleteCallback.kt` – To-do list backend.
- `res/layout/` – All XML layouts for activities and custom views.

---

## Topics

- toggle-switches
- todolist
- login-system
- student-managed
- image-updates

---

## Requirements

- Android Studio (latest recommended)
- Kotlin
- Min SDK as defined in `build.gradle`
- [Material Components](https://material.io/develop/android) (for text fields and FAB)

---

## How It Works

1. **Login Screen:**  
   Enter your email and password. If "Remember Me" is checked, you’ll stay logged in on next launch.

2. **Dashboard:**  
   - Toggle the light bulb.
   - Fill in student details and select a subject.
   - Tap "Next" to review your info.

3. **Submit Info:**  
   Review details and submit. On submission, you’re redirected to the To-Do List.

4. **To-Do List:**
   - Add new tasks with the orange FAB.
   - Swipe left to delete a task.
   - Check tasks as you complete them.

---

## Contributing

Pull requests and issues are welcome! Please follow best Android/Kotlin practices.

---

## License

MIT License

---

_Designed and maintained by Mohsin Muzamil._
