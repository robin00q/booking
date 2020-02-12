var slideImages = document.querySelector("#slide_images");
var ImagesWrap = document.querySelectorAll(".img_promotion");
var totalWidth = slideImages.childElementCount * 100;
var eachImagesWidth = 100 / slideImages.childElementCount;

slideImages.style.width = totalWidth.toString() + "%";
ImagesWrap.forEach(function(item){
	item.style.width = eachImagesWidth.toString() + "%";
});

var currentTranslateX = 0;
var currentImageIndex = 1;

function slideLeft(){
	setTimeout(()=>{
		currentTranslateX -= (100 / slideImages.childElementCount);
		slideImages.style.transition = 'all 1.0s';
		slideImages.style.transform = "translateX(" + currentTranslateX.toString() + "%)";
		if(currentImageIndex === (slideImages.childElementCount-1)){
			setTimeout(()=>{
				slideImages.style.transition = 'none';
				slideImages.style.transform = "translateX(" + currentTranslateX.toString() + "%)";
			}, 1000)
			currentTranslateX = 0;
			currentImageIndex = 0;
		}
		currentImageIndex++;
		slideLeft();
	}, 3000);
}

slideLeft();