
package server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the server package. 
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

    private final static QName _Eleccion_QNAME = new QName("http://server/", "eleccion");
    private final static QName _ArrancaProcesoResponse_QNAME = new QName("http://server/", "arrancaProcesoResponse");
    private final static QName _ArrancaProceso_QNAME = new QName("http://server/", "arrancaProceso");
    private final static QName _PararProcesoResponse_QNAME = new QName("http://server/", "pararProcesoResponse");
    private final static QName _Computar_QNAME = new QName("http://server/", "computar");
    private final static QName _ComputarResponse_QNAME = new QName("http://server/", "computarResponse");
    private final static QName _EleccionResponse_QNAME = new QName("http://server/", "eleccionResponse");
    private final static QName _PararProceso_QNAME = new QName("http://server/", "pararProceso");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PararProceso }
     * 
     */
    public PararProceso createPararProceso() {
        return new PararProceso();
    }

    /**
     * Create an instance of {@link EleccionResponse }
     * 
     */
    public EleccionResponse createEleccionResponse() {
        return new EleccionResponse();
    }

    /**
     * Create an instance of {@link ComputarResponse }
     * 
     */
    public ComputarResponse createComputarResponse() {
        return new ComputarResponse();
    }

    /**
     * Create an instance of {@link ArrancaProceso }
     * 
     */
    public ArrancaProceso createArrancaProceso() {
        return new ArrancaProceso();
    }

    /**
     * Create an instance of {@link Eleccion }
     * 
     */
    public Eleccion createEleccion() {
        return new Eleccion();
    }

    /**
     * Create an instance of {@link ArrancaProcesoResponse }
     * 
     */
    public ArrancaProcesoResponse createArrancaProcesoResponse() {
        return new ArrancaProcesoResponse();
    }

    /**
     * Create an instance of {@link PararProcesoResponse }
     * 
     */
    public PararProcesoResponse createPararProcesoResponse() {
        return new PararProcesoResponse();
    }

    /**
     * Create an instance of {@link Computar }
     * 
     */
    public Computar createComputar() {
        return new Computar();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Eleccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "eleccion")
    public JAXBElement<Eleccion> createEleccion(Eleccion value) {
        return new JAXBElement<Eleccion>(_Eleccion_QNAME, Eleccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrancaProcesoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "arrancaProcesoResponse")
    public JAXBElement<ArrancaProcesoResponse> createArrancaProcesoResponse(ArrancaProcesoResponse value) {
        return new JAXBElement<ArrancaProcesoResponse>(_ArrancaProcesoResponse_QNAME, ArrancaProcesoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrancaProceso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "arrancaProceso")
    public JAXBElement<ArrancaProceso> createArrancaProceso(ArrancaProceso value) {
        return new JAXBElement<ArrancaProceso>(_ArrancaProceso_QNAME, ArrancaProceso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PararProcesoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "pararProcesoResponse")
    public JAXBElement<PararProcesoResponse> createPararProcesoResponse(PararProcesoResponse value) {
        return new JAXBElement<PararProcesoResponse>(_PararProcesoResponse_QNAME, PararProcesoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Computar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "computar")
    public JAXBElement<Computar> createComputar(Computar value) {
        return new JAXBElement<Computar>(_Computar_QNAME, Computar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComputarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "computarResponse")
    public JAXBElement<ComputarResponse> createComputarResponse(ComputarResponse value) {
        return new JAXBElement<ComputarResponse>(_ComputarResponse_QNAME, ComputarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EleccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "eleccionResponse")
    public JAXBElement<EleccionResponse> createEleccionResponse(EleccionResponse value) {
        return new JAXBElement<EleccionResponse>(_EleccionResponse_QNAME, EleccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PararProceso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "pararProceso")
    public JAXBElement<PararProceso> createPararProceso(PararProceso value) {
        return new JAXBElement<PararProceso>(_PararProceso_QNAME, PararProceso.class, null, value);
    }

}
