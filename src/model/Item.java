package model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * Item obj from Rss
 * contain Title, Link, Description, Enclosure
 * @author Termchai Sadasengchan 5510546042
 *
 */
public class Item {
	private String title,link,description,enclosure;
	
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
	
	public String getEnclosure()
	{
		return enclosure;
	}
	
	public String toString()
	{
//		return getTitle() + "\n" + getLink() + "\n" + getDescription() +"\n" + getEnclosure();
		return getTitle()+"";
	}
	
	public String getData()
	{
		return "<html>"+getTitle() + "<br>" + getDescription() +"<br>" + getEnclosure()+"<html>";
	}
	
}
