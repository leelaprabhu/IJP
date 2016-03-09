/**
 * @author Leela Prabhu
 *
 */
public class GetLeft extends GetFrame {
	private Frame currentFrame;

	/**
	 * This class handles retrival of the frame left of the current Frame
	 */
	public GetLeft() {
	}

	@Override
	public Frame getFrame(Frame currentFrame) {
		if (currentFrame.getLeft() != null)
			return currentFrame.getLeft();
		else
			return null;
	}

	@Override
	public boolean getVisibilty(Frame currentFrame) {
		if (currentFrame.getLeft() == null)
			return (false);
		else
			return (true);
	}
}