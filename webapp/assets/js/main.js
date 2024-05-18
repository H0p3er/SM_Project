document.addEventListener("DOMContentLoaded", function () {
    $().ready(function () {

        function fetchData() {
            $.ajax({

                url: "/home/product/",
                method: "GET",
                dataType: "json",
                success: function (response) {
                    let data = response;

                }
            });

        }

        // Call fetchData() initially to load data on page load
        fetchData();

        // Call fetchData() every 30 seconds to refresh content
        setInterval(fetchData, 300000); // 30 seconds
    });
});



$('.btn-number').click(function (e) {
    e.preventDefault();

    fieldName = $(this).attr('data-field');
    type = $(this).attr('data-type');
    var input = $("input[name='" + fieldName + "']");
    var currentVal = parseInt(input.val());

    if (!isNaN(currentVal)) {
        if (type == 'minus') {

            if (currentVal > input.attr('min')) {
                input.val(currentVal - 1).change();
                updatePrice();
            }
            if (parseInt(input.val()) == input.attr('min')) {
                $(this).attr('disabled', true);
            }

        } else if (type == 'plus') {

            if (currentVal < input.attr('max')) {
                input.val(currentVal + 1).change();
                updatePrice();
            }
            if (parseInt(input.val()) == input.attr('max')) {
                $(this).attr('disabled', true);
            }

        }
    } else {
        input.val(0);
    }
});
$('.input-number').focusin(function () {
    $(this).data('oldValue', $(this).val());
});
$('.input-number').change(function () {

    minValue = parseInt($(this).attr('min'));
    maxValue = parseInt($(this).attr('max'));
    valueCurrent = parseInt($(this).val());

    atrname = $(this).attr('name');
    if (valueCurrent >= minValue) {
        $(".btn-number[data-type='minus'][data-field='" + atrname + "']").removeAttr('disabled')
    } else {
        alert('Sorry, the minimum value was reached');
        $(this).val($(this).data('oldValue'));
    }
    if (valueCurrent <= maxValue) {
        $(".btn-number[data-type='plus'][data-field='" + atrname + "']").removeAttr('disabled')
    } else {
        alert('Sorry, the maximum value was reached');
        $(this).val($(this).data('oldValue'));
    }


});
function updatePrice() {
    var totalPrice =0;
    $(".input-number").each(function() {
        fieldName = $(this).attr('name');
        totalPrice +=  (parseInt($("span[data-field='" + fieldName + "']").attr('value'))*$(this).val());
        console.log($("span[data-field='" + fieldName + "']").attr('value'));
    });
    console.log(totalPrice)
    $("#total-price").text(totalPrice);
};
updatePrice();