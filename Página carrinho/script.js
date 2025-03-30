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

const buyAllButton = document.querySelector('.btn');
        const popup = document.getElementById('popup');
        const caixa = document.getElementById('caixa');
        const closePopupButton = document.getElementById('close-popup');

        buyAllButton.addEventListener('click', function() {
            popup.style.display = 'block';
            caixa.style.display = 'block';
        });

        closePopupButton.addEventListener('click', function() {
            popup.style.display = 'none';
            caixa.style.display = 'none';
        });

        caixa.addEventListener('click', function() {
            popup.style.display = 'none';
            caixa.style.display = 'none';
        });


// Listar todos os produtos no carrinho que estão ativos

async function listarAtivos(url) {
    try {
        const resposta = await fetch(url);
        const dados = await resposta.json();

        const ativos = dados.filter(item => item.status === "ativa");

        const tbody = document.querySelector("#tabela tbody");
        tbody.innerHTML = ""; // Limpa a tabela antes de adicionar os itens

        ativos.forEach(item => {
            const linha = document.createElement("div");
            linha.innerHTML = `<img>${item.url_imagem}</img><h3>${item.nome}</h3><div class="cart-item-preco">${item.preco}</div>`;
            tbody.appendChild(linha);
        });
    } catch (erro) {
        console.error("Erro ao buscar os dados:", erro);
    }
}

// Chamada do método com a URL da API
listarAtivos("https://bytestore-eddr.onrender.com/carrinho/{idCarrinho}");
