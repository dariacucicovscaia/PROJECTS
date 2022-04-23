package controllers;

import domain.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class ProfileController {

	private User user;
	@FXML
	private VBox root;
	@FXML
	private TextArea textArea;
	@FXML
	private ImageView avatar;
	@FXML
	private Label userclass;
	@FXML
	private Label status;
	@FXML
	private Circle onlinecircle;
	@FXML
	private VBox detailes;
	@FXML
	private Label uuid;
	@FXML
	private Label email;
	@FXML
	private Label password;
	@FXML
	private Label dob;
	@FXML
	private Label real;
	@FXML
	private Button wrap;


	public void setUser(User user) {
		this.user = user;

		renderCompact();
	}

	public void renderCompact() {
		avatar.setImage(
				new Image(getClass().getResourceAsStream(user.getAvatarURL()))   );
		
		userclass.setText(user.getUserName());
		status.setText(user.onlineTimeAgo());
		if (user.isOnline() == true) {
			onlinecircle.setFill(Paint.valueOf("#87c762"));
		} else {
			onlinecircle.setFill(Paint.valueOf("#b1bcc7"));

		}
		//hide & collapse
		detailes.setVisible(false);
		//root.setMaxHeight(234);
	}
	public void renderDetailed() {
		renderCompact();
		user.setAvatarURL("/avatars/avatar-1-small.png");
		avatar.setImage(new Image(getClass().getResourceAsStream(user.getAvatarURL())));

		//hide & collapse
		detailes.setVisible(true);
		
		uuid.setText(user.getUuid());
		email.setText(user.getEmail());
		password.setText(user.getPassword());
		dob.setText(user.getDob());
		
		
		
	}
	public void upwrap() {
		renderCompact();
		detailes.setVisible(false);
		//root.setMaxHeight(234);
		user.setAvatarURL("/avatars/avatar-1-medium.png");
		avatar.setImage(new Image(getClass().getResourceAsStream(user.getAvatarURL())));
	}
}
