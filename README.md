# JavaFX Poster Viewer

This is a desktop GUI application built with JavaFX that allows users to view a collection of movie and TV show posters. Posters are loaded from URLs, and the application includes robust error handling for invalid or unavailable links. This project was created for an introductory computer science course and demonstrates event-driven programming and the use of a GUI framework.

![Poster Viewer Screenshot](https://i.imgur.com/L6gBDi3.png)
*(Suggestion: You can replace this with a screenshot of your own application running!)*

## Features

-   **Graphical User Interface (GUI)**: Built with JavaFX, providing a user-friendly windowed experience.
-   **Event-Driven Programming**: Uses an event listener on a `ComboBox` (dropdown menu) to dynamically update the displayed image when the user makes a selection.
-   **Web Resource Loading**: Loads images directly from URLs on the internet.
-   **Robust Error Handling**: Implements `try-catch` blocks to gracefully handle common issues such as `null` URLs, malformed URLs, and links that do not point to a valid image, displaying informative error messages to the user without crashing.

## How to Run

Running a JavaFX application from the command line requires the JavaFX SDK.

### Prerequisites

1.  Java Development Kit (JDK) 11 or higher.
2.  [JavaFX SDK](https://gluonhq.com/products/javafx/) for your operating system. Download the SDK and unzip it to a known location on your computer.

### Instructions

1.  Open a terminal or command prompt and navigate to the directory containing `PosterViewer.java`.

2.  **Compile the code:**
    You must provide the path to your JavaFX `lib` folder.

    *On macOS/Linux:*
    ```bash
    javac --module-path /path/to/your/javafx-sdk-21/lib --add-modules javafx.controls PosterViewer.java
    ```
    *On Windows:*
    ```bash
    javac --module-path "C:\path\to\your\javafx-sdk-21\lib" --add-modules javafx.controls PosterViewer.java
    ```

3.  **Run the application:**
    Similarly, you must provide the path to the JavaFX `lib` folder when running.

    *On macOS/Linux:*
    ```bash
    java --module-path /path/to/your/javafx-sdk-21/lib --add-modules javafx.controls PosterViewer
    ```
    *On Windows:*
    ```bash
    java --module-path "C:\path\to\your\javafx-sdk-21\lib" --add-modules javafx.controls PosterViewer
    ```

> **Note:** Running JavaFX applications is often much simpler within an IDE like Eclipse or IntelliJ IDEA, which can be configured to handle the JavaFX SDK automatically.
