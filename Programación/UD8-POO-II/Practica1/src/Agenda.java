public class Agenda {
    private DatosPersona[] personas;
    private int numPersonas;

    public Agenda(int capacidad) {
        this.personas = new DatosPersona[capacidad];
        this.numPersonas = 0;
    }

    public void anyadePersona(String nombre, String tlf) {
        if (numPersonas == personas.length) {
            System.err.println("ERROR E-01 (AGENDA LLENA)");
        } else {
            this.personas[numPersonas] = new DatosPersona(nombre, tlf);
            numPersonas++;
        }
    }

    public DatosPersona[] busca(String nombre) {
        int count = 0;
        int numPersona = 0;
        DatosPersona[] personasBusca;
        for (DatosPersona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                count++;
            }
        }

        personasBusca = new DatosPersona[count];
        for (DatosPersona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                personasBusca[numPersona] = new DatosPersona(persona.getNombre(), persona.getTlf());
                numPersona++;
            }
        }
        return personasBusca;
    }

}
