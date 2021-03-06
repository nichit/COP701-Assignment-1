package cop701.pastry;

import java.util.logging.Logger;




public class PastryListener {
	
	private static final Logger logger = Logger.getLogger(PastryListener.class.getName()); 
	
	private Pastry pastry;
	
	public PastryListener(Pastry pastry) {
		this.pastry = pastry;
	}

	public void doStuff(Message m) {
		
		//logger.info("Pastry message received");
		System.out.println("[Pastry Message] " + m.getAddress() + " received from " + m.getSenderId() + " msg type of " + m.getMessageType());
		if(m.getMessageType()==1)
		{
			this.pastry.sendNodesMap(m);
		}
		else if(m.getMessageType()==2)
		{
			this.pastry.addNodesMap(m);
		}
		else if(m.getMessageType()==4)
		{
			this.pastry.addBroadcastNodesMap(m);
		}
		else if(m.getMessageType()==5)
		{
			this.pastry.routeToNode(m);
		}
		else if(m.getMessageType()==6)
		{
			this.pastry.get(m.getSenderId(),m.getQueryAccountId());
		}
		else if(m.getMessageType()==7)
		{
			this.pastry.addDetails(m);
		}
		else if(m.getMessageType()==8)
		{
			this.pastry.sendLeftLeafSet(m);
		}
		else if(m.getMessageType()==9)
		{
			this.pastry.sendNeighborLedger(m);
		}
		else if(m.getMessageType()==10)
		{
			this.pastry.addNeighborhoodSet(m);
		}
		else {
			logger.warning("Unknown message type");
		}
		
	}

}
