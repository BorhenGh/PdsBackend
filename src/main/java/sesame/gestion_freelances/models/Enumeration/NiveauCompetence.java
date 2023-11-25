package sesame.gestion_freelances.models.Enumeration;

public enum NiveauCompetence {
    Debutant("Debutant"),
    Moyen("Moyen"),
    Avancé("Avancé");
    private final String label;

    NiveauCompetence(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
