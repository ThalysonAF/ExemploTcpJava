# ExemploTcpJava
Exemplo simples de sockets TCP em Java

mvn compile
--Executar primeiro o servidor
java -cp target/classes/ br.ufs.dcomp.ExemploTcpJava.TCPServer 

--Executar Cliente em novo terminal
java -cp target/classes/ br.ufs.dcomp.ExemploTcpJava.TCPClient 