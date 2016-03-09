/**
 * @author Leela Prabhu
 *
 */
public class ToDHT extends ToFrame{
/**This manages the path to David Hume Tower
 * 
 */
public void ToDHT(){
		
	}
	@Override
	public void toFrame(PhotoController controller){
		controller.clickR();
		controller.clickR();
		controller.clickF();
	}
	@Override
	public void fromFrame(PhotoController controller){
		controller.clickL();
		controller.clickL();
		controller.clickL();
		controller.clickF();
	}
}