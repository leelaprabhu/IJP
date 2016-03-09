public class GetRight extends GetFrame {
	private Frame currentFrame;

	/**
	 * This class handles retrival of the frame right of the current Frame
	 */
	public GetRight() {

	}

	@Override
	public Frame getFrame(Frame currentFrame) {
		if (currentFrame.getRight() != null)
			return currentFrame.getRight();
		else
			return null;
	}

	@Override
	public boolean getVisibilty(Frame currentFrame) {
		if (currentFrame.getRight() == null)
			return (false);
		else
			return (true);
	}
}