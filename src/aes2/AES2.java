package aes2;

import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

public class AES2 {

    private static String chaveSimetrica;
    private static String mensagem;
    private static SecretKey key;
    private static byte[] mensagemEncriptada;
    private static byte[] mensagemDescriptada;
    private static Scanner sc = new Scanner(System.in);
    private static String mensagemBase64;
 
    public static void main(String args[]) {
        /*do{
            System.out.println("32 caracteres = chave com 256 bits" + "\n Informe uma Chave: ");
            chaveSimetrica = sc.nextLine();
        }while(chaveSimetrica.length() != 32);
        */
        chaveSimetrica = "s5kIwgqWjxkvIb6bFPAEZlz4O4cMyUEa";
        key = new SecretKeySpec(chaveSimetrica.getBytes(), "AES");

        try {
            Cipher cipher = Cipher.getInstance("AES");
            System.out.println("Informe mensagem a ser encriptada: ");
            mensagem = sc.nextLine();
            cipher.init(Cipher.ENCRYPT_MODE, key);
            /*System.out.println("Informe a mensagem encriptada");
            mensagemEncriptada = sc.nextLine().getBytes();
            */
            mensagemEncriptada = cipher.doFinal(mensagem.getBytes());
            mensagemBase64 = new String(Base64.getEncoder().encode(mensagemEncriptada));
            cipher.init(Cipher.DECRYPT_MODE, key);
            /* Recebe a mensagem encriptada e descripta */
            mensagemDescriptada = cipher.doFinal(mensagemEncriptada);
            /**
             * Converte para a base 64 e amazena a mensagem em uma variavel
             * auxiliar
             */
            String mensagemOriginal = new String(mensagemDescriptada);
            /* Exibe Mensagem Descriptada */
            //String stringEncriptada = new String(mensagemEncriptada);
            
            System.out.println("Mensagem Digitada: " + mensagem + "\n\nMensagem Encriptada: " + mensagemBase64 + "\n\nMensagem Descriptada :" + mensagemOriginal );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
