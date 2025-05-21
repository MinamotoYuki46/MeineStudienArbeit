function setupPasswordToggle(inputId, toggleId, iconId) {
    const input = document.getElementById(inputId);
    const toggle = document.getElementById(toggleId);
    const icon = document.getElementById(iconId);

    if (input && toggle && icon) {
        toggle.addEventListener('click', function () {
            const isPassword = input.type === 'password';
            input.type = isPassword ? 'text' : 'password';
            icon.classList.toggle('fa-eye');
            icon.classList.toggle('fa-eye-slash');
        });
    }
}

document.addEventListener('DOMContentLoaded', function () {
    setupPasswordToggle('password', 'togglePassword', 'eyeIcon');
    setupPasswordToggle('confirmPassword', 'toggleConfirm', 'eyeIconConfirm');
});
