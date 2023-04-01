window.addEventListener("load", solve);

function solve() {
    let firstName = document.getElementById('first-name');
    let lastName = document.getElementById('last-name');
    let age = document.getElementById('age');
    let storyTitle = document.getElementById('story-title');
    let storyGenre = document.getElementById('genre');
    let storyText = document.getElementById('story');
    let publishBtn = document.getElementById('form-btn');
    let previewList = document.getElementById('preview-list');

    publishBtn.addEventListener('click', displayStory);

    function displayStory() {
        if (firstName.value !== '' && lastName.value !== '' && age.value !== '' && storyTitle.value !== '' && storyText.value !== '') {
            let li = document.createElement('li');
            li.className = 'story-info';
            previewList.appendChild(li);

            let article = document.createElement('article');
            li.appendChild(article);

            let heading = document.createElement('h4');
            heading.textContent = `Name: ${firstName.value} ${lastName.value}`;
            article.appendChild(heading);

            let agePreview = document.createElement('p');
            agePreview.textContent = `Age: ${age.value}`;
            article.appendChild(agePreview);

            let titlePreview = document.createElement('p');
            titlePreview.textContent = `Title: ${storyTitle.value}`;
            article.appendChild(titlePreview);

            let genrePreview = document.createElement('p');
            genrePreview.textContent = `Genre: ${storyGenre.value}`;
            article.appendChild(genrePreview);

            let textPreview = document.createElement('p');
            textPreview.textContent = storyText.value;
            article.appendChild(textPreview);

            let saveBtn = document.createElement('button');
            saveBtn.className = 'save-btn';
            saveBtn.textContent = 'Save Story'

            let editBtn = document.createElement('button')
            editBtn.className = 'edit-btn';
            editBtn.textContent = 'Edit Story';

            let deleteBtn = document.createElement('button')
            deleteBtn.className = 'delete-btn';
            deleteBtn.textContent = 'Delete Story';
            li.appendChild(saveBtn);
            li.appendChild(editBtn);
            li.appendChild(deleteBtn);


            firstName.value = '';
            lastName.value = '';
            age.value = '';
            storyTitle.value = '';
            storyGenre.value = '';
            storyText.value = '';
            publishBtn.disabled = true;

            saveBtn.addEventListener('click', saveStory);
            function saveStory() {
                document.getElementById('main').textContent = '';
                let h1 = document.createElement('h1');
                h1.textContent = 'Your scary story is saved!';
                document.getElementById('main').appendChild(h1);
            }

            editBtn.addEventListener('click', editStory);
            function editStory() {
                firstName.value = heading.textContent.split(': ')[1].split(' ')[0];
                lastName.value = heading.textContent.split(': ')[1].split(' ')[1];
                age.value = agePreview.textContent.split(': ')[1];
                storyTitle.value = titlePreview.textContent.split(': ')[1];
                storyGenre.value = genrePreview.textContent.split(': ')[1];
                storyText.value = textPreview.textContent;

                li.remove();
                publishBtn.disabled = false;

            }
            deleteBtn.addEventListener('click', deleteStory);

            function deleteStory() {
                li.remove();
                publishBtn.disabled = false;
            }
        }
    }

}
