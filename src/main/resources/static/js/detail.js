function subscript(hostNo=null){
    if(hostNo){
        $.ajax({
            type    : "POST",
            url        : "/subscript",
            //contentType: "application/json",
            dataType:"json",
            data     : {hostNo:hostNo}
        })
        .done(function (data, textStatus, xhr) {
            if(data.state){
                location.reload();
            }else{
                alert("이미 구독되어있습니다.")
            }
        })
        .fail(function(data, textStatus, errorThrown){
            console.log("구독에 실패헀습니다.");
            console.log(data);
            console.log(textStatus);
            console.log(errorThrown);
        });
    }else{
        alert("로그인 후 구독이 가능합니다.")
    }

}

function delSubscript(hostNo=null){
    if(hostNo){
        if(confirm('구독을 취소하시겠습니까?')){
            $.ajax({
                type    : "POST",
                url        : "/delSubscript",
                dataType: "json",
                data     : {hostNo:hostNo}
            })
            .done(function (data, textStatus, xhr) {
                alert('구독이 취소되었습니다.');
                location.reload();
            })
            .fail(function(data, textStatus, errorThrown){
                alert("구독취소에 실패헀습니다.");
                console.log(data);
                console.log(textStatus);
                console.log(errorThrown);
            });
        }
    }else{
        alert("로그인 후 구독취소가 가능합니다.")
    }

}