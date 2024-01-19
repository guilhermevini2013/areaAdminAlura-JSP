
function get(url,numberPage) {
   return $.ajax({
        type: "GET",
        url: url + numberPage.toString(),
        dataType: 'json',
        success: function (data) {
            if (data.length === 0) {
                numberPage -= 1;
                console.log(numberPage)
                return;
            }
            return data;
        },
        error: function () {
            console.log("Error in request.");
        }
    });
}
function showTableUnblocked(data) {
    $("#table-Unblocked tbody").empty();
    $.each(data, function (index, studentUnblock) {
        const newRow = $("<tr>");
        newRow.append("<td>" + studentUnblock.id + "</td>");
        newRow.append("<td>" + studentUnblock.name + "</td>");
        newRow.append("<td>" + studentUnblock.typeSignature + "</td>");
        newRow.append("<td><button class='icon-button block' data-student-id='" + studentUnblock.id + "'name='idStudent' value='"+studentUnblock.id+"'><ion-icon name='lock-closed-outline'></ion-icon></button></td>");
        $("#table-Unblocked tbody").append(newRow);
    });
}
function showTableBlocked(data) {
    $("#table-blocked tbody").empty();
    $.each(data, function (index, studentUnblock) {
        const newRow = $("<tr>");
        newRow.append("<td>" + studentUnblock.id + "</td>");
        newRow.append("<td>" + studentUnblock.name + "</td>");
        newRow.append("<td>" + studentUnblock.typeSignature + "</td>");
        newRow.append("<td>" + studentUnblock.timeBlocked + "</td>");
        newRow.append("<td><button class='icon-button' data-student-id='" + studentUnblock.id + "'name='idStudent' value='"+studentUnblock.id+"'><ion-icon name='lock-open-outline'></ion-icon></button></td>");
        $("#table-blocked tbody").append(newRow);
    });
}