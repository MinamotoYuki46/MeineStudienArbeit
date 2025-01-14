document.addEventListener('DOMContentLoaded', function() {
    var today = new Date().toISOString().slice(0, 10);
    document.getElementById('date_go').value = today;
});

function swapInputs() {
    var input1Value = document.getElementById("departure").value;
    var input2Value = document.getElementById("destination").value;

    document.getElementById("departure").value = input2Value;
    document.getElementById("destination").value = input1Value;
}

function handleFormSubmit(event) {
    var feedbackMessage = document.getElementById("message").value;
    alert("Terima kasih banyak atas masukannya\n\n" + feedbackMessage);
}