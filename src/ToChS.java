/**
 * @author Leela Prabhu
 *
 */
public class ToChS extends ToFrame{
	/**This manages the path to Charles Street
	 * 
	 */
	public void ToChS(){
		
	}
	@Override
	public void toFrame(PhotoController controller){
		controller.clickL();
		controller.clickL();
		controller.clickL();
		controller.clickF();
	}
	@Override
	public void fromFrame(PhotoController controller){
		controller.clickR();
		controller.clickR();
		controller.clickR();
		controller.clickR();
		controller.clickF();
	}
}