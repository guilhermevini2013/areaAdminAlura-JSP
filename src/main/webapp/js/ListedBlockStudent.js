let numberPageBlocked = 0;
let urlBlockedPage = "/admin/listStudentBlocked?page="
const formBlock = document.getElementById("formulario-container");
$('#before-block').click(async function () {
    if (numberPageBlocked > 0) {
        numberPageBlocked--;
        showTableBlocked(await getPaginationStudent(urlBlockedPage,numberPageBlocked))
    }
})
$('#next-block').click(async function () {
    numberPageBlocked++;
    const result = await getPaginationStudent(urlBlockedPage,numberPageBlocked);
    if (result.length === 0) {
        numberPageBlocked -= 1;
    } else {
        showTableBlocked(result)
    }
})