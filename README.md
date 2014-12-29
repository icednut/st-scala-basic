3장. 스칼라 두 번째 걸음
==================
<pre>
콘즈 연산자 (::)
 ㄴ 콘즈 연산자의 호출 대상 객체는 콜론(:) 바로 뒤의 객체이다.

리스트 뒤에 원소를 추가하는 효율적인 방법
 ㄴ 리스트를 뒤집는다 (reverse) -&gt; 콘즈 연산자로 맨 앞에 요소 추가 -&gt; 다시 뒤집는다.
 ㄴ 이렇게 하는 이유: 리스트 뒤에 원소를 추가하는 연산은 리스트의 길이에 비례한 시간이 걸리기 때문, 반면 콘즈 연산자는 상수 시간이 걸린다.

튜플
 ㄴ 각기 다른 타입의 원소를 담을 수 있는 컬렉션
 ㄴ 튜플에는 동시에 문자열과 정수를 함께 넣을 수 있다.
 ㄴ 단, 튜플의 원소를 리스트의 원소와 같이 접근할 수 는 없다.
 ㄴ 반드시 ._N 으로 접근 (또 N은 0이 아니라 1부터 시작)

집합과 맵

함수형으로 한 걸음 더 나아가는 방법은 var를 사용하지 않고 프로그램하려 노력하는 것이다.
스칼라는 val을 더 많이 사용하도록 권한다.

스칼라 프로그래머의 균현 잡힌 태도
val, 변경 불가능한 객체, 부수 효과가 없는 메소드를 더 많이 사용하라. 먼저 그런 접근 방법을 먼저 시도해보라. var나 변경 가능 객체나 부수 효과가 있는 메소드를 사용해야 할 구체적인 필요성이 있고 그런 이유를 정당화할 수 있는 경우에만 var, 변경 가능성, 부수 효과를 활용하라.
</pre>

4장. 클래스와 객체
==================
<pre>
클래스 (class)
 ㄴ 스칼라의 기본 접근 수준은 전체 공개다.
 ㄴ 메소드 파라미터는 항상 val 이다. (재할당 시 Compile error)
 ㄴ 메소드 마지막에는 명시적으로 return을 사용하지 않아도 맨 나중에 계산한 값을 반환한다.
 ㄴ 메소드 작성 시 권한하는 스타일은 return을 명시적으로 사용하지 않는 것, 특히 여러 번 사용하지 않는 것이다. 대신 각 메소드가 한 값을 계산하는 표현식인 것 처럼 생각하라. 이렇게 계산한 값이 바로 메소드의 반환 값이다. 이런 철학을 가지고 코딩하면, 메소드를 아주 작게 유지하고 커다란 메소드를 더 작은 여러 메소드로 나누게 된다. 다만 환경에 따라 다르므로 명시적으로 return을 사용할 수 는 있다.
 ㄴ 스칼라 클래스에는 정적(static) 멤버가 없다. 대신 싱글톤 객체를 제공한다.

싱글톤 객체 (object)
 ㄴ 어떤 싱글톤 객체의 이름이 어떤 클래스와 같을 때, 그 객체를 클래스의 동반 객체(companion object)라고 한다. 다만, 클래스와 동반 객체는 반드시 같은 소스 파일 안에 정의해야 한다. 이때 역으로 해당 클래스를 싱글톤 객체의 동반 클래스(companion class)라 부른다. 클래스와 동반 객체는 상대방의 비공개 멤버에 접근할 수 있다.
 ㄴ 자바 프로그래머라면 싱글톤을 자바의 정적 메소드를 담아두는 집처럼 생각하는 것도 한 가지 방법이다. 싱글톤 객체의 메소드도 정적 메소드와 비슷한 방식으로 호출할 수 있다.
 ㄴ 싱글톤 객체 정의는 타입을 정의하지 않는다. 따라서 싱글톤 객체 정의만 있다면 해당 타입의 객체를 만들 수 없다. (싱글톤은 new로 인스턴스화 할 수 없다.) 이 때는 동반 클래스를 정의해야만 해당 타입의 객체를 만들 수 있다.
 ㄴ 클래스와 싱글톤 객체의 한 가지 차이는 싱글톤 객체는 파라미터를 받을 수 없고 클래스는 받을 수 있다는 점이다. 싱글톤은 new로 인스턴스화할 수 없기 때문에 파라미터를 싱글톤에 넘길 방법이 없다.
 ㄴ 컴파일러는 각 싱글톤 객체를 합성한 클래스(synthetic class)의 인스턴스로 구현하고, 이를 정적 변수가 참조한다.
 ㄴ 동반 클래스가 없는 싱글톤 객체를 독립 개체라고도 한다.
 ㄴ 독립 객체의 활용법은 필요한 도구 메소드를 한데 모아두거나(java의 util 클래스), 스칼라 애플리케이션의 진입점을 만들 때 사용할 수 있다.
 ㄴ 자바에서는 public class를 그 클래스 이름과 같은 이름의 파일에 저장해야 하지만, 스칼라에서는 원하는 대로 .scala로 끝나는 파일 이름을 정할 수 있다는 점이다. 그 파일 안에는 마음대로 아무 클래스나 코드를 넣을 수 있다. 하지만 스크립트가 아닌 경우 자바와 마찬가지로 파일에 들어갈 클래스 이름을 따라 파일 이름을 짓는 것을 권장한다.
 ㄴ .scala 파일 안에 정의만 들어있는 것은 스크립트가 아니다. 스크립트는 결과를 계산하는 표현식이 끝에 와야만 한다. 114쪽 참조

