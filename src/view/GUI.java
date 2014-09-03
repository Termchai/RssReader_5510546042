package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Controller;
import model.Item;

/**
 * Gui of application
 * @author Termchai sadsaengchan 5510546042
 *
 */
public class GUI extends JFrame{
	
	private JPanel panelTop;
	private JPanel panelBot;
	
	//it should be "Private" but for save time
	public JTextField textFieldURL;
	public Button buttonSearch;
	public Button buttonHyperLink;
	public JList<Item> listItem;
	public ScrollPane scrollPaneItem;
	public ScrollPane scrollPaneDescription;
	public JLabel labelDescription;
	public JLabel labelChannel;
	public JPanel panelDummy;
	
	public GUI()
	{
		super("XML Reader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
	}
	
	public void run()
	{
		initCompenent();
		setVisible(true);
	}

	private void initCompenent() {
		
		//Top
		panelTop = new JPanel();
		panelTop.setLayout(new BorderLayout());
		textFieldURL = new JTextField();
		buttonSearch = new Button();
		buttonSearch.setLabel("Enter");
		panelTop.add(textFieldURL,BorderLayout.CENTER);
		panelTop.add(buttonSearch,BorderLayout.EAST);
		
		//Center
		labelChannel = new JLabel("Please enter link of Rss.");
		
		//Bot
		panelBot = new JPanel();
		panelBot.setLayout(new BorderLayout());
		buttonHyperLink = new Button("HyperLink");
		scrollPaneItem = new ScrollPane();
		scrollPaneDescription = new ScrollPane();
		listItem = new JList<Item>();
		labelDescription = new JLabel();
		panelDummy = new JPanel();
		panelDummy.add(buttonHyperLink,BorderLayout.CENTER);
		panelDummy.add(new JPanel(),BorderLayout.NORTH);
		panelDummy.add(new JPanel(),BorderLayout.SOUTH);
		scrollPaneDescription.add(labelDescription);
		scrollPaneItem.add(listItem);
		
		panelBot.add(scrollPaneItem,BorderLayout.WEST);
		panelBot.add(panelDummy,BorderLayout.CENTER);
		panelBot.add(scrollPaneDescription,BorderLayout.EAST);
		
		//set size of all component
		setComponetSize();
		
		//Add Panel to JFrame
		add(panelTop,BorderLayout.NORTH);
		add(labelChannel,BorderLayout.CENTER);
		add(panelBot,BorderLayout.SOUTH);
		
		
	}
	
	private void setComponetSize() {
		setSize(1000,600);
		setLocation(200,50);
		textFieldURL.setPreferredSize(new Dimension(600,30));
		buttonSearch.setPreferredSize(new Dimension(80,26));
		scrollPaneItem.setPreferredSize(new Dimension(300,400));
		scrollPaneDescription.setPreferredSize(new Dimension(600,400));
		labelDescription.setPreferredSize(new Dimension(600,400));
		buttonHyperLink.setPreferredSize(new Dimension(80,30));
		
	}
}
