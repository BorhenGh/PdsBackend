package sesame.gestion_freelances.models.Enumeration;
public enum DomaineExpertise {
    DEVELOPPEMENT_LOGICIEL("Développement logiciel"),
    CONCEPTION_GRAPHIQUE("Conception graphique"),
    REDACTION_ET_EDITION("Rédaction et édition"),
    MARKETING_NUMERIQUE("Marketing numérique"),
    TRADUCTION_ET_LOCALISATION("Traduction et localisation"),
    CONSULTING_ET_GESTION_DE_PROJET("Consulting et gestion de projet"),
    VIDEO_ET_ANIMATION("Vidéo et animation"),
    CONCEPTION_DE_BASES_DE_DONNEES("Conception de bases de données"),
    SERVICES_INFORMATIQUES("Services informatiques"),
    SCIENCES_DES_DONNEES_ET_INTELLIGENCE_ARTIFICIELLE("Sciences des données et intelligence artificielle"),
    SEO("SEO");
    private final String libelle;

    DomaineExpertise(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}