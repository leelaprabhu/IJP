import java.util.Hashtable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Text;

public class Viewer implements PhotoViewer {

	private static final int FRAME_Y = 1256;
	private static final int FRAME_X = 1243;

	@FXML
	private ImageView imageView;
	@FXML
	private ImageView mapView;
	@FXML
	private ImageView basketView;
	@FXML
	private ImageView bulbView;
	@FXML
	private ImageView bunnyView;
	@FXML
	private ImageView starView;
	@FXML
	private ImageView buttonL;
	@FXML
	private ImageView buttonF;
	@FXML
	private ImageView buttonR;
	@FXML
	private ImageView buttonB;

	@FXML
	private Text textBox;

	@FXML
	private MenuItem basketMenuPut;
	@FXML
	private MenuItem bulbMenuPut;
	@FXML
	private MenuItem bunnyMenuPut;
	@FXML
	private MenuItem starMenuPut;

	@FXML
	private MenuItem basketMenuPick;
	@FXML
	private MenuItem bulbMenuPick;
	@FXML
	private MenuItem bunnyMenuPick;
	@FXML
	private MenuItem starMenuPick;

	private PhotoController controller;
	private Hashtable<String, ImageView> imageViews = new Hashtable<String, ImageView>();
	private Hashtable<String, MenuItem> menuItems = new Hashtable<String, MenuItem>();

	public void initialise(PhotoController controller) {
		setController(controller);
		initImageViews();
		initMenuItems();
	}

	/**
	 * Maps String names to FXML Image Views so that it can handle requests from
	 * the controller faster It is called during initialization.
	 */
	public void initImageViews() {
		imageViews.put("imageView", imageView);
		imageViews.put("mapView", mapView);
		imageViews.put("basketView", basketView);
		imageViews.put("bulbView", bulbView);
		imageViews.put("bunnyView", bunnyView);
		imageViews.put("starView", starView);
		imageViews.put("buttonL", buttonL);
		imageViews.put("buttonR", buttonR);
		imageViews.put("buttonF", buttonF);
		imageViews.put("buttonB", buttonB);
	}

	/**
	 * Maps String names to FXML Menu Items so that it can handle request to the
	 * controller faster It is called during initialization.
	 */
	public void initMenuItems() {
		menuItems.put("basketMenuPut", basketMenuPut);
		menuItems.put("bulbMenuPut", bulbMenuPut);
		menuItems.put("bunnyMenuPut", bunnyMenuPut);
		menuItems.put("starMenuPut", starMenuPut);
		menuItems.put("basketMenuPick", basketMenuPick);
		menuItems.put("bulbMenuPick", bulbMenuPick);
		menuItems.put("bunnyMenuPick", bunnyMenuPick);
		menuItems.put("starMenuPick", starMenuPick);
	}

	public void setController(PhotoController controller) {
		this.controller = controller;
	}

	@Override
	public void setText(String text) {
		textBox.setText(text);
	}

	@Override
	public void setImage(String imageView, Image image) {
		imageViews.get(imageView).setImage(image);
	}

	@Override
	public void setImage(String imageView, Image image, int x_coord, int y_coord) {
		PixelReader reader = image.getPixelReader();
		WritableImage newImage = new WritableImage(reader, x_coord, y_coord,
				FRAME_X, FRAME_Y);
		imageViews.get(imageView).setImage(newImage);
	}

	@Override
	public void setVisible(String imageView, boolean visibility) {
		imageViews.get(imageView).setVisible(visibility);
	}

	@Override
	public void setDisable(String menuItem, boolean disable) {
		menuItems.get(menuItem).setDisable(disable);
	}

	/**
	 * This event takes a 'pick up' user input from the GUI and sends it to the
	 * controller to handle.
	 * 
	 * @param e
	 *            the action event corresponding to the menu select
	 */
	public void pickUp(ActionEvent e) {
		controller.pickUp(e);
	}

	/**
	 * This event takes a 'put down' user input from the GUI and sends it to the
	 * controller to handle.
	 * 
	 * @param e
	 *            the action event corresponding to the menu select
	 */
	public void putDown(ActionEvent e) {
		controller.putDown(e);
	}

	/**
	 * This event takes a 'right click' user input from the GUI and sends it to
	 * the controller to handle.
	 * 
	 */
	public void clickL() {
		controller.clickL();
	}

	/**
	 * This event takes a 'left click' user input from the GUI and sends it to
	 * the controller to handle.
	 * 
	 */
	public void clickR() {
		controller.clickR();
	}

	/**
	 * This event takes a 'front click' user input from the GUI and sends it to
	 * the controller to handle.
	 * 
	 */
	public void clickF() {
		controller.clickF();
	}
}