var anchorClass = document.querySelector(".section_event_tab");
var currentStartPoint = 0;
var leftBox = document.querySelector("#lst_event_box_left");
var rightBox = document.querySelector("#lst_event_box_right");
var moreButton = document.querySelector("#show-more");

window.addEventListener('load', function(event){
	var categoryId = 0;
	getFourProductUsingAjax(0, categoryId);
}, false);

anchorClass.addEventListener('click', function(event){
	var categoryId = GetCategoryIdByClickedPosition(anchorClass, event);
	if(categoryId != null){
		currentStartPoint = 0;
		clearBox(leftBox);
		clearBox(rightBox);
		getFourProductUsingAjax(0, categoryId);
	}
}, false);

moreButton.addEventListener('click', function(event){
	var categoryId = GetCategoryIdByActive(anchorClass, event);
	getFourProductUsingAjax(1, categoryId);
}, false);

function GetCategoryIdByClickedPosition(anchorClass, event){
	if(event.target.tagName === 'A' || event.target.tagName === 'SPAN' || event.target.tagName === 'LI'){
		var tobeRemovedActive = anchorClass.querySelector('.active');
		var tobeAddedActive = getClosestLiTag(event);
		var categoryId = tobeAddedActive.getAttribute("data-category");
		
		updateSectionEventTab(tobeRemovedActive, tobeAddedActive);
		
		return categoryId;
	} else {
		return null;
	}
}

function GetCategoryIdByActive(anchorClass, event){
	return anchorClass.querySelector('.active').closest("li").getAttribute("data-category");
}

function getFourProductUsingAjax(type, categoryId){
	var RequestURL = "http://localhost:8080/booking/api/products?categoryId=" + categoryId.toString() +"&start=" + currentStartPoint.toString();
	var xmlReq = new XMLHttpRequest();

	xmlReq.onload = function(){
		if(xmlReq.status == 200){
			var jsonobj = JSON.parse(this.responseText);
			if(type === 0){
				updateSectionEventCount(categoryId, jsonobj.totalCount);
			}
			updateSectionEventBox(jsonobj.items);
		}
	};
	
	xmlReq.open("GET", RequestURL);
	xmlReq.setRequestHeader("Content-Type", "application/json");
	xmlReq.send();
	
	currentStartPoint += 4;
}


function getClosestLiTag(event){
	if(event.target.tagName === 'LI'){
		return event.target;
	} else {
		return event.target.closest("li");
	}
}

function updateSectionEventTab(tobeRemovedActive, tobeAddedActive){
	tobeRemovedActive.classList.remove("active");
	tobeAddedActive.firstElementChild.classList.add("active");
}

function updateSectionEventCount(categoryId, CategoryCount){
		document.querySelector("#category_count").innerText = CategoryCount.toString() + "개";
}

function updateSectionEventBox(productDescriptions){
	var itemTemplate = document.querySelector("#itemListforTest").innerHTML;
	var count = 0;
	productDescriptions.forEach(function(item){
		var resultHTML = "";
		resultHTML = itemTemplate.replace("{description}", item.productDescription)
								.replace("{id}", item.displayInfoId)
								.replace("{placeName}", item.placeName)
								.replace("{content}", item.productContent)
								.replace("{imageUrl}", item.productImageUrl)
								.replace("{descriptionSpan}", item.productDescription);
		if(count % 2){
			leftBox.insertAdjacentHTML('beforeend', resultHTML);
		} else {
			rightBox.insertAdjacentHTML('beforeend', resultHTML);
		}
		count++;
	});
}

function clearBox(box){
	while(box.hasChildNodes()){
		box.removeChild(box.firstChild);
	}
}