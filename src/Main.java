
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import controller.Controller;
import view.GUI;
import model.Rss;

/**
 * Main
 * Create GUI and controller
 * push GUI to Controller
 * @author Termchai Sadsaengchan 5510546042
 *
 */
public class Main {
public static void main(String[]args) throws JAXBException, MalformedURLException
	{
//		JAXBContext ctx = JAXBContext.newInstance( Rss.class );
//		Unmarshaller unmarshaller = ctx.createUnmarshaller( );
//		URL url = new URL("https://www.blognone.com/rss.xml");
//		Object obj = unmarshaller.unmarshal( url );
//		Rss person = (Rss) obj;
//		
//		
//		System.out.println(person.getChannel().toString());
//		System.out.println(person.getChannel().getItems().get(0).toString());
		
		GUI gui = new GUI();
		gui.run();
		
		Controller controller = new Controller();
		controller.initGUI(gui);
	}
}
