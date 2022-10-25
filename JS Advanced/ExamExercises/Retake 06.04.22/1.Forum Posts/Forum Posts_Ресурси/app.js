window.addEventListener("load", solve);

function solve() {
    let input = {
        title: document.getElementById('post-title'),
        category: document.getElementById('post-category'),
        content: document.getElementById('post-content')
    };
    let list = {
        review: document.getElementById('review-list'),
        published: document.getElementById('published-list')
    };

    document.getElementById('publish-btn').addEventListener('click', publish);
    document.getElementById('clear-btn').addEventListener('click', clear);

    function publish(event) {
        event.preventDefault();
        let title = input.title.value;
        let category = input.category.value;
        let content = input.content.value;

        if (title === '' || category === '' || content === '') {
            return;
        }

        let li = document.createElement('li');
        li.className = 'rpost';
        li.innerHTML = `<article>
            <h4>${title}</h4>
            <p>Category: ${category}</p>
            <p>Content: ${content}</p>
            </article>
            <button class="action-btn edit">Edit</button>
            <button class="action-btn approve">Approve</button>`;

        let editBtn = li.querySelector('.edit');
        let approveBtn = li.querySelector('.approve');
        editBtn.addEventListener('click', edit)
        approveBtn.addEventListener('click', approve);

        list.review.appendChild(li);

        input.title.value = '';
        input.category.value = '';
        input.content.value = '';

        function edit() {
            input.title.value = title;
            input.category.value = category;
            input.content.value = content;

            li.remove();
        }

        function approve() {
            list.published.appendChild(li);
            editBtn.remove();
            approveBtn.remove();
        }

    }

    function clear() {
        list.published.innerHTML = '';
    }

}
