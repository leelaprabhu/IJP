public class GetFront extends GetFrame {
	private Frame currentFrame;

	/**
	 * This class handles retrival of the frame infront of the current Frame
	 */
	public GetFront() {
	}

	@Override
	public Frame getFrame(Frame currentFrame) {
		if (currentFrame.getFront() != null)
			return currentFrame.getFront();
		else
			return null;
	}

	@Override
	public boolean getVisibilty(Frame currentFrame) {
		if (currentFrame.getFront() == null)
			return (false);
		else
			return (true);
	}
}