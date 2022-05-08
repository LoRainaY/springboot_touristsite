/*
function viewTour(id) {
    $.ajax({
        url: "/" + id,
        success: function(response) {
            $('#viewUserHolder').html(response);
            $('#viewTour').modal();
            $('#viewTour').modal('open');
        }
    });
}*/
$(document).ready(function () {
    $('.card-deck .dBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        if (text == 'Show') {
            $.get(href, function (tour, status) {
                $('.myForm2 #id2').val(tour.id);
                $('.myForm2 #title2').val(tour.title);
                $('.myForm2 #description2').val(tour.description);
                $('.myForm2 #startTime2').val(tour.startTime);
                $('.myForm2 #endTime2').val(tour.endTime);
                $('.myForm2 #price2').val(tour.price);
            });

            $('.myForm2 #exampleModal2').modal();
        }
    });
});
