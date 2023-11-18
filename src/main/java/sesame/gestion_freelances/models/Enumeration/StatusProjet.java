package sesame.gestion_freelances.models.Enumeration;

public enum StatusProjet {
    EN_COURS("En Cours"),
    TERMINE("Terminé"),
    EN_ATTENTE("En Attente");
    private final String label;

    StatusProjet(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
