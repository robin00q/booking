document.addEventListener('DOMContentLoaded', function(){
	
	var ticketBoxMap = new HashMap();
	// initialize HashMap
	document.querySelectorAll('#ticket-box').forEach(function(element){
	    var DOMDataset = element.querySelector('.clearfix').dataset;
	    ticketBoxMap.put(DOMDataset.type, new TicketBox(DOMDataset));
	});
	
	// add Button + / - Button EventListener
	
	
}, false);

function TicketBox(DOMDataset){
	this.type = DOMDataset.type;
	this.price = DOMDataset.price;
	this.count = 0;
}

TicketBox.prototype.getTotalPrice = function(){
	return this.price * this.count;
}