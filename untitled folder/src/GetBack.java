/**
 * @author Leela Prabhu (S1471625) 
 *        
 */
public class GetBack extends GetFrame{
	private Frame currentFrame;
	/**This class handles retrival of the frame behind the current Frame
	 * 
	 */
	public GetBack(){
	}
	@Override
	public Frame getFrame(Frame currentFrame){
		if (currentFrame.getBack()!=null)
			return currentFrame.getBack();
		else 
			return null;
	}
	@Override
	public boolean getVisibilty(Frame currentFrame){
		if (currentFrame.getBack()==null)
			return(false);	
		else
			return(true);
	}
}