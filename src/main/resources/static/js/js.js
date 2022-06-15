$(document).ready(function () {
    $('.nBtn, .card-deck .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        if (text=='Редактировать тур') {
            $.get(href, function (tour, status) {
                $('.myForm #id').val(tour.id);
                $('.myForm #title').val(tour.title);
                $('.myForm #description').val(tour.description);
                $('.myForm #startTime').val(tour.startTime);
                $('.myForm #endTime').val(tour.endTime);
                $('.myForm #price').val(tour.price);
            });

            $('.myForm #exampleModal').modal();
        } else {

            $('.myForm #id').val('');
            $('.myForm #title').val('');
            $('.myForm #description').val('');
            $('.myForm #startTime').val('');
            $('.myForm #endTime').val('');
            $('.myForm #price').val('');
            $('.myForm #exampleModal').modal();
        }
    });
});


