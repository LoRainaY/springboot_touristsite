$(document).ready(function (){
    $(".minusButton").on("click",function (evt){
        evt.preventDefault();
        tourId=$(this).attr("pid");
        qtyInput=$("#quantity"+tourId);

        newQty=parseInt(qtyInput.val())-1;
        if(newQty>0)
            qtyInput.val(newQty);
    });
    $(".plusButton").on("click",function (evt){
        evt.preventDefault();
        tourId=$(this).attr("pid");
        qtyInput=$("#quantity"+tourId);

        newQty=parseInt(qtyInput.val())+1;
        if(newQty>0)
            qtyInput.val(newQty);
    });
});