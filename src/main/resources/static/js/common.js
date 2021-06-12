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
