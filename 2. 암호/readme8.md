[##_Image|kage@bn0dO1/btrw52tfwzM/eKv7GQTAzSo9u7JVBTKgk1/img.png|CDM|1.3|{"originWidth":240,"originHeight":184,"style":"alignCenter","width":381,"height":292,"caption":"hash함수의 도식화"}_##]

해시함수중에는 암호학적 해시함수(Cryptographic Hash Function)와 비암호학적 해시함수로 구분되곤 한다.

암호학적 해시함수의 종류로는 MD5, SHA계열 해시함수가 있으며 비암호학적 해시함수로는 CRC32등이 있다.

---

### **보안에서 Hash function을 왜사용해야 하나?**

alice가 M을 전자서명 하여 Bob에게 보낸다. 

S = \[M\]alice to bob : M을 alice의 개인키로 암호화하여 M에게 보낸다.

Bod은 S값을 alice의 개인키로 푼다.

M' ={M}alice

> Alice                     bob  
> M                         M  
> S =\[M\]alice        => M ={S}alice  
> \=> 이런방식으로 했을때, M이 크면, 계산이 상당히 오래걸린다.  
>   
> 따라서, 해시값으로 서명을 하여 시간을 줄인다.   
>   
> Alice                                                                       bob  
> S=\[h(M)\]alice(M\[alice\]의 해시값을 bob에게 전달한다.     => h'(M) = {S}alice  
>                                                                               일치하는지 판단하여 검증한다.

**Hash function을 사용이유 : 직접서명하면, 속도상 느려서 해시함수를 이용해 효율적으로 한다.** 

---

### **Crypto Hash Fucnction 조건**

**1) Compression : ouput이 작다.** 

**2) Efficiency : 어떤 x든지 상관없이 h(x)은 작다.**

\- 어떤 입력 값에 대해서도 해시 값을 구하는데 많은 자원과 노력이 소요 되지 않고 계산 속도가 빨라야 함

**3) One-way : h(x)값이 알떄 x를 찾을떄는 어려워야 한다.**

\+ 암호에서 추가적인 두가지 조건 - hash function 을 생각하면 항상 "충돌"을 생각해야 한다.

\- 해시 결과 값으로부터 입력 값을 계산하는 것은 불가능 해야 함

**4) 약한 충돌 회피성 Weak Collision resistance** 

\- 정의역이 많아도 공역이 적어 충돌이 나올 수 있다. 

\- pigeonhole principle : hash function을 사용하면 충돌이 나올 수 밖에 없다는 것. 

\- M과 동일한 hash값을 가지는 h'(M)

\- x가 주어졌을 때 H(x’)=H(x)인 x′(≠x)을 찾는 것은 계산적으로 어려워야 한다.  
설명) 입력 값과 해시 값을 알고 있을 때 동일한 해시 값을 가지는 다른 입력 값을 찾는 것은 불가능 해야 함

**5) 강한 충돌 회피성 Strong collision resistance**

\- 동일한 hash 값을 갖는 임이의 x를 찾기가 어려워야 한다. 

\- H(x’)=H(x)인 서로 다른 임의의 두 입력 x와 x’을 찾는 것은 계산적으로 어려워야 한다.  
설명) 동일한 해시 값을 가지는 서로 다른 메시지 쌍을 찾는 것은 불가능 해야 함

---

**Pre Birthday Problem** 

\- "몇명이상 있어야지 나랑 동일한 생일을 갖은 사람이 있을 확률이 50%가 이상일까?

\=> 253명이 있으면됨.

**BirthDay Problem**

\- "2명이 같은 생일을 갖은 사람이 있을 확률이 50%가 이상일까?" 

\=> 23명만 있으면 50퍼센트가 넘음.

AES  = 128Bit 2^128/2 = 2^127

Hash  = 256Bit 2^(256/2) = 2^128

\=> 둘이 비슷한 보안 강도를 가진다. 

---

#### **Non-crypto Hash  : 보안에 사용할 수 없는 해쉬 function**

ex) CRC 기법  : 데이터에다 CRC를 보내서 에러검출하는 방식  =>  참고 검색

#### **Popular Crypto Hashes** 

