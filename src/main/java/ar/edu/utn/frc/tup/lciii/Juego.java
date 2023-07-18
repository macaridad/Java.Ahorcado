package ar.edu.utn.frc.tup.lciii;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Juego {

    private static PalabrasService palabrasService = new PalabrasService();

    private String palabraEnJuego;
    private String palabraModoOculto = new String();
    private List<Character> letrasElegidas = new ArrayList<>();
    private Integer vidasJugador;
    private Integer puntosJuego;

    public String getPalabraEnJuego() {
        return palabraEnJuego;
    }

    public void setPalabraEnJuego(String palabraEnJuego) {
        this.palabraEnJuego = palabraEnJuego;
    }

    public void setPalabraModoOculto(String palabraModoOculto) {
        this.palabraModoOculto = palabraModoOculto;
    }

    public List<Character> getLetrasElegidas() {
        return letrasElegidas;
    }

    public void setLetrasElegidas(List<Character> letrasElegidas) {
        this.letrasElegidas = letrasElegidas;
    }

    public Integer getVidasJugador() {
        return vidasJugador;
    }

    public void setVidasJugador(Integer vidasJugador) {
        this.vidasJugador = vidasJugador;
    }

    public Integer getPuntosJuego() {
        return puntosJuego;
    }

    public void setPuntosJuego(Integer puntosJuego) {
        this.puntosJuego = puntosJuego;
    }

    public Juego() {
        this.palabraEnJuego = palabrasService.getPalabra();
        this.palabraModoOculto = this.getPalabraModoOculto();
        this.letrasElegidas = new ArrayList<>();
        this.vidasJugador = 6;
        this.puntosJuego = 0;
    }

    public void addLetra(Character letra) {
        letrasElegidas.add(letra);
    }

    /**
     * Este metodo debe verificar si el juego termnó porque ganó el jugador o porque se acabaron las vidas.
     * Cuando se lo llama y el juego no terminó, debe descontar las vidas y calcular el puntaje de este juego.
     *
     * @return si el juego ha terminado o no
     */
    public Boolean calcularEstadoDelJuego() {
        this.verificarLetras();
        Boolean terminado = false;
        if(!palabraModoOculto.contains("_"))
        {
            terminado = true;
            puntosJuego+=10;
            System.out.println("¡Felicidades, ha descubierto la palabra!");
            dibujar();
        }
        else if (vidasJugador==0)
        {
            terminado = true;
            System.out.println("Se ha quedado sin vidas");
        }
        return terminado;
    }

    /**
     * Este metodo genera la palabra en modo oculto, es decir, muestra las
     * letras encontradas, sino, muestra guones bajos
     *
     * @return La palabra en juego en modo oculto
     */
    public String getPalabraModoOculto() {
        Integer cantidadCaracteres = palabraEnJuego.length();
        String[] oculta = new String[cantidadCaracteres];
        if(letrasElegidas.size()==0)
        {
            for(int i=0; i<oculta.length; i++)
            {
                oculta[i] = "_";
                palabraModoOculto += oculta[i];
            }
        }
        return palabraModoOculto;
    }

    public Boolean verificarLetras() {
        char[] arrayDeEnJuego = palabraEnJuego.toCharArray();
        int errores = 0;
        int aciertos = 0;
        Boolean valida = false;
        for(Character c : letrasElegidas)
        {
            if(palabraEnJuego.contains(c.toString()))
            {
                aciertos++;
                char[] arrayDeOculto = palabraModoOculto.toCharArray();
                for(int i = 0; i<arrayDeEnJuego.length;i++)
                {
                    if(arrayDeEnJuego[i]==c)
                    {
                        arrayDeOculto[i] = c;
                    }
                }
                palabraModoOculto = String.valueOf(arrayDeOculto);
                valida = true;
            }
            else {
                errores++;
            }
        }
        vidasJugador = 6-errores;
        puntosJuego = aciertos*2-errores;
        return valida;
    }
    /**
     * Este metodo dibuja el juego por cada iteracion, es decir, pinta la palabra oculta
     * con sus espacios en blanco (guiones bajos) y sus espacios ocupados por las letras ya elegidas;
     * y el resto de la informacion referente al juego, cantidad de vidas que restan por ejemplo.
     *
     */
    public void dibujar() {
        System.out.println(this.palabraModoOculto);
        System.out.println("Le quedan " + vidasJugador + " vidas");
        System.out.println("Sus puntos son "+puntosJuego);
    }

}
