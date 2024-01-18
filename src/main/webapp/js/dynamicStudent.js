let numberPage = 0;
$("#before").click(function () {
    if (numberPage > 0) {
        numberPage--;
        $.ajax({
            type: "GET",
            url: "/admin/listStudentUnblocked?page=" + numberPage.toString(),
            dataType: 'json',
            success: function (data) {
                $("#sua-tabela-id tbody").empty();
                $.each(data, function (index, studentUnblock) {
                    var newRow = $("<tr>");
                    newRow.append("<td>" + studentUnblock.id + "</td>");
                    newRow.append("<td>" + studentUnblock.name + "</td>");
                    newRow.append("<td>" + studentUnblock.typeSignature + "</td>");
                    newRow.append("<td><button class='icon-button block' data-student-id='" + studentUnblock.id + "'><ion-icon name='lock-closed-outline'></ion-icon></button></td>");
                    $("#sua-tabela-id tbody").append(newRow);
                });
            },
            error: function () {
                console.log("Erro na requisição Ajax.");
            }
        });
    }
});
$("#next").click(function () {
    numberPage++;
    $.ajax({
        type: "GET",
        url: "/admin/listStudentUnblocked?page=" + numberPage.toString(),
        dataType: 'json',
        success: function (data) {
            $("#sua-tabela-id tbody").empty();
            $.each(data, function (index, studentUnblock) {
                var newRow = $("<tr>");
                newRow.append("<td>" + studentUnblock.id + "</td>");
                newRow.append("<td>" + studentUnblock.name + "</td>");
                newRow.append("<td>" + studentUnblock.typeSignature + "</td>");
                newRow.append("<td><button class='icon-button block' data-student-id='" + studentUnblock.id + "'><ion-icon name='lock-closed-outline'></ion-icon></button></td>");
                $("#sua-tabela-id tbody").append(newRow);
            });
        },
        error: function () {
            console.log("Erro na requisição Ajax.");
        }
    });
});
