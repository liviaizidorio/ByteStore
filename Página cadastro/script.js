function cadastrarUsuario(event) {
    event.preventDefault();
    console.log("cadastrarUsuario foi chamado!");

    const url = "https://bytestore-eddr.onrender.com/usuario/post";
    const nome = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    const body = {
        name: nome,
        email: email,
        senha: senha
    };

    console.log("Corpo da requisição:", body);

    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    })
    .then(response => {
        console.log("Status:", response.status);
        return response.text(); // ou response.json() se o backend responder com JSON
    })
    .then(data => {
        console.log("Resposta:", data);
        console.log("Requisição POST bem-sucedida!");
        exibir();
    })
    .catch(error => {
        console.error("Erro na requisição POST:", error);
    });
    app.use((req, res, next) => {
        res.header('Access-Control-Allow-Origin', '*'); // ou especifique seu domínio
        res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
        next();
      });
      
}


// Exibir o popup
function exibir(){
    event.preventDefault();
    document.getElementById('popup').style.display = 'block';
    document.getElementById('caixa').style.display = 'block';
}

function fecharPopup(){
    document.getElementById('popup').style.display = 'none';
    document.getElementById('caixa').style.display = 'none';
    window.location.href = "/Página principal/index.html";//leva para a página principal
}

// Fechar o popup ao clicar fora dele
function fora(){
    document.getElementById('popup').style.display = 'none';
    document.getElementById('caixa').style.display = 'none';
    window.location.href = "/Página principal/index.html";//leva para a página principal
}