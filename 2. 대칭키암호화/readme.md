## 암호
- 목적 : 기밀성 제공

### 대표적인 암호알고리즘
> 1) Symmetric key - 대칭키 암호 : 암호화할때 쓰는키, 풀때 쓰는 키가 같다.
> 2) Public Key - 공개키 암호 (비대칭키 암호) : : 암호화할때 쓰는키, 풀대 쓰는 키가 다르다.
> -  ex) 공인인증서 public key와 private key가 pc에 저장되는 방식

![image](https://user-images.githubusercontent.com/55049159/158124236-6abc181c-d783-4f7a-adbe-1a28a75e03ae.png)
- 송신자가 데이터를 보낼때 plainntext, key 가 들어와서 이것을 바탕으로 해서 encrypt(암호화하여) ciphertext(암호문)으로 네트워크로 전달 하면 수신자는 key를 통해 decrpty(복호화) 하여 plaintext로 만든다.
- 이렇게 키를 사용하는 방식이 대칭키 암호화 방식과 공개키 암호화 방식이 있다. 

### 암호화
- 가정 : Kerckhoffs Principle - 알고리즘 자체는 공격자에게 모두 공개되어 있다. key만 secret하게 유지가 된다. 
- secret algorithrms을 비밀스럽게 유지하면 노출되면 굉장이 약하기 때문이다. 
- 따라서 아예 알고리즘을 공개해서 개선하는 것이 좋다.  

### 대칭키 암호화 - Symmetric key Crypthography
#### 1. Stream Ciphers 
- bit단위로 암호화
- 잘 안씀

#### 2. Block Ciphers 
- block단위로 암호화
- round function을 반복 수행하여 실제로 plaintext에서 Ciphertext를 얻을 수 있다. 
- round function의 input은 key, 이전 round ouput이다. 
- 대부분 software로 구현이 되어 있다. - 크게 느리지 않다!

#### Feistel cipher 
- Block Ciphers를 사용하는 설계 방식, 전반적인 설계 디자인 패턴이라고 보면된다. 
![image](https://user-images.githubusercontent.com/55049159/158126896-997213bd-365c-47ad-9fab-ac517f3b21be.png width="400" heigth="400")

### 공개키 암호화 - Public Key Crypthography
