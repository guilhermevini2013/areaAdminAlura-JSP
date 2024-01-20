let numberPageBlocked = 0;
let urlBlockedPage = "/admin/listStudentBlocked?page="
$('#before-block').click(async function () {
    if (numberPageBlocked > 0) {
        numberPageBlocked--;
        showTableBlocked(await get(urlBlockedPage,numberPageBlocked))
    }
})
$('#next-block').click(async function () {
    numberPageBlocked++;
    const result = await get(urlBlockedPage,numberPageBlocked);
    if (result.length === 0) {
        numberPageBlocked -= 1;
    } else {
        showTableBlocked(result)
    }
})