package model;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
@XmlType(name="channel")
@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Channel obj from Rss
 * contain Items, Title, Link, Description, Language
 * @author Termchai sadsaengchan 5510546042 
 *
 */
public class Channel {
	private ArrayList<Item> item;
	private String title;
	private String link;
	private String description;
	private String language ;
	
	public ArrayList<Item> getItems()
	{
		return item;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getLink()
	{
		return link;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getLanguage()
	{
		return language;
	}
	
	public String toString()
	{
		return getTitle() + "\n" + getLink() + "\n" + getDescription() +"\n" + getLanguage();
	}
	
}
