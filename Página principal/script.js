// estilizando imagens
document.querySelectorAll('.caixa1 img').forEach(img => {
    img.addEventListener('mouseover', () => { // aqui ele ta adicionando um evento na classe .caixa1 img quando passa o mouse encima (mouseover)
        img.style.transform = 'scale(1.2)'; //transforma a imagem 20% maior quando passa o mouse encima
        img.style.transition = 'transform 0.3s ease';//suavizando o tempo que ela faz isso
    });

    img.addEventListener('mouseout', () => {
        img.style.transform = 'scale(1)'; //aqui ele volta a imagem pra escala normal quando o mouse sai (mouseout)
    });
});

document.querySelectorAll('.caixa2 img').forEach(img => {
    img.addEventListener('mouseover', () => {
        img.style.transform = 'scale(1.2)'; 
        img.style.transition = 'transform 0.3s ease';
    });

    img.addEventListener('mouseout', () => {
        img.style.transform = 'scale(1)'; 
    });
});

document.querySelectorAll('.botao-cadastro').forEach(img => {
    img.addEventListener('mouseover', () => {
        img.style.transform = 'scale(1.1)'; 
        img.style.transition = 'transform 0.3s ease';
    });

    img.addEventListener('mouseout', () => {
        img.style.transform = 'scale(1)'; 
    });
});

// side bar link-caixa1
document.addEventListener("DOMContentLoaded", function () { //As modificações no DOM podem ser feitas, como adicionar ou alterar elementos, adicionar eventos, etc
    let menuIcon = document.getElementById("menuIcon");
    let sidebar = document.getElementById("sidebar");
    let closeBtn = document.getElementById("closeBtn");

    menuIcon.addEventListener("click", function () {  // ele adiciona uma função quando o menuIcon eh clicado
        sidebar.style.left = "0"; //abrindo a side - mudando a estilização do sidebar left para 0
    });

    closeBtn.addEventListener("click", function () {// ele adiciona uma função quando o closeBtn eh clicado
        sidebar.style.left = "-300px";//fechando a side -  mudando a estilização do sidebar left para -300 - escondendo como no inicio
    });
});

