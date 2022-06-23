$(document).ready(function () {
    $("#buttonAddToCart").on("click", function (e) {
        addToCart();
    });
    $("#book").on("click", function (e) {
        showCart();
    });


 })


function showCart() {
    done(function (response) {
        $("#modalTitle").text("Корзина");
        $("#modalBody").text(response);
        $("#cartModal").modal();
        $("#modalTitle").text("Корзина");
        $("#modalBody").text("Тур забронирован ожидайте звонок сотрудника агентства");
        $("#cartModal").modal();
    });
}

function addToCart() {
    quantity = $("#quantity" + tourId).val();
    url = contextPath + "cart/add/" + tourId + "/" + quantity;
    $.ajax({
        type: "POST",
        url: url,
        headers: {
            'X-CSRF-TOKEN':csrfValue,
            'Content-Type':'application/json'
        },
        // beforeSend: function (xhr) {
        //     xhr.setRequestHeader(csrfHeaderName, csrfValue);
        // }
    }).done(function (response) {
      $("#modalTitle").text("Корзина");
      $("#modalBody").text(response);
      $("#cartModal").modal();

    }).fail(function (request) {
        $("#modalTitle").text("Корзина");
        $("#modalBody").text("Произошла ошибка при добавлении тура в корзину\nСтатус: "+request.status);
        $("#cartModal").modal();

    });

}
