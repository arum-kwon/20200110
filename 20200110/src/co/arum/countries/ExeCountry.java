package co.arum.countries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExeCountry {
	Scanner sc = new Scanner(System.in);
	CountryServiceImpl counImpl = new CountryServiceImpl();

	public void mainMenu() {
		
		boolean run = true;
		while (run) {
			System.out.println("------------------[County정보]------------------");
			System.out.println("1.전체조회 | 2.선택조회 | 3.추가 | 4.수정 | 5.삭제 | 6.종료");
			System.out.println("-----------------------------------------------");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				exeAllSelect();
				break;
			case 2:
				exeSelect();
				break;
			case 3:
				exeInsert();
				break;
			case 4:
				exeUpdate();
				break;
			case 5:
				exeDelete();
				break;
			case 6:
				run = false;
				break;
			default:
				System.out.println("정확하게 입력해주십시오.");
				break;
			}
		}
		System.out.println("종료");
	}

	public void exeAllSelect() {
		List<CountryDto> list = new ArrayList<CountryDto>();

		list = counImpl.allSelect();
		toPrint(list);
	}

	public void exeSelect() {
		CountryDto dto = new CountryDto();

		System.out.print("검색할 CountryID 입력 : ");
		dto.setCountry_id(sc.nextLine());
		dto = counImpl.select(dto);
		if (dto != null) {
			toPrint(dto);
		}
	}

	public void exeInsert() {
		CountryDto dto = new CountryDto();

		exeAllSelect();
		System.out.print("추가 ID: ");
		dto.setCountry_id(sc.nextLine());
		System.out.print("Country Name: ");
		dto.setCountry_name(sc.nextLine());
		System.out.print("Region ID(1:Europe/2:Americas/3:Asia/4:Middle East and Africa): ");
		dto.setRegion_id(sc.nextInt());
		sc.nextLine();
		int result = counImpl.insert(dto);
		printResult(result);
	}

	public void exeUpdate() {
		CountryDto dto = new CountryDto();

		exeAllSelect();
		System.out.print("변경할 ID: ");
		dto.setCountry_id(sc.nextLine());
		dto = counImpl.select(dto);
		if (dto != null) {
			toPrint(dto);
		}
		System.out.print("변경 Country Name: ");
		dto.setCountry_name(sc.nextLine());
		System.out.print("변경 Region ID(1:Europe/2:Americas/3:Asia/4:Middle East and Africa): ");
		dto.setRegion_id(sc.nextInt());
		sc.nextLine();

		int result = counImpl.update(dto);
		printResult(result);
	}

	public void exeDelete() {
		CountryDto dto = new CountryDto();

		exeAllSelect();
		System.out.print("삭제할 ID: ");
		dto.setCountry_id(sc.nextLine());

		int result = counImpl.delete(dto);
		printResult(result);
	}

	public void toPrint(List<CountryDto> list) {
		for (CountryDto dto : list) {
			System.out.print(dto.getCountry_id() + " | ");
			System.out.print(dto.getCountry_name() + " | ");
			System.out.print(dto.getRegion_id() + "\n");
		}
	}

	public void toPrint(CountryDto dto) {
		System.out.print(dto.getCountry_id() + " | ");
		System.out.print(dto.getCountry_name() + " | ");
		System.out.print(dto.getRegion_id() + "\n");
	}
	
	public void printResult(int result) {
		if (result == 0) {
			System.out.println("DO NOT");
		} else {
			System.out.println("COMPLET");
			exeAllSelect();
		}
	}
}
