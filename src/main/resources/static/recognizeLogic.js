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
            document.getElementById('result').innerHTML = "Document uploaded";
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
            let result = "";
            for (let i = 0; i < response.length; i++) {
                let recognizeResult = response[i];
                result += "Tested document:" + recognizeResult.testedDocument + '<br>';
                result += "Language:" + recognizeResult.language + '<br>';
                result += "Rank:" + recognizeResult.rank + '<br>';
                result += '<br>';
            }
            document.getElementById('result').innerHTML = result;
        },
        error: function (message) {
            // TODO: add handling error
        }
    });
    e.preventDefault();
}, false);
