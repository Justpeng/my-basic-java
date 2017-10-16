
package webservice.student.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.student.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetScoreById_QNAME = new QName("http://impl.web.learn/", "getScoreById");
    private final static QName _GetScoreByIdResponse_QNAME = new QName("http://impl.web.learn/", "getScoreByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.student.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetScoreById }
     * 
     */
    public GetScoreById createGetScoreById() {
        return new GetScoreById();
    }

    /**
     * Create an instance of {@link GetScoreByIdResponse }
     * 
     */
    public GetScoreByIdResponse createGetScoreByIdResponse() {
        return new GetScoreByIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScoreById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.web.learn/", name = "getScoreById")
    public JAXBElement<GetScoreById> createGetScoreById(GetScoreById value) {
        return new JAXBElement<GetScoreById>(_GetScoreById_QNAME, GetScoreById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScoreByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.web.learn/", name = "getScoreByIdResponse")
    public JAXBElement<GetScoreByIdResponse> createGetScoreByIdResponse(GetScoreByIdResponse value) {
        return new JAXBElement<GetScoreByIdResponse>(_GetScoreByIdResponse_QNAME, GetScoreByIdResponse.class, null, value);
    }

}
