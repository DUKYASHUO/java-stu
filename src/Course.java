public enum Course {
    ACOURSE(Fuck.A.class),
    BCOURSE(Fuck.B.class),
    CCOURSE(Fuck.C.class);

    private Fuck[] values;
    private Course(Class<? extends Fuck> kind) {
        values = kind.getEnumConstants();
    }
    public Fuck randomSelection() {
        return Enums.random(values);
    }
}
