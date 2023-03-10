public class MiniFileManager {

    private String pwd;

    public MiniFileManager(String pwd) {
        this.pwd = pwd;
    }

    public void interaccion(String interaccion){
        String comando = interaccion.split(" ")[0];
        switch (comando){
            case "pwd" -> System.out.println(getPwd() + " > " + getPwd());
            case "cd" -> cd(accion(interaccion));
            case "ls" -> ls();
            case "ll" -> ll();
            case "mkdir" -> mkdir(accion(interaccion));
            case "rm" -> rm(accion(interaccion));
            case "mv" -> mv(accion(interaccion));
            case "help" -> help();
        }
    }

    private String accion(String interaccion) {
        return interaccion.substring(interaccion.indexOf(" "));
    }

    private void help(){
        System.out.println("""
                    • pwd:  Muestra cual es la carpeta actual.
                    • cd <DIR>: Cambia la carpeta actual a ‘DIR’. Con .. cambia a la carpeta superior.
                    • ls:   Muestra la lista de directorios y archivos de la carpeta actual (primero directorios,
                            luego archivos, ambos ordenados alfabéticamente).
                    • ll:   Como ls pero muestra también el tamaño y la fecha de última modificación.
                    • mkdir <DIR>:  Crea el directorio ‘DIR’ en la carpeta actual.
                    • rm <FILE>:    Borra ‘FILE’. Si es una carpeta, borrará primero sus archivos y luego la
                                    carpeta. Si tiene subcarpetas, las dejará intactas y mostrará un aviso al usuario.
                    • mv <FILE1> <FILE2>:   Mueve o renombra ‘FILE1’ a ‘FILE2’.
                    • help: Muestra una breve ayuda con los comandos disponibles.
                    • exit: Termina el programa.         
                """);
    }

    private void mv(String accion) {
        
    }

    private void rm(String accion) {
    }

    private void mkdir(String accion) {

    }

    private void ll() {

    }

    private void ls() {
    }

    private void cd(String accion) {

    }

    public String getPwd() {
        return pwd;
    }
}
