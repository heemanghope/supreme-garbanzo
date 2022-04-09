package exam11;

public interface ProgrammerOper {
   //메서드 정의
	public String binary(int n1);//2진법
	public String octal(int nn1); //8진수
    public String hexa(int n1);//숫자를 뜻하는 접두사.
    public int binaryToDecimal(String binary);
    public int octalToDecimal(String octal);
    public int hexaToDecimal(String hexa);
}
