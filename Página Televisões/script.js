// side bar 
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

//Carrossel produtos
const carrossel = document.querySelector(".carrossel");
const antesBtn = document.getElementById("antes");
const nextBtn = document.getElementById("next");
const totalItems = document.querySelectorAll(".carrossel-item").length;
let index = 0; //armazena a posição inicial do carrossel e incrementa e descrementa esse valor

function mudaCarrossel() {
    const tamanhoItem = document.querySelector(".carrossel-item").clientWidth + 20; //clientWidth= obtém a largura do item (excluindo margens externas) - + 20 = adiciona um espaço entre os itens
    carrossel.style.transform = `translateX(${-index * tamanhoItem}px)`; //translateX(valor) = move o carrossel horizontalmente.
    // -index * tamanhoItem = desloca os itens para a esquerda.
    // index indica a posição atual, então:
    // index = 0 → Não move nada (translateX(0px))
    // index = 1 → Move 1 item para a esquerda (translateX(-tamanhoItem px))
    // index = 2 → Move 2 itens para a esquerda (translateX(-2 * tamanhoItem px))
}

nextBtn.addEventListener("click", () => {
if (index < totalItems - 3) { // Exibir no máximo 3 por vez
    index++; // Avança para o próximo conjunto de itens
    mudaCarrossel(); // Atualiza a posição do carrossel
}
});


antesBtn.addEventListener("click", () => {
if (index > 0) { // Só volta se já estiver avançado
    index--; // Volta para o conjunto anterior de itens 
    mudaCarrossel(); // Atualiza a posição do carrossel 
}
});

//Estilizando imagens
document.querySelectorAll('.carrossel-item').forEach(img => {
    img.addEventListener('mouseover', () => {
        img.style.transform = 'scale(1.05)'; 
        img.style.transition = 'transform 0.3s ease';
    });

    img.addEventListener('mouseout', () => {
        img.style.transform = 'scale(1)'; 
    });
});
