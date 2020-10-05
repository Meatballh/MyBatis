package cn.edu.xit.entity;

import java.io.Serializable;

public class Student implements Serializable {
	private int stuNo;
	private String stuName;
	private int stuAge;
	private String graName;
	private boolean stuSex;
	private StudentCard card;
	
	public StudentCard getCard() {
		return card;
	}

	public void setCard(StudentCard card) {
		this.card = card;
	}






	private Address address;//家庭和学校
	
	public Student() {
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Student(int stuNo, String stuName, int stuAge, String graName,
			boolean stuSex) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.graName = graName;
		this.stuSex = stuSex;
	}

	public Student(int stuNo, String stuName, int stuAge, String graName) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.graName = graName;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getGraName() {
		return graName;
	}
	public void setGraName(String graName) {
		this.graName = graName;
	}

	public boolean isStuSex() {
		return stuSex;
	}

	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
	}






	@Override
	public String toString() {
		//return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", stuAge="+ stuAge + ", graName=" + graName + ", stuSex=" + stuSex + "]";
		return stuNo+"-"+this.stuNo+"-"+this.stuName+"-"+this.stuAge+"-"+this.card.getCardId()+"-"+this.card.getCardInfo();
	}
	
	
	
}
