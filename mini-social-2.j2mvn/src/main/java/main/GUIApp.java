package main;

import java.io.IOException;

import java.net.URL;
import java.util.UUID;

import InvalidExceptions.InvalidDoBException;
import InvalidExceptions.InvalidEmailException;
import InvalidExceptions.InvalidPasswordException;
import InvalidExceptions.InvalidUUIDException;
import InvalidExceptions.InvalidUserNameException;
import controllers.ProfileController;
import domain.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUIApp extends Application {

//    @Override
//    public void start(Stage stage) {
//        String javaVersion = System.getProperty("java.version");
//        String javafxVersion = System.getProperty("javafx.version");
//        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        Scene scene = new Scene(new StackPane(l), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }

	@Override
	public void start(Stage stage) throws IOException, InvalidUserNameException, InvalidEmailException, InvalidUUIDException, InvalidDoBException, InvalidPasswordException {
		FXMLLoader loader = new FXMLLoader();
		URL path = getClass().getResource("/fxml/Configuration.fxml");
		loader.setLocation(path);

		Parent root = loader.load();

		//1. load user
		User u = new User();
		u.setUserName("Marry");
		u.setAvatarURL("/avatars/avatar-1-medium.png");
		u.setLastOnline("2021-12-23T22:44:00");
		u.setEmail("mary123@gmali.com");
		u.setUuid(UUID.randomUUID());
		u.setDob("2000-12-01T10:37:05");
		u.setReal(true);
		u.setPassword("123jdjoq@A");
		//2. pass to controller
		((ProfileController)loader.getController()).setUser(u);
		
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
