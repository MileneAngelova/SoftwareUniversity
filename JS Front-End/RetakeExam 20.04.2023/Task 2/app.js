window.addEventListener("load", solve);

function solve() {
    let titleInput = document.getElementById('task-title');
    let categoryInput = document.getElementById('task-category');
    let contentInput = document.getElementById('task-content');
    let publishBtn = document.getElementById('publish-btn');
    publishBtn.addEventListener("click", publish);

    let reviewList = document.getElementById('review-list');
    let publishedList = document.getElementById('published-list');
    function publish(e) {
        if (e) {
            e.preventDefault();
        }

        if (titleInput.value !== '' && categoryInput.value !== '' && contentInput.value !== '') {
            let li = document.createElement('li');
            li.className = 'rpost';
            reviewList.appendChild(li);

            let article = document.createElement('article');
            li.appendChild(article);

            let h4 = document.createElement('h4');
            h4.textContent = `${titleInput.value}`;
            article.appendChild(h4);

            let categoryPreview = document.createElement('p');
            categoryPreview.textContent = `Category: ${categoryInput.value}`;
            article.appendChild(categoryPreview);

            let contentPreview = document.createElement('p');
            contentPreview.textContent = `Content: ${contentInput.value}`;
            article.appendChild(contentPreview);

            let editBtn = document.createElement('button')
            editBtn.className = 'action-btn edit';
            editBtn.textContent = 'Edit';

            let postBtn = document.createElement('button')
            postBtn.className = 'action-btn post';
            postBtn.textContent = 'Post';

            li.appendChild(editBtn);
            li.appendChild(postBtn);

            titleInput.value = '';
            categoryInput.value = '';
            contentInput.value = '';

            editBtn.addEventListener('click', editPost);
            postBtn.addEventListener("click", publishPost)
            function editPost() {
                titleInput.value = h4.textContent;
                categoryInput.value = categoryPreview.textContent.split(': ')[1];
                contentInput.value = contentPreview.textContent.split(': ')[1];

                reviewList.removeChild(li);
                // publishBtn.disabled = false;
            }

            function publishPost() {
                publishedList.appendChild(li);
                li.removeChild(editBtn);
                li.removeChild(postBtn);

                reviewList.removeChild(li);
            }
        }
    }
}