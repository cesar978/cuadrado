package edu.ieu.sockets.2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PotenciasServer {

	

	public void iniciar() {
        ServerSocket servidor;
        boolean fin = false;
        try {
        servidor = new ServerSocket(6666);
        System.out.println("Servidor  puerto 6666");
        Socket socketManejoCliente = servidor.accept();
        
        DataInputStream in= new DataInputStream(socketManejoCliente.getInputStream());
        DataOutputStream out = new DataOutputStream(socketManejoCliente.getOutputStream());
        do {
        Double mensaje =0d;
        mensaje = in.readDouble();
        System.out.println(" recibio del cliente:"+ mensaje);
       out.writeDouble(mensaje*mensaje);
        if (mensaje.equals("fin")) {
        fin= true;
        System.out.println("NO RECIVE MAS MENSAJES:");
        }
        }while(!fin);
        in.close();
        out.close();
        socketManejoCliente.close();
        servidor.close();
    }catch (IOException e) {
        	e.printStackTrace();
        }
	}
	public static void main(String args[]) {
		2 servidor = new 2();
		servidor.iniciar();
} 
	} 

