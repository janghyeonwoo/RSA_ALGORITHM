import java.math.BigInteger;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class RsaMain {

	int p = 2; // 소수 p = 2
	int q = 7; // 소수 q = 7 , n = 14
	int e = 5; // & = (p-1)(q-1) = 6 임으로 1< e < $ 소로소로 e는 5로 택하였습니다.
	int d = 11; // e * d mod 14 = 1 임으로 (5 * d )mod14 = 1 로 d=11로 택하였습니다.

	int n; // n = p *q 공개키

	RsaMain() {
		n = p * q; // 공개키 n = p * q
	}

	public int[] encrypt_msg(int txt[]) {
		System.out.println("암호화를 진행합니다.");

		for (int i = 0; i < txt.length; i++) {
			txt[i] = (int) (Math.pow(txt[i], e) % n);
			System.out.print(txt[i]);

		}
		System.out.println();
		return txt;

	}

	void decrypt_msg(int txt[]) {
		System.out.println("복호화를 진행합니다.");
		for (int i = 0; i < txt.length; i++) {
			txt[i] = (int) (Math.pow(txt[i], d) % n);
			System.out.print(txt[i]);
		}
		System.out.println();

		
	}

	public static void main(String[] args) {
		RsaMain rsa = new RsaMain();
		int[] msg;
		Scanner sc = new Scanner(System.in);
		String input;

		System.out.println("평문을 입력해주세요.");
		input = sc.nextLine();
		

		msg = new int[input.length()];
		System.out.println(input.length());
		System.out.print("평문 : ");
		for (int i = 0; i < input.length(); i++) {

			msg[i] = Character.getNumericValue(input.charAt(i));
			System.out.print(msg[i]);
			

		}
		System.out.println();

		// 암호화
		int[] en_msg = rsa.encrypt_msg(msg);

		// 복호화
		rsa.decrypt_msg(en_msg);

		
	}

}
