package co.arum.dowhile;

import java.util.Scanner;

import co.arum.countries.ExeCountry;
import co.rum.hr.employees.EmployeeDisplay;

public class Menu {
	/* 1.직원관리 2.급여관리 3.부서관리 4.종료
	 * 
	 * [직원관리]
	 * 1.조회 2.등록 3.수정 4.삭제 5.돌아가기
	 * [급여관리]
	 * 1.조회 2.등록 3.수정 4.삭제 5.돌아가기
	 * [부서관리]
	 * 1.조회 2.등록 3.수정 4.삭제 5.돌아가기
	 * */
	Scanner sc = new Scanner(System.in);
 	public void mainMenu() {
 		int choice;
 		boolean b = true;
 		do {
 			System.out.println("--------MAIN-------");
 			System.out.println("    1. 직 원 관 리 ");
 			System.out.println("    2. 급 여 관 리 ");
 			System.out.println("    3. 부 서 관 리 ");
 			System.out.println("    4.  종   료  ");
 			System.out.println("------------------");
 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 			choice = sc.nextInt();
 			sc.nextLine();
 			switch(choice) {
 			case 1:
 				employeeMenu();
 				break;
 			case 2:
 				salaryMenu();
 				break;
 			case 3:
 				departmentMenu();
 				break;
 			case 4:
 				b=false;
 				break;
 			default:
 				System.out.println("제대로 입력하십시오");
 			}
 		}while(b);
 		System.out.println("...\n...\n...종료");
	}
	
	public void employeeMenu() {
		int choice;
 		boolean b = true;
 		EmployeeDisplay empDis = new EmployeeDisplay();
 		
 		do {
 			System.out.println("=======================직원 관리==================");
 			System.out.println("1.직원조회 | 2.직원등록 | 3.직원갱신 | 4.직원삭제 | 5.돌아가기");
 			System.out.println("===============================================");
 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 			choice = sc.nextInt();
 			sc.nextLine();
 			switch(choice) {
 			case 1:
 				System.out.println("조회");
 				empDis.allSelectList();
 				break;
 			case 2:
 				System.out.println("등록");
 				empDis.employeeInsert();
 				break;
 			case 3:
 				System.out.println("갱신");
 				empDis.employeeUpdate();
 				break;
 			case 4:
 				System.out.println("삭제");
 				empDis.employeeDelete();
 				break;
 			case 5:
 				b=false;
 				break;
 			default:
 				System.out.println("제대로 입력하십시오");
 			}
 		}while(b);
 		System.out.println("...돌아갑니다");
	}
	
	public void salaryMenu() {
		int choice;
 		boolean b = true;
 		do {
 			System.out.println("=======================급여 관리==================");
 			System.out.println("1.급여조회 | 2.급여등록 | 3.급여갱신 | 4.급여삭제 | 5.돌아가기");
 			System.out.println("===============================================");
 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 			choice = sc.nextInt();
 			sc.nextLine();
 			switch(choice) {
 			case 1:
 				System.out.println("조회");
 				break;
 			case 2:
 				System.out.println("등록");
 				break;
 			case 3:
 				System.out.println("갱신");
 				break;
 			case 4:
 				System.out.println("삭제");
 				break;
 			case 5:
 				b=false;
 				break;
 			default:
 				System.out.println("제대로 입력하십시오");
 			}
 		}while(b);
 		System.out.println("...돌아갑니다");
	}
	
	public void departmentMenu() {
		int choice;
 		boolean b = true;
 		ExeCountry exeCountry= new ExeCountry();
 		
 		do {
 			System.out.println("=======================부서 관리==================");
 			System.out.println("1.부서조회 | 2.부서등록 | 3.부서갱신 | 4.부서삭제 | 5.돌아가기");
 			System.out.println("===============================================");
 			System.out.print("> 원하는 작업을 선택하십시오 : ");
 			choice = sc.nextInt();
 			sc.nextLine();
 			switch(choice) {
 			case 1:
 				System.out.println("조회");
 				exeCountry.exeAllSelect();
 				break;
 			case 2:
 				System.out.println("등록");
 				exeCountry.exeInsert();
 				break;
 			case 3:
 				System.out.println("갱신");
 				exeCountry.exeUpdate();
 				break;
 			case 4:
 				System.out.println("삭제");
 				exeCountry.exeDelete();
 				break;
 			case 5:
 				b=false;
 				break;
 			default:
 				System.out.println("제대로 입력하십시오");
 			}
 		}while(b);
 		System.out.println("...돌아갑니다");
	}
}
