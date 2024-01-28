let numberPageUnblocked = 0;
let urlUnblockedPage = "/admin/student?action=ListedStudent&page="
$("#before").click(async function () {
    if (numberPageUnblocked > 0) {
        numberPageUnblocked--;
        showTableUnblocked(await getPaginationStudent(urlUnblockedPage, numberPageUnblocked))
    }
});
$("#next").click(async function () {
    numberPageUnblocked++;
    const result = await getPaginationStudent(urlUnblockedPage, numberPageUnblocked);
    if (result.length === 0) {
        numberPageUnblocked -= 1;
    } else {
        showTableUnblocked(result)
    }
});
$('#searchUnblock').click(async function (){
    const valueFind = document.getElementById('formFindUnblock').value
    const result = await getFindStudent(urlFindStudentName,valueFind,"unblock");
    showTableUnblocked(result)
})
$(document).ready(function() {
    $(document).on('click', '#show-form-block', function() {
        const studentId = $(this).val();
        const formContent = `
                <div id="formulario-container">
                    <div id="formulario">
                        <h2>Enter the total hours to block</h2>
                        <form action="/admin/student?action=BlockStudent" method="post">
                            <input type="hidden" name="idStudent" value="${studentId}">
                            <label>Total hours:</label>
                            <input type="number" name="hours" required>
                            <button type="submit" class="button-send">Send</button>
                        </form>
                        <button id="close-form-block" class="button-cancel">Cancel</button>
                    </div>
                </div>
            `;
        $('#container-form-block').html(formContent);
    });
    $(document).on('click', '#close-form-block', function() {
        $('#container-form-block').empty();
    });
});



