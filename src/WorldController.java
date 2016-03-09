import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leela Prabhu (S1471625)
 *
 */
public class WorldController implements PhotoController {

	private static final int NUM_OF_PICS = 7;
	private static final int FRAME_X = 1243;
	private static final int START_POSITION = 5;
	private static final int FRAME_Y = 1256;
	private static final int STARTING_POINT = 0;
	private static final int PANORAMA_BREAK = 3;
	private static final int PANORAMA_START = 1;
	private static final int PANORAMA_OMIT = 2;
	private static final int PANORAMA_START_2 = 5;
	private static final int PANORAMA_END = 7;
	private static final int REVERSE = 6;

	private int x_coord = 0;
	private int y_coord = 0;
	private ArrayList<Pickable> pickableItems = new ArrayList<Pickable>();
	private String pickable[] = new String[] { "basket", "bulb", "bunny",
			"star" };
	private String frame[] = new String[] { "Junction", "Crichton Street",
			"To Chapel Street", "", "Charles Street", "To David Hume Tower",
			"George Square" };
	private int offset[] = new int[] { 0, 0, 5, 0, 0, 5, 2 };
	private ArrayList<Frame> frames = new ArrayList<Frame>();
	private Hashtable<String, Integer> putOpt = new Hashtable<String, Integer>();
	private ArrayList<GetFrame> getFrames = new ArrayList<GetFrame>();
	private Image image;
	private Frame currentFrame;
	private PhotoViewer viewer;

	/**
	 * The viewer handles all GUI interactions of the application, all GUI
	 * commands from the controller pass to the viewer, it is made accessible to
	 * the controller through this function.
	 * 
	 * @param viewer
	 *            it implements PhotoViewer, it handles all GUI functions.
	 */
	public WorldController(PhotoViewer viewer) {
		this.viewer = viewer;
	}

	public void Initialise() {
		frameInit();
		mapInit();
		backgroundInit();
		arrowInit();
		pickableInit();
		hashtableInit();
		getFramesInit();
	}

	/**
	 * A frame is one entire panorama image at a location. A pane is a portion
	 * of the frame. This function handles moving from one Frame to another
	 * based on the current pane. It is called during initialization.
	 */
	public void getFramesInit() {
		getFrames.add(new GetRight());
		getFrames.add(new GetBack());
		getFrames.add(new GetBack());
		getFrames.add(new GetLeft());
		getFrames.add(new GetFrame());
		getFrames.add(new GetFront());
		getFrames.add(new GetFront());
	}

	/**
	 * This function initializes the Hashtable 'putOpt' that facilitates fast
	 * access to the menu items. It is called during initialize.
	 */
	public void hashtableInit() {
		for (int i = 0; i < pickable.length; i++)
			putOpt.put(pickable[i], i);
	}

	/**
	 * This function loads images and stores them into Frame instances.
	 * Properties of the Frame instances are also set, like image, map, frameNo
	 * and offset. This is called during initialization.
	 */
	public void frameInit() {
		for (int i = PANORAMA_START; i <= PANORAMA_BREAK; i++) {
			Image tempImage = new Image("panorama" + i + ".jpg");
			Image tempImage2 = new Image("frame" + i + ".jpg");
			Frame tempFrame = new Frame(i - 1, tempImage, tempImage2);
			frames.add(tempFrame);
		}
		frames.add(frames.get(PANORAMA_OMIT));
		for (int i = PANORAMA_START_2; i <= PANORAMA_END; i++) {
			Image tempImage = new Image("panorama" + i + ".jpg");
			Image tempImage2 = new Image("frame" + i + ".jpg");
			Frame tempFrame = new Frame(i - 1, tempImage, tempImage2);
			frames.add(tempFrame);
		}
		for (int i = 0; i < frames.size(); i++) {
			frames.get(i).setOffset(offset[i]);
		}

	}

	/**
	 * This is called during intialization. This function initializes the map,
	 * that is establishes connections between Frames. Note that the positioning
	 * of Frames is based on the entry position and not absolute orientation.
	 */
	public void mapInit() {
		frames.get(0).setFront(frames.get(1));
		frames.get(1).setBack(frames.get(0));

		frames.get(0).setLeft(frames.get(4));
		frames.get(4).setRight(frames.get(0));

		frames.get(0).setRight(frames.get(5));
		frames.get(5).setBack(frames.get(0));

		frames.get(0).setBack(frames.get(6));
		frames.get(6).setFront(frames.get(0));

		frames.get(1).setFront(frames.get(2));
		frames.get(2).setFront(frames.get(1));
	}

	/**
	 * This function is called during initialization, it initializes maps, frames and the text
	 */
	private void backgroundInit() {
		currentFrame = frames.get(STARTING_POINT);
		viewer.setText("Junction");
		image = currentFrame.getImage();
		x_coord = (x_coord + FRAME_X
				* (START_POSITION + offset[currentFrame.getframeNo()]))
				% (FRAME_X * NUM_OF_PICS);
		viewer.setImage("imageView", image, x_coord, y_coord);
		viewer.setImage("mapView", currentFrame.getMap());
	}

	/**
	 * This initializes arrows that change the displayed image and other
	 * elements of the GUI.
	 */
	public void arrowInit() {
		Image moveLeft = new Image("arrow_left.png");
		viewer.setImage("buttonL", moveLeft);

		Image moveRight = new Image("arrow_right.png");
		viewer.setImage("buttonR", moveRight);

		Image moveForward = new Image("arrow_up.png");
		viewer.setImage("buttonF", moveForward);
	}

