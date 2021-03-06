package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaFondo extends VentanaGeneral {
    ManejadorVentanas manejador;
    String carpeta;
    int posY = 350;

    public VentanaFondo(ManejadorVentanas manejadorV, String titulo, String dirCarpeta) {
        super(titulo);
        carpeta = dirCarpeta;
        this.addBtnSalir();
        this.addBtnVolverInicio();
        this.addImagenDeFondo(dirCarpeta + "/fondo.png");
        manejador = manejadorV;
    }

    private void addBtnVolverInicio() {
        String direccion = carpeta + "/inicio.png";
        if (direccion.equals("imagenes/victoria/inicio.png")) {
            System.out.println("la direccion esta bien");
        }
        Boton btnVolverInicio = new Boton(carpeta + "/inicio.png", 41, posY);
        btnVolverInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // pepe
                manejador.abrirInicio(frame);
            }
        });
        this.getContentPane().add(btnVolverInicio);
        // return btnTutorial;

    }

    private void addBtnSalir() {
        Boton btnSalir = new Boton(carpeta + "/salir.png", 543, posY);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
            }
        });
        this.getContentPane().add(btnSalir);
        // return btnTutorial;

    }
}
