import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;

import org.junit.Test;
/**
 * @author Leela Prabhu (S1471625)
 *
 */
public class Test2 extends junit.framework.TestCase implements PhotoViewer {
	private static final Object EXPECTED_COUNT_1 = 10;
	private static final Object EXPECTED_COUNT_2 = 24;
	private static final int NO_OF_PANES = 7;
	private String text;
	private String imageView;
	private String menuPick;
	private String menuPut;
	private Image image;
	private int x_coord;
	private int y_coord;
	private boolean disablePick;
	private boolean disablePut;
	private boolean disable;
	private Hashtable<String, Boolean> visibility= new Hashtable<String, Boolean>();
	private Hashtable<String, Boolean> disablePick1= new Hashtable<String, Boolean>();
	private Hashtable<String, Boolean> disablePut1= new Hashtable<String, Boolean>();
	private boolean buttonVisibility;
	private boolean visibility1;
	private boolean basketVisible= true;
	private boolean bunnyVisible= true;
	private boolean bulbVisible= true;
	private boolean starVisible= true;
	private boolean basketPick= true;
	private boolean bunnyPick= true;
	private boolean bulbPick= true;
	private boolean starPick= true;
	private boolean basketPut= false;
	private boolean bunnyPut= false;
	private boolean bulbPut= false;
	private boolean starPut= false;

	private String frame[] = new String[] { "Junction", "To David Hume Tower",
			"George Square","Charles Street", "Crichton Street",
			"To Chapel Street"};
	private String pickable[] = new String[] { "basket", "bulb", "bunny",
			"star" };
	private boolean visible[] = new boolean[] {true, true, true, true};
	private String mapView;
	private Image map;
	private ArrayList<ToFrame> getFrames= new ArrayList<ToFrame>();
	//

	@Test
	public void test1() { // test to see if it started at the right place
		PhotoViewer viewer = this;
		PhotoController controller = new WorldController(this);
		JFXPanel fxPanel = new JFXPanel();
		controller.Initialise();
		controller.clickR();
		//assertEquals(text, "Junction");
	}

	@Test
	public void test2() { // test every location
		PhotoViewer viewer = this;
		PhotoController controller = new WorldController(this);
		int count = 0;
		JFXPanel fxPanel = new JFXPanel();
		controller.Initialise();
		initToFrames();
		Image map1;
		Image map2;
		//int i=1;
		for (int i=1; i <frame.length; i++){
			map1= map;
			getFrames.get(i-1).toFrame(controller);
			map2= map;
			if (text.equals(frame[i])&&goAround(controller)&&(map1!=map2))
				count = count + 1;
			getFrames.get(i-1).fromFrame(controller);
			map2= map;
			if (text.equals("Junction")&&goAround(controller)&&(map1.equals(map2)))
				count = count + 1;
		}
		assertEquals(count, EXPECTED_COUNT_1);
	}

	private void initToFrames() {
		getFrames.add(new ToDHT());
		getFrames.add(new ToGS());
		getFrames.add(new ToChS());
		getFrames.add(new ToCrS());
		getFrames.add(new ToTCS());
	}

	@Test
	public void test3() { // test every pickable
		PhotoViewer viewer = this;
		PhotoController controller = new WorldController(this);
		int count = 0;
		JFXPanel fxPanel = new JFXPanel();
		controller.Initialise();

		for (int i = 0; i < pickable.length; i++) {
			controller.pickUp(pickable[i]);
			count= testConditions(false, count, i);
			controller.putDown(pickable[i]);
			count= testConditions(true, count, i);
		}
		assertEquals(count, EXPECTED_COUNT_2);
	}
	