참고
 ㄴ 스칼라는 항상 java.lang과 scala 패키지의 멤버를 암시적으로 임포트한다. 또한 scala 패키지에 있는 Predef라는 싱글톤 객체의 멤버도 항상 임포트 한다. Predef에는 유용한 메소드가 많이 있으며, println도 실제로는 Predef의 println을 호출하는 것이다. (Predef.println은 다시 Console.println을 호출하고, 그 메소드가 실제 출력을 수행한다.) assert를 사용할 때도 역시 Predef.assert를 사용하는 것이다.
 ㄴ fsc (fast scala compiler)
</pre>

5장. 기본 타입과 연산
====================
<pre>
Int
 ㄴ 16진수: 0x로 시작할 경우
 ㄴ 8진수: 0 으로 시작할 경우
 ㄴ 10진수: 0이 아닌 숫자로 시작하고 그 밖의 추가 장식이 없을 경우

Long
 ㄴ 정수 리터럴이 L이나 l로 끝나면 Long
 ㄴ 끝에 아무것도 없으면 Int 이다.

Double, Float
 ㄴ 부동소수점 리터럴이 F나 f로 끝나면 그 수는 Float 타입
 ㄴ 그렇지 않는 부동소수점 리터럴은 Double

Char
 ㄴ 작은 따옴표 안에 유니코드 문자를 넣은 문자 리터럴을 지칭

심볼 리터럴

연산자
 ㄴ 리터럴 비교 뿐만 아니라 객체 및 객체 필드 값 비교까지 가능
 ㄴ 자동으로 null을 체크하기 때문에 직접 null을 검사할 필요가 없다.
</pre>

6장. 함수형 객체
====================
<pre>
여기서는 좀 더 완전한 기능을 갖춘 스칼라 클래스 작성법을 알아본다.
변경 가능한 상태를 전혀 갖지 않는 함수형 객체 (functional object)을 다룬다.

변경 불가 분수 클래스(Rational)을 만들어보자

class Rational(n: Int, d: Int)

클래스 이름인 Rational 뒤에 괄호가 오고, 그 안에 n과 d라는 식별자가 있다.
이를 클래스 파라미터 라고 부른다. 스칼라 컴파일러는 내부적으로 두 클래스 파라미터를 종합해서, 클래스 파라미터와 같은 두 인자를 받는 주 생성자 (primary constructor)를 만든다.

class Rational(n: Int, d: Int) {
    println(“Created “ + n + “/“ + d)
}

스칼라 컴파일러는 println을 호출하는 위 코드를 Rational 클래스의 주 생성자(primary constructor)에 넣는다.
n과 d가 클래스 내부에서 쓰이긴 했지만 생성자 내부에서만 쓰이는 경우 스칼라 컴파일러는 그들에 해당하는 필드를 생성하지 않는다.
주 생성자(primary constructor)는 클래스의 유일한 진입점이다.

override
 ㄴ 8장에서 다시 언급

require
 ㄴ 전제 조건을 만들 때 사용
 ㄴ require 메소드는 인자로 불리언 값을 하나 받는다. 이 값이 참(true)이면 require 문이 정상적으로 끝나고 다음으로 진행, 아니라면 IllegalArgumentException 발생

필드 추가

자기 참조

