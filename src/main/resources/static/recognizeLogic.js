var documentForm = document.forms.namedItem("documentForm");
documentForm.addEventListener('submit', function (e) {
    let url = this.getAttribute("action");
    let method = this.getAttribute("method").toUpperCase();

    let doc = document.getElementById('document').files[1];
    let lang;
    let radios = document.getElementsByName('language');
    for (let i = 0, length = radios.length; i < length; i++) {
        if (radios[i].checked) {
            lang = radios[i].value;
            break;
        }
    }

    let formData = new FormData(this);
    // formData.append("lang", lang);
    // formData.append("doc", doc);

    $.ajax({
        url: url,
        type: method,
        cache: false,
        contentType: false,
        processData: false,
        data: formData,
        success: function () {
            // TODO: add handling success
        },
        error: function (message) {
            // TODO: add handling error
        }
    });
    e.preventDefault();
}, false);
