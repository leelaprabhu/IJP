/**
 * @author Leela Prabhu
 *
 */
public class ToGS extends ToFrame{
	/**This manages the path to George Square
	 * 
	 */
	public void ToGS(){
		
	}
	@Override
	public void toFrame(PhotoController controller){
		controller.clickL();
		controller.clickF();
	}
	@Override
	public void fromFrame(PhotoController controller){
		controller.clickL();
		controller.clickL();
		controller.clickL();
		controller.clickL();
		controller.clickF();
	}
}