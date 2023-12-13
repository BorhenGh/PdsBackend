package sesame.gestion_freelances.models.Enumeration;

public enum Experience {
    ONE_TO_TWO_YEARS("1-2 Years"),
    TWO_TO_THREE_YEARS("2-3 Years"),
    THREE_TO_SIX_YEARS("3-6 Years"),
    SIX_MORE_YEARS("6-more");

    private final String label;

    Experience(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
