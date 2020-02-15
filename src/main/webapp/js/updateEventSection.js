var anchorClass = document.querySelector(".section_event_tab");
var currentStartPoint = 0;
var leftBox = document.querySelector("#lst_event_box_left");
var rightBox = document.querySelector("#lst_event_box_right");
var moreButton = document.querySelector("#show-more");
var initialLoad = 0;
var updateEventBox = 1;

window.addEventListener('load', function(event){
	var categoryId = 0;
	getFourProductByCategoryIdUsingAjax(initialLoad, categoryId);
}, false);

anchorClass.addEventListener('click', function(event){
	var categoryId = getCategoryIdByClickedPosition(anchorClass, event);
	if(categoryId != null){
		currentStartPoint = 0;
		/* update Event Tab Active ( current => now clicked ) */
		updateEventTab(anchorClass.querySelector('.active'), getClosestLiTag(event));
		clearEventBox(leftBox);
		clearEventBox(rightBox);
		getFourProductByCategoryIdUsingAjax(initialLoad, categoryId);
	}
	document.querySelector(".more").style.display="block";
}, false);

moreButton.addEventListener('click', function(event){
	var categoryId = getCategoryIdByActive(anchorClass, event);
	getFourProductByCategoryIdUsingAjax(updateEventBox, categoryId);
}, false);

function getCategoryIdByClickedPosition(anchorClass, event){
	if(event.target.tagName !== 'A' && event.target.tagName !== 'SPAN' && event.target.tagName !== 'LI'){
		return;
	}
	
	return getClosestLiTag(event).getAttribute("data-category");
}

function getCategoryIdByActive(anchorClass, event){
	return anchorClass.querySelector('.active').closest("li").getAttribute("data-category");
}

function getFourProductByCategoryIdUsingAjax(type, categoryId){
	var RequestURL = "http://localhost:8080/booking/api/products?categoryId=" + categoryId.toString() +"&start=" + currentStartPoint.toString();
	var xmlReq = new XMLHttpRequest();

	xmlReq.onload = function(){
		if(xmlReq.status !== 200) {
			return;
		}
		var jsonobj = JSON.parse(this.responseText);
		if(type === initialLoad){
			updateEventCategoryCount(categoryId, jsonobj.totalCount);
		} else if(type === updateEventBox){
			if(currentStartPoint >= jsonobj.totalCount) {
				document.querySelector(".more").style.display="none";
			}
		}
		updateSectionEventBox(jsonobj.items);
		
	};
	
	xmlReq.open("GET", RequestURL);
	xmlReq.setRequestHeader("Content-Type", "application/json");
	xmlReq.send();
	
	currentStartPoint += 4;
	
}

function getClosestLiTag(event){
	if(event.target.tagName === 'LI'){
		return event.target;
	}
	return event.target.closest("li");
}

function updateEventTab(tobeRemovedActive, tobeAddedActive){
	tobeRemovedActive.classList.remove("active");
	tobeAddedActive.firstElementChild.classList.add("active");
}

function updateEventCategoryCount(categoryId, CategoryCount){
	document.querySelector("#category_count").innerText = CategoryCount.toString() + "개";
}

function updateSectionEventBox(productDescriptions){
	var itemTemplate = document.querySelector("#itemListforTest").innerHTML;
	var bindTemplate = Handlebars.compile(itemTemplate);
	var count = 0;
	
	productDescriptions.forEach(function(item){
		var resultHTML = bindTemplate(item);
		
		if(count % 2){
			leftBox.insertAdjacentHTML('beforeend', resultHTML);
		} else {
			rightBox.insertAdjacentHTML('beforeend', resultHTML);
		}
		count++;
	});
}

function clearEventBox(box){
	while(box.hasChildNodes()){
		box.removeChild(box.firstChild);
	}
}