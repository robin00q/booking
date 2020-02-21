var visualizeNumOffButton = {

	showButton : function(){
		if(document.querySelector("#page_size").getAttribute('data-count') != 1){			
			var htmlTemplate = document.querySelector("#num_off_button");
			document.querySelector(".group_visual > div").insertAdjacentHTML('beforeend', htmlTemplate.innerHTML);
		}
	}
}

visualizeNumOffButton.showButton();