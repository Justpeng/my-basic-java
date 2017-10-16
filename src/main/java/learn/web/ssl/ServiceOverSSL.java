package learn.web.ssl;


import learn.web.StudentScore;
import learn.web.impl.StudentScoreImpl;
import lombok.extern.slf4j.Slf4j;
//import org.apache.cxf.Bus;
//import org.apache.cxf.BusFactory;
//import org.apache.cxf.configuration.jsse.TLSServerParameters;
//import org.apache.cxf.configuration.security.ClientAuthentication;
//import org.apache.cxf.configuration.security.FiltersType;
//import org.apache.cxf.endpoint.Server;
//import org.apache.cxf.frontend.ServerFactoryBean;
//import org.apache.cxf.transport.ConduitInitiatorManager;
//import org.apache.cxf.transport.DestinationFactoryManager;
//import org.apache.cxf.transport.http_jetty.JettyHTTPServerEngineFactory;
//import org.apache.cxf.transport.local.LocalTransportFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.ws.Endpoint;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

@Slf4j
public class ServiceOverSSL {

//    private static final int PORT = 12345;
//
//    /**
//     * 开启，并发布webService服务
//     * @param args
//     */
//    public static void main(String args[]){
//        System.out.println("starting server ServiceOverSSL");
//        //定义webService地址: ip+port
//        String address = "http://127.0.0.1:"+PORT+"/student";
//
//        configSSL();
//
//        ServerFactoryBean factoryBean = new ServerFactoryBean();
//        StudentScoreImpl studentScore = new StudentScoreImpl();
//        factoryBean.setServiceBean(studentScore);
//        factoryBean.setServiceClass(StudentScore.class);
//        factoryBean.setAddress(address);
//
//        Server server = factoryBean.create();
//
//        String endpoint = server.getEndpoint().getEndpointInfo().getAddress();
////        System.out.println("Server started at " + endpoint);
////        Endpoint.publish(address, studentScore);
//
//    }
//
//    public static void configSSL() {
//        File file = new File(ServiceOverSSL.class.getResource("/key/test.jks").getFile());
//        try {
//            TLSServerParameters tlsParams = new TLSServerParameters();
//            KeyStore keyStore = KeyStore.getInstance("JKS");
//            String password = "mypassword";
//            String storePassword = "mypassword";
//
//            keyStore.load(new FileInputStream(file), storePassword.toCharArray());
//            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//            keyFactory.init(keyStore, password.toCharArray());
//            KeyManager[] keyManagers = keyFactory.getKeyManagers();
//            tlsParams.setKeyManagers(keyManagers);
//
//            keyStore.load(new FileInputStream(file), storePassword.toCharArray());
//            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustFactory.init(keyStore);
//            TrustManager[] trustManagers = trustFactory.getTrustManagers();
//            tlsParams.setTrustManagers(trustManagers);
//
//            FiltersType filtersTypes = new FiltersType();
//            filtersTypes.getInclude().add(".*_EXPORT_.*");
//            filtersTypes.getInclude().add(".*_EXPORT1024_.*");
//            filtersTypes.getInclude().add(".*_WITH_DES_.*");
//            filtersTypes.getInclude().add(".*_WITH_NULL_.*");
//            filtersTypes.getExclude().add(".*_DH_anon_.*");
//            tlsParams.setCipherSuitesFilter(filtersTypes);
//
//            ClientAuthentication ca = new ClientAuthentication();
//            ca.setRequired(true);
//            ca.setWant(true);
//            tlsParams.setClientAuthentication(ca);
//            Bus bus = BusFactory.getDefaultBus();
//            LocalTransportFactory localTransport = new LocalTransportFactory();
//            DestinationFactoryManager dfm = bus.getExtension(DestinationFactoryManager.class);
//            dfm.registerDestinationFactory("http://schemas.xmlsoap.org/soap/http", localTransport);
//            dfm.registerDestinationFactory("http://schemas.xmlsoap.org/wsdl/soap/http", localTransport);
//            dfm.registerDestinationFactory("http://cxf.apache.org/bindings/xformat", localTransport);
//            dfm.registerDestinationFactory("http://cxf.apache.org/transports/local", localTransport);
//
//            ConduitInitiatorManager extension = bus.getExtension(ConduitInitiatorManager.class);
//            extension.registerConduitInitiator("http://cxf.apache.org/transports/local", localTransport);
//            extension.registerConduitInitiator("http://schemas.xmlsoap.org/wsdl/soap/http", localTransport);
//            extension.registerConduitInitiator("http://schemas.xmlsoap.org/soap/http", localTransport);
//            extension.registerConduitInitiator("http://cxf.apache.org/bindings/xformat", localTransport);
//            JettyHTTPServerEngineFactory factory = new JettyHTTPServerEngineFactory();
//            factory.setTLSServerParametersForPort(PORT, tlsParams);
//        } catch (Exception e) {
//            log.error("创建服务异常:"+e);
//        }
//    }
}
