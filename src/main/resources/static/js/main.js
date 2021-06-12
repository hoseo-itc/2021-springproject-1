
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
    var top_place = new Swiper('.top-place-container', {
        autoplay : {  // 자동 슬라이드 설정 , 비 활성화 시 false
          delay : 3000,   // 시간 설정
          disableOnInteraction : false,  // false로 설정하면 스와이프 후 자동 재생이 비활성화 되지 않음
        },
        slidesPerView: 1, // 보여지는 슬라이드 수
        pagination: {
            el: '.bullet-box',
            type: 'bullets',
        },
        loop: true,
        slidesPerGroup : 1,
    });
    var popular_post = new Swiper('.popular-post', {
        autoplay: { delay: 3000, },
        loop: true,
        slidesPerView: 3, // 보여지는 슬라이드 수
        spaceBetween: 10, // 슬라이드 간의 거리(px 단위)
    });
    var best_photo_post = new Swiper('.best-photo-post', {
            autoplay: { delay: 2000, },
            loop: true,
            slidesPerView: 3, // 보여지는 슬라이드 수
            spaceBetween: 10, // 슬라이드 간의 거리(px 단위)
        });

})
