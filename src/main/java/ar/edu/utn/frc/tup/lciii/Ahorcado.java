package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

public class Ahorcado {

    private Scanner scanner;
    private Jugador jugador;
    private Integer puntajePartida;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Integer getPuntajePartida() {
        return puntajePartida;
    }

    public void setPuntajePartida(Integer puntajePartida) {
        this.puntajePartida = puntajePartida;
    }

    public Ahorcado() {
        this.scanner = new Scanner(System.in);
        this.jugador = null;
        this.puntajePartida = 0;
    }

    public void bienvenida() {
        System.out.println("Bienvenido al juego del ahorcado");
    }

    /**
     * Este metodo gestiona todo el proceso de pedir los datos al jugador
     * y retornarlos al programa principal para poder Jugar
     *
     */
    public void cargarJugador() {
        System.out.println("Ingrese nombre del jugador");
        Jugador jugador1 = new Jugador(scanner.nextLine());
    }

    /**
     * Este metodo gestiona todo el proceso de pedir una letra al jugador,
     * validar que la entrada por panatañña sea una correcta y retornar
     * dicha entrada como un Character de Java.
     * @return el caracter ingresado por usuario
     */
    public Character pedirLetra() {
        /*
            Escribir el codigo para pedir una letra, y cargarlo en "letra"
         */
        Character letra = null;
        do {
            System.out.println("Ingrese una letra");
            String input = scanner.nextLine();
            if(validarInputLetra(input)) {
                letra = getCharacterFromInput(input);
            } else {
                System.out.println("Debe ingresar una letra válida");
            }
        } while (letra == null);
        return letra;
    }

    public void addPuntajePartida(Integer puntosJuego) {

    }

    /**
     * Este metodo retorna el string de input como un caracter que representa una letra
     * del idioma español en mayusculas.
     *
     * @param input
     * @return el caracter ingresado por usuario
     */
    private Character getCharacterFromInput(String input) {
        char c = input.charAt(0);
        Character cter = new Character(c);
        return cter;
    }

    /**
     * Este metodo retorna true si el input leido de scanner es traducible a una letra
     * del idioma español.
     * @param input
     * @return true si la entrda fue apropiada, o false si no lo fue
     */
    private Boolean validarInputLetra(String input) {
        boolean valido = false;
        if(input.length()==1)
        {
            valido = true;
        }
        return valido;
    }

    /**
     * Este metodo gestiona todo el proceso para preguntar si se desea volver a jugar, si es así, retorna true
     * sino, retorna false
     *
     * @return la seleccion del jugador de volver a jugar
     */
    public Boolean getPlayAgain() {
        String rta = new String();
        System.out.println("¿Desea jugar otra partida? Y/N");;
        rta = scanner.nextLine();
        if(rta.equals("Y")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Este metodo gestiona el proceso de despedia de la partida, muestra los puntajes y partidas jugadas
     * (ganadas y perdidas) y termina la aplicación.
     */
    public void despedida() {
    }
}
