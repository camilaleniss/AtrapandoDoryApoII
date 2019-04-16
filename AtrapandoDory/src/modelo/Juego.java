package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Juego {

	public static int VELOCIDAD = 5;
	public static int LEVEL1=30;
	public static int LEVEL2=50;
	public static int LEVEL3=70;
	public static String NOMESTADO = "data"+File.separator+"Partida.txt";
	public static String NOMDATOS = "data"+File.separator+"Datos.txt";
	public static String NOMPLAYER = "data"+File.separator+"User.txt";

	private int puntos;
	private int level;
	private int velocidad;
	
	private Jugador jugador;	
	private ArrayList<Personaje> personaje;
	private ArrayList<Jugador> listjugadores;
	
	public Juego() {
		puntos =0;
		level =1;
		velocidad=10;	
		jugador = new Jugador();
		personaje = new ArrayList<Personaje>();
		listjugadores = new ArrayList<Jugador>();
		
		try {
			generarlistajugador();
		} catch (Exception e) {
			
		}
	}
	
	public int darpuntos() {
		return puntos;
	}
	
	public void setpuntos(int puntos) {
		this.puntos=puntos;
	}
	
	public int darlevel() {
		return level;
	}
	
	public void setlevel(int level) {
		this.level=level;
	}
	
	public int darvelocidad() {
		return velocidad;
	}
	
	public void aumentarvelocidad() {
		velocidad+= VELOCIDAD;
	}
	
	public Jugador darjugador() {
		return jugador;
	}
	
	public void setjugador(Jugador j) {
		jugador=j;
	}
	
	public ArrayList<Personaje> darpersonaje() {
		return personaje;
	}
	
	public ArrayList<Jugador> darlistajugadores(){
		return listjugadores;
	}
	
	public void setlistajugadores(ArrayList<Jugador> array) {
		listjugadores = array;
	}
	
	public void crearpez() {
		borrarpecesinvisibles();
		
		boolean creado=true;
		int numero;
		int coordenada=0;
		Personaje pez;
			
		do{
			creado=false;
			numero = (int) (Math.random() * 15) + 1;
			coordenada =(int) (Math.random() * 500) + 1;
			if (numero==8) {
				pez = new Personaje (-100, coordenada,( "./images/8.png"), true);
			}else {
				pez= new Personaje (-100, coordenada, ("./images/"+numero+".png"), false);
			}
			
			for (int i=0; i<personaje.size() && !creado; i++) {
				if (personaje.get(i).getforma().intersects(pez.getforma())) {			
					creado =true;
				}
			}
			
			
		}while (creado);
		personaje.add(pez);

	}
	
	public void moverpersonajes() {
		for (int i=0; i<personaje.size(); i++) {
			if (personaje.get(i)!=null) {
			personaje.get(i).mover(velocidad, personaje);
			}
		}
	}
	
	public void atraparpez(int x, int y) {
		for (int i=0; i<personaje.size(); i++) {
			if (personaje.get(i).getforma().contains(x,y)) {
				personaje.get(i).setinvisible();
				if (personaje.get(i).dardory()) {
					puntos+=5;
				}else {
					puntos-=5;
				}
				
			}
		}
		validarnivel();
	}
	
	public void borrarpecesinvisibles() {
		for (int i =0; i<personaje.size(); i ++) {
			if (!personaje.get(i).darvisible()) {
				personaje.remove(i);
			}
		}
	}
	
	public void validarnivel() {
		
		if (level==1) {
			if (puntos ==LEVEL1) {
				level+=1;
				aumentarvelocidad();
			}
		}else if (level == 2) {
			velocidad = 10 + VELOCIDAD;
			if (puntos ==LEVEL2) {
				level+=1;
				aumentarvelocidad();
			}
		}else if (level == 3) {
			velocidad = 10 + VELOCIDAD*2;
			if (puntos ==LEVEL3) {
				level+=1;
				aumentarvelocidad();
			}
		}

		puntos =(puntos<0 ? 0: puntos);
		level =(level<0 ? 1: level);
		
	}
	
	public void añadirjugador() {
		listjugadores.add(new Jugador (jugador.darnick(), puntos));
	}
	
	public void guardarpartida() throws Exception{
		//Este hace la serialización 
		File archivo = new File (NOMESTADO);
		if( archivo.exists( ) ){
			//si existe lo borra
			archivo.delete();
        }
        //lo crea
		ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( archivo ) );
		try {
			oos.writeObject( personaje );
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			 oos.close( ); 
		}
       
	}

	//recupera la partida
	public boolean recuperarpartida() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		File partida = new File (NOMESTADO);
		boolean existe = partida.exists() && partida.isFile();
		
		if (existe) {
			ObjectInputStream ois = new ObjectInputStream (new FileInputStream(partida));
				personaje = (ArrayList<Personaje>) ois.readObject();
				ois.close();
		}else {
			throw new FileNotFoundException("No se ha encontrado archivo");
		}
		
		return existe;
	}
	
	public void guardardatos() throws IOException{
		
		File archivo = new File (NOMDATOS);
		PrintWriter  a = new PrintWriter(archivo);
		
		if( archivo.exists( ) ){
			//si existe lo borra
			archivo.delete();
        }
		
		a.println(jugador.darnick());
		a.println("Nivel:"+level);
		a.println("Puntos:"+puntos);
		a.close();
		
		guardarnewplayer ();
	}
	
	public void guardarnewplayer () throws IOException{
		File archivo = new File (NOMPLAYER);
		PrintWriter a = new PrintWriter (archivo);
		
		if (archivo.exists()) {
			archivo.delete();
		}
		
		for (int i=0; i<listjugadores.size(); i++)
			a.println(listjugadores.get(i).darnick()+"/"+listjugadores.get(i).darpuntos());
		
		a.close();
		
		generarlistajugador();
		
	}
	
	public boolean recuperardatos() throws IOException{
		File datos = new File (NOMDATOS);
		boolean existe = datos.exists() && datos.isFile();
		
		if (existe) {
			BufferedReader read = new BufferedReader(new FileReader(datos));
			String usuario = read.readLine();
			String[] nivel = read.readLine().split(":");
			String[] puntuacion = read.readLine().split(":");
			jugador.setnick(usuario);
			level = Integer.parseInt(nivel[1]);
			puntos = Integer.parseInt(puntuacion[1]);
			read.close();
			
			validarnivel();
		}else {
			throw new FileNotFoundException("No se ha encontrado archivo");
		}
		return existe;
	}
	
	public void generarlistajugador() throws FileNotFoundException, IOException{
		
		listjugadores.clear();
		
		File datos = new File (NOMPLAYER);
		boolean existe = datos.exists() && datos.isFile();
		
		if (existe) {
			BufferedReader read = new BufferedReader(new FileReader(datos));
			String[] linea = read.readLine().split("/");
			while (existe) {
				listjugadores.add(new Jugador (linea[0], Integer.parseInt(linea[1])));
			 
			 try {
			 linea = read.readLine().split("/");
			 }catch (Exception e) {
				 read.close();
				 existe=false;
			 }
			}
			
		}
	}
	
	public String buscarjugador(int n) throws NotFoundException{
		String nombre="";
		boolean respuesta= false;
		int inicio=0;
		int fin = listjugadores.size()-1;
		
		while (inicio<=fin && !respuesta) {
			int medio = (inicio+fin)/2;
			if (listjugadores.get(medio).darpuntos()==n) {
				nombre = listjugadores.get(medio).darnick();
				respuesta = true;
			}else if (listjugadores.get(medio).darpuntos()<n) {
				fin = medio - 1;
			}else {
				inicio = medio + 1;
			}
		}
		
		if (nombre.equals("")){
			throw new NotFoundException ("No existe un jugador con ese puntaje");
		}
		
		
		return nombre;
	}
	
	public void ordenarnombre() {
	
		for (int i = 0; i<listjugadores.size()-1; i++) {
			Jugador menor = listjugadores.get(i);
			int index = i;
			
			for (int j= i+1; j<listjugadores.size(); j++) {
				
				if ((listjugadores.get(j).darnick().compareTo(menor.darnick())) <0) {
					menor = listjugadores.get(j);
					index = j;
				}
			}
			
			Jugador tmp = listjugadores.get(i);
			listjugadores.set(i, menor);
			listjugadores.set(index, tmp);
		}
	}
	
	public void ordenarpuntaje () {
	
		for (int i = 1 ; i<listjugadores.size(); i++) {
			for (int j = i; j>0 && listjugadores.get(j-1).darpuntos()<listjugadores.get(j).darpuntos(); j--) {
				Jugador tmp = listjugadores.get(j);
				listjugadores.set(j, listjugadores.get(j-1));
				listjugadores.set(j-1, tmp);
				
			}
		}
	}
	
	
	
}

