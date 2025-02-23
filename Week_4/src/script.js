function addRoutine(){
    var tr=document.createElement('tr');
    var td1=tr.appendChild(document.createElement('td'));
    var td2=tr.appendChild(document.createElement('td'));
    var td3=tr.appendChild(document.createElement('td'));


    document.getElementById('table').appendChild(tr);
}

function fileReader(){
    const fs = require('fs');
    fs.readFile('Input.txt', (err, data) => {
    if (err) throw err;

    console.log(data.toString());
    });
}

function homePage(){
    const home=document.querySelector('.home');
    const routine=document.querySelector('.routine');
    const create=document.querySelector('.create');
    home.classList.add('active');
    routine.classList.remove('active');
    create.classList.remove('active');
}

function routinePage(){
    //fileReader();
    const home=document.querySelector('.home');
    const routine=document.querySelector('.routine');
    const create=document.querySelector('.create');
    routine.classList.add('active');
    home.classList.remove('active');
    create.classList.remove('active');
}

function trackPage(){

}

function createPage(){
    const home=document.querySelector('.home');
    const routine=document.querySelector('.routine');
    const create=document.querySelector('.create');
    routine.classList.remove('active');
    home.classList.remove('active');
    create.classList.add('active');
}
