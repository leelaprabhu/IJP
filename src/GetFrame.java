/**
 * @author Leela Prabhu(S1471625)
 */
public class GetFrame {
	private Frame currentFrame;

	/**
	 * This function gets the frame linked to the current frame when a forward
	 * arrow is pressed
	 * 
	 * @param currentFrame
	 *            a Frame the user is in when the forward arrow was pressed.
	 * @return nothing the subclasses return frames
	 */
	public Frame getFrame(Frame currentFrame) {
		return null;
	}

	public boolean getVisibilty(Frame currentFrame) {
		return false;
	}
}