package controller;

import java.awt.Button;
import java.awt.Desktop;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Item;
import model.Rss;
import view.GUI;
/**
 * recieve GUI and get some component that important
 * add actionlistener to that component
 * @author Termchai sadsaengchan 5510546042
 *
 */
public class Controller {
	
	private JTextField textFieldURL;
	private Button buttonSearch;
	private JList<Item> listItem;
	private ScrollPane scrollPaneItem;
	private JLabel labelDescription;
	private JLabel labelChannel;
	private Rss rss;
	private URL url;
	private Button buttonHyperLink;
	
	/**
	 * keep component from gui and add action listener
	 * @param gui
	 */
	public void initGUI(GUI gui)
	{
		this.textFieldURL = gui.textFieldURL;
		this.buttonSearch = gui.buttonSearch;
		this.listItem = gui.listItem;
		this.scrollPaneItem = gui.scrollPaneItem;
		this.labelChannel = gui.labelChannel;
		this.labelDescription = gui.labelDescription;
		this.buttonHyperLink = gui.buttonHyperLink;
		
		this.buttonSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JAXBContext ctx = JAXBContext.newInstance( Rss.class );
					Unmarshaller unmarshaller = ctx.createUnmarshaller( );
					url = new URL(textFieldURL.getText());
					Object obj = unmarshaller.unmarshal( url );
					rss = (Rss) obj;
					labelChannel.setText("<html>" + "Accese " + url + " is OK."
							+ "<br>Title: " + rss.getChannel().getTitle()
							+ "<br>Description: " + rss.getChannel().getDescription()
							+ "<br>Link: " + rss.getChannel().getLink()
							+ "</html>");
					addItemToList();
					
					
					
					
				} catch (MalformedURLException e1) {
					labelChannel.setText("don't right format of URL");
					e1.printStackTrace();
				} catch (JAXBException e1) {
					labelChannel.setText(url + " is not XML.");
					e1.printStackTrace();
				}
			}
		});
		
		this.listItem.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Item selectItem = (Item)listItem.getSelectedValue();
				labelDescription.setText((selectItem.getData()));
				
				    for( ActionListener al : buttonHyperLink.getActionListeners() ) {
				        buttonHyperLink.removeActionListener( al );
				    }
				
				buttonHyperLink.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							open(new URI(selectItem.getLink()));
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
			}
		});
		
		
	}
	
	/**
	 * add all item to JList
	 */
	public void addItemToList()
	{
		ArrayList<Item>arrListItems = rss.getChannel().getItems();
		Item[] items = new Item[arrListItems.size()]  ;
		arrListItems.toArray(items);
		
		
		listItem.setListData(items);
	}
	
	/**
	 * open specific URI in internet browser
	 * @param uri
	 */
	  private static void open(URI uri) {
		    if (Desktop.isDesktopSupported()) {
		      try {
		        Desktop.getDesktop().browse(uri);
		      } catch (IOException e) { /* TODO: error handling */ }
		    } else { /* TODO: error handling */ }
		  }
	
	
}
