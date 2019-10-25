var documentForm = document.forms.namedItem("documentForm");
documentForm.addEventListener('submit', function (e) {
    let url = this.getAttribute("action");
    let method = this.getAttribute("method").toUpperCase();
    let formData = new FormData(this);

    $.ajax({
        url: url,
        type: method,
        cache: false,
        contentType: false,
        processData: false,
        data: formData,
        success: function (response) {
            // TODO: add handling success
        },
        error: function (message) {
            // TODO: add handling error
        }
    });
    e.preventDefault();
}, false);

var recognizeForm = document.forms.namedItem("recognizeForm");
recognizeForm.addEventListener('submit', function (e) {
    let url = this.getAttribute("action");
    let method = this.getAttribute("method").toUpperCase();
    let formData = new FormData(this);

    $.ajax({
        url: url,
        type: method,
        cache: false,
        contentType: false,
        processData: false,
        data: formData,
        success: function (response) {
            // TODO: add handling success
        },
        error: function (message) {
            // TODO: add handling error
        }
    });
    e.preventDefault();
}, false);
