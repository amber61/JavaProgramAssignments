import java.rmi.Remote;

/** Remote interface for the RMI-based EchoServer
 */
public interface EchoServerInterface extends Remote {
	public String processMessage(String hostName, String message) throws java.rmi.RemoteException;
}
