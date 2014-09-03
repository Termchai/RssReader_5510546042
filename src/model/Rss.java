package model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * Rss obj
 * contain only Channel
 * @author Termchai sadaseangchan 5510546042
 *
 */
public class Rss {
	private Channel channel;
	public Channel getChannel()
	{
		return channel;
	}
}
