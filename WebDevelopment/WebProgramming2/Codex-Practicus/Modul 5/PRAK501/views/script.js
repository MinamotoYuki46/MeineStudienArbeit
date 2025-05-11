document.addEventListener('DOMContentLoaded', function () {
    const searchInputs = document.querySelectorAll('.search-input');

    searchInputs.forEach(function (searchInput) {
        const table = searchInput.closest('.top-bar').nextElementSibling;
        const rows = table.querySelectorAll('tbody tr');

        searchInput.addEventListener('input', function () {
            const query = searchInput.value.toLowerCase();

            rows.forEach(function (row) {
                const cells = row.getElementsByTagName('td');
                let match = false;

                for (let cell of cells) {
                    if (cell.textContent.toLowerCase().includes(query)) {
                        match = true;
                        break;
                    }
                }

                if (match) {
                    row.style.visibility = 'visible';
                    row.style.position = 'static';
                } else {
                    row.style.visibility = 'hidden';
                    row.style.position = 'absolute';
                }
            });
        });
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const phoneCells = document.querySelectorAll('.phone-number');

    phoneCells.forEach(cell => {
        const digits = cell.textContent.replace(/\D/g, '');
        const formatted = digits.match(/.{1,4}/g);
        if (formatted) {
            cell.textContent = formatted.join('-');
        }
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const phoneInput = document.getElementById('phone');

    phoneInput.addEventListener('input', function (e) {
        let digits = phoneInput.value.replace(/\D/g, ''); 
        let formatted = digits.match(/.{1,4}/g); 

        if (formatted) {
            phoneInput.value = formatted.slice(0, 3).join('-');
        }
    });
});