보조 생성자
 ㄴ 하나의 클래스에 여러 생성자가 필요한 경우 보조 생성자를 사용하자!
 ㄴ 스칼라에서는 주 생성자가 아닌 다른 생성자는 보조 생성자(auxiliary constructor)라고 부른다.
 ㄴ 스칼라에서 보조 생성자는 def this(...)로 시작한다.
 ㄴ 스칼라에서 모든 보조 생성자는 반드시 같은 클래스에 속한 다른 생성자를 호출하는 코드로 시작해야 한다. (모든 보조 생성자의 첫 구문은 this(...)여야 한다.)

비공개 필드와 메소드

연산자 정의
 ㄴ 스칼라에서는 연산자도 메소드
 ㄴ 그러므로 클래스의 멤버로 연산자 메소드 추가가 가능

스칼라의 식별자

메소드 오버로드
 ㄴ 이 부분은 java와 비슷한 것 같다.

암시적 타입 변환
 ㄴ implicit def intoRational(x: Int) = new Rational(x)
 ㄴ 가능하면 21장에서 다루는 다른 암시 기법을 활용하는 것이 좋다.
</pre>

7장. 내장 제어 구문
===================
<pre>
- 스칼라가 제공하는 내장 제어구문: if, while, for, try, match, function call
- 스칼라의 제어 구문 수가 적은 이유는 설계 초기 함수 리터럴을 포함했기 때문, 제어 구문 위에 다른 제어 구문을 하나하나 추가하기 보다는, 라이브러리에 제어 구문을 추가하는 편을 택함
- 스칼라의 제어구문은 대부분 어떤 값을 결과로 내놓는다. 이는 프로그램 전체를 값을 계산하는 관점에서 바라보고, 프로그램 구성요소 또한 값을 도출해야 한다는 함수 언어적 접근을 채용한 결과다.
- java와 스칼라의 차이점은 for, try, match가 값을 반환한다는 것에 있다. 스칼라는 제어구문들이 결과 값을 반환하기 때문에 임시변수가 필요 없다. 임시 변수를 만들어 계산한 값을 저장하는 과정이 없어지기 때문에 여러 가지 버그를 방지해준다. (Wow!!)

if 표현식
 ㄴ 스칼라의 if는 다른 여러 언어와 마찬가지로 동
 ㄴ if 표현식은 값을 내놓기 때문에 임시 변수를 없앨 수 있다. (java 에서도 리터럴을 그냥 바로 리턴하면 동일한거 아닌가?)

var filename = "default.txt"
if (!args.isEmpty)
    filename = args(0)

val filename = if (!args.isEmpty) args(0) else "default.txt"

여기서 중요한 것은 filename을 var가 아닌 val로 선언했다는 것이다. (함수적 스타일)
val을 사용함으로서 그 변수의 값이 결코 바뀌지 않음을 알려주고, 해당 변수의 값이 바뀌었는지를 찾아보기 위해 코드에서 그 변수의 모든 스코프를 다 뒤지는 일이 없게 해준다! (Wow!! @.@)

while 루프
 ㄴ 여타 언어와 마찬가지로 동작
 ㄴ condition이 참인 동안 본문을 반복 수행
 ㄴ while과 do-while이 이루는 구조는 수행 결과가 특정 값을 반환하는 것이 아니기 때문에 표현식이라 하지 않고 '루프'라 부른다.
 ㄴ 루프의 결과는 타입이 Unit 이다.
 ㄴ 일반적으로, while 루프는 var 변수와 마찬가지로 최대한 이를 적게 사용하기 위해 노력할 것을 권장한다. (p.166)

Unit 타입
 ㄴ 유니트 값(unit value) 밖에 없고, 이 값은 빈 괄호로 표기한다.
 ㄴ ()라는 값이 존재한다는 점에서 자바의 void와 스칼라의 Unit는 다르다.
 ㄴ println("hi") == () // true

for 표현식
 ㄴ 스칼라의 for 표현식은 반복 처리를 위한 스위스 군용 만능 칼이라 할 수 있다. (맥가이버 칼이라고 쓰면 뭐라 할까봐 이렇게 표현한건가...-_-)

val files = (new java.io.File(".")).listFiles
for (file &lt;- files)
    println(file)

for (i &lt;- 1 to 4)
    println(i)
// 1, 2, 3, 4

for (i &lt;- 1 until 4)
    println(i)
// 1, 2, 3

