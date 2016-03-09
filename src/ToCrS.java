/**
 * @author Leela Prabhu
 *
 */
public class ToCrS extends ToFrame{
/**This manages the path to Crichton Street
 * 
 */
public void ToCrS(){
		
	}
	@Override
	public void toFrame(PhotoController controller){
		controller.clickL();
		controller.clickL();
		controller.clickF();
	}
	@Override
	public void fromFrame(PhotoController controller){
		controller.clickR();
		controller.clickR();
		controller.clickR();
		controller.clickF();
	}
}