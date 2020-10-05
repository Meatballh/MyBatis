package cn.edu.xit.entity;

public class StudentBusiness extends Student{//学生扩展类
	private int cardId;
	private String cardInfo;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(String cardInfo) {
		this.cardInfo = cardInfo;
	}

	@Override
		public String toString() {
			return super.toString()+','+this.cardId+','+this.cardInfo;
		}
}
