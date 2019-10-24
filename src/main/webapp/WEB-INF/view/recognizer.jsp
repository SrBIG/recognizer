<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Stemmer</title>
</head>
<body>
<h1>Hello! I'm Recognizer!</h1>

<form name="documentForm" id="documentForm"
      action="${pageContext.request.contextPath}/document/upload" method="post"
      enctype="multipart/form-data">
    File to upload:
    <input id="document" name="document" type="file"/>

    <label for="italianLang">Italian</label>
    <input type="radio" name="language" id="italianLang" value="Italian" checked>
    <label for="spanishLang">Spanish</label>
    <input type="radio" name="language" id="spanishLang" value="Spanish">

    <button type="submit">
        Upload
    </button>
</form>

<script>var ctx = "${pageContext.servletContext.contextPath}"</script>
<script src="${pageContext.request.contextPath}/recognizeLogic.js"></script>
</body>
</html>