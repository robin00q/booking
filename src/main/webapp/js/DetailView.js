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
		document.querySelector(".prev_inn").addEventListener('click', function(evemt){
		    var current = parseInt(slideImages.getAttribute('current-point'));
		    if(current === -50){
		    	document.querySelector(".figure_pagination > span").innerText = 1;
		    	slideImages.setAttribute('current-point', (current+50));
		    	slideImages.style.transform = "translateX(" + (current+50) + "%)";
		    }
		}, false)
	},

	slideNext : function(slideImages){
		document.querySelector(".nxt_inn").addEventListener('click', function(evemt){
		    var current = parseInt(slideImages.getAttribute('current-point'));
		    if(current === 0){
		    	document.querySelector(".figure_pagination > span").innerText = 2;
		    	slideImages.setAttribute('current-point', (current-50));
		    	slideImages.style.transform = "translateX(" + (current-50) + "%)";
		    }
		}, false);
	}
}

visualizeNumOffButton.initializeButton();
addSlideButtonEventListener.slidePrev(document.querySelector("#slide_images"));
addSlideButtonEventListener.slideNext(document.querySelector("#slide_images"));