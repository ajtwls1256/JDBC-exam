package kh.properties.run;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesMain {

	public static void main(String[] args) {
		
		Properties prop = new Properties();			// Properties 객체 생성
		
		try {
			prop.load(new FileReader("resources/Windows.properties"));	// 파일 불러오기

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		// 키 에 해당하는 값 불러오기
		String os = prop.getProperty("OS");			// getProperty("키")
		String price = prop.getProperty("Price");
		String company = prop.getProperty("Company");
		String primaryUI = prop.getProperty("PrimaryUI");
		
		System.out.println(os);
		System.out.println(price);
		System.out.println(company);
		System.out.println(primaryUI);
		
	}

}
