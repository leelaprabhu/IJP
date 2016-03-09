import javafx.event.ActionEvent;


/**
 * @author Leela Prabhu
 *
 */
public interface PhotoController {

    /**
     * Initialize the frames, maps, pickables, etc.
     */
    public void Initialise();

    /**Handles pick up requests from the viewer
     * @param e action event for menu selection
     */
    public void pickUp(ActionEvent e);
    /**Handles put down requests from the viewer
     * @param e action event for menu selection
     */
    public void putDown(ActionEvent e);
    /**
     * Handle click left requests from the viewer
     */
    public void clickL();
    /**
     * Handle click right requests from the viewer
     */
    public void clickR();
    /**
     * Handle click front requests from the viewer
     */
    public void clickF();

	/** Handles pick up requests from the test viewer
	 * @param string corresponding to an event action on a menu item
	 */
	public void pickUp(String string);
	/**Handles put down requests from the test viewer
	 * @param string corresponding to an event action on a menu item
	 */
	public void putDown(String string);

	public void go(String a);
}