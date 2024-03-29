package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sample03 {//쓰기

	public static void main(String[] args) {
		/*
		 * FileOutputStream
		 *           - 바이트 단위로 파일에 데이터를 쓰기 위해 사용
		 *           - 미디어, 이미지, 텍스트 파일 등 모든 종류의 파일 쓰기 가능
		 */
		File f = new File("C:/Users/user/eclipse/jee-2021-122/eclipse/file_text.txt");
		
		
		try (FileOutputStream fos = new FileOutputStream(f, true)) { //덮어쓰기가 아니라 이어쓰기.true를 쓰면 이어쓰기가 됨.개행되어 나오는게 아니다.
			//마지막글자뒤에 바로 나오는것임.
		    
			fos.write(65);
			
			byte[] bArr = new byte[] {66, 67, 68 ,69};
			fos.write(bArr);
			
			fos.write("\nFileOutputStream\n".getBytes());
			
			fos.write("한글쓰기".getBytes());//문자열을 바이트로 만들기.
			
			fos.flush();//마지막은 항상 flush로 쓰기
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일쓰기 작업중에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}

}
