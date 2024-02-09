let listCourse = new Array();
function createVideoLesson() {
    const nameVideo = document.getElementById('nameLesson').value;
    let urlVideo = document.getElementById('archive').value;
    let idYT = getIdYT(urlVideo);
    const course = {
        nameLesson : nameVideo,
        archive : idYT
    }
    listCourse.push(course)
    insertCourseToView(listCourse)
    $('#container-form-create').empty();
}
function sendCourse(){
    let course = JSON.stringify(getCourse());
    $.ajax({
        type: "POST",
        url: "/admin/course?action=CourseForm",
        contentType: "application/json; charset=utf-8",
        data: course
    });
    listCourse.pop()
}
function getCourse() {
    let nameContent = document.getElementById('nameCourse').value;
    let description = document.getElementById('descriptionCourse').value;
    let certificateDTO = document.getElementById('certificateDTO').value;
    let comboBox = document.getElementById('combo-box').value;
    const certificate = {
        nameCertificate : certificateDTO
    };
    const formData = {
        nameContent: nameContent,
        description: description,
        certificateDTO: certificate,
        idCategory: comboBox,
        videoLessonDTOList : listCourse
    };
    return formData;
}
function insertCourseToView(listCourse) {
    $('.container-video').empty();
    listCourse.forEach(course => {
        let html = `
                <div class="video-Lesson">
                            <span>${course.nameLesson}</span>
                            <span>${course.archive}</span>
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
                            <button onclick="createVideoLesson()" class="button-send">Create</button>
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