package sesame.gestion_freelances.models.Enumeration;

public enum NatureTravail {
    FULL_TIME("Temps plein"),
    PART_TIME("Temps partiel"),
    CONTRACT("Contrat"),
    FREELANCE("Freelance"),
    INTERNSHIP("Stage"),
    TEMPORARY("Temporaire"),
    OTHER("Autre");

    private final String label;

    NatureTravail(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
