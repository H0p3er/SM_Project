
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
    var totalPrice = 0;
    $(".input-number").each(function () {
        fieldName = $(this).attr('name');
        totalPrice += ($("span[data-field='" + fieldName + "']").attr('value') * $(this).val());
        console.log($("span[data-field='" + fieldName + "']").attr('value'));
    });
    $("#total_price").text(parseFloat(totalPrice).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".") + " VND");
    return totalPrice;
};
updatePrice();


for (var product of document.getElementsByClassName("add-cart")) {
    product.addEventListener("click", async  () => {
        await fetch("/home/user/cart?id="+ product.id, {
            method: "POST",
        });
        alert("Sản phẩm đã được thêm vào giỏ hàng!");
    })
}

/*function addOnlineOrderToDatabase() {
    var postData = "action=addBill&paymentMethod=Online";
    var submitUrl = "/user/bills";
    $.ajax({
        type: "POST",
        url: submitUrl,
        data: postData,
        success: function (response) {
            response = "ĐƠN HÀNG ĐƯỢC GHI NHẬN THÀNH CÔNG";
            alert(response);
        },
        error: function (xhr, status, error) {
            console.error("Đã xảy ra lỗi khi ghi nhận đơn hàng: " + xhr.responseText);
        }
    });
}
*/
$("#purchase").on("click", function () {
    if (updatePrice() == 0) { alert("Giỏ hàng trống! Vui lòng thêm sản phẩm") } else {
        if ($("#methodselection").find(":selected").val() == 0) {
            alert("Vui lòng chọn phương thức thanh toán!");
        }
        else if ($("#methodselection").find(":selected").val() == 2) {
            alert("Đơn hàng của bạn đã được ghi nhận! Vui lòng chờ xác nhận");
/*            addOnlineOrderToDatabase();*/
        } else {
            var postData = "amount=" + updatePrice() + "&bankCode=&language=vn";
            var submitUrl = "/home/vnpayajax";
            $.ajax({
                type: "POST",
                url: submitUrl,
                data: postData,
                dataType: 'JSON',
                success: function (x) {
                    if (x.code === '00') {
                        if (window.vnpay) {
                            vnpay.open({ width: 768, height: 600, url: x.data });
                        } else {
                            location.href = x.data;
                        }
                        return false;
                    } else {
                        alert(x.Message);
                    }
                }
            });
            return false;
        }
    }
});

$("button").on("click", function () {
    var target = $(this).attr('id');
    $("tr#row" + target).remove();
    updatePrice();
    fetch("/home/user/cart?id=" + target + "", {
        method: "DELETE",
    });
});