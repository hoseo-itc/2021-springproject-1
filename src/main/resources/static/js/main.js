
// 사이드바 열고 닫기
function side_menu_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
function side_menu_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// 여행지 추전 스와이퍼
$(function(){
    var top_place = new Swiper('.swiper-container', {
        autoplay: { delay: 2000, },
    });
})
