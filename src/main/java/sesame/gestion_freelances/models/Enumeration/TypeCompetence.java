package sesame.gestion_freelances.models.Enumeration;

public enum TypeCompetence {
    Technique("Technique"),
    Linguistique("Linguistique");

    private final String label;

    TypeCompetence(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
