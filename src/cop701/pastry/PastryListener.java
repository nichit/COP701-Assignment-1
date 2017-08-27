package cop701.pastry;

import java.util.logging.Logger;




public class PastryListener {
	
	private static final Logger logger = Logger.getLogger(PastryListener.class.getName()); 
	
	private Pastry pastry;
	
	public PastryListener(Pastry pastry) {
		this.pastry = pastry;
	}

	public void doStuff(Object inObject) {
		
		
		if (inObject instanceof Message) {
			Message m = (Message)inObject;
			logger.info("Pastry message received");
			this.pastry.get(m.getSenderId(),m.getQueryAccountId());
			if(m.getMessageType()==2)
			{
				this.pastry.addNodesMap(m);
			}
			else if(m.getMessageType()==1)
			{
				this.pastry.sendNodesMap(m);
			}
			else if(m.getMessageType()==4)
			{
				this.pastry.addBroadcastNodesMap(m);
			}
		}
		
	}

}