이와 같이 스칼라에서는 간단하게 컬렉션을 직접 순회할 수 있다.
컬렉션을 직접 순회하면 코드도 더욱 짧아지고 배열을 순회하면서 인덱스를 잘못 처리해 발생할 수 있는 실수를 피할 수 있다.
인덱스를 0에서 시작할지, 1에서 시작할지, +1을 더할지, -1을 더할지, 마지막 순회에서 특별한 처리는 안해도 되는지 이런 질문을 아예 피할 수 있어 안전한 코드를 작성할 수 있다.
(와....대박 ㅜㅜ 근데 순서대로 순회한다는 보장은 있겠지? javascript의 for in 구문처럼 뒤통수 칠 일은 없어야 할텐데...)

필터링 (ㅜㅜ)
 ㄴ for 표현식을 통해 컬렉션 순회 시 전체 컬렉션에서 일부만 사용하고 싶은 경우 사용
 ㄴ for 표현식에 필터(fileter)를 추가하면 가능하다.
 ㄴ 혹시 필터를 메소드로 뺄 수는 없을까? 조건이 많아지면 필터가 복잡해질 것 같은데...

val files = (new java.io.File(".")).listFiles
for (file &lt;- files if file.getName.endsWith(".scala"))
     println(file)

// 같은 목적의 코드
for (file &lt;- files) {
     if (file.getName.endsWith(".scala"))
         println(file)
}

여러 개의 필터 적용
for(file &lt;- files
   if file.isFile
   if file.getName.endsWith(".scala")
) println(file)

중첩 순회
 ㄴ 여러 개의 제네레이터절을 추가하면 중첩 루프를 작성할 수 있다.
 ㄴ 원한다면 괄호 대신 중괄호를 사용해 제네레이터와 필터를 감쌀 수 있다.

for 중에 변수 바인딩하기
 ㄴ 필터링 부분에 변수를 선언할 수도 있다. (이 때 변수 선언은 val이나 var를 생략해도 된다.)

새로운 컬렉션 만들어내기 (for-yeild 표현식)
 ㄴ for 표현식의 반복 결과를 저장하기 위한 값을 만들어 리턴하고자 할 때 사용
 ㄴ for 표현식의 본문 앞에 yield라는 키워드를 사용하면 된다.
</pre>

8장. 함수와 클로저
===================
<pre style="word-wrap: break-word">
스칼라에서는 함수 안에 함수를 정의할 수 있다.

1급 계층 함수 (first class function)
 ㄴ 함수를 정의하고 호출할 뿐만 아니라, 이름 없이 리터럴로 표기해 값처럼 주고 받을 수 있다. (함수 값은 객체)
 ㄴ 함수 리터럴의 본문에 둘 이상의 문장이 필요하다면 본문을 중괄호로 감싸서 블록으로 만든다.
 ㄴ (x: Int) =&gt; x + 1
 ㄴ =&gt; 기호는 왼쪽의 내용(x)을 오른쪽의 내용(x + 1)으로 변환하는 함수라는 표시. (위 코드는 정수 x를 x + 1로 매핑하는 함수를 의미)
 
타깃 타이핑(target typing)
 ㄴ 함수 리터럴을 좀 더 간단하게 만든느 방법은 함수 리터럴의 인자 타입을 제거하는 것이다.
 ㄴ 스칼라 컴파일러가 컴파일 타임에 인자 타입을 아는 것을 말한다.
 ㄴ 타입 추론으로 인하여 인자를 둘러싼 괄호도 생략할 수 있다.
 ㄴ x =&gt; x + 1

위치 표시자 (_)
 ㄴ 함수 리터럴의 파라미터에 대한 위치 표시자를 사용할 수 있다.
 ㄴ 밑줄을 '채워넣어야 할 빈칸'으로 생각해도 좋다.
 ㄴ 함수 리터럴 _ > 0은 좀 더 긴 표현 방법인 x =&gt; x > 0과 같다.
 
부분 적용한 함수 (partially applied function)
 ㄴ 스칼라에서는 함수를 호출하면서 필요한 어떤 인자를 전달하는 것을 함수를 해당 인자에 적용한다(apply)고 말한다.
 ㄴ ex)
  def sum(a: Int, b: Int, c: Int) = a + b + c
  sum(1, 2, 3) // 인자 1, 2, 3을 함수 sum에 적용한다.
 ㄴ 결국에 가서는 foreach 같은 곳에서는 함수 인자 없이 호출이 가능하다. (인자 부분 적용으로 인해)
 ㄴ ex)
  someNumbers.foreach(println)
  
