# 토비의 스프링부트 이해와 원리 강의를 보고 정리
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

- 아래 HelloService 인터페이스를 구현하고 있는 구현체는 SimpleHelloService 1개만 존재한다.<br>
  단독으로 존재하는 경우 코드상에서 구현체를 지정하지 않아도 자동으로 단독구현체를 주입해준다. (=AutoWired) <br>
  단, SimpleHelloService 는 Bean으로 등록되어있어야 한다. (@Service로 등록)
- 만일 인터페이스 구현체가 2개 이상일 때는 @Primary 를 우선순위인 구현체에 사용해서 명시해야한다.
<img src="https://user-images.githubusercontent.com/103364805/214223781-42a4cfb6-93b2-4b65-a3b6-cfd7f02fcd4e.png"  width="650" height="250">


- 메타 에노테이션 추가하기<br>
  @Test 를 메타 에노테이션을 추가하기 -> @FastUnitTest 어노테이션을 생성해서 빠른단위테스트 라는 의미로 테스트 코드로 사용하기<br>
  @Retention 과 @Target을 이용해서 어노테이션을 생성할 수 있으며, @Test 역할을 해야하기 때문에 추가한다.<br>
  @UnitTest 를 기준으로 메타 에노테이션을 생성하기 위해 @Target에 ANNOTATION_TYPE 을 추가하면 또 다른 메타 에노테이션을 생성할 수 있다.
<img src="https://user-images.githubusercontent.com/103364805/214231317-5ec52504-8c3c-40c7-a044-cb2d76342614.png"  width="400" height="450">

- 구성정보(config) 관련된 파일이 같은 패키지 밖에 있다면 @Import를 사용해서 적용시킬 수 있다.
