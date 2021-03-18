# HiddenPlace

Q1.

다음 코드를 아래 조건에 맞게 개선 하세요.

- Template method 패턴을 이용하여 할인 금액을 하위 클래스에서 정의 할 수 있도록 개선 하세요.
- 기존 Coupon 클래스는 500원 할인 쿠폰만을 처리하고 있습니다.
- 기존 Coupon 클래스는 수정 할 수 없으며 새로 만들거나 상속 해야 합니다.
- Main 메서드는 사용 예시이므로 작성하지 않아도 됩니다.
- 500원 할인 쿠폰과 5%할인 쿠폰 Class 를 각각 정의하세요. 


public class Coupon {
    int price;

    public Coupon(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Coupon coupon = new Coupon(1000);
        int dp= coupon.getDiscountPrice();
        coupon.order(dp);
    }

    public final void order(int discountPrice) {
        validate(discountPrice);
        pay(discountPrice);
    }

    private final void pay(int discountPrice) {
        // do something
    }

    private final void validate(int discountPrice) {
        // do something
    }

    protected int getDiscountPrice() {
        return 500;
    }
}

답변을 작성해주십시오.

Q2.

int 형 숫자를 하나 입력받아 1인 비트 개수를 세는 매서드를 작성하세요.
단 Integer.toBinaryString 또는 Interger.toString 함수를 사용하지 않고 구현합니다.

Ex) 입력 7 -> 0111 
결과 : 3


public static int countBits(int number){





     //이곳에 해당하는 코드를 작성하시요.






}
