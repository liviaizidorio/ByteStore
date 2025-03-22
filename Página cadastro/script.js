const form = document.getElementById('formulario-container');
        const popup = document.getElementById('popup');
        const caixa = document.getElementById('caixa');
        const fecharPopup = document.getElementById('fecha-popup');

        form.addEventListener('submit', function(event) {
            event.preventDefault();

            // Obter os dados do formulário
            const name = document.getElementById('name').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            // Exibir o popup
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