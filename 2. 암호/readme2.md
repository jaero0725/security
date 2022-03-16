**DES에 대해서 알아보기 전에 먼저 Feistel Cipher에 대해서 알아보자.**

---

## **파이스텔 암호(Feistel cipher)**

**파이스텔 암호화란?** 

**파이스텔 암호**(Feistel cipher)는 블록암호(Block Cipher)의 일종  암호화 방식이 특정 계산 함수의 반복으로 이루어진다. 이 때, 각 과정에 사용되는 함수는 라운드 함수(round function)이라고 부른다.

Feistel Cipher는 Block Ciphers를 사용하는 설계 방식, 전반적인 설계 디자인 패턴이라고 보면된다.


**파이스텔 암호화 동작 방식** 

> 1\. F를 라운드 함수로 하고 K0, K1, ... , Kn을 각각 라운드 0, 1, ..., n의 하위 키로 한다.  
> 2\. 평문 블록을 두 개의 동일한 조각으로 분할(L0, R0)  
> 3\. 각 라운드의 경우 i = 0, 1, ..., n,  
> 4\. ComputeLi+1 = Ri, Ri+1 = Li = Li = ⊕ F(Ri,Ki)  
> 5\. 암호 텍스트는 (Rn+1, Ln+1)  
> 위 그림 전체 (i-1~ i) 의 일련의 과정이 한 Round이다.

**파이스텔 암호화 특징**

\- XOR의 특징을 이용 ex) A XOR B XOR B = A 라는점. 

\- 암호화된 결과(ciphertext)를 생성할때, bits가 섞인 상태로 완성됨.

\- 여기서 F는 어떤 함수를 만들어도 상관 없지만 특정한 F에 Secure하기 때문에 잘 적용하는 것이 중요하다. 

F의 가장 대표적인 것이 DES이다. 

---

## DES(Data Encryption Standard)

\- 1970년대에 개발됨

\- Lucifer cipher에 기반해서 만들어진 암호화 알고리즘

\- U.S. 정부의 표준

\- 잘만들어진 암호화 알고리즘 

\- 대칭키 암호화 

\- 기존에 암호화된 문서를 복호화 하는 용도로만 사용하고 신규 암호화 문서를 생성하는데는 절대로 사용하지 말 것을 권장

**DES는 파이스텔 암호화** 

\- 64 bit(글자 8개정도)의 block으로 쪼갬

\- key의 길이는 56 bit - 54bit + 2bit는 parity bit(오류검증)

\- round는 16번

\- 매번 라운드마다 48 bit의 subkey 사용

---

#### **One Round of DES**

#### **0) 최초로 섞음.**

#### **1) expand 확장  : 32비트를 48비트로 확장** 

DES Expansion Permutation - 섞는다.(순열)


#### **2) DES subkey 를 만들기**

**(1) 56 비트를 순서를 섞어서 반으로 나눔** 

Left half key bits (LK)

49 42 35 28 21 14 7

0 50 43 36 29 22 15

8 1 51 44 37 30 23

16 9 2 52 45 38 31

Right half key bits (RK)

55 48 41 34 27 20 13

6 54 47 40 33 26 19

12 5 53 46 39 32 25

18 11 4 24 17 10 3

**(2) shift하여 순서를 이동한뒤, 압축 (compress)**

8,17,21,24를 LK에서 빼고, 6,9,14,25를 RK에서 뺀다. 

Let LK = (LK circular shift left by ri) : 28

Let RK = (RK circular shift left by ri)

Left half of subkey Ki is of LK bits : 24

13 16 10 23 0 4 2 27 14 5 20 9

22 18 11 3 25 7 15 6 26 19 12 1

Right half of subkey Ki is RK bits

12 23 2 8 18 26 1 11 22 16 4 19

15 20 10 27 5 24 17 13 21 7 0 3

**\- 매 라운드마다 subkey생성**

#### **3) expand한 다음에 key와 XOR하여 sboxes를 통해 6비트를 4비트로 매핑 (sboxes는 8개)**

**\# sbox에서 매핑방법**


예를들어 100001이 오면 맨앞과 맨뒤 한자리를 짤라 11, 그리고나머지 0000 두개가 생긴다. 

2자리수를 왼쪽 기준, 나머지 4자리수를 오른쪽기준으로하여 표에 맞춰 보면 1111을 출력하게 된다. 

이런방식으로 sbox 8 개가 매핑을 통해 48비트를 32비트로 변경 시킴.

#### **4) DES P-box를 통해 32비트를 섞는다.** 


#### **5) swap하고 최종적으로 섞어 ciphertext를 만든다.**

암호화는 Permutation(순열), Substitution(대체) 방식으로 이루어지게 된다.

---

#### Securtiy of DES

\- S-boxes가 안정성에 영향을 준다.

\- back door가 없는 것으로 밝혀짐, key를 직접 하나하나 넣어보는 수 밖에없음
