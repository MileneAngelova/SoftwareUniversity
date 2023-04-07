function attachEvents() {
    let URL = 'http://localhost:3030/jsonstore/tasks/';
    let addBtn = document.getElementById('add-button');
    let loadBtn = document.getElementById('load-button');
    let newTask = document.getElementById('title');
    let tasksList = document.getElementById('todo-list');

    addBtn.addEventListener("click", addTask);
    loadBtn.addEventListener("click", loadAllTasks);

    function loadAllTasks(e) {
        // e?.preventDefault();
        if (e) {
            e.preventDefault();
        }
        tasksList.textContent = '';

        fetch(URL)
            .then((info) => info.json())
            .then((tasks) => {
                let task = Object.values(tasks)

                for (const {_id, name} of task) {

                    let li = document.createElement('li');
                    let span = document.createElement('span');
                    let removeBtn = document.createElement('button');
                    let editBtn = document.createElement('button');

                    li.id = _id;
                    span.textContent = name;
                    removeBtn.textContent = 'Remove';
                    editBtn.textContent = 'Edit';
                    li.appendChild(span);
                    li.appendChild(removeBtn);
                    li.appendChild(editBtn);
                    tasksList.appendChild(li);
                    editBtn.addEventListener("click", editTask);
                    removeBtn.addEventListener("click", removeTask);
                }


            })
            .catch(err => console.error(err));

    }

    function editTask(e) {
        let parentLi = e.currentTarget.parentNode;
        let [span, removeBtn, editBtn] = Array.from(parentLi.children);
        let inputToEdit = document.createElement('input');
        let submitBtn = document.createElement("button");
        inputToEdit.value = span.textContent;
        submitBtn.textContent = 'Submit';
        parentLi.replaceChild(submitBtn, editBtn);
        parentLi.replaceChild(inputToEdit, span);
        submitBtn.addEventListener("click", renewInfo);
    }

    function renewInfo(e) {
        e.preventDefault();
        let parentLi = e.currentTarget.parentNode;
        let id = parentLi.id;
        let [input] = Array.from(parentLi.children);
        let headers = {
            method: 'PATCH',
            body: JSON.stringify({name: input.value})
        }
        fetch(`${URL}${id}`, headers)
            .then(() => loadAllTasks())
            .catch((err) => {
                console.error(err);
            })
    }

    function addTask(e) {
        e.preventDefault();

        let name = newTask.value;
        let headers = {
            method: 'POST',
            body: JSON.stringify({name})
        }

        fetch(URL, headers)
            .then(() => {
                loadAllTasks();
                newTask.value = '';
            })
            .catch((error) => {
                console.error(error);
            })

    }

    function removeTask(e) {
        const id = e.currentTarget.parentNode.id;
        let headers = {
            method: 'DELETE'
        };

        fetch(`${URL}${id}`, headers)
            .then(() => loadAllTasks())
            .catch(err => {
                console.error(err);
            })
    }


}

attachEvents();
