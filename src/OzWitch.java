public enum  OzWitch {
    WEST("WEST description"),
    NORTH("NORTH description"),
    EAST("EAST description"),
    SOUTH("SOUTH description");

    private String descption;

    private OzWitch(String descption) {
        this.descption = descption;
    }

    public String getDescption() {
        return descption;
    }

    public static void main(String[] args) {
        for(OzWitch witch : OzWitch.values()) {
            System.out.println(witch + " : " + witch.getDescption());
        }
    }
}