	public int testConditions(boolean bool, int count, int i){
		if ((imageView.equals(pickable[i] + "View"))
				&& ((boolean)visibility.get(pickable[i]+"View") == bool))
			count++;
		if ((menuPick.equals(pickable[i] + "MenuPick")) && (disablePick == !bool))
			count++;
		if ((menuPut.equals(pickable[i] + "MenuPut"))&& (disablePut == bool)){
			count++;
		}
		return count;
	}
	
/*	@Test
	public void test4() { // test every pickable
		PhotoViewer viewer = this;
		PhotoController controller = new WorldController(this);
		int count = 0;
		JFXPanel fxPanel = new JFXPanel();
		controller.Initialise();
		java.util.Random r = new java.util.Random();         //Use the Java class for random numbers.
        int rn=0;                                   //Initialize a random number for selecting which picture in that topic to load.

        int check=0;

		visibilityGet();
        for (int i=0; i< pickable.length; i++){
        	rn= r.nextInt(2);
        	if ((rn==0)&&((boolean)visibility.get(pickable[i]+"View") == true)){
        		controller.pickUp(pickable[i]);
        		check=1;
        	}
        }

        while(check!=0){
        	if(buttonVisibility)
            	rn= r.nextInt(3);
            else
            	rn= r.nextInt(2);
        	
        	switch(rn){
        		case 0: controller.clickL(); break;
        		case 1: controller.clickR(); break;
        		case 2: controller.clickF(); break;
        	}
        	visibilityGet();
        	for (int i=0; i< pickable.length; i++){
            	rn= r.nextInt(2);
            	if ((rn==0)&&((boolean)visibility.get(pickable[i]+"View") == true)){
            		controller.pickUp(pickable[i]);
            		check=1;
            	}
            }
        	
        	//check =0;
        	visibilityGet();
        	for (int i=0; i< pickable.length; i++){
            	rn= r.nextInt(2);
            	if ((rn==0)&&((boolean)visibility.get(pickable[i]+"View") == true)){
            		controller.pickUp(pickable[i]);
            		check=1;
            	}
            }
        	
        }
        
       // assertEquals(count,1);
        
	}
	*/
	public void visibilityGet(){
		visibility.put("basketView",basketVisible);
		visibility.put("bunnyView",bunnyVisible);
		visibility.put("bulbView",bulbVisible);
		visibility.put("starView",starVisible);
	}

	public void disablePutGet(){
		visibility.put("basketView",basketVisible);
		visibility.put("bunnyView",bunnyVisible);
		visibility.put("bulbView",bulbVisible);
		visibility.put("starView",starVisible);
	}
	
	public boolean goAround(PhotoController controller){
		for(int i=0; i < NO_OF_PANES; i++){
        	controller.clickR();
        }
        Image image1= image;
        int x_coord1= x_coord;
        
        for(int i=0; i < NO_OF_PANES; i++){
        	controller.clickL();
        }
        Image image2= image;
        int x_coord2= x_coord;
        
        return((x_coord1==x_coord2)&&(image1.equals(image2)));
	}

	@Override
	public void setController(PhotoController controller) {

	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setImage(String imageView, Image image) {
		if (imageView.contains("map")){
		this.map = image;
		}
		this.mapView = imageView;
	}

	@Override
	public void setVisible(String imageView, boolean visibility1) {
		for(int i=0; i<pickable.length; i++){
			visibility.put(pickable[i]+"View", visible[i]);
		}
		
		this.imageView = imageView;
		visibility.put(this.imageView, (Boolean)visibility1);
		if (imageView.contains("buttonF")){
			this.buttonVisibility= visibility1;
		}
		if (imageView.contains("bulbView")){
			bulbVisible= visibility1;
		}
		else if (imageView.contains("bunnyView")){
			bunnyVisible= visibility1;
		}
		else if (imageView.contains("basketView")){
			basketVisible= visibility1;
		}
		else if (imageView.contains("starView")){
			starVisible= visibility1;
		}
		else
			this.visibility1 = visibility1;

		
	}

	@Override
	public void setDisable(String menuItem, boolean disable) {
			if (menuItem.contains("Pick")){
				this.menuPick=menuItem;
				this.disablePick= disable;
				//disablePick1.put(this.menuItem, (Boolean)disable);
				if (menuItem.contains("bulb")){
					bulbPick= disable;
				}
				else if (menuItem.contains("bunny")){
					bunnyPick= disable;
				}
				else if (menuItem.contains("basket")){
					basketPick= disable;
				}
				else if (menuItem.contains("star")){
					starPick= disable;
				}
			}
			else{
				this.menuPut=menuItem;
				this.disablePut= disable;
				//disablePut1.put(this.menuItem, (Boolean)disable);
				if (menuItem.contains("bulb")){
					bulbPut= disable;
				}
				else if (menuItem.contains("bunny")){
					bunnyPut= disable;
				}
				else if (menuItem.contains("basket")){
					basketPut= disable;
				}
				else if (menuItem.contains("star")){
					starPut= disable;
				}
			}
			
	}

	@Override
	public void initialise(PhotoController controller) {

	}

	@Override
	public void setImage(String imageView, Image image, int x_coord, int y_coord) {
		this.imageView= imageView;
		this.x_coord= x_coord;
		this.y_coord= y_coord;
		this.image= image;
	}

}
