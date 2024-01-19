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
    showTableBlocked(await get(urlBlockedPage,numberPageBlocked))
})