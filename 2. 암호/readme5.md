Plain text는 여러개의 블럭으로 나누어져있다.

블럭이 128비트라고 하면 각각의 블럭으로 암호화 하는 방식에 대해서는 DES, TripleDES, AES를 통해 알 수 있다.

블럭을 독립적으로 암호화 한다면, 보안에 취약하기 때문에 해결하는 방식이 필요하다.

각각의 블럭마다 새로운 key를 사용하면 key가 너무 많아진다. (좋은 방식이 아님)

각각의 블럭을 같은 key로 독립적으로 암호화하는 방식은 보안상으로 취약하다. 

\=> 암호화를 이전 블록에 의존하도록 만드는 방식은 좀더 안전한 방식이 될 수 있다. (Chain을 형성) - CBC방식

\=> 크기가 블럭보다 작아서 잘린 블럭은 128비트로 인위적으로 채워서 만든다.

---

### **1\. Electronic Codebook (ECB) Mode**


\- 각각의 블럭을 독립적으로 암호화 하는 방식

\- 치명적 약점 존재

\- 모든 블록이 같은 암호화 키를 사용하여 보안에 취약하다.

> \# 이런식으로 K가 다 같음.  
>   
> Encrypt             Decrypt  
> C0 = E(P0, K),     P0 = D(C0, K),  
> C1 = E(P1, K),     P1 = D(C1, K),  
> C2 = E(P2, K),…   P2 = D(C2, K),…
---

### **2\. Cipher Block Chaining (CBC) Mode  
**


\- 많이 사용됨.

\- ECB Mode보다 더 안전하고 추가적인 작업이 거의 들어가지 않는다. 

\- 블럭을 체인으로 묶는 방식

\- 처음에 초기화 백터가 사용됨(IV)

\- ciphertext가 동일하게 나오지 않음

\- 체인을 형성했어도 문제가 생겨도 두개에서 영향을 주고 에러 전파가 안됨.

> \# 이런식으로 Chain을 형성한다.  
> \# 이전 ciphertext block이 사용됨.  
>   
> Encryption                   Decryption  
> C0 = E(IV XOR P0, K),     P0 = IV XOR D(C0, K),  
> C1 = E(C0 XOR P1, K),    P1 = C0 XOR D(C1, K),  
> C2 = E(C1 XOR P2, K),…  P2 = C1 XOR D(C2, K),…


---

### **3\. Counter Mode (CTR) Mode**


\- 1씩 증가하는 counter와 nonce가 있음. 

\- 랜덤 액세스에 효율적이다. (CBC도 chain이지만 랜덤 엑세스할 수 있다.)

> \# 암호화 한뒤 P와 C를 Xor시킨다.   
>   
> Encryption                     Decryption  
> C0 = P0 XOR E(IV, K),       P0 = C0 XOR E(IV, K),  
> C1 = P1 XOR E(IV+1, K),   P1 = C1 XOR E(IV+1, K),  
> C2 = P2 XOR E(IV+2, K),… P2 = C2 XOR E(IV+2, K),…

---

**결론** 

CBC mode에 AES를 적용해서 암호화가 많이 이루어짐

실제 개발에서 라이브러리를 사용해서 암호화를 구현하면된다.

---



zeroco.tistory.com](https://zeroco.tistory.com/61?category=995656)