$(document).ready(function () {
    $('.nBtn, .eBtn').on('click', function (event) {
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
                $('.myForm #firstDayDescription').val(tour.firstDayDescription);
                $('.myForm #secondDayDescription').val(tour.secondDayDescription);
                $('.myForm #thirdDayDescription').val(tour.thirdDayDescription);
                $('.myForm #fourthDayDescription').val(tour.fourthDayDescription);
                $('.myForm #fifthDayDescription').val(tour.fifthDayDescription);
                $('.myForm #includeInPrice').val(tour.includeInPrice);
                $('.myForm #additionally').val(tour.additionally);
            });

            $('.myForm #exampleModal').modal();
        } else {

            $('.myForm #id').val('');
            $('.myForm #title').val('');
            $('.myForm #description').val('');
            $('.myForm #startTime').val('');
            $('.myForm #endTime').val('');
            $('.myForm #price').val('');
            $('.myForm #firstDayDescription').val('');
            $('.myForm #secondDayDescription').val('');
            $('.myForm #thirdDayDescription').val('');
            $('.myForm #fourthDayDescription').val('');
            $('.myForm #fifthDayDescription').val('');
            $('.myForm #includeInPrice').val('');
            $('.myForm #additionally').val('');
            $('.myForm #exampleModal').modal();
        }
    });
    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#modalBeforeDelete #delRef').attr('href', href);
        $('#modalBeforeDelete').modal();
    });
    $('.uBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        if (text=='Редактировать') {
            $.get(href, function (user,role, status) {
                $('.userForm #idU').val(user.id);
                $('.userForm #lastname').val(user.lastname);
                $('.userForm #firstname').val(user.firstname);
                $('.userForm #patronymic').val(user.patronymic);
                $('.userForm #phone').val(user.phone);
                $('.userForm #email').val(user.email);
                $('.userForm #bonus').val(user.getBonus);
                $('.userForm #id').val(role.id);
                $('.userForm #role').val(role.role);
                $('.userForm #active').val(user.active);

                $('.userForm #password').val(user.password);
            });

            $('.userForm #exampleModal2').modal();
        } else {

            $('.userForm #idU').val('');
            $('.userForm #lastname').val('');
            $('.userForm #firstname').val('');
            $('.userForm #patronymic').val('');
            $('.userForm #phone').val('');
            $('.userForm #email').val('');
            $('.userForm #password').val('');
            $('.userForm #bonus').val('');
            $('.userForm #active').val('');
            $('.userForm #exampleModal2').modal();
        }
    });
});


