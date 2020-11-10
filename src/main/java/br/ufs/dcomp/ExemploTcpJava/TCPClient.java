/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            //Criação do socket e pedido da conexão (ip e porta do servidor :linha17 em TCPServer)
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            String msg = "Olá, DCOMP!!!";
            byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(buf);
            System.out.println("[OK] ]");
            
            //imprimir resposta do servidor na tela
            byte[] buf2 = new byte[20]; // buffer de recepção
            
            //Captura de 1 pedaço da sequência de bytes (byte[20]) :receive==read
            System.out.print("[ Aguardando recebimento da resposta   ..............  ");
            is.read(buf2); // Operação bloqueante (aguardando chegada de dados)
            System.out.println("[OK] ]");
            
            String msg2 = new String(buf2);
            System.out.println("  Mensagem recebida: "+ msg2);
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}