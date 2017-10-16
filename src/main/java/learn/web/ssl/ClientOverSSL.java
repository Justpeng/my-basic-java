package learn.web.ssl;


import learn.web.StudentScore;
import lombok.extern.slf4j.Slf4j;
//import org.apache.cxf.configuration.jsse.TLSClientParameters;
//import org.apache.cxf.configuration.security.FiltersType;
//import org.apache.cxf.endpoint.Client;
//import org.apache.cxf.frontend.ClientProxy;
//import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
//import org.apache.cxf.transport.http.HTTPConduit;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

@Slf4j
public class ClientOverSSL {

//    private static final String ADDRESS = "http://127.0.0.1:12345/student";
//
//
//    public static void main(String[] args) throws Exception {
//        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
//        factoryBean.setAddress(ADDRESS);
//        factoryBean.setServiceClass(StudentScore.class);
//
//        Object obj = factoryBean.create();
//        StudentScore userService = (StudentScore) obj;
//
//        configureSSLOnTheClient(userService);
//
//        System.out.println(userService.getScoreById("just"));
//    }
//
//    private static void configureSSLOnTheClient(Object obj) {
//        File file = new File(ClientOverSSL.class.getResource("/key/test.jks").getFile());
//
//        Client client = ClientProxy.getClient(obj);
//        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
//
//        try {
//            TLSClientParameters tlsParams = new TLSClientParameters();
//            tlsParams.setDisableCNCheck(true);
//
//            KeyStore keyStore = KeyStore.getInstance("JKS");
//            String password = "mypassword";
//            String storePassword = "mypassword";
//
//            keyStore.load(new FileInputStream(file), storePassword.toCharArray());
//            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustFactory.init(keyStore);
//            TrustManager[] trustManagers = trustFactory.getTrustManagers();
//            tlsParams.setTrustManagers(trustManagers);
//
//            keyStore.load(new FileInputStream(file), storePassword.toCharArray());
//            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//            keyFactory.init(keyStore, password.toCharArray());
//            KeyManager[] keyManagers = keyFactory.getKeyManagers();
//            tlsParams.setKeyManagers(keyManagers);
//
//            FiltersType filtersTypes = new FiltersType();
//            filtersTypes.getInclude().add(".*_EXPORT_.*");
//            filtersTypes.getInclude().add(".*_EXPORT1024_.*");
//            filtersTypes.getInclude().add(".*_WITH_DES_.*");
//            filtersTypes.getInclude().add(".*_WITH_NULL_.*");
//            filtersTypes.getExclude().add(".*_DH_anon_.*");
//            tlsParams.setCipherSuitesFilter(filtersTypes);
//
//            httpConduit.setTlsClientParameters(tlsParams);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
