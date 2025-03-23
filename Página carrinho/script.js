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