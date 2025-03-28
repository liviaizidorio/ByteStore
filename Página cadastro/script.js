const form = document.getElementById('formulario-container');
        const popup = document.getElementById('popup');
        const caixa = document.getElementById('caixa');
        const fecharPopup = document.getElementById('fecha-popup');
        const cadastro=document.getElementById('cadastro');

        function doPost(url, body) {
            console.log("Enviando:", body); // Debug: Mostra o corpo da requisição
            let request = new XMLHttpRequest();
            request.open("POST", url, true);
            request.setRequestHeader("Content-type", "application/json");
        
            request.onload = function() {
                console.log("Status:", this.status); // Debug: Mostra o status da resposta
                console.log("Resposta:", this.responseText); // Debug: Mostra a resposta completa
                if (this.status >= 200 && this.status < 300) { // Sucesso!
                    console.log("Requisição POST bem-sucedida!");
                } else {
                    console.error("Erro na requisição POST. Status:", this.status);
                }
            };
        
            request.onerror = function() {
                console.error("Erro de rede ao fazer a requisição.");
            };
        
            request.send(JSON.stringify(body));
        }
        
        function cadastrarUsuario() {
            event.preventDefault();
            let url = "https://bytestore-eddr.onrender.com/usuario/";
        
            let nome = document.getElementById('name').value;
            let email = document.getElementById('email').value;
            let senha = document.getElementById('senha').value;
        
            // Não precisa usar localStorage para isso, a menos que você precise dos dados depois
            let body = {
                "name": nome,
                "email": email,
                "senha": senha
            };
        
            console.log("Corpo da requisição:", body); // Debug
            doPost(url, body);
        }
            // Exibir o popup
            cadastro.addEventListener('click', function(event) {
                event.preventDefault();
                popup.style.display = 'block';
                caixa.style.display = 'block';
            });

        fecharPopup.addEventListener('click', function() {
            popup.style.display = 'none';
            caixa.style.display = 'none';
            window.location.href = "/Página principal/index.html";//leva para a página principal
        });

        // Fechar o popup ao clicar fora dele
        caixa.addEventListener('click', function() {
            popup.style.display = 'none';
            caixa.style.display = 'none';
            window.location.href = "/Página principal/index.html";//leva para a página principal
        });