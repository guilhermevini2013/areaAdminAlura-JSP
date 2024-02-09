let listCourse = new Array();
function createCourse() {
    const nameVideo = document.getElementById('nameLesson').value;
    let urlVideo = document.getElementById('archive').value;
    let idYT = getIdYT(urlVideo);
    const course = {
        nameVideo : nameVideo,
        idYT : idYT
    }
    listCourse.push(course)
    insertCourseToView(listCourse)
    $('#container-form-create').empty();
}

function insertCourseToView(listCourse) {
    listCourse.forEach(course => {
        let html = `
                <div class="video-Lesson">
                            <span>${course.nameVideo}</span>
                            <span>${course.idYT}</span>
                            <a href="">Remove</a>
                        </div>
            `;
        $('.container-video').append(html);
    })
}

function getIdYT(url) {
    let subsUrl = url.split("=");
    return subsUrl[1];
}

$(document).ready(function () {
    $(document).on('click', '#show-form-create', function () {
        const formContent = `
                <div id="formulario-container">
                    <div id="formulario">
                        <h2>Complete the information</h2>
                            <label>Name video lesson:</label>
                            <input type="text" id="nameLesson" required>
                            <label>Url video:</label>
                            <input type="text" id="archive" required>
                            <button onclick="createCourse()" class="button-send">Create</button>
                        <button id="close-form-create" class="button-cancel">Cancel</button>
                    </div>
                </div>
            `;
        $('#container-form-create').html(formContent);
    });
    $(document).on('click', '#close-form-create', function () {
        $('#container-form-create').empty();
    });
});