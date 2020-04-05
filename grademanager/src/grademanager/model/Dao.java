package grademanager.model;

import static grademanager.resource.R.*;

public class Dao {

	Dto[] dArr = new Dto[MAX];
	int top = 0;
	int seq = 1;

	private static Dao instance;

	public static Dao getInstance() {
		if (instance == null) {
			instance = new Dao();
		}
		return instance;
	}

	public void create(Dto dto) {

		if (top >= MAX) {
			System.out.println("저장할 공간이 없습니다!");
			return;
		}
		dto.setIdx(seq++);
		dArr[top++] = dto;
	}

	public void update(Dto dto) {

		for (int i = 0; i < top; i++) {
			if (dArr[i].getIdx() == dto.getIdx()) {
				dArr[i].setIdx(dto.getIdx());
				dArr[i].setName(dto.getName());
				dArr[i].setKor(dto.getKor());
				dArr[i].setMath(dto.getMath());
				dArr[i].setEng(dto.getEng());
				dArr[i].setTotal();
				dArr[i].setAvg();
				dArr[i].setGrade();
				return;
			}
		}

	}

	public void delete(Dto dto) {
		for (int i = 0; i < top; i++) {
			if (dArr[i].getIdx() == dto.getIdx()) {
				for (int j = i; j < top - 1; j++) {
					dArr[j] = dArr[j + 1];
				}
			}
		}
		top--;
	}

	public Dto[] readAll() {
		Dto[] arr = new Dto[top];
		for (int i = 0; i < top; i++) {
			Dto d = new Dto();
			d.setIdx(dArr[i].getIdx());
			d.setName(dArr[i].getName());
			d.setKor(dArr[i].getKor());
			d.setMath(dArr[i].getMath());
			d.setEng(dArr[i].getEng());
			d.setTotal();
			d.setAvg();
			d.setGrade();
			d.setRank(dArr[i].getRank());
			arr[i] = d;
		}
		return arr;
	}

	public Dto[] readSome(Dto dto) {
		Dto[] tmpArr = new Dto[top];
		int cnt = 0;
		for (int i = 0; i < top; i++) {
			if (dArr[i].getName().toUpperCase().equals(dto.getName().toUpperCase())) {
				Dto d = new Dto();
				d.setIdx(dArr[i].getIdx());
				d.setName(dArr[i].getName());
				d.setKor(dArr[i].getKor());
				d.setMath(dArr[i].getMath());
				d.setEng(dArr[i].getEng());
				d.setTotal();
				d.setAvg();
				d.setGrade();
				d.setRank(dArr[i].getRank());
				tmpArr[cnt++] = d;
			}
		}
		Dto[] arr = new Dto[cnt];
		for (int i = 0; i < cnt; i++) {
			Dto d = new Dto();
			d.setIdx(tmpArr[i].getIdx());
			d.setName(tmpArr[i].getName());
			d.setKor(tmpArr[i].getKor());
			d.setMath(tmpArr[i].getMath());
			d.setEng(tmpArr[i].getEng());
			d.setTotal();
			d.setAvg();
			d.setGrade();
			d.setRank(tmpArr[i].getRank());
			arr[i] = d;
		}

		return arr;
	}

	public void rank() {
		int[] rankArr = new int[top];
		for (int i = 0; i < top; i++) {
			rankArr[i] = dArr[i].getTotal();
		}
		for (int i = 0; i < top - 1; i++) {
			for (int j = i + 1; j < top; j++) {
				if (rankArr[i] < rankArr[j]) {
					int tmp = rankArr[i];
					rankArr[i] = rankArr[j];
					rankArr[j] = tmp;
				}
			}
		}

		for (int i = 0; i < top; i++) {
			for (int j = 0; j < rankArr.length; j++) {
				if (dArr[i].getTotal() == rankArr[j]) {
					dArr[i].setRank(j + 1);
					break;
				}
			}
		}

	}
	
	public Dto[] sort() {
		Dto[] arr = new Dto[top];
		for (int i = 0; i < top; i++) {
			Dto d = new Dto();
			d.setIdx(dArr[i].getIdx());
			d.setName(dArr[i].getName());
			d.setKor(dArr[i].getKor());
			d.setMath(dArr[i].getMath());
			d.setEng(dArr[i].getEng());
			d.setTotal();
			d.setAvg();
			d.setGrade();
			d.setRank(dArr[i].getRank());
			arr[i] = d;
		}
		for (int i = 0; i < top - 1; i++) {
			for (int j = i + 1; j < top; j++) {
				if (arr[i].getRank() > arr[j].getRank()) {
					Dto tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		
		return arr;
	}
	
	

}
