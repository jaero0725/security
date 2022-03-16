### Block Cipher Notation

> **P = plaintext block**  
> **C = ciphertext block**  
>   
> **C = E(P, K)    //P를 K를 사용해서 Encrpt하면, C가 나온다는 뜻.**   
> **P = D(C, K)   //C를 K를 사용해서 Decrypt하면, P가 나온다는 뜻.**   
>   
> **P = D(E(P, K), K) and C = E(D(C, K), K)  // 대칭키의 의미**

---

## **Triple DES**

#### **\[기존 DES의 문제점 \]**

기존의 DES는 56 bit key이다. 

DES의 key를 exhaustive key search를 하면 2^56를 하면 key값을 검출 할 수 있다. 분산시스템으로 여러대의 컴퓨터로 key값을 찾으면 금방 찾아낼 수 있다. 따라서 DES는 안전하지 못한 암호화 알고리즘으로 대체될 방식이 필요하다. 

여기서 DES방식은 안전하지만 key크기가 작다는 문제를 해결하기 위해 개선한 방식은 2가지 정도가 있다. 

(NIST는 2005년 단순DES 를 공식적으로 퇴출함)

> **1) Triple DES - 호환을 유지**  
> **2) AES  - 완전히 새로운 방식으로 만듦**

이 글에서는 이 문제를 해결하기 위한 Triple DES의 방식에 대해서 알아보겠다.

---

Triple DES는 3중 DES이다. key가 112 bit이다. 

#### **작동방식** 

[##_Image|kage@nVK0T/btrv4lHvqM1/xlBI8LujekcZl8VN2K8cO0/img.png|CDM|1.3|{"originWidth":700,"originHeight":205,"style":"alignCenter"}_##]

> **\# 암호화과정   
>   
> C = E(D(E(P,K1),K2),K1)**  
>   
> 1) K1을 가지고 P를 암호화한다.  
> 2) K2를 가지고 복호화한다.   
> 3) K1을 가지고 암호화하여 C를 만든다.   
>   
> \=>3번의 과정을 거침. (속도가 3배정도 느려질 수 있다.)  
> \=> key는 2개 사용되므로, 112 bit길이가 된다. 

> **\# 복호화과정**  
>   
> **P = D(E(D(C,K1),K2),K1)**  
>   
> 1) K1을 가지고 C를 복호화한다.  
> 2) K2를 가지고 암호화한다.   
> 3) K1을 가지고 복호화하여 P를 만든다.

#### **아래의 방식을 하지 않은 이유?** 

1) Why not C = E(E(P,K),K) ?

\- 키가 여전히 56비트이다.

2) Why not C = E(E(P,K1),K2) ?

\- Known plaintext attack이 있을 수 있다.

공격자 입장에서 증거가 많을 수록 공격하기 쉽다. 기본적으로 Cipher text를 얻을 수 있다. 그리고 known Plain text도 얻을 수 있다. 왜냐하면 이메일같은 방식은 header가 같기 때문이다. 그래서 저런 방식으로 쓰지 않게 된다.

**공격방식** 

E(P, K1) = D(C, K2) 

모든 K1, K2에 대해서 암호문을 만듦

암호화, 복호화 : 2^56 + 2^56 = 2^57 개의 암복호화 연산이 필요함.  

---

**DES의 동작방식**


zeroco.tistory.com](https://zeroco.tistory.com/59?category=995656)