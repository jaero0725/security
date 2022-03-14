## 암호
- 목적 : 기밀성 제공

### 대표적인 암호알고리즘
1) Symmetric key - 대칭키 암호 
2) Public Key - 공개키 암호 (비대칭키 암호)

![image](https://user-images.githubusercontent.com/55049159/158124236-6abc181c-d783-4f7a-adbe-1a28a75e03ae.png)
- 송신자가 데이터를 보낼때 plainntext, key 가 들어와서 이것을 바탕으로 해서 encrypt(암호화하여) ciphertext(암호문)으로 네트워크로 전달 하면 수신자는 key를 통해 decrpty(복호화) 하여 plaintext로 만든다.
- 이렇게 키를 사용하는 방식이 대칭키 암호화 방식과 공개키 암호화 방식이 있다. 
- 대칭키 : 암호화할때 쓰는키, 풀때 쓰는 키가 같다.
- 공개키 : 암호화할때 쓰는키, 풀대 쓰는 키가 다르다. ex) 공인인증서 public key와 private key가 pc에 저장되는 방식
