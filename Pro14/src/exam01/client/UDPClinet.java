package exam01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClinet {
	
	
	
    public static void main(String[] args) {
		
    	
    	
    	try {
    		
    		/*
    		 * 1.네트워크 통신을 위한 IP 주소 정보 설정
    		 */
    		
    		
    		
			//InetAddress ip = InetAddress.getByName("localhost");//외부통신에 사용하는 것은 아님.
			//내부 pc안에서 테스트용으로.. 내부의 프로그램
    		
    		//byte[] addr = new byte[] {(byte)192, (byte)168,(byte)219,(byte)105};
    		//InetAddress ip = InetAddress.getByAddress(null);//cmd를 통해서 내가 알아내서 쓴거임.
    		
    		
    		
    		
    		InetAddress clientIp = InetAddress.getLocalHost();//내가 사용하고 있는 ip주소가 나온다.알아서
			int clientPort = 50000;//내가 정하기
			
			byte[] addr = new byte[] {(byte)192, (byte)168,(byte)219,(byte)105};
			InetAddress serverIp = InetAddress.getByAddress(addr);//서버설정
    		int serverPort =51000;
    		
    		
    		/*
    		 * 2.UDP 통신용 소켓 생성
    		 * 
    		 */
    	
				DatagramSocket udpSock = new DatagramSocket(clientPort, clientIp);
				
				/*
	    		 * 3.서버에 데이터를 송신하기 위한 패킷 생성
	    		 * (서버가 활성화 되어있어야함.)
	    		 */
			
				Scanner sc = new Scanner(System.in);
				while(true) {
					String msg = sc.nextLine();
					byte[]data = msg.getBytes();
					DatagramPacket packet = new DatagramPacket(data,data.length,serverIp,serverPort);
				    udpSock.send(packet);
				}
				
				
			//byte[] data = "Hello".getBytes();	
	    	//DatagramPacket packet = new DatagramPacket(data,data.length,serverIp,serverPort);
	       // udpSock.send(packet);
	        //메시지 송신 끝.

		
	  
	        
			/*
    		 * 4.데이터 송신을 완료하였으면 모든 자원 반납.
    		 * 
    		 */
			//udpSock.close(); //비연결 지향형
				
    	   }catch (UnknownHostException e) {
	           e.printStackTrace();	
	           
    	   }catch (SocketException e) {
   			   e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
			
    		
			//네트워크 방화벽 없앰
		}
	}
}