클로저
 (x: Int) =&gt; x + more
 ㄴ more는 자유 변수(free variable)
 ㄴ x는 바운드 변수(bound variable)
 ㄴ 주어진 함수 리터럴로부터 실행 시점에 만들어낸 객체인 함수 값(객체)을 클로저(closure)라고 부른다.
 ㄴ 클로저라는 이름은 함수 리터럴의 본문에 있는 모든 자유 변수에 대한 바인딩(binding, 변수 이름과 스코프상에서 실제 값 또는 변수 위치 등에 대한 연결)을 '포획capturing'해서 자유 변수가 없게 '닫는closing' 행위에서 따온 말이다.

(x: Int) =&gt; x + 1과 같이 자유 변수가 없는 함수 리터럴을 닫힌 코드 조각 (closed term)
 ㄴ 닫힌 함수 리터럴에서 실행 시점에 생긴 함수 값은 엄밀히 말해 클로저가 아니다.
(x: Int) =&gt; x + more처럼 자유 변수가 있는 함수 리터럴은 열린 코드 조각 (open term)
 ㄴ 위 함수 리터럴을 가지고 실행 시점에 만들어내는 함수 값은 정의에 따라 자유 변수인 more의 바인딩을 포획해야 한다.
 ㄴ 그렇게 해서 만들어진 함수 값에는 포획한 more 변수에 대한 참조가 들어 있기 떄문에, 클로저라 부른다.
 
var more = 1
val addMore = (x: Int) =&gt; x + more
addMore(10) // 11

more = 9999
addMore(10) // 10009

위 코드를 보면 addMore 클로저에서 more의 바인딩을 감지했다. 이를 변수를 포획한다고도 표현하기도 한다.
반대로 클로저 안에서 포획한 변수를 변경하면 클로저 밖에서도 볼 수 있다.

val someNumbers = List(-11, -10, 0, 5, 10)
var sum = 0
someNumbers.foreach(sum += _) // 외부 스코프에 있는 sum 변수에 접근
println sum // -11

반복 파라미터
 ㄴ def echo(args: String*) = for (arg &lt;- args) println(arg)
 ㄴ echo(), echo("one"), echo("hello", "world!")
 ㄴ echo(array: _*) // 배열을 전달하기 위해서는 _* 기호를 추가
이름 붙인 인자
 ㄴ 이름 붙인 인자를 이용해 호출하면 인자들의 순서를 바꾸어 전달해도 호출의 의미가 변하지 않는다.
 ㄴ speed(distance = 100, time = 10) // == speed(time = 10, distance = 100)
디폴트 인자
 ㄴ c++의 디폴트 파라미터와 비슷
꼬리 재귀
</pre>

9장. 흐름 제어 추상화
===================
<pre>
파라미터로 전달받은 함수 값을 통해 함수 안에서 함수값을 실행할 수 있다.

object FileMatcher {
     private def filesHere = (new java.io.File(".")).listFiles
     
     def fileMatching(query: String, matcher: (String, String) => Boolean) = {
          for (file <- filesHere; if matcher(file.getName, query)) yield file
     }
     
     def filesEnding(query: String) = filesMatching(query, (fileName: String, query: String) => fileName.endsWith(query))
     def filesContaining(query: String) = filesMatching(query, _.contains(_))
     def filesRegex(query: String) = filesMatching(query, _.matches(_))
}

여기서 matcher는 함수이기 때문에 =&gt;가 타입에 있어야 하고 인자로 문자열을 받으며 리턴값은 불리언 값을 내어놓는다.
따라서 이 함수의 타입은 (String, String) => Boolean 이다.

object FileMatcher {
     private def filesHere = (new java.io.File(".")).listFiles
     
     def fileMatching(query: String, matcher: (String, String) =&gt; Boolean) = {
          for (file &lt;- filesHere; if matcher(file.getName, query)) yield file
     }
     
     def filesEnding(query: String) = filesMatching(_.endsWith(query))
     def filesContaining(query: String) = filesMatching(_.contains(query))
     def filesRegex(query: String) = filesMatching(_.matches(query))
}

그리고 호출하는 함수들(filesEnding, filesContaining, filesRegex)에서는 query 문자열이라는 자유 변수를 갖고 있기 때문에
굳이 여러 번 주고 받을 필요가 없다.
</pre>