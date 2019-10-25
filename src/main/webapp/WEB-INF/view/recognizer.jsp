<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Recognizer</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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

<form name="recognizeForm" id="recognizeForm"
      action="${pageContext.request.contextPath}/recognize" method="post"
      enctype="multipart/form-data">
    File to recognize:
    <input id="recognitionDoc" name="recognitionDoc" type="file"/>
    <button type="submit">
        Recognize!
    </button>
</form>

<script src="${pageContext.request.contextPath}/recognizeLogic.js"></script>
</body>
</html>