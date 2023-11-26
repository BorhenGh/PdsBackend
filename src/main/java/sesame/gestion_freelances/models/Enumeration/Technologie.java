package sesame.gestion_freelances.models.Enumeration;

public enum Technologie {
    PHOTOSHOP("Photoshop"),
    ORACLE("Oracle"),
    JAVA("Java"),
    C_PLUS_PLUS("C++"),
    PYTHON("Python"),
    JAVASCRIPT("JavaScript"),
    HTML_CSS("HTML/CSS"),
    REACT("React"),
    ANGULAR("Angular"),
    SPRING("Spring"),
    NODE_JS("Node.js"),
    ANDROID("Android"),
    IOS("iOS"),
    DJANGO("Django"),
    FLASK("Flask"),
    RUBY("Ruby"),
    PHP("PHP"),
    SEO("SEO");

    private final String libelle;

    Technologie(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
