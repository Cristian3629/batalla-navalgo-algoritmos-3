package partida;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import partes.ParteDanioDisparo;
import partes.ParteDanioTotal;
import barcos.Vector;
import disparos.Disparo;
import escenario.Tablero;
import excepciones.DisparoInvalido;

public class ConstructorDeDaniadorTest {

	@Test
	public void testAlCrearUnaMinaDeContactoConElConstructor() {
		ConstructorDeDaniador constructor = new ConstructorDeDaniador();
		Vector posicion = new Vector(1, 2);
		Disparo disparo = constructor
				.construirDisparo("minacontacto", posicion);
		assertEquals(disparo.costo(), 150);

	}

	@Test
	public void testCreoUnDisparoConElConstructorHacerloDaniarYVeoSiLaParteQuedoDestruida() {
		Tablero tablero = Tablero.getTablero();
		ConstructorDeDaniador constructor = new ConstructorDeDaniador();
		Vector posicion = new Vector(1, 2);
		ParteDanioTotal parte = new ParteDanioTotal(1);
		tablero.colocarElemento(posicion, parte);
		Disparo disparo = constructor.construirDisparo("disparoconvencional",
				posicion);
		disparo.daniar();

		assertTrue(parte.estaDestruida());
	}

	@Test
	public void testAlConstruirUnDisparoEnUnaPosicionFueraDelTableroDeberiaDarError() {
		boolean valor = false;
		try {
			ConstructorDeDaniador constructor = new ConstructorDeDaniador();
			Disparo disparo = constructor.construirDisparo(
					"disparoconvencional", new Vector(11, 123));
		} catch (DisparoInvalido error) {
			valor = true;
		}
		assertTrue(valor);
	}

	@Test
	public void testAlCrearUnaMinaConElConstructorHacerlaDaniarYVerSiLaParteDanioDisparQuedoDestruidaDeberiaSerFalso() {
		Tablero tablero = Tablero.getTablero();
		ConstructorDeDaniador constructor = new ConstructorDeDaniador();
		Vector posicion = new Vector(1, 2);
		ParteDanioDisparo parte = new ParteDanioDisparo(1);
		tablero.colocarElemento(posicion, parte);
		Disparo disparo = constructor.construirDisparo("minadobleradio",
				posicion);
		disparo.daniar();

		assertFalse(parte.estaDestruida());
	}
}
