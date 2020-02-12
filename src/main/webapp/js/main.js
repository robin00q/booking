var anchorClass = document.querySelector(".section_event_tab");

anchorClass.addEventListener('click', function(event){
	
	var categoryCount = toggleActiveBar(anchorClass, event);
    
	changeTotalCategoryCount(categoryCount);
    
}, false);

function toggleActiveBar(anchorClass, event){
	if(event.target.tagName === 'A' || event.target.tagName === 'SPAN' || event.target.tagName === 'LI'){
		var tobeRemovedActive = anchorClass.querySelector('.active');
		var tobeAddedActive;
		if(event.target.tagName === 'LI'){
			tobeAddedActive = event.target;
		}
		else {
			tobeAddedActive = event.target.closest("li");
		}
	    
	    tobeRemovedActive.classList.remove("active");
	    tobeAddedActive.firstElementChild.classList.add("active");
	    
	    return tobeAddedActive.getAttribute("data-count");
	}
}

function changeTotalCategoryCount(categoryCount){
	var totalCategoryCount = document.querySelector("#category_count");
	
	totalCategoryCount.innerText = categoryCount.toString() + "개";
}

var slideImages = document.querySelector("#slide_images");
var currentTranslateX = 0;

function slideLeft(){
	setTimeout(()=>{
		currentTranslateX -= 25;
		slideImages.style.transition = 'all 1.0s';
		slideImages.style.transform = "translateX(" + currentTranslateX.toString() + "%)";
		if(currentTranslateX === -75){
			setTimeout(()=>{
				slideImages.style.transition = 'none';
				slideImages.style.transform = "translateX(" + currentTranslateX.toString() + "%)";
			}, 1000)
			currentTranslateX = 0;
		}
		slideLeft();
	}, 3000);
}

slideLeft();