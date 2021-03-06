package disparos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import partes.ParteDanioTotal;
import barcos.Vector;
import escenario.Tablero;
import excepciones.PosicionInvalida;

public class MinaDobleRadioTest {

	@Test
	public void testCreoUnaMinaRadioYAlHaberUnaParteSuceptibleConUnaSolaVidaEstaRecibeSuImpactoYEsDestruida() {
		MinaDobleRadio mina = new MinaDobleRadio();
		Vector posicion = new Vector(3, 3);
		mina.cambiarCasillerosAfectados(posicion);
		Vector posicionPertenecienteAlRadio = new Vector(3, 1);
		ParteDanioTotal parte = new ParteDanioTotal(1);
		Tablero tablero = Tablero.getTablero();
		tablero.colocarElemento(posicionPertenecienteAlRadio, parte);
		mina.daniar();
		assertTrue(parte.estaDestruida());
	}

	@Test
	public void testCreoUnaMinaDobleRadioYAlHaberUnaParteSuceptibleConUnaSolaVidaEstaRecibeSuImpactoYEsDestruida() {
		MinaDobleRadio mina = new MinaDobleRadio();
		Vector posicion = new Vector(3, 3);
		mina.cambiarCasillerosAfectados(posicion);
		Vector posicionNoPertenecienteAlRadio = new Vector(9, 9);
		ParteDanioTotal parte = new ParteDanioTotal(1);
		Tablero tablero = Tablero.getTablero();
		tablero.colocarElemento(posicionNoPertenecienteAlRadio, parte);
		mina.daniar();
		assertFalse(parte.estaDestruida());
	}

	@Test
	public void testAlCrearlaEnPosicionInvalidaDeberiaDarError() {
		MinaDobleRadio unaMina = new MinaDobleRadio();
		boolean valor = false;
		try {
			unaMina.cambiarCasillerosAfectados(new Vector(111, 231));
		} catch (PosicionInvalida error) {
			valor = true;
		}
		assertTrue(valor);
	}

}
