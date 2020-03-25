package SeleniumTest;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class SeleniumTest {

		private boolean in;
		private boolean res;
		private static WebDriver driver;
		public SeleniumTest(Boolean in,Boolean res) {
			this.in=in;
			this.res=res;
		}
		
		@Parameters
		public static Collection<Object[]> getData(){
			return Arrays.asList(Output());
		}
		@Before
		public void setUp()  {
			
			
		}

		@AfterClass
		public static void tearDown()  {
			System.out.println();
		}

		@Test
		public void testOutput() {	
			assertEquals(this.res, this.in); 
		}
		public static Object[][] Output(){
			final int TestCaseNumber = 20; //���ò�������
			Boolean[][] objects=new Boolean[TestCaseNumber][2];
            System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe"); //���õ������װ·���µ�exe�ļ�
			driver = new FirefoxDriver(); //�򿪻�������
			//����������
			XSSFWorkbook xssfWorkbook= null;
			try {
				//��ȡ��һ��������
				xssfWorkbook = new XSSFWorkbook(new FileInputStream("F:\\Selenium Lab2020.xlsx"));
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//�˴���0��ʼ�����������б���
			XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
			for (int row = 0; row < TestCaseNumber; row++) {
				int maxRol = sheet.getRow(row).getLastCellNum();
				System.out.println("--------��" + row + "�е���������--------");
				for (int rol = 0; rol < maxRol; rol++){
					System.out.print(sheet.getRow(row).getCell(rol) + "  ");
				}
				String StudentID = sheet.getRow(row).getCell(1) + "";
				String PassWord = sheet.getRow(row).getCell(2) + "";
				System.out.println();
				//��ȡ��������¼����Ϣ������ҳ������
				driver.get("http://103.120.226.190/selenium-demo/git-repo/");//��ת����λ��ҳ
				WebElement element_name = driver.findElement(By.name("user_number")); //��ȡѧ��������Ԫ��
				element_name.clear();//���������������
				element_name.sendKeys(StudentID); //��ѧ�����������õ���ѧ��
				WebElement element_pwd = driver.findElement(By.name("password")); //��ȡ����������Ԫ��
				element_pwd.clear();
				element_pwd.sendKeys(PassWord);
				WebElement element_submit = driver.findElement(By.cssSelector(".btn.btn-primary.btn-user.btn-block")); //��ȡ�ύ��ť
				element_submit.click(); //����ύ��ť

				//��ȡ��¼����ҳ����ʾ��github��ַ����ҳԪ��
				String text = driver.findElement(By.cssSelector(".mb-2+.mb-2")).getText();
				System.out.println(text);
				//������������ݺ���ҳ�϶�ӦԪ�ص�������ȣ�����Ϣһ�£�������Ϣ��һ��
				if (PassWord.equals(text))	{
					System.out.println("��Ϣһ��");
					objects[row][0]= true;
					objects[row][1]=true;
				}
				else {
					System.out.println("��Ϣ��һ��");
					objects[row][0]= false;
					objects[row][1]=true;
				}
                
			}
			driver.close();
			return objects;
		}

}
