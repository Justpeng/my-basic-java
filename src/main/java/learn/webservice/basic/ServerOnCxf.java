package learn.webservice.basic;

import learn.webservice.StudentScore;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.apache.cxf.transport.http_jetty.JettyHTTPServerEngineFactory;
import org.apache.cxf.transport.local.LocalTransportFactory;

/**
 * Description: Basic
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 10/16/2017-14:18
 */
@Slf4j
public class ServerOnCxf {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(StudentScore.class);
        factory.setAddress("http://localhost:9000/student");



//        Bus bus = BusFactory.getDefaultBus();
//        LocalTransportFactory localTransport = new LocalTransportFactory();
//        DestinationFactoryManager dfm = bus.getExtension(DestinationFactoryManager.class);
//        dfm.registerDestinationFactory("http://schemas.xmlsoap.org/soap/http", localTransport);
//        dfm.registerDestinationFactory("http://schemas.xmlsoap.org/wsdl/soap/http", localTransport);
//        dfm.registerDestinationFactory("http://cxf.apache.org/bindings/xformat", localTransport);
//        dfm.registerDestinationFactory("http://cxf.apache.org/transports/local", localTransport);
//
//        ConduitInitiatorManager extension = bus.getExtension(ConduitInitiatorManager.class);
//        extension.registerConduitInitiator("http://cxf.apache.org/transports/local", localTransport);
//        extension.registerConduitInitiator("http://schemas.xmlsoap.org/wsdl/soap/http", localTransport);
//        extension.registerConduitInitiator("http://schemas.xmlsoap.org/soap/http", localTransport);
//        extension.registerConduitInitiator("http://cxf.apache.org/bindings/xformat", localTransport);


        factory.create();

        System.out.println("Server start...");
        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            log.error("异常：",e);
        }
    }
}