**MD5**

 [MD5 - 위키백과, 우리 모두의 백과사전

MD5(Message-Digest algorithm 5)는 128비트 암호화 해시 함수이다. RFC 1321로 지정되어 있으며, 주로 프로그램이나 파일이 원본 그대로인지를 확인하는 무결성 검사 등에 사용된다. 1991년에 로널드 라이베

ko.wikipedia.org](https://ko.wikipedia.org/wiki/MD5)

**SHA-1** 

 [SHA - 위키백과, 우리 모두의 백과사전

SHA(Secure Hash Algorithm, 안전한 해시 알고리즘) 함수들은 서로 관련된 암호학적 해시 함수들의 모음이다. 이들 함수는 미국 국가안보국(NSA)이 1993년에 처음으로 설계했으며 미국 국가 표준으로 지정

ko.wikipedia.org](https://ko.wikipedia.org/wiki/SHA)

**SHA256**

 [SHA256 - 해시넷

SHA-256은 SHA(Secure Hash Algorithm) 알고리즘의 한 종류로서 256비트로 구성되며 64자리 문자열을 반환한다. SHA-256은 미국의 국립표준기술연구소(NIST; National Institute of Standards and Technology)에 의해 공표된

wiki.hash.kr](http://wiki.hash.kr/index.php/SHA256)

해시함수중에는 암호학적 해시함수(Cryptographic Hash Function)와 비암호학적 해시함수로 구분되곤 한다.

암호학적 해시함수의 종류로는 MD5, SHA계열 해시함수가 있으며 비암호학적 해시함수로는 CRC32등이 있다.

---

### **보안에서 Hash function을 왜사용해야 하나?**

alice가 M을 전자서명 하여 Bob에게 보낸다. 

S = \[M\]alice to bob : M을 alice의 개인키로 암호화하여 M에게 보낸다.

Bod은 S값을 alice의 개인키로 푼다.

M' ={M}alice

> Alice                     bob  
> M                         M  
> S =\[M\]alice        => M ={S}alice  
> \=> 이런방식으로 했을때, M이 크면, 계산이 상당히 오래걸린다.  
>   
> 따라서, 해시값으로 서명을 하여 시간을 줄인다.   
>   
> Alice                                                                       bob  
> S=\[h(M)\]alice(M\[alice\]의 해시값을 bob에게 전달한다.     => h'(M) = {S}alice  
>                                                                               일치하는지 판단하여 검증한다.

**Hash function을 사용이유 : 직접서명하면, 속도상 느려서 해시함수를 이용해 효율적으로 한다.** 

---

### **Crypto Hash Fucnction 조건**

**1) Compression : ouput이 작다.** 

**2) Efficiency : 어떤 x든지 상관없이 h(x)은 작다.**

\- 어떤 입력 값에 대해서도 해시 값을 구하는데 많은 자원과 노력이 소요 되지 않고 계산 속도가 빨라야 함

**3) One-way : h(x)값이 알떄 x를 찾을떄는 어려워야 한다.**

\+ 암호에서 추가적인 두가지 조건 - hash function 을 생각하면 항상 "충돌"을 생각해야 한다.

\- 해시 결과 값으로부터 입력 값을 계산하는 것은 불가능 해야 함

**4) 약한 충돌 회피성 Weak Collision resistance** 

\- 정의역이 많아도 공역이 적어 충돌이 나올 수 있다. 

\- pigeonhole principle : hash function을 사용하면 충돌이 나올 수 밖에 없다는 것. 

\- M과 동일한 hash값을 가지는 h'(M)

\- x가 주어졌을 때 H(x’)=H(x)인 x′(≠x)을 찾는 것은 계산적으로 어려워야 한다.  
설명) 입력 값과 해시 값을 알고 있을 때 동일한 해시 값을 가지는 다른 입력 값을 찾는 것은 불가능 해야 함

**5) 강한 충돌 회피성 Strong collision resistance**

\- 동일한 hash 값을 갖는 임이의 x를 찾기가 어려워야 한다. 

\- H(x’)=H(x)인 서로 다른 임의의 두 입력 x와 x’을 찾는 것은 계산적으로 어려워야 한다.  
설명) 동일한 해시 값을 가지는 서로 다른 메시지 쌍을 찾는 것은 불가능 해야 함

---

**Pre Birthday Problem** 

\- "몇명이상 있어야지 나랑 동일한 생일을 갖은 사람이 있을 확률이 50%가 이상일까?

\=> 253명이 있으면됨.

**BirthDay Problem**

\- "2명이 같은 생일을 갖은 사람이 있을 확률이 50%가 이상일까?" 

\=> 23명만 있으면 50퍼센트가 넘음.

AES  = 128Bit 2^128/2 = 2^127

Hash  = 256Bit 2^(256/2) = 2^128

\=> 둘이 비슷한 보안 강도를 가진다. 

---

#### **Non-crypto Hash  : 보안에 사용할 수 없는 해쉬 function**

ex) CRC 기법  : 데이터에다 CRC를 보내서 에러검출하는 방식  =>  참고 검색

#### **Popular Crypto Hashes** 

**MD5**

 [MD5 - 위키백과, 우리 모두의 백과사전

MD5(Message-Digest algorithm 5)는 128비트 암호화 해시 함수이다. RFC 1321로 지정되어 있으며, 주로 프로그램이나 파일이 원본 그대로인지를 확인하는 무결성 검사 등에 사용된다. 1991년에 로널드 라이베

ko.wikipedia.org](https://ko.wikipedia.org/wiki/MD5)

**SHA-1** 

 [SHA - 위키백과, 우리 모두의 백과사전

SHA(Secure Hash Algorithm, 안전한 해시 알고리즘) 함수들은 서로 관련된 암호학적 해시 함수들의 모음이다. 이들 함수는 미국 국가안보국(NSA)이 1993년에 처음으로 설계했으며 미국 국가 표준으로 지정

ko.wikipedia.org](https://ko.wikipedia.org/wiki/SHA)

**SHA256**

 [SHA256 - 해시넷

SHA-256은 SHA(Secure Hash Algorithm) 알고리즘의 한 종류로서 256비트로 구성되며 64자리 문자열을 반환한다. SHA-256은 미국의 국립표준기술연구소(NIST; National Institute of Standards and Technology)에 의해 공표된

wiki.hash.kr](http://wiki.hash.kr/index.php/SHA256)
