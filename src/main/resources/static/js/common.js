function open_left_menu(){
	if($('.left-menu-wrap').hasClass('open')){
		$('.left-menu-wrap').removeClass('open')
	}else{
		$('.left-menu-wrap').addClass('open')
	}
}

function main_searching_text(val=''){
	val=$.trim(val)
	alert('검색어 : '+val);
}

$(function(){
	$('#main_search').on({
		'keyup':function(key){
			if(key.keyCode==13) main_searching_text($(this).val())
		}
	})
})
