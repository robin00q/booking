document.addEventListener('DOMContentLoaded', function(){
	
	var ticketBoxMap = new HashMap();
	// initialize HashMap
	document.querySelectorAll('#ticket_box').forEach(function(element){
	    var ticketBoxDOM = element.querySelector('.count_control');
	    ticketBoxMap.put(ticketBoxDOM.dataset.type, new TicketBox(ticketBoxDOM));
	});
	
	// add Button + / - Button EventListener
	var ticketBoxWrap = document.querySelector('#ticket_box_wrap');
	ticketBoxWrap.addEventListener('click', function(event){
	    var clicked = event.target;
	    
	    if(clicked.tagName === 'A'){
	        var type = clicked.closest('.count_control').dataset.type;
	        var currentTicketBox = ticketBoxMap.get(type);
	        
	        if(clicked.id === 'ticket_plus_button'){
	            currentTicketBox.addTicket();
	        } else if(clicked.id === 'ticket_minus_button'){
	            currentTicketBox.subtractTicket();
	        }
	        
	        currentTicketBox.totalCountDOM.value = currentTicketBox.count;
	        currentTicketBox.totalPriceDOM.dataset.totalPrice = currentTicketBox.getTotalPrice();
	        currentTicketBox.totalPriceDOM.innerText = currentTicketBox.totalPriceDOM.dataset.totalPrice;
	    }
	}, false);
	
	// add agreement Button EventListener
	var reservationInfo = new ReservationInfo(); 	
	var agreementBoxWrap = document.querySelector('#agreement_box_wrap');
	
	agreementBoxWrap.addEventListener('click', function(event){
		var clicked = event.target;
		
		if(clicked.classList.contains('agree_all')){
			if(reservationInfo.agreement === false){
				document.querySelector('.bk_btn_wrap').classList.remove('disable');
			} else {
				document.querySelector('.bk_btn_wrap').classList.add('disable');
			}
			
			reservationInfo.agreement = !reservationInfo.agreement;
			
		} else if(clicked.className === 'btn_text' || clicked.id === 'agree_arrow_button'){
			
			clicked.closest('.agreement').classList.toggle('open');
			
			var arrowButton = clicked;
			
			if(clicked.tagName === 'SPAN'){
				arrowButton = clicked.nextElementSibling;
			}
			
			if(arrowButton.classList.contains('fn-down2')){
				arrowButton.classList.remove('fn-down2');
				arrowButton.classList.add('fn-up2');
			} else {
				arrowButton.classList.remove('fn-up2');
				arrowButton.classList.add('fn-down2');
			}
		}
	}, false);
	
}, false);

function ReservationInfo(){
	this.revervationName = "";
	this.reservationPhoneNumber = "";
	this.reservationEmail = "";
	this.totalCount = 0;
	this.agreement = false;
}

function TicketBox(ticketBoxDOM){
	this.type = ticketBoxDOM.dataset.type;
	this.price = ticketBoxDOM.dataset.price;
	this.count = 0;
	
	this.totalPriceDOM = ticketBoxDOM.querySelector('#total_price');
	this.totalCountDOM = ticketBoxDOM.querySelector('.count_control_input');
	this.minusButtonDOM = ticketBoxDOM.querySelector('.ico_minus3');
}

TicketBox.prototype.getTotalPrice = function(){
	return this.price * this.count;
}

TicketBox.prototype.addTicket = function(){
	this.minusButtonDOM.classList.remove('disabled');
	this.totalCountDOM.classList.remove('disabled');
	return this.count++;
	
}
TicketBox.prototype.subtractTicket = function(){
	if(this.count > 0){
		this.count--;
		if(this.count == 0){
			this.minusButtonDOM.classList.add('disabled');
			this.totalCountDOM.classList.add('disabled');
		}
	}
	return this.count;
}