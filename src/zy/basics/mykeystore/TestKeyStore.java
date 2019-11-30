package zy.basics.mykeystore;


import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by kaiser_zhao on 2018/9/5.
 */
public class TestKeyStore {
    public final static void main(String... strings){
        // get default key store of jre, need password?

        try {
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            System.out.println(KeyStore.getDefaultType());
            char[] pswd = "changeit".toCharArray();

            String javaHome = System.getProperty("java.home");
            String jksPath = javaHome + "/lib/security/cacerts";
            FileInputStream fis = new FileInputStream(jksPath);
            ks.load(fis, pswd);

            System.out.print(ks.getCertificate("env18").getType());
            System.out.print(ks.getCertificate("env18").getEncoded());
            System.out.print(ks.getCertificate("env18").getEncoded());
//            while(ks.aliases().hasMoreElements()){
//                String alias = ks.aliases().nextElement();
//                System.out.println(ks.getCertificate(alias).getPublicKey().toString());
//            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }


    }
}
