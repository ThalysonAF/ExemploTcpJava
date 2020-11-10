/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
public class TCPServer{
    public static void main(String[] args){
        
        try {
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            //socket TCP do Java Net, cria terminal, associa a uma porta e escuta (listenig)(5:tamanho da fila)
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");
            
            System.out.print("[ Aquardando pedidos de conexão    ..................  ");
            Socket sock = ss.accept(); // Operação bloqueante (aguardando pedido de conexão)
            System.out.println("[OK] ]");
            
            //Sequencias de bytes
            InputStream is = sock.getInputStream(); //Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); //Canal de saída de dados
            byte[] buf = new byte[20]; // buffer de recepção
            
            //Captura de 1 pedaço da sequência de bytes (byte[20]) :receive==read
            System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
            is.read(buf); // Operação bloqueante (aguardando chegada de dados)
            System.out.println("[OK] ]");
            
            //Devolver resposta
            String msg2 = "Olá, Cliente!!!";
            byte[] buf2 = msg2.getBytes();
            System.out.print("[ Enviando resposta    ..............................  ");
            os.write(buf2);
            System.out.println("[OK] ]");
            
            //Mapeia para unicode-16
            String msg = new String(buf); // Mapeando vetor de bytes recebido para String
            
            System.out.println("  Mensagem recebida: "+ msg);
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}