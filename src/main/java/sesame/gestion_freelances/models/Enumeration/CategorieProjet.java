package sesame.gestion_freelances.models.Enumeration;

public enum CategorieProjet {
    WEB_DEVELOPPEMENT("Web Développement"),
    APPLICATION_MOBILE("Application Mobile"),
    DESIGN_GRAPHIQUE("Design Graphique"),
    CONSULTATION("Consultation"),
    AUTRE("Autre");

    private final String label;

    CategorieProjet(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
