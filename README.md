
# KMP Clean Architecture

A modular **Kotlin Multiplatform (KMP)** project demonstrating a clean, scalable, and production-ready architecture.
This template is designed for **Android, iOS, Desktop, and Web** using shared business logic and UI layers where applicable.

This repository is intended for **developers**, **open-source contributors**, and **internal engineering teams** who want a well-structured reference for building large KMP applications.

---

## 📑 Table of Contents

* [Introduction](#introduction)
* [Architecture](#architecture)
* [Features](#features)
* [Project Structure](#project-structure)
* [Installation](#installation)
* [Usage](#usage)
* [Dependencies](#dependencies)
* [Build Targets](#build-targets)
* [Troubleshooting](#troubleshooting)
* [Contributing](#contributing)
* [License](#license)

---

## 🔥 Introduction

This project showcases a **Clean Architecture implementation in Kotlin Multiplatform**, emphasizing:

* Separation of concerns
* Feature-based modularization
* Shared data & domain layers
* Platform-specific UI hosting
* Composable and testable code

The goal is to provide a flexible baseline for real-world multiplatform applications.

---

## 🏗️ Architecture

Below is the official architecture diagram used in this repository:
<img src="https://github.com/user-attachments/assets/674c1907-f0c8-4e31-90dc-e2691ba4c2f2" width="800" height="800" />


### Layers Overview

#### **ComposeApp (UI Layer)**

Contains platform-specific entry points:

* AndroidApp
* IOSApp
* WebApp
* DesktopApp

Each platform module interacts with feature modules like:

* `Feature:Login`
* `Feature:Registration`
* `Feature:Home`

#### **Data Layer**

Modularized into:

* **Core-Utils** — common utilities
* **Core-Net** — networking layer
* **Core-Analytic** — shared analytics logic
* **Data** — repositories, data sources, mappers

#### **Libraries (Build Artifacts)**

Produces:

* **Android** → `.aar`
* **iOS** → `.xcframework`

---

## ✨ Features

* Fully modular **KMP Clean Architecture**
* Shared business logic across all platforms
* Reusable feature modules
* Extensible composition for new features
* Multi-platform build outputs (AAR + XCFramework)
* Compose Multiplatform UI support
* Well-structured dependency flow

---

## 📁 Project Structure

```
kmp-clean-architecture/
│
├── composeApp/             # Platform UI hosts
│   ├── androidApp/
│   ├── iosApp/
│   ├── webApp/
│   └── desktopApp/
│
├── features/               # Feature-level modules
│   ├── login/
│   ├── registration/
│   └── home/
│
├── data/                   # Data layer
│   ├── core-utils/
│   ├── core-net/
│   ├── core-analytic/
│   └── data/
│
├── shared/                 # Multiplatform shared modules
│
└── build/outputs/          # .aar and .xcframework artifacts
```

---

## ⚙️ Installation

### **Clone the repository**

```sh
git clone https://github.com/r0shanbhagat/kmp-clean-architecture.git
cd kmp-clean-architecture
```

### **Android**

Open in Android Studio (Hedgehog or later) and run the `androidApp` module.

### **iOS**

From the project root:

```sh
./gradlew :shared:packForXcode
```

Then open the generated Xcode workspace.

### **Desktop**

```sh
./gradlew :composeApp:desktopApp:run
```

### **Web**

```sh
./gradlew :composeApp:webApp:jsBrowserDevelopmentRun
```

---

## 🚀 Usage

Add new features by creating a new module under `features/` and wiring it into the UI containers found in `composeApp/`.

Each feature follows:

* UI (optional multiplatform)
* Domain (logic, use cases)
* Data (repositories)

---

## 📦 Dependencies (High-Level)

* Kotlin Multiplatform
* Jetpack Compose Multiplatform
* Ktor (Networking)
* Kotlinx Serialization
* Kotlinx Coroutines
* SQLDelight / Other storage (if used)
* Dependency Injection (Koin / Manual)

---

## 🎯 Build Targets

| Platform    | Output         |
| ----------- | -------------- |
| **Android** | `.aar`         |
| **iOS**     | `.xcframework` |
| **Desktop** | Native app     |
| **Web**     | JS bundle      |

---

## 🛠️ Troubleshooting

**Gradle sync issues**

* Use the latest Android Studio & Kotlin plugin
* Run:

  ```sh
  ./gradlew clean build
  ```

**iOS framework not generating**

* Ensure Xcode command line tools are installed
* Try:

  ```sh
  ./gradlew :shared:packForXcode --info
  ```

---

## 🤝 Contributing

Contributions are welcome!
Feel free to open issues or submit Pull Requests to improve the architecture, features, or documentation.

---

## 📄 License

This project is licensed under the **Apache 2.0 License**.

---
