package Prueba;

import java.io.Serializable;

public class Pregunta implements Serializable {
    private String enunciado;
    private String respuestaCorrecta;

    public Pregunta(String enunciado, String respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}