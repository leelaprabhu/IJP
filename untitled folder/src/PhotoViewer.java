import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * @author Leela Prabhu
 *
 */
public interface PhotoViewer {

    /**This function initializes the controller
     * @param controller
     */
    public void setController(PhotoController controller);

    /**This sets the text for the text Box on the GUI with the location
     * @param text the location in a String
     */
    public void setText(String text);
    /**This sets the image for a particular image view (map or pickable)
     * @param imageView the image view
     * @param image the image
     */
    public void setImage(String imageView, Image image);
    /**This sets the main image as it is a panorama, only part is set.
     * @param imageView the image view
     * @param image the image
     * @param x_coord the x coordinate from which the image starts
     * @param y_coord the y coordinate from which the image starts
     */
    public void setImage(String imageView, Image image, int x_coord, int y_coord);
    /**This sets a pickable item's visibility or that of the forward arrow
     * @param imageView Which pickable item or arrow
     * @param visibility visible or not visible
     */
    public void setVisible(String imageView, boolean visibility);
    /**This disables the menu item when a change happens
     * @param menuItem the menu item
     * @param disable true or false
     */
    public void setDisable(String menuItem, boolean disable);

	/**This initializes the controller
	 * @param controller
	 */
	public void initialise(PhotoController controller);

}