	/**
	 * This loads images for Pickable items and creates instances. It also sets
	 * some properties like the name and the viewer to which GUI actions must be
	 * reported. This is called during intialize.
	 */
	public void pickableInit() {
		Image temp;
		for (int i = 0; i < pickable.length; i++) {
			temp = new Image(pickable[i] + ".png");
			Pickable tempPick = new Pickable(temp, pickable[i], viewer);
			pickableItems.add(tempPick);
			viewer.setImage(pickable[i] + "View", pickableItems.get(i)
					.getImage());
		}
	}

	public void clickF() {
		forwardDecision();
		image = currentFrame.getImage();
		viewer.setImage("mapView", currentFrame.getMap());
		viewer.setText(frame[currentFrame.getframeNo()]);
		x_coord = (x_coord + offset[currentFrame.getframeNo()] * FRAME_X)
				% (FRAME_X * NUM_OF_PICS);
		forwardArrow();
		pickableShow(x_coord);
		backgroundShow(x_coord);
	}

	/**
	 * This is called when the Forward arrow is pressed. It handles which Frame
	 * should be shown next.
	 * 
	 */
	public void forwardDecision() {
		int swtch = (int) (x_coord / FRAME_X);
		currentFrame = getFrames.get(swtch).getFrame(currentFrame);
	}

	/**
	 * This is called when a new pane or frame is entered. It decides whether or
	 * not the Forward arrow should be enabled.
	 */
	public void forwardArrow() {
		int swtch = (int) (x_coord / FRAME_X);
		viewer.setVisible("buttonF",
				getFrames.get(swtch).getVisibilty(currentFrame));
	}

	public void clickR() {
		x_coord = (x_coord + FRAME_X) % (FRAME_X * NUM_OF_PICS);
		forwardArrow();
		pickableShow(x_coord);
		backgroundShow(x_coord);
	}

	public void clickL() {
		x_coord = (x_coord + FRAME_X * REVERSE) % (FRAME_X * NUM_OF_PICS);
		forwardArrow();
		pickableShow(x_coord);
		backgroundShow(x_coord);
	}

	/**
	 * This is called whenever the pane or frame is changed, it shows the
	 * background image pane given frame.
	 * 
	 * @param x_coord
	 *            and int that determines which pane of the frame should be
	 *            shown.
	 */
	public void backgroundShow(int x_coord) {
		viewer.setImage("imageView", image, x_coord, y_coord);
	}

	/**
	 * This determines which pickable items should be shown given the pane and
	 * frame. It not only determines the visibilty of the elements but also the
	 * 
	 * @param x_coord
	 */
	public void pickableShow(int x_coord) {
		for (int i = 0; i < pickable.length; i++) {
			if ((x_coord == pickableItems.get(i).getPixelNo())
					&& (currentFrame.getframeNo() == pickableItems.get(i)
							.getFrameNo())) {
				if (!pickableItems.get(i).getPicked()) {
					viewer.setVisible(pickable[i] + "View", true);
					viewer.setDisable(pickable[i] + "MenuPick", false);
				}
			} else {
				viewer.setVisible(pickable[i] + "View", false);
				viewer.setDisable(pickable[i] + "MenuPick", true);
			}
		}
	}

	/**
	 * Takes the String of the action event extracts the MenuItem responsible.
	 * 
	 * @param comp
	 *            a String dereived from the action event
	 * @return switchVar a String that can be used to access the Hashtable
	 *         'putOpt'
	 */
	public String stringParse(String comp) {
		String switchVar = "";
		int i = 12;
		while (comp.charAt(i) != 'M') {
			switchVar = switchVar + comp.charAt(i);
			i++;
		}
		return switchVar;
	}

	public void pickUp(ActionEvent e) {
		String comp = e.getSource().toString();
		String switchVar = stringParse(comp);
		int i = putOpt.get(switchVar);
		if ((x_coord == pickableItems.get(i).getPixelNo())
				&& (currentFrame.getframeNo() == pickableItems.get(i)
						.getFrameNo())) {
			pickableItems.get(i).pickUp();
		}
	}

	public void pickUp(String switchVar) {
		int i = putOpt.get(switchVar);
		if ((x_coord == pickableItems.get(i).getPixelNo())
				&& (currentFrame.getframeNo() == pickableItems.get(i)
						.getFrameNo())) {
			pickableItems.get(i).pickUp();
		}
	}

	public void putDown(ActionEvent e) {
		String comp = e.getSource().toString();
		String switchVar = stringParse(comp);
		pickableItems.get(putOpt.get(switchVar)).putDown(x_coord,
				currentFrame.getframeNo());
	}

	public void putDown(String switchVar) {
		pickableItems.get(putOpt.get(switchVar)).putDown(x_coord,
				currentFrame.getframeNo());
	}
	
	public void go(String a){
		System.out.println(a);
		if (a.contains("George Square"))
			currentFrame= frames.get(6);
		else if (a.contains("David Hume"))
			currentFrame= frames.get(5);
		else if (a.contains("Charle"))
			currentFrame= frames.get(4);
		else if (a.contains("Crichton"))
			currentFrame= frames.get(1);
		else if (a.contains("Chapel"))
			currentFrame= frames.get(2);
		else if (a.contains("Junction"))
			currentFrame= frames.get(0);
		
		image = currentFrame.getImage();
		viewer.setImage("mapView", currentFrame.getMap());
		viewer.setText(frame[currentFrame.getframeNo()]);
		x_coord = (x_coord + offset[currentFrame.getframeNo()] * FRAME_X)
				% (FRAME_X * NUM_OF_PICS);
		forwardArrow();
		pickableShow(x_coord);
		backgroundShow(x_coord);
	}

}