package edu.ieu.sockets.2b;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;



public class PotenciasCliente {

	   
			private BufferedReader entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
		   
			private Socket socket;
			private DataOutputStream out;
			private DataInputStream in;	
			
			public void conectar() {
		byte[]mensaje_bytes =  new byte[256];
		Double mensaje = 0d;
		
		
		try {
			socket = new Socket ("localhost",6666);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("conectado puerto 6666");
			do {
				System.out.println("escriba un mensaje :");
				mensaje =Double.parseDouble(entradaTeclado.readLine()) ;
				
				out.writeDouble(mensaje);
				System.out.println("ENVIADO: " + mensaje);
				Double respuesta = in.readDouble();
				System.out.println("RESPUESTA SERVIDOR:"+ respuesta);
			}while(!mensaje.equals("fin") );
			in.close();
			out.close();
			socket.close();
			System.out.println("conexion cerrada");
		} catch (IOException e) {
			e.printStackTrace();
		}
				}
				
				public static void main (String args[]) {
					PotenciasCliente cliente = new PotenciasCliente();
					cliente.conectar();
				}
}
