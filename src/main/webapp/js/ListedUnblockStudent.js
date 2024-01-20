let numberPageUnblocked = 0;
let urlUnblockedPage = "/admin/listStudentUnblocked?page="
$("#before").click(async function () {
    if (numberPageUnblocked > 0) {
        numberPageUnblocked--;
        showTableUnblocked(await get(urlUnblockedPage, numberPageUnblocked))
    }
});
$("#next").click(async function () {
    numberPageUnblocked++;
    const result = await get(urlUnblockedPage, numberPageUnblocked);
    if (result.length === 0) {
        numberPageUnblocked -= 1;
    } else {
        showTableUnblocked(result)
    }
});



