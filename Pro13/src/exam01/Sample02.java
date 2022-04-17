package exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Sample02 {//바이트 읽기

	public static void main(String[] args) {
		/*
		 * FileInputStream 클래스
		 *     - 바이트 기반 스트림으로 바이트 단위로 파일을 읽는다.
		 *     - 미디어, 이미지, 텍스트 파일 등 모든 종류의 파일 읽기 가능
		 */
		File f = new File("C:/Users/user/eclipse/jee-2021-122/eclipse/file_test.txt");
		          // 확장자 잘 확인하기!!
		try {
			FileInputStream fis = new FileInputStream(f);
			
			/*
			while(true) {
				int i = fis.read();
				if(i == -1) {
					break;
				}
				System.out.print((char)i);
			}
			*/
			//바이트기반 읽기작업
			byte[] buffer = new byte[4];
			byte[] bytes = new byte[0];
			
			while(true) {
				int i = fis.read(buffer);//1바이트씩 읽는게 아니라 4byte씩 읽는것임.
				if(i == -1) {
					break;
				}
				bytes = Arrays.copyOf(bytes, bytes.length + i);
				System.arraycopy(buffer, 0, bytes, bytes.length - i, i);
			}
			
			//System.out.print((char)i); 문자로 넣으면 깨져서 나온다.한글은 2byte나 3byte로 한글은1byte로 넣으면 안됨.
			System.out.println(new String(bytes));
			
			fis.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("해당 파일을 읽는 과정에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}

}
