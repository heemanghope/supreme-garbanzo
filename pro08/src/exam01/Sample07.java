package exam01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sample07 {
	
	private DateFormat sFormat;

	public void ex01() {
		/*
		 * 현재 날짜를 구하고 다음 형식에 맞추어 출력하시오.
		 *     1. 2022/01/01
		 *     2. 2022년 01월 01일
		 *     3. 1월 1일
		 *     4. 오전 12시 00분 월요일
		 */
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
	//SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");	
		String strDate = sFormat.format(new Date());
   //     String strDate = sFormat.format(new Date());
		
		System.out.println(strDate);
		
		sFormat.applyPattern("yyyy년 MM월 dd일");
		strDate = sFormat.format(new Date());
		System.out.println(strDate);
		
		sFormat.applyPattern("M월 d일");
		strDate = sFormat.format(new Date());
		System.out.println(strDate);
		
		sFormat.applyPattern("a hh시 mm분 E요일");
		strDate = sFormat.format(new Date());
		System.out.println(strDate);
	}
	
	
	
	

	public void ex02() {
		/*
		 * 사용자 입력을 이용하여 현재 날짜에서 n일 을 추가하거나 뺐을 때의
		 * 날짜가 언제인지를 확인할 수 있게 출력하시오.
		 *     예)
		 *         일자 : 10
		 *         현재 날짜에서 10일 후 날짜는 2022년 04월 11일 입니다.
		 *         
		 *         일자 : -10
		 *         현재 날짜에서 10일 전 날짜는 2022년 03월 22일 입니다.
		 */
		Scanner sc = new Scanner(System.in);//사용자 입력을 통하여
		System.out.print("일자 : ");
		String input = sc.nextLine();
		int addDay = Integer.parseInt(input);
		//int addDay =Integer.parseInt(input);
		
		
		GregorianCalendar g = new GregorianCalendar();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		g.add(Calendar.DATE, addDay);
		
		String strDate = sFormat.format(g.getTime());
		String result = "";
		if(addDay > 0) {
			result = String.format("현재 날짜에서 %d일 후 날짜는 %s 입니다.", addDay, strDate);
		} else {
			result = String.format("현재 날짜에서 %d일 전 날짜는 %s 입니다.", -addDay, strDate);
		}
		System.out.println(result);
	}
	
	
	

	
	
	public void ex03() {
		/*
		 * 주민등록 앞 번호의 생년월일을 입력하면 날짜로 변환되어 출력할 수
		 * 있도록 하시오.
		 */
		Scanner sc = new Scanner(System.in);
		String input = "";
		while(true) {
			System.out.print("주민번호 앞자리만 입력 : ");
			input = sc.nextLine();
			if(input.matches("\\d{6}")) {
				break;
			}
			System.out.println("주민번호 앞자리 6자만 입력하세요.");
		}
		
		SimpleDateFormat sFormat = new SimpleDateFormat("yyMMdd");
		//String strDate = sFormat.parse(input);
		try {
			Date d = sFormat.parse(input);
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	

	public void ex04() {
		/*
		 * 자신의 올해 생일이 몇일 남았는지 알 수 있도록 해주는 코드를 작성하시오.
		 */
		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar birthDay = new GregorianCalendar();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy.MM.dd");
		//                                                  -   -이거는 1970기준
		Scanner sc = new Scanner(System.in);        
		
		String input = "";
		while(true) {
			System.out.print("자신의 생일을 \"월.일\" 형식으로 입력하세요 : ");
			input = sc.nextLine();
			
			if(input.matches("\\d{1,2}\\.\\d{1,2}")) {
				break;          //범위가 1~2자 사이일때!
			}                   // \\. 점은 모든 문자라고 생각함.하나는\문자열.
			System.out.println("입력 형식을 다시 확인하세요.");
		}
		//birthDay.setTime(sFormat.parse(input));
		
		try {
			birthDay.setTime(sFormat.parse(now.get(Calendar.YEAR) + "." + input));
			System.out.println(birthDay.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//기본이 1970년을 기준으로 되어있음.
		System.out.println(now.after(birthDay));
		System.out.println(now.before(birthDay));
	}
	
	
	
	
	
	
	
	
	public void ex05() {
		/*
		 * 프로그램이 동작한 후 부터 종료할 때까지의 시간 기록을 남기기 위한 코드를 작성하시오.
		 * 기록을 남기기 위한 프로그램은 1 ~ 100,000 까지의 누적합을 구하는 코드로 한다.
		 */ 
		Date start = new Date();       ;
		
		long tot = 0;
		for(long i = 1; i <= 10000000000L; i++) {
			tot += i;
		}//누적합구하기.
		
		Date end = new Date();
		
		long time = end.getTime() - start.getTime();
		System.out.println("실행 시간 : " + time / 1000.0 + " 초");
		
	}
	
	
	

	
	
	public void ex06() {
		/*
		 * 2020년 부터 2099년 까지의 년도 중 윤년에 해당하는 년도를 정수 배열에 담아 출력하시오.
		 */
    GregorianCalendar gc  = new GregorianCalendar();
    int[] leapYear =new int[0];
    for(int year=2020; year<2100; year++) {
    	if(gc.isLeapYear(year)) {
    		leapYear=Arrays.copyOf(leapYear, leapYear.length+1);
    		leapYear[leapYear.length-1]=year;
    	}
    }
    
    System.out.println(Arrays.toString(leapYear));
	}
	
	public void ex07() {
		/*
		 * 2022년 04월 에서 주말에 해당하는 날짜만 날짜 배열에 저장하시오.
		 */
	Date[] dArr = new Date[0];
	GregorianCalendar gc= new GregorianCalendar();
	SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd E요일");
	gc.set(2022,4,1);
	
	for(int i=gc.get(Calendar.DATE); i<= gc.getActualMaximum(Calendar.DATE); i++) {
		gc.set(2022,3,i); //month 는 +1시켜줘야함.
		switch(gc.get(Calendar.DAY_OF_WEEK)) {
		   case Calendar.SATURDAY: case Calendar.SUNDAY:
			  dArr=Arrays.copyOf(dArr,dArr.length+1);
			  dArr[dArr.length-1]= gc.getTime();
			
		}
	}
	
	for(int i= 0; i<dArr.length; i++) {
		
		System.out.println(sFormat.format(dArr[i]));
	   }
	
	}
	
	
	
	
	
	

	
	public void ex08() {
		/*
		 * 유튜브에서는 영상 업로드가 언제 이루어졌는지를 보여주는 형식이 x초 전 또는 x분 전, x시간 전
		 * x일 전, x주 전, x개월 전, y년 전 으로만 출력이 이루어지는데. 이를 동일하게 모방하여 사용자가
		 * 입력한 날짜가 현재 시간과 얼만큼의 차이가 있는지 출력하시오.
		 */
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		GregorianCalendar upload = new GregorianCalendar(2021, 2-1,28,12, 46, 20);
		Date now = new Date();
		
		
		System.out.println("업로드 시간 : " + sFormat.format(upload.getTime()));
		System.out.println("현재 시간 : " + sFormat.format(now));
		
		int beforeTime = (int)((now.getTime() - upload.getTime().getTime())/ 1000 );
		                                                      //Date    long   초단위
		if(beforeTime <= 60) {
			System.out.println(beforeTime + " 초 전");
		} else if(beforeTime <= 60 * 60) {
			System.out.println(beforeTime / 60 + " 분 전");
		} else if(beforeTime <= 60 * 60 * 24) {
			System.out.println(beforeTime / (60 * 60) + " 시간 전");
		} else if(beforeTime <= 60 * 60 * 24 * 7) {
			System.out.println(beforeTime / (60 * 60 * 24) + " 일 전");
		} else if(beforeTime <= 60 * 60 * 24 * 7 * 4) {
			System.out.println(beforeTime / (60 * 60 * 24 * 7) + " 주 전");
		} else if(beforeTime <= 60 * 60 * 24 * 7 * 4 * 12) {
			System.out.println(beforeTime / (60 * 60 * 24 * 7 * 4) + " 개월 전");
		} else {
			System.out.println(beforeTime / (60 * 60 * 24 * 7 * 4 * 12) + " 년 전");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Sample07 sample = new Sample07();
		//sample.ex01();
		//sample.ex02();
		//sample.ex03();
		//sample.ex04();
		// sample.ex05();
		// sample.ex06();
		  //  sample.ex07();
		sample.ex08();
		//sample.ex09();
	
	}
	
	public void ex09() {
		/*
		 * D-Day 계산기를 만들어 보시오.
		 *     1. 현재 시간보다 과거의 시간을 입력한 경우 "D-Day n일 지남" 으로 출력
		 *     2. 현재 시간보다 미래의 시간을 입력한 경우 "D-Day n일 남음" 으로 출력
		 */
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar userInputDate = new GregorianCalendar(2022, 4 - 1, 23);
		Date now = new Date();
		
		System.out.println("입력한 날짜 : " + sFormat.format(userInputDate.getTime()));
		System.out.println("현재 날짜 : " + sFormat.format(now));
		
		int dDayTime = (int)((now.getTime() - userInputDate.getTime().getTime()) / 1000);
		String t = "지남";
		
		if(dDayTime < 0) {
			t = "남음";
			dDayTime = -dDayTime;
		}
		System.out.printf("D-Day %d일 %s", dDayTime / (60 * 60 * 24), t);
	}



		 
		 
	}
	

//알아두면 좋은것
//1년 365,1주는 7일,1일은 24시간,1시간은 60분,1분은 60초,1초는 1000밀리초
