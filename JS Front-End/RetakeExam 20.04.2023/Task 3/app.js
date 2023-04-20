function coursePlanner() {
    let URL = 'http://localhost:3030/jsonstore/tasks/';

    let listCourses = document.getElementById('list');
    let titleInput = document.getElementById('course-name');
    let typeInput = document.getElementById('course-type');
    let descriptionInput = document.getElementById('description');
    let teacherInput = document.getElementById('teacher-name');

    let addCourseBtn = document.getElementById('add-course');
    addCourseBtn.addEventListener("click", addCourse);

    let loadBtn = document.getElementById('load-course');
    loadBtn.addEventListener("click", loadCourses);

    function loadCourses(e) {
        if (e) {
            e.preventDefault();
        }

        listCourses.textContent = '';

        fetch(URL)
            .then((info) => info.json())
            .then((res) => {
                let courses = Object.values(res)

                for (const {title, type, description, teacher, _id} of courses) {
                    let divContainer = document.createElement('div');
                    divContainer.className = 'container';

                    let courseName = document.createElement('h2');
                    courseName.textContent = title;
                    divContainer.appendChild(courseName);

                    let teacherName = document.createElement('h3');
                    teacherName.textContent = teacher;
                    divContainer.appendChild(teacherName);

                    let courseType = document.createElement('h3');
                    courseType.textContent = type;
                    divContainer.appendChild(courseType);


                    let courseDescription = document.createElement('h4');
                    courseDescription.textContent = description;
                    divContainer.appendChild(courseDescription);

                    let editBtn = document.createElement('button')
                    editBtn.className = 'edit-btn';
                    editBtn.textContent = 'Edit Course';
                    divContainer.appendChild(editBtn);
                    editBtn.addEventListener("click", editInfo);

                    let finishBtn = document.createElement('button')
                    finishBtn.className = 'finish-btn';
                    finishBtn.textContent = 'Finish Course';
                    divContainer.appendChild(finishBtn);
                    finishBtn.addEventListener("click", finishCourse);

                    listCourses.appendChild(divContainer);

                    function editInfo(e) {
                        let parent = e.currentTarget.parentNode;
                        let editCourseBtn = document.getElementById('edit-course');
                        editCourseBtn.addEventListener("click", editCourse);
                        editCourseBtn.disabled = false;


                        titleInput.value = parent.children[0].textContent;
                        typeInput.value = parent.children[2].textContent;
                        descriptionInput.value = parent.children[3].textContent;
                        teacherInput.value = parent.children[1].textContent;

                        editBtn.disabled = true;
                        addCourseBtn.disabled = true;

                        function editCourse() {
                            let title = titleInput.value;
                            let type = typeInput.value;
                            let description = descriptionInput.value;
                            let teacher = teacherInput.value;

                            let headers = {
                                method: 'PATCH',
                                body: JSON.stringify({title, type, description, teacher})
                            }

                            fetch(`${URL}${_id}`, headers)
                                .then(() => {
                                    listCourses.textContent = '';
                                    loadCourses();
                                    titleInput.value = '';
                                    typeInput.value = '';
                                    descriptionInput.value = '';
                                    teacherInput.value = '';
                                    editCourseBtn.disabled = true;
                                })
                                .catch(err => console.error(err));
                        }
                    }
                    function finishCourse() {
                        if (e) {
                            e.preventDefault();
                        }

                        let headers = {
                            method: 'DELETE'
                        }

                        fetch(URL + _id, headers)
                            .then(() => loadCourses())
                            .catch(err => {
                                console.error(err)
                            });
                    }


                }

            })
            .catch(err => {
                console.error(err)
            });
   }

    function addCourse(e) {
        if (e) {
            e.preventDefault();

            let title = titleInput.value;
            let type = typeInput.value;
            let description = descriptionInput.value;
            let teacher = teacherInput.value;

            let headers = {
                method: 'POST',
                body: JSON.stringify({title, type, description, teacher})
            }

            fetch(URL, headers)
                .then(() => {
                    loadCourses();
                    listCourses.textContent = '';
                    titleInput.value = '';
                    typeInput.value = '';
                    descriptionInput.value = '';
                    teacherInput.value = '';
                })
                .catch(err => console.error(err));

        }
    }
}


coursePlanner();