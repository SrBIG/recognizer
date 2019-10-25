package bsuir.ai.recognizer.model;

public enum Language {
    SPANISH,
    ITALIAN,
    ENGLISH,
    RUSSIAN;

    public static Language parse(String lang) {
        return Language.valueOf(lang.toUpperCase());
    }
}
