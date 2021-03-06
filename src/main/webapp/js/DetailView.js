var visualizeNumOffButton = {

	initializeButton : function(){
		var pageSize = document.querySelector("#page_size").getAttribute('data-count');
		if(pageSize != 1){			
			var htmlTemplate = document.querySelector("#num_off_button");
			document.querySelector("#image_visual_wrapper").insertAdjacentHTML('beforeend', htmlTemplate.innerHTML);
			
			var slideImages = document.querySelector("#slide_images");
			slideImages.style.width = (pageSize * 100).toString() + "%";
			
			slideImages.style.transition = 'all 1.0s';
		}
	},
	
}

var addSlideButtonEventListener = {
	
	slidePrev : function(slideImages){
		if(document.querySelector(".prev_inn") !== null){
			document.querySelector(".prev_inn").addEventListener('click', function(event){
			    var current = parseInt(slideImages.getAttribute('current-point'));
			    if(current === -50){
			    	document.querySelector(".figure_pagination > span").innerText = 1;
			    	slideImages.setAttribute('current-point', (current+50));
			    	slideImages.style.transform = "translateX(" + (current+50) + "%)";
			    }
			}, false);
		}
	},

	slideNext : function(slideImages){
		if(document.querySelector(".nxt_inn") !== null){
			document.querySelector(".nxt_inn").addEventListener('click', function(event){
				var current = parseInt(slideImages.getAttribute('current-point'));
				if(current === 0){
					document.querySelector(".figure_pagination > span").innerText = 2;
					slideImages.setAttribute('current-point', (current-50));
					slideImages.style.transform = "translateX(" + (current-50) + "%)";
				}
			}, false);
		}
	}
}

var addBkMoreButtonEventListener = {
	openButton : function(){
		document.querySelector("._open").addEventListener('click', function(event){
		    document.querySelector(".store_details").classList.remove('close3');
		    this.style.display = 'none';
		    document.querySelector("._close").style.display = 'block';
		    event.preventDefault();
		}, false);
	},
	closeButton : function(){
		document.querySelector("._close").addEventListener('click', function(event){
		    document.querySelector(".store_details").classList.add('close3');
		    this.style.display = 'none';
		    document.querySelector("._open").style.display = 'block';
		    event.preventDefault();
		}, false);
	} 
}

var addPathButtonEventListener = {
	pathButton : function(){
		document.querySelector("._path").addEventListener('click', function(event){
			var liWrap = document.querySelector("._path").closest("LI");
			liWrap.classList.add('active');
			liWrap.firstElementChild.classList.add('active');
			
			var siblingNode = document.querySelector("._detail");
			siblingNode.classList.remove('active');
			siblingNode.firstElementChild.classList.remove('active');
			
		    document.querySelector(".detail_location").classList.remove('hide');
		    document.querySelector(".detail_area_wrap").classList.add('hide');  
		    event.preventDefault();
		}, false);
	},
	DetailButton : function(){
		document.querySelector("._detail").addEventListener('click', function(event){
			var liWrap = document.querySelector("._detail").closest("LI");
			liWrap.classList.add('active');
			liWrap.firstElementChild.classList.add('active');
			
			var siblingNode = document.querySelector("._path");
			siblingNode.classList.remove('active');
			siblingNode.firstElementChild.classList.remove('active');
			
		    document.querySelector(".detail_area_wrap").classList.remove('hide');
		    document.querySelector(".detail_location").classList.add('hide');  
		    event.preventDefault();
		}, false);
	}
}

visualizeNumOffButton.initializeButton();
addSlideButtonEventListener.slidePrev(document.querySelector("#slide_images"));
addSlideButtonEventListener.slideNext(document.querySelector("#slide_images"));
addBkMoreButtonEventListener.openButton();
addBkMoreButtonEventListener.closeButton();
addPathButtonEventListener.pathButton();
addPathButtonEventListener.DetailButton();
