package disparos;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import barcos.Vector;
import casillero.Casillero;

public class MinaContacto extends Mina {
    public MinaContacto() {
        super();
        radio = 0;
        costo = 150;
        nombre = "minacontacto";
    }

    public MinaContacto(Element nodo) {
        super();
        radio = 0;
        costo = 150;
        nombre = "minacontacto";
        this.cambiarCasillerosAfectados(new Vector(nodo.attributeValue("posicion")));
    }

    @Override
    public boolean debeDaniarEnEsteTurno() {
        Casillero casilleroAfectado = casillerosAfectados.get(0);
        return casilleroAfectado.contieneElementos();
    }

    @Override
    public Element generarNodo() {
        Element nodoADevolver = DocumentHelper.createElement("MinaContacto");
        nodoADevolver.addAttribute("posicion", posicion.toString());
        return nodoADevolver;
    }

}
