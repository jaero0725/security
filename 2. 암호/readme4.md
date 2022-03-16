**기존 알고리즘의 불안전함** 

기존의 DES의 안전하지 못함. 

Triple DES는 DES와 호환성을 유지하며 키의 길이를 늘림

AES는 DES를 대체하는 암호화 알고리즘이다. 

---

## **AES**

**특징**

-   실제로 사용하는 암호화 방식이다. 
-   대칭키 블럭 암호화 알고리즘 
-   128, 192, 256비트로 key size가 커졌다. 각각 AES-128, AES-192, AES-256으로 불린다. 
-   애플리케이션 유형에 따라 세가지 종류중에 정한다.
-   DES, Triple DES보다 안전함
-   Feistel cipher이 아니다. 

Block Size와 독립적이다.

> Block size: 128, 192 or 256 bits  
> Key length: 128, 192 or 256 bits

-   round가 10 ~ 14 (키의 길이에 따라 달라짐)

> \# 각각의 라운드는 4개의 function으로 구성됨.  
>   
> **ByteSub (nonlinear layer)**  
> **ShiftRow (linear mixing layer)**  
> **MixColumn (nonlinear layer)**  
> **AddRoundKey (key addition layer)**

#### **알고리즘**

<iframe src="https://www.youtube.com/embed/mlzxpkdXP58" width="860" height="484" frameborder="0" allowfullscreen="true"></iframe>

알고리즘을 시각화한 자료

Rijndael 알고리즘은 크게 보아 네 단계로 이루어진다.

1) KeyExpansion: key schedule(키 스케줄)이라고도 부른다. 128, 192 또는 256비트 길이인 하나의 주 암호화 키를 받아서 아래 라운드들에서 사용할 여러 개의 128비트 라운드 키를 생성한다.

2) 0 라운드: 위의 단계에서 생성한 라운드 키 중 첫번째 키를 사용, AddRoundKey를 한 번 실행한다.

3) 1~(9, 11, 13) 라운드: SubBytes, ShiftRows, MixColumns, AddRoundKey를 순서대로 실행한다. 이것을 AES-128, 192, 256에 따라 각각 9번, 11번, 13번 반복한다.

4) 마지막 (10, 12, 14)번째 라운드: SubBytes, ShiftRows, AddRoundKey를 순서대로 실행한다.