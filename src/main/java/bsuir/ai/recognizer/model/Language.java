package bsuir.ai.recognizer.model;

public enum Language {
    SPANISH("ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"),
    ITALIAN("AEIOUBCDFGHLMNPQRSTVZ"),
    ENGLISH("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    RUSSIAN("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");

    private String alphabet;

    Language(String alphabet) {
        this.alphabet = alphabet;
    }

    public static Language parse(String lang) {
        return Language.valueOf(lang.toUpperCase());
    }

    public String getAlphabet() {
        return alphabet;
    }
}
