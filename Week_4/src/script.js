function addRoutine(){
    var tr=document.createElement('tr');
    var td1=tr.appendChild(document.createElement('td'));
    var td2=tr.appendChild(document.createElement('td'));
    var td3=tr.appendChild(document.createElement('td'));


    document.getElementById('table').appendChild(tr);
}


function homePage(){
    const home=document.querySelector('.home');
    const routine=document.querySelector('.routine');
    home.classList.add('active');
    routine.classList.remove('active');
}

function routinePage(){
    const home=document.querySelector('.home');
    const routine=document.querySelector('.routine');
    routine.classList.add('active');
    home.classList.remove('active');
}

function trackPage(){

}

function createPage(){

}
