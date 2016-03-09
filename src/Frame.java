import javafx.scene.image.Image;

/**
 * @author Leela Prabhu (S1471625)
 *
 */
public class Frame {
	private int frameNo; // The unique ID of the frame
	private Image image; // The image the frame displays
	private Frame leftFrame; // The frame to the left of this frame, if any
	private Frame rightFrame; // The frame to the right of this frame, if any
	private Frame frontFrame;// The frame to the front of this frame, if any
	private Frame backFrame;// The frame to the back of this frame, if any
	private Image map; // The top view map representation corresponding to this
						// frame
	private int offset; // The offset from default position due to errors while
						// taking a photo

	/**
	 * This is the constructor for Frame. It makes a new instance of Frame.
	 * 
	 * @param frameNo
	 *            an int that gives the Frame a unique ID
	 * @param image
	 *            an Image that represents how the frame will appear to the user
	 * @param map
	 *            an Image that represents the top view of the location
	 */
	public Frame(int frameNo, Image image, Image map) {
		this.image = image;
		this.map = map;
		this.frameNo = frameNo;
	}

	/**
	 * This function sets the frame to the left of the current frame.
	 * 
	 * @param leftFrame
	 *            a Frame this is the frame that is to the left of the current
	 *            frame.
	 */
	public void setLeft(Frame leftFrame) {
		this.leftFrame = leftFrame;
	}

	/**
	 * This function sets the frame to the right of the current frame.
	 * 
	 * @param rightFrame
	 *            a Frame this is the frame that is to the right of the current
	 *            frame.
	 */
	public void setRight(Frame rightFrame) {
		this.rightFrame = rightFrame;
	}

	/**
	 * This function sets the frame to in front of the current frame.
	 * 
	 * @param frontFrame
	 *            a Frame this is the frame that is in front of the current
	 *            frame.
	 */
	public void setFront(Frame frontFrame) {
		this.frontFrame = frontFrame;
	}

	/**
	 * This function sets the frame to behind of the current frame.
	 * 
	 * @param backFrame
	 *            a Frame this is the frame that is behind the current frame.
	 */
	public void setBack(Frame backFrame) {
		this.backFrame = backFrame;
	}

	/**
	 * This adjusts for any error made while taking the panorama shot.
	 * 
	 * @param offset
	 *            an int, the number of panes the frame has been shifted by.
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * This frame returns the frame to the left of the current frame, leftFrame
	 * 
	 * @return leftFrame a Frame, the one to the left of the current frame.
	 */
	public Frame getLeft() {
		return leftFrame;
	}

	/**
	 * This frame returns the frame to the right of the current frame,
	 * rightFrame
	 * 
	 * @return rightFrame a Frame, the one to the right of the current frame.
	 */
	public Frame getRight() {
		return rightFrame;
	}

	/**
	 * This frame returns the frame in front of the current frame, frontFrame
	 * 
	 * @return frontFrame a Frame, the one in front of the current frame.
	 */
	public Frame getFront() {
		return frontFrame;
	}

	/**
	 * This function returns the frame behind the current frame, backFrame.
	 * 
	 * @return backFrame a Frame, the one behind the current frame.
	 */
	public Frame getBack() {
		return backFrame;
	}

	/**
	 * This function returns the image that is displayed to the user, image.
	 * 
	 * @return image an Image, the displayed by the Frame to the user.
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * This function returns the image that the depicts the Frame's top view,
	 * map.
	 * 
	 * @return map an Image, the one to that shows the location from above.
	 */
	public Image getMap() {
		return map;
	}

	/**
	 * This function returns the unique ID of the frame, frameNo.
	 * 
	 * @return frameNo an int, the unique ID of the Frame.
	 */
	public int getframeNo() {
		return frameNo;
	}

	/**
	 * This function returns the number of panes by which the panorama was
	 * shifted when capturing, offset.
	 * 
	 * @return offset an int, the number of panes by which the panorama was
	 *         shifted
	 */
	public int getOffset() {
		return offset;
	}
}