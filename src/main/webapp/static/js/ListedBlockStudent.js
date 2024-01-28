let numberPageBlocked = 0;
let urlBlockedPage = "/admin/student?action=ListedStudentBlock&page="
const formBlock = document.getElementById("formulario-container");
$('#before-block').click(async function () {
    if (numberPageBlocked > 0) {
        numberPageBlocked--;
        showTableBlocked(await getPaginationStudent(urlBlockedPage,numberPageBlocked))
    }
});
$('#searchBlock').click(async function (){
    const valueFind = document.getElementById('formFindBlock').value
    const result = await getFindStudent(urlFindStudentName,valueFind,"block");
    showTableBlocked(result)
})
$('#next-block').click(async function () {
    numberPageBlocked++;
    const result = await getPaginationStudent(urlBlockedPage,numberPageBlocked);
    if (result.length === 0) {
        numberPageBlocked -= 1;
    } else {
        showTableBlocked(result)
    }
});