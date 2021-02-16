package binarios;

import Whatsapp.IODatos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Password vPas[] = new Password[10];
		
		
		vPas[0] = new Password("Diego", 654, false);
		vPas[1] = new Password("Paco", 741, true);
		vPas[2] = new Password("Yo", 852, true);
		vPas[3] = new Password("Jordi", 963, false);
		
		IOData.guardarDatos("pass.dat", vPas);
		
	}

}
