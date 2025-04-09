# cafe-orders

카페 주문 금액 계산 프로그램 리팩터링

## 요구사항

- 아래 메뉴판을 가진 간단한 카페의 주문 시스템을 개선한다.

| 메뉴명   | 가격   |
|-------|------|
| 아메리카노 | 1500 |
| 라떼    | 2000 |
| 모카    | 2500 |
| 크로와상  | 3000 |

- 사용자는 메뉴와 개수를 입력하여 주문을 할 수 있다.
- 주문을 마친 후 총액을 계산하여 알려준다.
- 프로모션을 적용할 수 있다.
  - 대형 손님 환영: 음료를 5잔 이상 주문하면, 전체 음료 가격에서 10% 할인
  - 아메리카노 할인: 아메리카노 1잔 당 300원 할인

## 수정 전략

- 존재하지 않는 메뉴가 음료 개수를 셀 때 포함된다! -> 존재하지 않는 메뉴는 미리 제외한다.
- 특정 메뉴의 수량이 0 이하일 경우에도 전체 가격 계산에 포함된다! -> 수량이 0 이하인 메뉴는 미리 제외한다.

## 리팩터링 전략

- `calculateTotalPrice()` 메서드의 호흡이 너무 길다.
  - 필터링하는 기능, 총가격 구하는 기능, 할인 등의 역할이 혼재되어 있다.
  - **큰 흐름별로 메서드를 나누어 가독성을 향상시키자!**
- 가능한 아이템들의 종류, 아이템의 가격등을 `CafeOrder`에서 처리하는 것은 책임에 맞지 않다.
  - `CafeOrder`의 책임은 문제있는 주문들을 필터링하고, 적절한 할인을 적용하는 것이라 생각
  - **`CafeItems` 같은 객체에게 역할을 위임하자!**
- 거의 모든 기능이 `String`을 기반으로 동작하고 있다.
  - 해당 객체에게 책임을 추가할 수 없으니 `CafeOrder`가 많은 책임을 지고 있다.
  - **`CafeItems`를 기반으로 동작하게 하고, `CafeItems`에게 책임을 위임하자!**
- 거의 모든 기능이 배열을 기반으로 동작하고 있다.
  - 크기가 변하지 않고, 기능이 부실해 코드가 장황해지고 있다.
  - **컬렉션을 기반으로 동작하게 하여 읽기 좋은 코드를 만들자!**
- 거의 모든 기능이 `for`문을 기반으로 동작하고 있다.
  - **스트림을 활용하여 가독성을 늘리자!**
- 아이템과 개수가 분리되어 있어 코드가 불완전하다.
  - 두 배열의 크기가 다르면?, 실수로 다른 인덱스로 접근하면? 등의 문제가 존재한다.
  - **둘을 묶는 객체를 사용하여 안정성을 늘리자!**
  - 이러면 `Order` 에게 역할을 더 많이 넘겨줄 수 있다.
- 아메리카노 할인이 코드에 드러나지 않는다.
  - **처음에 아메리카노 300원 할인하는 것을 드러낸다!**
- 여러 매직넘버가 사용되고 있다.
  - **상수로 만들면서 이름을 부여하여 명시적으로 드러낸다!**
- 추후에 추가/제거될 할인 정책에 대한 유연성이 부족하다.
  - **할인 정책을 유연하게 추가/제거하도록 추상화한다!**
