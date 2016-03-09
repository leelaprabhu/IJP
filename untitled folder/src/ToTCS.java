/**
 * @author Leela Prabhu
 *
 */
public class ToTCS extends ToFrame{
	/**This manages the path to Chapel Street
	 * 
	 */
	public void ToTCS(){
		
	}
	@Override
	public void toFrame(PhotoController controller){
		controller.clickL();
		controller.clickL();
		controller.clickL();
		controller.clickF();
		controller.clickF();
	}
	@Override
	public void fromFrame(PhotoController controller){
		controller.clickR();
		controller.clickR();
		controller.clickR();
		controller.clickF();
		controller.clickR();
		controller.clickR();
		controller.clickF();
	}
}