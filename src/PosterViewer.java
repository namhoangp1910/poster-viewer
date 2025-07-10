import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A JavaFX application that displays movie and TV show posters from URLs.
 * The user can select a poster from a dropdown menu, and the application
 * will attempt to load and display the corresponding image. It includes
 * robust error handling for invalid or unavailable URLs.
 *
 * @author Baba Kofi Weusijana
 * @author Phuong Nam Hoang
 */
public class PosterViewer extends Application {
    private static final double APP_SPACING = 10;
    private static final double APP_WIDTH = 800;
    private static final double APP_HEIGHT = 400;
    private static final boolean DEBUG = true;

    /**
     * The main entry point for the Java application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Attempts to load an image from a given URL.
     * If the URL is null, invalid, or unsupported, the returned Image object
     * will be null and the posterLabel's text will be set to an error message.
     * Otherwise, the posterLabel's text will be set to the URL.
     *
     * @param url         The String URL of the image to load.
     * @param posterLabel The Label used to display status messages or errors.
     * @return An Image object if successful, or null if an error occurs.
     */
    private Image getPosterImage(String url, Label posterLabel) {
        Image posterImage = null;
        try {
            posterImage = new Image(url);

            // Check if JavaFX encountered an error while loading the image.
            if (posterImage.isError()) {
                posterLabel.setText("Error loading poster: " + posterImage.getException().getLocalizedMessage());
                return null; // Return null on image loading error.
            } else {
                posterLabel.setText(url);
            }
        } catch (NullPointerException e) {
            posterLabel.setText("Error: The provided URL is null.");
            if (DEBUG) e.printStackTrace();
        } catch (IllegalArgumentException e) {
            posterLabel.setText("Error: The URL is invalid or unsupported.");
            if (DEBUG) e.printStackTrace();
        }

        return posterImage;
    }

    /**
     * The main entry point for this JavaFX application. This method is called
     * after the application has been launched and is ready to start.
     *
     * @param stage The primary stage for this application, onto which the
     * application scene can be set.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // --- UI Component Initialization ---
        final ComboBox<String> posterComboBox = new ComboBox<String>();
        final ImageView posterImageView = new ImageView();
        final Label posterLabel = new Label();

        // --- Data for the ComboBox ---
        String[] posterNames = {
            "Dandadan", "Chainsaw Man", "Jujutsu Kaisen", "Frieren", "Attack on Titan",
            "Fullmetal Alchemist", "Vinland Saga", "Berserk", "Hunter x Hunter",
            "Mob Psycho 100", "Bad URL", "null URL", "URL to an HTML page", "Empty URL"
        };
        String[] posterURLs = {
            "https://libremdb.iket.me/_next/image?url=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FM%2FMV5BMmE4NGI0NWUtOGFmNS00Yzk4LWFjYWYtYjU2MTAxYTMxMGQ5XkEyXkFqcGc%40.UX600.jpg&w=640&q=75",
            "https://libremdb.iket.me/_next/image?url=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FM%2FMV5BN2U3ZGUzYzEtNWYwMi00MDI1LWIyYTgtYjM1NGY5MmMzOWI4XkEyXkFqcGc%40.UX600.jpg&w=640&q=75",
            "https://libremdb.iket.me/_next/image?url=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FM%2FMV5BM2Q1NDI4ZjItOTkzNC00YzI2LTk0ODgtMTk2MjJhMjNjMjM0XkEyXkFqcGc%40.UX600.jpg&w=640&q=75",
            "https://libremdb.iket.me/_next/image?url=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FM%2FMV5BZTI4ZGMxN2UtODlkYS00MTBjLWE1YzctYzc3NDViMGI0ZmJmXkEyXkFqcGc%40.UX600.jpg&w=640&q=75",
            "https://libremdb.iket.me/_next/image?url=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FM%2FMV5BNjY4MDQxZTItM2JjMi00NjM5LTk0MWYtOTBlNTY2YjBiNmFjXkEyXkFqcGc%40.UX600.jpg&w=384&q=75",
            "https://ih1.redbubble.net/image.597868371.1720/flat,750x,075,f-pad,750x1000,f8f8f8.u3.jpg",
            "https://m.media-amazon.com/images/M/MV5BNDA3MGNmZTEtMzFiMy00ZmViLThhNmQtMjQ4ZDc5MDEyN2U1XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg",
            "https://m.media-amazon.com/images/M/MV5BZmE1YTFlZWMtYzRkYi00MWU0LWIwODctZmYzMDExZGRkM2NmXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg",
            "https://staticg.sportskeeda.com/editor/2022/10/d8581-16663316932144-1920.jpg",
            "https://i.redd.it/76ejdm88qg991.jpg",
            "badURL",
            null,
            "https://www.google.com",
            ""
        };

        // --- Configure UI Components ---
        posterLabel.setLabelFor(posterImageView);
        posterImageView.setPreserveRatio(true);
        posterImageView.setSmooth(true);
        posterImageView.setCache(true);

        posterComboBox.getItems().setAll(posterNames);
        posterComboBox.setPromptText("Select a Poster");
        posterComboBox.setEditable(false);
        posterComboBox.getSelectionModel().select(0);

        // --- Event Handling ---
        // Set an event listener to execute when the user selects a new item.
        posterComboBox.setOnAction((ActionEvent actionEvent) -> {
            int selectedIndex = posterComboBox.getSelectionModel().getSelectedIndex();
            Image nextPosterImage = getPosterImage(posterURLs[selectedIndex], posterLabel);

            // Set the image in the ImageView, or clear it if loading failed.
            posterImageView.setImage(nextPosterImage);
        });

        // Programmatically trigger the event listener to load the first poster on startup.
        posterComboBox.fireEvent(new ActionEvent());

        // --- Layout and Scene Setup ---
        // Arrange UI elements vertically in boxes.
        VBox posterVBox = new VBox(APP_SPACING, posterLabel, posterImageView);
        posterVBox.setAlignment(Pos.CENTER);

        VBox controlsVBox = new VBox(APP_SPACING, posterComboBox);
        controlsVBox.setAlignment(Pos.CENTER);

        // Arrange the vertical boxes horizontally.
        HBox sceneHBox = new HBox(APP_SPACING, controlsVBox, posterVBox);
        sceneHBox.setAlignment(Pos.CENTER);

        // Create the scene and set it on the stage.
        Scene scene = new Scene(sceneHBox, APP_WIDTH, APP_HEIGHT);
        stage.setTitle("Poster Viewer");
        stage.setScene(scene);
        stage.show();
    }
}
