# 토비의 스프링부트 이해와 원리 강의를 보고 정리한 내용입니다.
핵심 내용을 정리했습니다.

### Request 
- Request Line: Method, Path, HTTP Version
- Header
- Message Body

### Response
- Status Line: HTTP Version, Status Code, Status Text
- Headers
- Message Body

<img src="https://user-images.githubusercontent.com/103364805/213848646-da1ded08-db25-43ad-957a-a8ad9af7cf09.png"  width="550" height="350">
<br>

### DI (Dependency Injection)
DI 는 의존성 주입입니다.<br>
HelloController 는 HelloService 의 구체적인 클래스를 바라보는 것이 아닌, 추상화(인터페이스) 를 바라보고 있습니다.<br>
따라서, 런타임시에는 SimpleHelloService를 사용할건지, ComplexHelloService 를 사용할건지 정해주어야 합니다.<br>
SimpleHelloBean을 사용하기로 했다면 Bean으로 등록을 하고 DI를 진행합니다<br>
의존성 주입을 해주기 위한 방법은 크게 3가지가 있습니다.<br>
1.생성자 주입 2. Setter주입 3.필드 주입이 있으며, 대표적으로 생성자 파라미터 주입을 사용합니다.<br>

<img src="https://user-images.githubusercontent.com/103364805/213906266-a31ad5ae-acc0-4fd5-a661-d8f076669f26.png"  width="550" height="350">
