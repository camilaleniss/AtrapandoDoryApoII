package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import modelo.Juego;
import modelo.Jugador;

class JuegoTest {
	
	private Juego juego;
	
	JuegoTest(){
		juego = new Juego();
	}

	void setUpEscenario1() {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador ("Camila", 50));
		jugadores.add(new Jugador ("Karol", 40));
		jugadores.add(new Jugador ("Angela", 30));
		jugadores.add(new Jugador ("Brittany", 10));
		jugadores.add(new Jugador ("Zxl", 20));
		juego.setlistajugadores(jugadores);
	}
	
	void setUpEscenario2() {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador ("Ana", 10));
		jugadores.add(new Jugador ("Alejandro", 10));
		jugadores.add(new Jugador ("Angela", 10));
		jugadores.add(new Jugador ("Anastasia", 10));
		jugadores.add(new Jugador ("Aaa", 10));
		jugadores.add(new Jugador ("Andrea", 10));
		juego.setlistajugadores(jugadores);
	}
	
	void setUpEscenario3() {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador ("ángel", 20));
		jugadores.add(new Jugador ("Ángel", 20));
		jugadores.add(new Jugador ("Angel", 10));
		juego.setlistajugadores(jugadores);
	}
	
	void setUpEscenario4() {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador ("Cam Lenis", 40));
		jugadores.add(new Jugador ("Camila", 40));
		jugadores.add(new Jugador ("Cam ms", 40));
		juego.setlistajugadores(jugadores);
	}
	
	void setUpEscenario5() {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador ("Amm", 20));
		jugadores.add(new Jugador ("Amm", 30));
		jugadores.add(new Jugador ("Amm", 50));
		jugadores.add(new Jugador ("Amm", 10));
		jugadores.add(new Jugador ("Amm", 30));
		jugadores.add(new Jugador ("Amm", 60));
		juego.setlistajugadores(jugadores);
	}
	
	void setUpEscenario6() {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador ("Ooo", 30));
		jugadores.add(new Jugador ("Ooo", 35));
		jugadores.add(new Jugador ("Ooo", 10));
		jugadores.add(new Jugador ("Ooo", 15));
		jugadores.add(new Jugador ("Ooo", 20));
		jugadores.add(new Jugador ("Ooo", 40));
		jugadores.add(new Jugador ("Ooo", 5));
		juego.setlistajugadores(jugadores);
	}
	
	
	@Test
	void testOrdenar1() {
		setUpEscenario1();
		juego.ordenarnombre();
		assertTrue(juego.darlistajugadores().get(0).darnick().equals("Angela"));
		assertTrue(juego.darlistajugadores().get(1).darnick().equals("Brittany"));
		assertTrue(juego.darlistajugadores().get(2).darnick().equals("Camila"));
		assertTrue(juego.darlistajugadores().get(3).darnick().equals("Karol"));
		assertTrue(juego.darlistajugadores().get(4).darnick().equals("Zxl"));
	}
	
	@Test
	void testOrdenar2() {
		setUpEscenario2();
		juego.ordenarnombre();
		assertTrue(juego.darlistajugadores().get(0).darnick().equals("Aaa"));
		assertTrue(juego.darlistajugadores().get(1).darnick().equals("Alejandro"));
		assertTrue(juego.darlistajugadores().get(2).darnick().equals("Ana"));
		assertTrue(juego.darlistajugadores().get(3).darnick().equals("Anastasia"));
		assertTrue(juego.darlistajugadores().get(4).darnick().equals("Andrea"));
		assertTrue(juego.darlistajugadores().get(5).darnick().equals("Angela"));
	}
	
	@Test
	void testOrdenar3() {
		setUpEscenario3();
		juego.ordenarnombre();
		assertTrue(juego.darlistajugadores().get(0).darnick().equals("Angel"));
		assertTrue(juego.darlistajugadores().get(1).darnick().equals("Ángel"));
		assertTrue(juego.darlistajugadores().get(2).darnick().equals("ángel"));
	}
	
	@Test
	void testOrdenar4() {
		setUpEscenario4();
		juego.ordenarnombre();
		assertTrue(juego.darlistajugadores().get(0).darnick().equals("Cam Lenis"));
		assertTrue(juego.darlistajugadores().get(1).darnick().equals("Cam ms"));
		assertTrue(juego.darlistajugadores().get(2).darnick().equals("Camila"));
	}
	
	@Test
	void testOrdenar5() {
		setUpEscenario1();
		juego.ordenarpuntaje();
		assertTrue(juego.darlistajugadores().get(0).darpuntos()==50);
		assertTrue(juego.darlistajugadores().get(1).darpuntos()==40);
		assertTrue(juego.darlistajugadores().get(2).darpuntos()==30);
		assertTrue(juego.darlistajugadores().get(3).darpuntos()==20);
		assertTrue(juego.darlistajugadores().get(4).darpuntos()==10);

	}
	
	@Test
	void testOrdenar6() {
		setUpEscenario2();
		juego.ordenarpuntaje();
		assertTrue(juego.darlistajugadores().get(0).darpuntos()==10);
		assertTrue(juego.darlistajugadores().get(1).darpuntos()==10);
		assertTrue(juego.darlistajugadores().get(2).darpuntos()==10);
		assertTrue(juego.darlistajugadores().get(3).darpuntos()==10);
		assertTrue(juego.darlistajugadores().get(4).darpuntos()==10);

	}
	
	@Test
	void testOrdenar7() {
		setUpEscenario5();
		juego.ordenarpuntaje();
		assertTrue(juego.darlistajugadores().get(0).darpuntos()==60);
		assertTrue(juego.darlistajugadores().get(1).darpuntos()==50);
		assertTrue(juego.darlistajugadores().get(2).darpuntos()==30);
		assertTrue(juego.darlistajugadores().get(3).darpuntos()==30);
		assertTrue(juego.darlistajugadores().get(4).darpuntos()==20);
		assertTrue(juego.darlistajugadores().get(5).darpuntos()==10);

	}
	
	@Test
	void testOrdenar8() {
		setUpEscenario6();
		juego.ordenarpuntaje();
		assertTrue(juego.darlistajugadores().get(0).darpuntos()==40);
		assertTrue(juego.darlistajugadores().get(1).darpuntos()==35);
		assertTrue(juego.darlistajugadores().get(2).darpuntos()==30);
		assertTrue(juego.darlistajugadores().get(3).darpuntos()==20);
		assertTrue(juego.darlistajugadores().get(4).darpuntos()==15);
		assertTrue(juego.darlistajugadores().get(5).darpuntos()==10);
		assertTrue(juego.darlistajugadores().get(6).darpuntos()==5);
	}

}
