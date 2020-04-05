package grademanager.model;

public class Dto {

	private int idx;

	private String name;
	private int kor;
	private int math;
	private int eng;
	private int total;
	private double avg;
	private String grade;
	private int rank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = this.kor + this.eng + this.math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg() {
		this.avg = Math.round((this.total / 3.0)*100)/100.0;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade() {
		switch ((int) (this.avg / 10)) {
		case 10:
			this.grade = "A";
			break;
		case 9:
			this.grade = "A";
			break;
		case 8:
			this.grade = "B";
			break;
		case 7:
			this.grade = "C";
			break;
		case 6:
			this.grade = "D";
			break;
		default:
			this.grade = "F";
		}
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "["+idx + "\t" + name + "\t" + kor + "\t" + math + "\t" + eng + "\t"
				+ total + "\t" + avg + "\t" + grade + "\t" + rank + "\t]";
	}
	
	

}
