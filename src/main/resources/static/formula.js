 //скрипт для отправки данных из формы с возможной формулой
const form = document.getElementById('forma_formuli');

async function retrieveFormValue(event) {
    event.preventDefault(); //когда метод на сервер не нужно отправлять

    const formula = form.querySelector('[name="formula"]');

    const value = {
    formula: formula.value
    };

    console.log('формула для отправки на сервер', value);

    let response = await fetch('http://localhost:8080//formula/rest/string', {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json;charset=utf-8'
    },
    body: formula.value
    });


    let content = await response.text(); //ответ сервера в виде строки
    console.log('Ответка от сервака', content);

    let vivodFormuli = document.querySelector('.card-body'); //поиск див куда вставлять ответ от сервака
    // listq.parentNode.getElementById('vivodFormuli'); //удаление
    vivodFormuli.innerHTML += '<h1>' + content + '</h1>'

}
form.addEventListener('submit', retrieveFormValue);

