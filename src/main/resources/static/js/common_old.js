// 사이드바 열고 닫기
function side_menu_open() {
    if($('#mySidebar').css('display')=="block"){
        $('#mySidebar').css('display','none');
        $('#myOverlay').css('display','none');
    }else{
        $('#mySidebar').css('display','block');
        $('#myOverlay').css('display','block');
    }
}

// 전체 검색
function total_search(){
    var search_text = $('#total_search_var').val();
    if($.trim(search_text)==''){
        alert('입력된 검색어가 없습니다.');
    }else{
        alert('검색어 : '+search_text);
    }
}