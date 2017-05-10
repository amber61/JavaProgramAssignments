
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.rmi.NotBoundException;


/* EXERCISE FOR READER: read the code, understand, and insert comments */
public class EchoClientDatabase {

	public static void main(String[] args) {
		int port = 8082;
		String serverName = new String("localhost");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String myHostName = "localhost";
		
		switch (args.length) {
		case 0:
			break;
		case 1: 
			serverName = args[0];
			break;
		case 2:
			serverName = args[0];
			port = Integer.parseInt(args[1]);
			break;
		default:
			System.out.println("usage: EchoClient [hostname [portnum]]");
			break;
		}
		try {
			InetAddress myHost = Inet4Address.getLocalHost();
			myHostName = myHost.getHostName();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

		try {
			String message;
			System.out.println("Attempting to connect to rmi://"+serverName+":"+port+"/EchoService");
			EchoServerInterface es = (EchoServerInterface) 
					Naming.lookup("rmi://"+serverName+":"+port+"/EchoService");
			
			do {
				System.out.print("Input> ");
				try {
					message = br.readLine();
					if (message != null){
						System.out.println(es.processMessage(myHostName, message));
					}
				}catch(IOException e){
					e.printStackTrace();
					message = null;
				}
			} while (message != null);
		}
		catch (MalformedURLException murle) {
			System.out.println();
			System.out.println(
					"MalformedURLException");
			System.out.println(murle);
		}
		catch (RemoteException re) {
			System.out.println();
			System.out.println("RemoteException");
			System.out.println(re);
		}
		catch (NotBoundException nbe) {
			System.out.println();
			System.out.println("NotBoundException");
			System.out.println(nbe);
		}
	}
}
