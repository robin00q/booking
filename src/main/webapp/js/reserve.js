document.addEventListener('DOMContentLoaded', function(){
	
	var ticketBoxMap = new HashMap();
	// initialize & generate HashMap
	document.querySelectorAll('#ticket_box').forEach(function(element){
	    var ticketBoxDOM = element.querySelector('.count_control');
	    ticketBoxMap.put(ticketBoxDOM.dataset.type, new TicketBox(ticketBoxDOM));
	});
	
	// initialize & generate ReservationInfo
	var reservationInfo = new ReservationInfo();
	var validator = new Validator(document.querySelector('.form_horizontal'));
	
	// add Button + / - Button EventListener
	var ticketBoxWrap = document.querySelector('#ticket_box_wrap');
	ticketBoxWrap.addEventListener('click', function(event){
	    var clicked = event.target;
	    
	    if(clicked.tagName === 'A'){
	        var type = clicked.closest('.count_control').dataset.type;
	        var currentTicketBox = ticketBoxMap.get(type);
	        
	        if(clicked.id === 'ticket_plus_button'){
	            currentTicketBox.addTicket();
	            reservationInfo.manageTotalCount('add');
	        } else if(clicked.id === 'ticket_minus_button'){
	            currentTicketBox.subtractTicket();
	            reservationInfo.manageTotalCount('subtract');
	        }
	        
	        currentTicketBox.eachCountDOM.value = currentTicketBox.count;
	        currentTicketBox.totalPriceDOM.dataset.totalPrice = currentTicketBox.getTotalPrice();
	        currentTicketBox.totalPriceDOM.innerText = currentTicketBox.totalPriceDOM.dataset.totalPrice;
	    }
	}, false);
	
	// add agreement Button EventListener
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
	
	// add submitButton EventListener
	var submitButton = document.querySelector('#submit_button');
	submitButton.addEventListener('click', function(event){
		if(this.classList.contains('disable')){
			return;
		}
		
		if(validator.validateForm()){
			reservationInfo.setReservationInfo(validator);
			console.log(reservationInfo);
		}
		
		
	}, false);
	
	// add autohypen EventListener
	const telInput = document.querySelector('.tel_input');
	telInput.addEventListener('keyup', () => {
		telInput.value = autoHypenPhoneNumber(telInput.value);
	});
}, false);

function autoHypenPhoneNumber(str){
	str = str.replace(/[^0-9]/g, '');
	if(str.length < 4) {
		return str;
	} else if(str.length < 7) {
		return `${str.substr(0, 3)}-${str.substr(3)}`;
	} else if(str.length < 11) {
		return `${str.substr(0, 3)}-${str.substr(3, 3)}-${str.substr(6)}`;
	} else {
		return `${str.substr(0, 3)}-${str.substr(3, 4)}-${str.substr(7)}`;
	}
}

function ReservationInfo(){
	this.totalCountDOM = document.querySelector('#totalCount');

	this.reservationName = "";
	this.reservationPhoneNumber = "";
	this.reservationEmail = "";
	this.totalCount = "";
	this.agreement = false;
}

ReservationInfo.prototype.manageTotalCount = function(addOrSubtract){
	if(addOrSubtract === 'add'){
		this.totalCountDOM.innerText = ++this.totalCountDOM.dataset.totalCount;
	} else if(addOrSubtract === 'subtract'){
		if(this.totalCountDOM.dataset.totalCount > 0){
			this.totalCountDOM.innerText = --this.totalCountDOM.dataset.totalCount;
		}
	}
}

ReservationInfo.prototype.setReservationInfo = function(validator){
	this.reservationName = validator.nameDOM.value;
	this.reservationPhoneNumber = validator.telDOM.value;
	this.reservationEmail = validator.emailDOM.value;
	this.totalCount = this.totalCountDOM.dataset.totalCount;
	this.agreement = true;
}

function Validator(inlineFormDOM){
	this.nameDOM = inlineFormDOM.querySelector('#name');
	this.telDOM = inlineFormDOM.querySelector('#tel');
	this.emailDOM = inlineFormDOM.querySelector('#email');
	
	this.nameRegex = /^[가-힣]{2,4}$/;
	this.telRegex = /^01(0|1|8|9|0)-\d{3,4}-\d{4}$/;
	this.emailRegex = /^[0-9a-zA-Z][0-9a-zA-Z_]+?@[a-zA-Z]+?\.[a-zA-Z]{2,3}$/;
	
	this.isValid = false;
}

Validator.prototype.validateForm = function(){
	this.isValid = true;
	
	if(!this.nameRegex.test(this.nameDOM.value)){
		this.nameDOM.value = "형식이 틀렸거나 너무 짧아요";
		this.isValid = false;
	} 
	if(!this.telRegex.test(this.telDOM.value)){
		this.telDOM.value = "형식이 틀렸거나 너무 짧아요";
		this.isValid = false;
	}
	if(!this.emailRegex.test(this.emailDOM.value)){
		this.emailDOM.value = "형식이 틀렸거나 너무 짧아요";
		this.isValid = false;
	}
	
	return this.isValid;
}

function TicketBox(ticketBoxDOM){
	this.type = ticketBoxDOM.dataset.type;
	this.price = ticketBoxDOM.dataset.price;
	this.count = 0;
	
	this.totalPriceDOM = ticketBoxDOM.querySelector('#each_price');
	this.eachCountDOM = ticketBoxDOM.querySelector('.count_control_input');
	this.minusButtonDOM = ticketBoxDOM.querySelector('.ico_minus3');
	this.totalCountDOM = document.querySelector('#totalCount');
}

TicketBox.prototype.getTotalPrice = function(){
	return this.price * this.count;
}

TicketBox.prototype.addTicket = function(){
	this.minusButtonDOM.classList.remove('disabled');
	this.eachCountDOM.classList.remove('disabled');
	return this.count++;
	
}
TicketBox.prototype.subtractTicket = function(){
	if(this.count > 0){
		this.count--;
		if(this.count == 0){
			this.minusButtonDOM.classList.add('disabled');
			this.eachCountDOM.classList.add('disabled');
		}
	}
	return this.count;
}