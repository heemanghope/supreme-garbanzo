package exam01.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPServer {
    
	public static void main(String[] args) {
        try {
    		
    		/*
    		 * 1.네트워크 통신을 위한 IP 주소 정보 설정
    		 */
    	//여러 주소중에 지정하기.....
			
			byte[] addr = new byte[] {(byte)192, (byte)168,(byte)219,(byte)105};
			InetAddress serverIp = InetAddress.getByAddress(addr);
    		int serverPort =51000;//여러주소가 있을 수 있으므로 정확히만들기.
    		
    		
    		/*
    		 * 2.UDP 통신용 소켓 생성
    		 * 
    		 */
    	    DatagramSocket udpSock = new DatagramSocket(serverPort, serverIp);
				
			while(true) {
				/*
	    		 * 3. 클라이언트가 서버에 송신한 데이터를 수신하기 위한 패킷 생성  //클라이언트는 송신. 서버는 수신
	    		 * (서버가 활성화 되어있어야함.)
	    		 */
				
			byte[] data = new byte[1024];
	    	DatagramPacket packet = new DatagramPacket(data,data.length);
	        udpSock.receive(packet);
	        
			/*
    		 * 수신한 패킷에서 클라이언트 정보 확인
    		 */
			InetAddress clientIp =packet.getAddress();
            int clientPort = packet.getPort();
					
					
					
			/*
	         * 4.수신한 데이터를 출력하여 확인
	         * 
	    	 */
            SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
            String now =sFormat.format(new Date());
            String msg = new String(packet.getData());
			System.out.printf("[%s] [%s:%d] - %s\n", now, clientIp.getHostAddress(),clientPort,msg);
			
			}
			/*
			 * 5.데이터 송신을 완료하였으면 모든 자원 반납.
			 * (서버가 활성화 되어있어야함.)
			 */
			//udpSock.close(); //비연결 지향형
				
    	   } catch (UnknownHostException e) {
	           e.printStackTrace();	
	           
    	   } catch (SocketException e) {
   			   e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
			
    		
			
		}
	}
}
