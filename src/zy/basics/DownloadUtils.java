package zy.basics;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;

/**
 * Created by kaiser_zhao on 2018/10/11.
 */
public class DownloadUtils {
    // ignore PKIX check
    static {
        TrustManager[ ] certs = new TrustManager[ ] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
                }
        };
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("SSL");
            ctx.init(null, certs, new SecureRandom());
        } catch (java.security.GeneralSecurityException ex) {
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());
    }

    public final static void main(String...strings){
        try {
            testConnectionTo("https://qatenant18.identity.env3.ociqa1.c9dev1.oc9qadev.com:443");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void testConnectionTo(String aURL) throws Exception {
        URL destinationURL = new URL(aURL);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("www-proxy.uk.oracle.com", 80));
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection(proxy);

//        System.setProperty("http.proxyHost","www-proxy.uk.oracle.com");
//        System.setProperty("http.proxyPort","80");

        conn.connect();
        Certificate[] certs = conn.getServerCertificates();
        System.out.println("nb = " + certs.length);
        int i = 1;
        for (Certificate cert : certs) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("################################################################");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Certificate is: " + cert);
            if(cert instanceof X509Certificate) {
                try {
                    ( (X509Certificate) cert).checkValidity();
                    System.out.println("Certificate is active for current date");
                    //FileOutputStream os = new FileOutputStream("/home/sebastien/Bureau/myCert"+i);
                    i++;
                    //os.write(cert.getEncoded());
                } catch(CertificateExpiredException cee) {
                    System.out.println("Certificate is expired");
                }
            } else {
                System.err.println("Unknown certificate type: " + cert);
            }
        }
    }
}
