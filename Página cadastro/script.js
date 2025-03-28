const form = document.getElementById('formulario-container');
        const popup = document.getElementById('popup');
        const caixa = document.getElementById('caixa');
        const fecharPopup = document.getElementById('fecha-popup');
        function doPost(url, body){
            console.log(body)
            let request = new XMLHttpRequest()
            request.open("POST", url, true)
            request.setRequestHeader("Content-type", "application/json")
            request.send(JSON.stringify(body))
        
            request.onload = function(){
                console.log(this.responseText)
            }
        
            return request.responseText
        }
        
        function cadastrarUsuario(){
            event.preventDefault()
            let url = "https://bytestore-eddr.onrender.com/usuario/"
        
            let nome = document.getElementById('name').value
            let email = document.getElementById('email').value
            let password = document.getElementById('password').value
        
            localStorage.setItem("nome", nome)
            localStorage.setItem("email", email)
            localStorage.setItem("password", password)
        
            body = {
                "name": localStorage.getItem("nome"),
                "email": localStorage.getItem("email"),
                "password": localStorage.getItem("password")
            }
            
            console.log(body)
            doPost(url, body)
            console.log(localStorage.getItem("email"))
        }

        form.addEventListener('submit', function(event) {
            event.preventDefault();

            
            if(cadastrarUsuario){
            // Exibir o popup
                popup.style.display = 'block';
                caixa.style.display = 'block';
            }
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