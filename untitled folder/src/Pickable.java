import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * @author Leela Prabhu (S1471625)
 *
 */
public class Pickable {

	private static final int INITIAL_PIXEL_NO = 6215; // Default portion of
														// panorama where the
														// Pickable is displayed
	private Image image; // The image that represents the Pickable.
	private String name; // The name of the Pickable.
	private int frameNo; // The current frame where the Pickable is.
	private int pixelNo; // The current portion of frame where the Pickable is.
	private boolean picked = false;
	private PhotoViewer viewer;

	/**
	 * This function constructs a new Pickable.
	 * 
	 * @param image
	 *            an Image that represents the Pickable when displayed.
	 * @param name
	 *            a String that represents the Pickable.
	 * @param viewer
	 *            of PhotoViewer Interface, it directs all GUI commands to this.
	 */
	public Pickable(Image image, String name, PhotoViewer viewer) {
		this.image = image;
		this.name = name;
		frameNo = 0;
		pixelNo = INITIAL_PIXEL_NO;
		this.viewer = viewer;
	}

	/**
	 * This function gets image of the Pickable.
	 * 
	 * @return Image The image depicted by the Pickable.
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * This function gets the part of the panorama in which the Pickable is.
	 * 
	 * @return pixelNo The part of the panorama in which the Pickable is.
	 */
	public int getPixelNo() {
		return pixelNo;
	}

	/**
	 * This function sets the part of the panorama in which the Pickable is.
	 * 
	 * @param pixelNo
	 *            The part of the panorama in which the Pickable is.
	 */
	public void setPixelNo(int pixelNo) {
		this.pixelNo = pixelNo;
	}

	/**
	 * This function gets the frame in which the Pickable is.
	 * 
	 * @return frameNo The frame in which the Pickable is.
	 */
	public int getFrameNo() {
		return frameNo;
	}

	/**
	 * This function sets the frame in which the Pickable is.
	 * 
	 * @param frameNo
	 *            The frame in which the Pickable is.
	 */
	public void setFrameNo(int frameNo) {
		this.frameNo = frameNo;
	}

	/**
	 * This function sets the picked state of the Pickable.
	 * 
	 * @return picked boolean that shows if the Pickable has been picked or not.
	 */
	public boolean getPicked() {
		return picked;
	}

	/**
	 * This function sets the picked state of the Pickable.
	 * 
	 * @param picked
	 *            whether the Pickable has been picked or not.
	 */
	public void setPicked(boolean picked) {
		this.picked = picked;
	}

	/**
	 * This function returns the name of the Pickable.
	 * 
	 * @return name A String, the name of the Pickable.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This function is called when an Object of type Pickable is put down. It
	 * make the Pickable visible. It saves the pixel and frame number of the new
	 * location as properties of the Object Pickable. It also changes the status
	 * of the Picked property, indicating that the object is no longer in the
	 * picked state. It disables the respective 'Put Down' Menu and enable the
	 * 'Pick Up' Menu.
	 * 
	 * @param x_coord
	 *            the section of the panorama Frame where the Pickable has been
	 *            put.
	 * @param x_coord
	 *            the section of the panorama Frame where the Pickable has been
	 *            put.
	 */
	public void putDown(int x_coord, int frameNo) {
		viewer.setVisible(name + "View", true);
		setPixelNo(x_coord);
		setFrameNo(frameNo);
		setPicked(false);
		viewer.setDisable(name + "MenuPut", true);
		viewer.setDisable(name + "MenuPick", false);
	}

	/**
	 * This function is called when an Object of type Pickable is picked up. It
	 * makes the pickable invisible. It also changes the status of the Picked
	 * property, indicating that the object is in the picked state. It disables
	 * the respective 'Pick Up' Menu and enable the 'Put Down' Menu.
	 */
	public void pickUp() {
		viewer.setVisible(name + "View", false);
		setPicked(true);
		viewer.setDisable(name + "MenuPut", false);
		viewer.setDisable(name + "MenuPick", true);
	}
}