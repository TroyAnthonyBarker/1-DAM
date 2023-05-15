public class Covid {
    public static String covid(float bodyTemperature, boolean difficultyBreathing,
                               boolean diabetes, boolean cancer, boolean isPregnant,
                               boolean isOver60yearsold, boolean hepatic,
                               boolean kidnevDisease, boolean respiratoryDisease,
                               String provincia) {

        boolean hasFever = bodyTemperature >= 38;
        boolean meetsCriteria = difficultyBreathing || diabetes || cancer || isPregnant ||
                isOver60yearsold || hepatic || kidnevDisease || respiratoryDisease;

        if (hasFever && meetsCriteria) {
            return "/diagnostico/" + provincia;
        } else if (hasFever) {
            return "/cuarentena/";
        } else {
            return "/diagnostico_bueno/";
        }
    }
}