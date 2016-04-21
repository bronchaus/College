package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import Server.ChatServerIF;

public class ChatClient extends UnicastRemoteObject implements ChatClientIF, Runnable {

	private static final long serialVersionUID = 1L;
	private ChatServerIF chatServer;
	private String name = null;
	String message = new String();

	//Constructor for the Client
	protected ChatClient(String name, ChatServerIF chatServer) throws RemoteException {
		this.name = name;
		this.chatServer = chatServer;
		chatServer.registerChatClient(this);
	}

	//Takes the message from the Chat server to update Clients GUI's
	public void retreiveMessages(String message) throws RemoteException {
		//System.out.println(message);
		this.message=(message+"\n");
		ChatClientDriver.getMessage(message);
	}
	
	//Thread to run
	public void run(){
		Scanner scanner = new Scanner(System.in);
		String message;
		while(true){
			message = scanner.nextLine();
			try{
				chatServer.broadcastMessage(name+ ": " +message);
			} catch (RemoteException e){
				e.printStackTrace();
			}
		}
	}

}
