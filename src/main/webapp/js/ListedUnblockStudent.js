let numberPage = 0;
let urlUnblockedPage = "/admin/listStudentUnblocked?page="
$("#before").click(function () {
    if (numberPage > 0) {
        numberPage--;
        get(urlUnblockedPage)
    }
});
$("#next").click(function () {
    numberPage++;
    get(urlUnblockedPage)
});

function get(url) {
    $.ajax({
        type: "GET",
        url: url + numberPage.toString(),
        dataType: 'json',
        success: function (data) {
            if (data.length === 0) {
                console.log("A lista está vazia.");
                numberPage = numberPage - 1;
                return;
            }
            showTableUnblocked(data)
        },
        error: function () {
            console.log("Error in request.");
        }
    });
}

function showTableUnblocked(data) {
    $("#table-Unblocked tbody").empty();
    $.each(data, function (index, studentUnblock) {
        var newRow = $("<tr>");
        newRow.append("<td>" + studentUnblock.id + "</td>");
        newRow.append("<td>" + studentUnblock.name + "</td>");
        newRow.append("<td>" + studentUnblock.typeSignature + "</td>");
        newRow.append("<td><button class='icon-button block' data-student-id='" + studentUnblock.id + "'><ion-icon name='lock-closed-outline'></ion-icon></button></td>");
        $("#table-Unblocked tbody").append(newRow);
    });
}
