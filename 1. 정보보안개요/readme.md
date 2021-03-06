## 정보보안개요
### 예시
> Alice(은행), Bob(고객)  - good <br>
> Turdy(해커) - Bad

### 보안 서비스
- 보안을 통해 고객에게 어떤 기능을 제공하는가? <br>
:heavy_check_mark: CIA 기능 (3가지 기능을 필수로 제공) + (Access Control, 부인봉쇄)

> #### 1) 기밀성 (Confidentiality) - Reading을 막음
> - Alice(은행) 입장에서 허가받지않은 사람이 함부로 정보를 읽지 못하게 막는 것. (ex. 도청..)
> - 기밀성을 제공받기 위해 어떤 방식을 쓰나? - 읽지못하게, 읽더라도 해석 못하게함
 
> #### 2) 무결성 (Integrirty) - Writing을 막음
> - 변조없는 깨끗한 상태, 허가 받지 않은 쓰기를 허용하지 않은 상태 
> - Turdy(해커)가 Bod(고객)의 잔고를 수정하지 못하게 하는 것
> - 무결성을 제공받기 위해 어떤 방식을 쓰나? - 원천적으로 막거나, 해쉬함수를 사용하여 원본을 수정했는지 안됐는지 판단을 한다.

> #### 3) 가용성 (Availability)
> - 항상 서비스가 가용해야 한다는 것.
> - 필요할때마다 사용이 가능해야 한다 :  Alice(은행)은 거래가 항상 가능해야 한다. 
> - 필요할때 Data는 적시에 이용가능해야 한다.
> - 가용성은 새로운 Securit concern 이 생김 - ex) 디도스 공격 해결 

> #### 4) Access Control (인증, 인가)
> 1) Authentication (인증)
> - Bob의 컴퓨터가 어떻게 실제 Bob인지 알 수 있나? - password를 사용
> - password는 cryptogrphy(암호학)이 필요하다. 
> - password이 과연 안전한가? - password의 대안 : 패턴, 생채인식 
> - 네트워크에서는 network securit 이슈가 있다. -> 이런 경우 고려해야할 상황 : Protocols이 중요하다. ex) Https, SSL
> 2) Authorization (인가)
> - 인가란 권한에 대한 제한을 두는 것 (읽기 쓰기 권한, 관리자 사용자 권한)

> #### 5) 부인봉쇄 (Non-repudiation)
> - 고객이 발뺌할 수 없는 것 - 나중에 부인못하게 하는 것 
> - 어떻게 부인봉쇄? - 오프라인에서는 계약서에 서명하는 방식으로 한다. 온라인에서는 전자서명을 통해서 부인봉쇄한다. 

### 소프트웨어 이슈

> #### 1) secure coding
> - 소프트웨어 개발에 있어 결함을 줄여야 함.

> #### 2) malware
> - ex) 바이러스, worms, 랜섬웨어
> - malware을 어떻게 막을까? 

> #### 3) os
> - 운영체제에서 내부적으로 보안 기능을 구현해주고 있다.
> - OS도 점차적으로 복잡해지지만, 완벽하게 믿을수는 없다. 

### :clipboard: 책 구성요소 살펴보기 [정보보안 이론과 실제]
> #### 1) 암호학(Cryptography)
> - 전통적으로 암호학을 어떻게 사용?
> -  현재에 암호학을 어떻게 사용?
> - 대칭키암호화(AES), 공개키 암호화(RSA)
> - 해쉬함수(SHA1) : 보안에서 사용되는 해쉬함수는 좀 다르다.
> - 암호화된것을 어떻게 깰 것인가?

> #### 2) 접근제어(Acess Control)
> - 인증 : Password, 생체인증 
> - 인가 : 자원을 누가 접근할 수 있는지? 
> - 레벨을 나누어서 관리(Multilevel security - MLS) 
> - 방화벽, 침입탐지 시스템

> #### 3) 프로토콜
> - "Butterfly effect" : 프로토콜을 조금만 변경시켜도 시스템 측면에서 거대한 효과를 줄 수 있다. 
> - SSL(가장 많이씀), IPSec(재택근무중 회사 서버에 들어갈때) , Kerberos(윈도우에서 인증)
> - GSM security (2G 프로토콜)

> #### 4) 소프트웨어
> 어떤 결함이 치명적일까? - Buffer overflow, Other common flaws
> - Malware 탐지
> - SRE(source <- binary) : sourcecode reverse enginering 리버스엔지니어링을 통해 해커들이 분석함
> - 디지털 권리 관리(Digital rights management, DRM) : 함부로 복사할 수 없음 ex) Mp3, e-book
> - Open Source vs Closed Source

### 결론 : Trudy(해커)와 같이 생각하는 것이 중요함
